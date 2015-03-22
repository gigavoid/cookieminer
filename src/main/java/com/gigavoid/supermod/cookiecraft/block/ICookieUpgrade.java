package com.gigavoid.supermod.cookiecraft.block;

import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public interface ICookieUpgrade extends ICookieBlock {
    public double getCPS(World world, BlockPos pos, IBlockState state);
}
