package com.gigavoid.supermod.tileentity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

/**
 * Created by ineentho on 2014-11-03.
 */
public class TileEntityRopeWheel extends TileEntity {
    public float rot = 0;
    public short direction;

    public void frame() {
        rot += .05f;
    }

    @Override
    public void readFromNBT(NBTTagCompound tags) {
        direction = tags.getShort("direction");
        super.readFromNBT(tags);
    }

    @Override
    public void writeToNBT(NBTTagCompound tags) {
        tags.setShort("direction", direction);
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