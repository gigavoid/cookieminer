package com.gigavoid.supermod.cookiecraft.block;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public interface ICookieStorageBlock extends ICookieBlock {
    long getStorageCap();
    long getCurrentStorage(World world, BlockPos pos);
    void addCookies(World world, BlockPos pos, long numCookies);
    long getTransferSpeed();
}
