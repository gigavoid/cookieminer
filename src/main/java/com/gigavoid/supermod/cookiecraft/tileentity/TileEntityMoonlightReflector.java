package com.gigavoid.supermod.cookiecraft.tileentity;

import com.gigavoid.supermod.cookiecraft.cookie.CookieNetwork;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;

public class  TileEntityMoonlightReflector extends TileEntityCookieGenerator implements ITickable{
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
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        compound.setBoolean(KEY_IS_ACTIVE, isActive);
        super.writeToNBT(compound);
        return compound;
    }

    @Override
    public void update() {
        tick++;

        if (tick % 100 == 0) {
            boolean isActive = isTopBlock() && !isDay();

            if (isActive != isActive()) {
                setIsActive(isActive);
                CookieNetwork.getNetwork(world, pos).updateNetwork();
            }
        }
    }

    /**
     * Custom isDay method since the one provided by Minecraft only works on the server side
     */
    private boolean isDay() {
        return world.getWorldTime() % 24000 > 0 && world.getWorldTime() % 24000 < 12000;
    }

    private boolean isTopBlock() {
        for (int i = pos.getY() + 1; i < 256; i++){
            if (world.getBlockState(new BlockPos(pos.getX(), i, pos.getZ())).getBlock() != Blocks.AIR){
                return false;
            }
        }
        return true;
    }
}
