package com.gigavoid.supermod.worldgen.trees;

import com.gigavoid.supermod.block.SuperBlocks;
import net.minecraft.block.BlockSapling;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

import java.util.Random;

public class SuperWorldGenBloodTree extends WorldGenAbstractTree {

    public SuperWorldGenBloodTree(boolean p_i45448_1_) {
        super(p_i45448_1_);
    }

    @Override
    public boolean generate(World p_76484_1_, Random p_76484_2_, BlockPos pos) {
        genTree(p_76484_1_, p_76484_2_, pos);
        return true;
    }

    private void genTree(World world, Random random, BlockPos pos) {
        int height = 6 + random.nextInt(3);
        IBlockState block2 = world.getBlockState(pos.add(0, -1, 0));
        boolean isSoil = block2.getBlock().canSustainPlant(world, pos.add(0, -1, 0), EnumFacing.UP, (BlockSapling) Blocks.sapling);
        if (isSoil && pos.getY() + height + 3 < 256) {
            for (int k = 0; k < height; k++) {
                if (k < (height / 2))
                    world.setBlockState(pos.add(0, k, 0), SuperBlocks.bone.getDefaultState());
                else
                    world.setBlockState(pos.add(0, k, 0), SuperBlocks.meat.getDefaultState());
                if (k > height / 4 && k < height - 1) {
                    world.setBlockState(pos.add(1, k, 0), SuperBlocks.meat.getDefaultState());
                    world.setBlockState(pos.add(0, k, 1), SuperBlocks.meat.getDefaultState());
                    world.setBlockState(pos.add(1, k, 0), SuperBlocks.meat.getDefaultState());
                    world.setBlockState(pos.add(0, k, 1), SuperBlocks.meat.getDefaultState());
                    if (k == height / 2 || k == (height / 2) + 1) {
                        int r = random.nextInt(10);
                        if (random.nextInt(10) < 6) world.setBlockState(pos.add(2, k, 0), SuperBlocks.meat.getDefaultState());
                        if (random.nextInt(10) < 6) world.setBlockState(pos.add(0, k, 2), SuperBlocks.meat.getDefaultState());
                        if (random.nextInt(10) < 6) world.setBlockState(pos.add(2, k, 0), SuperBlocks.meat.getDefaultState());
                        if (random.nextInt(10) < 6) world.setBlockState(pos.add(0, k, 2), SuperBlocks.meat.getDefaultState());
                        if (random.nextInt(10) < 6) world.setBlockState(pos.add(1, k, 1), SuperBlocks.meat.getDefaultState());
                        if (random.nextInt(10) < 6) world.setBlockState(pos.add(1, k, 1), SuperBlocks.meat.getDefaultState());
                        if (random.nextInt(10) < 6) world.setBlockState(pos.add(1, k, 1), SuperBlocks.meat.getDefaultState());
                        if (random.nextInt(10) < 6) world.setBlockState(pos.add(1, k, 1), SuperBlocks.meat.getDefaultState());
                    }
                }
            }
        }
    }
}
