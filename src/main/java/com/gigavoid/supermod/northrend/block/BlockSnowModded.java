package com.gigavoid.supermod.northrend.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSnow;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public class BlockSnowModded extends BlockSnow {
    public BlockSnowModded(){super();}

    @Override
    public boolean canPlaceBlockAt(World worldIn, BlockPos pos) {
        IBlockState iblockstate = worldIn.getBlockState(pos.offsetDown());
        Block block = iblockstate.getBlock();
        return block != Blocks.ice && block != Blocks.packed_ice && block != NorthrendBlocks.glacialIce && block != NorthrendBlocks.dragonBone && block != NorthrendBlocks.blight
                && (block.isLeaves(worldIn, pos.offsetDown())
                || (block == this && (Integer) iblockstate.getValue(LAYERS_PROP) == 7
                || block.isOpaqueCube() && block.getMaterial().blocksMovement()));
    }
}
