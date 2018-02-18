package com.gigavoid.supermod.cookiecraft.tileentity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

public class TileEntityCookieCrafter extends TileEntity {

    private double cps;

    /**
     * Leftover cookies from last tick
     */
    private double leftover;

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);
        cps = compound.getDouble("CPS");
        leftover = compound.getDouble("leftover");
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        compound.setDouble("CPS", cps);
        compound.setDouble("leftover", leftover);
        super.writeToNBT(compound);
        return compound;
    }

    public void setCPS(double cps) {
        this.cps = cps;
        //TODO: Update?
    }

    public double getCPS() {
        return cps;
    }

    public double getLeftover() {
        return leftover;
    }

    public void setLeftover(double leftover) {
        this.leftover = leftover;
    }

    @Override
    public NBTTagCompound getUpdateTag() {
        NBTTagCompound tag = super.getUpdateTag();
        tag.setDouble("CPS", cps);
        return tag;
    }

    @Override
    public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity pkt) {
        NBTTagCompound compound = pkt.getNbtCompound();
        cps = compound.getDouble("CPS");
    }
}
