package com.gigavoid.supermod.decorator;

import com.gigavoid.supermod.block.SuperBlocks;
import net.minecraft.block.Block;
import net.minecraft.world.World;

import java.util.Random;

public class SuperEmeraldDecorator extends SuperDecorator {
    @Override
    public void genDecorations(World p_76728_1_, Random p_76728_2_, int p_76728_3_, int p_76728_4_) {
        super.genDecorations(p_76728_1_, p_76728_2_, p_76728_3_, p_76728_4_);
        genFlowers(p_76728_1_, p_76728_2_, p_76728_3_, p_76728_4_);
    }

    private void genFlowers(World p_76728_1_, Random p_76728_2_, int p_76728_3_, int p_76728_4_) {
        int flowers = emeraldFlowersPerChunk + p_76728_2_.nextInt(2);
        for (int i = flowers; i > 0; i--) {
            int posX = p_76728_3_ + p_76728_2_.nextInt(16);
            int posY = p_76728_4_ + p_76728_2_.nextInt(16);
            for (int j = 128; j > 60; j--) {
                if (p_76728_1_.getBlock(posX, j, posY) == Block.getBlockById(2) && p_76728_1_.getBlock(posX, j + 1, posY) == Block.getBlockById(0)) {
                    p_76728_1_.setBlock(posX, j + 1, posY, SuperBlocks.emeraldFlower);
                }
            }
        }
    }
}
