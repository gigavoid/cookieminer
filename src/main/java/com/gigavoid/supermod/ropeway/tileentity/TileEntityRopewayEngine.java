package com.gigavoid.supermod.ropeway.tileentity;

import com.gigavoid.supermod.ropeway.entity.EntityRope;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagIntArray;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.util.Constants;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TileEntityRopewayEngine extends TileEntity {
    public List<int[]> ropePoints = new ArrayList<int[]>();
    private HashMap<Integer, EntityRope> spawnedRopes = new HashMap<Integer, EntityRope>();

    public static int getRopeId(BlockPos to, BlockPos from) {
        int[] id = new int[6];
        if(to.getX() > from.getX()){
            id[0] = to.getX();
            id[1] = from.getX();
        }

        if(to.getY() > from.getY()){
            id[2] = to.getY();
            id[3] = from.getY();
        }

        if(to.getZ() > from.getZ()){
            id[4] = to.getZ();
            id[5] = from.getZ();
        }

        String idString = "";
        for(int i : id) {
            idString += i + ".";
        }
        return idString.hashCode();
    }

    public static void addRopeFromTo(World world, BlockPos from, BlockPos to) {
        if(from.equals(to))
            return;

        int id = getRopeId(to, from);

        TileEntity fromTileEntity = world.getTileEntity(from);
        TileEntity toTileEntity = world.getTileEntity(to);

        if(fromTileEntity == null || toTileEntity == null)
            return;


        TileEntityRopewayEngine fromWheel = (TileEntityRopewayEngine) fromTileEntity;
        TileEntityRopewayEngine toWheel = (TileEntityRopewayEngine) toTileEntity;

        if(!fromWheel.containsRopePoint(to))
            fromWheel.addRopePoint(to, id, 0);

        if(!toWheel.containsRopePoint(from))
            toWheel.addRopePoint(from, id, 1);
    }

    private boolean containsRopePoint(BlockPos to) {
        for(int[] rp : ropePoints) {
            if(new BlockPos(rp[0], rp[1], rp[2]).equals(to))
                return true;
        }
        return false;
    }

    private void addRopePoint(BlockPos point, int id, int direction) {
        int[] rope = new int[] {point.getX(),point.getY(), point.getZ(), id, direction};
        ropePoints.add(rope);

        if(direction == 1 && worldObj.isRemote)
            spawnRope(rope);
    }

    @Override
    public void readFromNBT(NBTTagCompound tags) {

        NBTTagList list = tags.getTagList("ropePoints", Constants.NBT.TAG_INT_ARRAY);
        for(int i = 0; i < list.tagCount(); i++) {
            int[] ropePoint = list.getIntArray(i);
            ropePoints.add(ropePoint);
        }
        super.readFromNBT(tags);
    }

    @Override
    public void writeToNBT(NBTTagCompound tags) {
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
            BlockPos pos = new BlockPos(rope[0], rope[1], rope[2]);

            TileEntity tileEntity = worldObj.getTileEntity(pos);
            if(tileEntity != null && tileEntity instanceof TileEntityRopewayEngine) {
                TileEntityRopewayEngine ropeWheel = (TileEntityRopewayEngine) tileEntity;
                ropeWheel.removeRopeTo(pos);
            }
        }
    }

    private void removeRopeTo(BlockPos pos) {
        for(int[] rope : ropePoints) {
            if(pos.equals(new BlockPos(rope[0], rope[1], rope[2]))) {
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
        return new S35PacketUpdateTileEntity(pos, 1, tags);
    }


    @Override
    public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt) {
        readFromNBT(pkt.getNbtCompound());
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
        BlockPos targetPos = new BlockPos(rX, rY, rZ);

        EntityRope rope = new EntityRope(worldObj, pos, targetPos);
        worldObj.spawnEntityInWorld(rope);
        spawnedRopes.put(id, rope);
    }

    public void spawnRopes() {
        for(int[] ropePoint : ropePoints) {
            spawnRope(ropePoint);
        }
    }

}
