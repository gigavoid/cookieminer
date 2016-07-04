package com.gigavoid.supermod.cookiecraft.block;

import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public interface ICookieGenerator extends ICookieBlock {
    double getCPS(World world, BlockPos pos, IBlockState state);
    double getModifiedCPS(World world, BlockPos pos, IBlockState state);
}
