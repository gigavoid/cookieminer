package com.gigavoid.supermod.tileentity;

import com.gigavoid.supermod.entity.EntityRope;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagIntArray;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.util.Constants;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ineentho on 2014-11-03.
 */
public class TileEntityRopeWheel extends TileEntity {
    public static List<TileEntityRopeWheel> allTileEntities = new ArrayList<TileEntityRopeWheel>();


    public float rot = 0;
    public short direction;
    public List<int[]> ropePoints = new ArrayList<int[]>();

    public List<EntityRope> ropes = new ArrayList<EntityRope>();



    public TileEntityRopeWheel() {
        allTileEntities.add(this);
    }

    @Override
    protected void finalize() throws Throwable {
        allTileEntities.remove(this);
        super.finalize();
    }

    public static void addRopeFromTo(World world, int[] from, int[] to) {
        TileEntity fromTileEntity = world.getTileEntity(from[0], from[1], from[2]);
        TileEntity toTileEntity = world.getTileEntity(to[0], to[1], to[2]);
        
        if(fromTileEntity == null || toTileEntity == null)
            return;
        
        
        TileEntityRopeWheel fromWheel = (TileEntityRopeWheel) fromTileEntity;
        TileEntityRopeWheel toWheel = (TileEntityRopeWheel) toTileEntity;

        if(!fromWheel.containsRopePoint(to) && !toWheel.containsRopePoint(from))
            fromWheel.addRopePoint(to);
    }

    private boolean containsRopePoint(int[] to) {
        for(int[] rp : ropePoints) {
            if(rp[0] == to[0] && rp[1] == to[1] && rp[2] == to[2])
                return true;
        }
        return false;
    }

    private void addRopePoint(int[] point) {
        ropePoints.add(point);
        refreshRopes();
    }

    public void frame() {
        rot += .05f;
    }

    @Override
    public void readFromNBT(NBTTagCompound tags) {
        direction = tags.getShort("direction");

        NBTTagList list = tags.getTagList("ropePoints", Constants.NBT.TAG_INT_ARRAY);
        for(int i = 0; i < list.tagCount(); i++) {
            int[] ropePoint = list.func_150306_c(i);
            ropePoints.add(ropePoint);
        }
        super.readFromNBT(tags);
    }

    @Override
    public void writeToNBT(NBTTagCompound tags) {
        tags.setShort("direction", direction);

        NBTTagList points = new NBTTagList();
        for(int[] point : ropePoints)
            points.appendTag(new NBTTagIntArray(point));
        tags.setTag("ropePoints", points);

        super.writeToNBT(tags);

    }

    @Override
    public Packet getDescriptionPacket() {
        NBTTagCompound tags = new NBTTagCompound();
        writeToNBT(tags);
        return new S35PacketUpdateTileEntity(xCoord, yCoord, zCoord, 1, tags);
    }


    @Override
    public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt) {
        readFromNBT(pkt.func_148857_g());
        refreshRopes();
    }

    @Override
    public void invalidate() {
        super.invalidate();

        for(TileEntityRopeWheel ropeWheel : TileEntityRopeWheel.allTileEntities) {
            ropeWheel.despawnRopes();
            for(int[] rope : ropePoints) {
                TileEntity tileEntity = ropeWheel.worldObj.getTileEntity(rope[0], rope[1], rope[2]);
                if (tileEntity == null || !(tileEntity instanceof TileEntityRopeWheel))
                    continue;
                TileEntityRopeWheel otherRopeWheel = (TileEntityRopeWheel) tileEntity;
                otherRopeWheel.refreshRopes();
            }
        }
    }

    private void spawnRopes() {
        for(int[] ropePoint : ropePoints) {
            int rX = ropePoint[0];
            int rY = ropePoint[1];
            int rZ = ropePoint[2];
            EntityRope rope = new EntityRope(worldObj, xCoord, yCoord, zCoord, rX, rY, rZ);
            worldObj.spawnEntityInWorld(rope);
            ropes.add(rope);
        }
    }


    public void refreshRopes() {
        if(!worldObj.isRemote)
            return;

        despawnRopes();
        cleanupOldRopes();
        spawnRopes();
    }

    private void cleanupOldRopes() {
        List<int[]> oldRopes = new ArrayList<int[]>(ropePoints);
        for(int[] rope : oldRopes){
            TileEntityRopeWheel.addRopeFromTo(worldObj, getPos(), rope);
        }
    }

    private void despawnRopes() {
        for(EntityRope rope : ropes) {
            worldObj.removeEntity(rope);
        }
        ropes.clear();
    }

    public int[] getPos() {
        return new int[]{xCoord, yCoord, zCoord};
    }
}