package com.gigavoid.supermod.tileentity;

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
    public float rot = 0;
    public short direction;
    public List<int[]> ropePoints = new ArrayList<int[]>();

    public static void addRopeFromTo(World world, int[] from, int[] to) {
        TileEntityRopeWheel startBlock = (TileEntityRopeWheel) world.getTileEntity(from[0], from[1], from[2]);
        startBlock.addRopePoint(to);
    }

    private void addRopePoint(int[] point) {
        ropePoints.add(point);
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
    }
}