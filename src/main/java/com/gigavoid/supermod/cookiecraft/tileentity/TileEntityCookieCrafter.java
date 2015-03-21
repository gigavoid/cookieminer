package com.gigavoid.supermod.cookiecraft.tileentity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TileEntityCookieCrafter extends TileEntity {

    private double cps;

    /**
     * Leftover from last tick
     */
    private double leftover;

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);
        cps = compound.getDouble("CPS");
        leftover = compound.getDouble("leftover");
    }

    @Override
    public void writeToNBT(NBTTagCompound compound) {
        compound.setDouble("CPS", cps);
        compound.setDouble("leftover", leftover);
        super.writeToNBT(compound);
    }

    public void setCPS(double cps) {
        System.out.println("Set " + cps + " @ " + this);
        this.cps = cps;
    }

    public double getCPS() {
        System.out.println("Get " + cps + " @ " + this);
        return cps;
    }

    public double getLeftover() {
        return leftover;
    }

    public void setLeftover(double leftover) {
        this.leftover = leftover;
    }
}
