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
import java.util.HashMap;
import java.util.List;

/**
 * Created by ineentho on 2014-11-03.
 */
public class TileEntityRopeWheel extends TileEntity {
    public short direction;
    public List<int[]> ropePoints = new ArrayList<int[]>();
    private HashMap<Integer, EntityRope> spawnedRopes = new HashMap<Integer, EntityRope>();

    public static int getRopeId(int[] to, int[] from) {
        int[] id = new int[6];
        if(to[0] > from[0]){
            id[0] = to[0];
            id[1] = from[0];
        }

        if(to[1] > from[1]){
            id[2] = to[1];
            id[3] = from[1];
        }

        if(to[2] > from[2]){
            id[4] = to[2];
            id[5] = from[2];
        }

        String idString = "";
        for(int i : id) {
            idString += i + ".";
        }
        return idString.hashCode();
    }

    public static void addRopeFromTo(World world, int[] from, int[] to) {
        if(from[0] == to[0] && from[1] == to[1] && from[2] == to[2])
            return;

        int id = getRopeId(to, from);

        TileEntity fromTileEntity = world.getTileEntity(from[0], from[1], from[2]);
        TileEntity toTileEntity = world.getTileEntity(to[0], to[1], to[2]);

        if(fromTileEntity == null || toTileEntity == null)
            return;


        TileEntityRopeWheel fromWheel = (TileEntityRopeWheel) fromTileEntity;
        TileEntityRopeWheel toWheel = (TileEntityRopeWheel) toTileEntity;

        if(!fromWheel.containsRopePoint(to))
            fromWheel.addRopePoint(to, id, 0);

        if(!toWheel.containsRopePoint(from))
            toWheel.addRopePoint(from, id, 1);
    }

    private boolean containsRopePoint(int[] to) {
        for(int[] rp : ropePoints) {
            if(rp[0] == to[0] && rp[1] == to[1] && rp[2] == to[2])
                return true;
        }
        return false;
    }

    private void addRopePoint(int[] point, int id, int direction) {
        int[] rope = new int[] {point[0], point[1], point[2], id, direction};
        ropePoints.add(rope);

        if(direction == 1 && worldObj.isRemote)
            spawnRope(rope);
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
    public void invalidate() {
        super.invalidate();

        for(EntityRope rope : spawnedRopes.values()) {
            rope.setDead();
        }

        for(int[] rope : ropePoints) {
            int x = rope[0];
            int y = rope[1];
            int z = rope[2];

            TileEntity tileEntity = worldObj.getTileEntity(x, y, z);
            if(tileEntity != null && tileEntity instanceof TileEntityRopeWheel) {
                TileEntityRopeWheel ropeWheel = (TileEntityRopeWheel) tileEntity;
                ropeWheel.removeRopeTo(getPos());
            }
        }
    }

    private void removeRopeTo(int[] pos) {
        for(int[] rope : ropePoints) {
            if(rope[0] == pos[0] && rope[1] == pos[1] && rope[2] == pos[2]) {
                ropePoints.remove(rope);
                int id = rope[3];

                EntityRope entityRope = spawnedRopes.get(id);
                if(entityRope != null)
                    entityRope.setDead();

                return;
            }
        }
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
        spawnRopes();
    }


    private void spawnRope(int[] ropePoint) {
        int direction = ropePoint[4];
        if(direction == 0)
            return;

        int rX = ropePoint[0];
        int rY = ropePoint[1];
        int rZ = ropePoint[2];
        int id = ropePoint[3];
        EntityRope rope = new EntityRope(worldObj, xCoord, yCoord, zCoord, rX, rY, rZ);
        worldObj.spawnEntityInWorld(rope);
        spawnedRopes.put(id, rope);
    }

    public void spawnRopes() {
        for(int[] ropePoint : ropePoints) {
            spawnRope(ropePoint);
        }
    }


    public int[] getPos() {
        return new int[]{xCoord, yCoord, zCoord};
    }

}