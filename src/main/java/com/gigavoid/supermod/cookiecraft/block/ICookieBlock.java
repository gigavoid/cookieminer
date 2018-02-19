package com.gigavoid.supermod.cookiecraft.block;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public interface ICookieBlock {
    boolean shouldSideBeRendered(IBlockAccess worldIn, BlockPos pos, EnumFacing side);

    boolean isOpaqueCube();

    void onNeighborBlockChange(World worldIn, BlockPos pos, IBlockState state, Block neighborBlock);
}
