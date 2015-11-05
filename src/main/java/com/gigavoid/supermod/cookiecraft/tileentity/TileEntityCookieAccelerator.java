package com.gigavoid.supermod.cookiecraft.tileentity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.server.gui.IUpdatePlayerListBox;
import net.minecraft.tileentity.TileEntity;

public class TileEntityCookieAccelerator extends TileEntity implements IUpdatePlayerListBox {
    public static final String KEY_IS_ACTIVE = "isActive";

    private boolean isActive;

    public boolean isActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
        worldObj.markBlockForUpdate(pos);
        worldObj.markChunkDirty(pos, null);
    }

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);
        isActive = compound.getBoolean(KEY_IS_ACTIVE);
    }

    @Override
    public void writeToNBT(NBTTagCompound compound) {
        compound.setBoolean(KEY_IS_ACTIVE, isActive);
        super.writeToNBT(compound);
    }

    @Override
    public void update() {

    }


    @Override
    public Packet getDescriptionPacket() {
        NBTTagCompound compound = new NBTTagCompound();
        compound.setBoolean(KEY_IS_ACTIVE, isActive);
        return new S35PacketUpdateTileEntity(pos, 1, compound);
    }

    @Override
    public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt) {
        NBTTagCompound compound = pkt.getNbtCompound();
        isActive = compound.getBoolean(KEY_IS_ACTIVE);
    }
}
