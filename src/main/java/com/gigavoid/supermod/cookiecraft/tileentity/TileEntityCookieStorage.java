package com.gigavoid.supermod.cookiecraft.tileentity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

public class TileEntityCookieStorage extends TileEntity {
    private long cookies;

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);
        cookies = compound.getLong("Cookies");
    }

    @Override
    public void writeToNBT(NBTTagCompound compound) {
        compound.setDouble("Cookies", cookies);
        super.writeToNBT(compound);
    }

    public void addCookies(long cookies) {
        setCookies(this.cookies + cookies);
        worldObj.markBlockForUpdate(pos);
        System.out.println(this.cookies);
    }

    public void setCookies(long cookies) {
        this.cookies = cookies;
        worldObj.markBlockForUpdate(pos);
    }

    public long getCookies() {
        return cookies;
    }

    @Override
    public Packet getDescriptionPacket() {
        NBTTagCompound compound = new NBTTagCompound();
        compound.setLong("Cookies", cookies);
        return new S35PacketUpdateTileEntity(pos, 1, compound);
    }

    @Override
    public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt) {
        NBTTagCompound compound = pkt.getNbtCompound();
        cookies = compound.getLong("Cookies");
    }
}
