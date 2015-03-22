package com.gigavoid.supermod.cookiecraft.block;

import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public interface ICookieStorage extends ICookieBlock {
    public long getStorageCap();
    long getCurrentStorage(World world, BlockPos pos);
    void addCookies(World world, BlockPos pos, long numCookies);
}
