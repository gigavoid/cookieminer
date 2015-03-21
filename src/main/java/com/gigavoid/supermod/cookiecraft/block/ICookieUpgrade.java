package com.gigavoid.supermod.cookiecraft.block;

import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public interface ICookieUpgrade {
    public double getCPS(World world, BlockPos pos);
}
