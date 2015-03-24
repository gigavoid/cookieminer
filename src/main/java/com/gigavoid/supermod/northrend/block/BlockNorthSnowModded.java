package com.gigavoid.supermod.northrend.block;

import com.gigavoid.supermod.northrend.creativetab.NorthrendCreativeTabs;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSnow;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public class BlockNorthSnowModded extends BlockSnow {
    public BlockNorthSnowModded(){
        super();
        setCreativeTab(NorthrendCreativeTabs.tabNorthrend);
    }

    @Override
    public boolean canPlaceBlockAt(World worldIn, BlockPos pos) {
        IBlockState iblockstate = worldIn.getBlockState(pos.offsetDown());
        Block block = iblockstate.getBlock();
        return block != Blocks.ice && block != Blocks.packed_ice && block != NorthrendBlocks.glacialIce && block != NorthrendBlocks.dragonBone && block != NorthrendBlocks.blight
                && (block.isLeaves(worldIn, pos.offsetDown())
                || (block == this && (Integer) iblockstate.getValue(LAYERS_PROP) == 7
                || block.isOpaqueCube() && block.getMaterial().blocksMovement()));
    }

    @Override
    public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state)
    {
        if (worldIn.provider.getDimensionId() > 0 || !NorthrendBlocks.portalNorthrend.func_176548_d(worldIn, pos)) {
            if(!canPlaceBlockAt(worldIn, pos)){
                worldIn.setBlockToAir(pos);
            }
        }
    }
}
