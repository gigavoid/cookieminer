package com.gigavoid.supermod.northrend.worldgen.tree;

import com.gigavoid.supermod.northrend.block.NorthrendBlocks;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

import java.util.Random;

public class NorthrendWorldGenGlacierCrack extends WorldGenAbstractTree {
    public NorthrendWorldGenGlacierCrack(boolean b){
        super(b);
    }

    @Override
    public boolean generate(World world, Random random, BlockPos blockPos) {
        int depth = -random.nextInt(20) + 4;
        for (int i = 0; i > depth; i--){
            if (world.getBlockState(blockPos).getBlock() == NorthrendBlocks.glacialIce){
                world.setBlockState(blockPos.add(0, i, 0), Blocks.air.getDefaultState());
                for (int j = -1; j < 2; j++){
                    for (int k = -1; k < 2; k++){
                        if ((j == 0 || k == 0) && random.nextFloat() < .85f){
                            world.setBlockState(blockPos.add(j, i, k), Blocks.air.getDefaultState());
                        }
                        else if (random.nextFloat() < .4f){
                            world.setBlockState(blockPos.add(j, i, k), Blocks.air.getDefaultState());
                        }
                    }
                }
            }
        }
        return true;
    }
}
