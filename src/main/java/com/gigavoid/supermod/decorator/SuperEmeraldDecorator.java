package com.gigavoid.supermod.decorator;

import com.gigavoid.supermod.block.SuperBlocks;
import net.minecraft.block.Block;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

public class SuperEmeraldDecorator extends SuperDecorator {
    @Override
    public void genDecorations(World p_76728_1_, Random p_76728_2_, BlockPos pos) {
        super.genDecorations(p_76728_1_, p_76728_2_, pos);
        genFlowers(p_76728_1_, p_76728_2_, pos);
    }

    private void genFlowers(World world, Random rand, BlockPos pos) {
        if (world.getBlockState(pos) == Block.getStateById(2) && rand.nextFloat() > .95f){
            world.setBlockState(new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ()), SuperBlocks.emeraldFlower.getDefaultState());
        }
    }
}
