package com.gigavoid.supermod.cookiecraft.tileentity;

import com.gigavoid.supermod.cookiecraft.cookie.CookieNetwork;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.server.gui.IUpdatePlayerListBox;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;

public class  TileEntityMoonlightReflector extends TileEntity implements IUpdatePlayerListBox{
    public static final String KEY_IS_ACTIVE = "isActive";

    private boolean isActive;
    private int tick = 0;

    public boolean isActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
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
        tick++;

        if (tick % 100 == 0) {
            boolean isActive = isTopBlock() && !isDay();

            if (isActive != isActive()) {
                setIsActive(isActive);
                CookieNetwork.getNetwork(worldObj, pos).updateNetwork(worldObj, pos);
            }
        }
    }

    /**
     * Custom isDay method since the one provided by Minecraft only works on the server side
     */
    private boolean isDay() {
        return worldObj.getWorldTime() % 24000 > 0 && worldObj.getWorldTime() % 24000 < 12000;
    }

    private boolean isTopBlock() {
        for (int i = pos.getY() + 1; i < 256; i++){
            if (worldObj.getBlockState(new BlockPos(pos.getX(), i, pos.getZ())).getBlock() != Blocks.air){
                return false;
            }
        }
        return true;
    }
}
