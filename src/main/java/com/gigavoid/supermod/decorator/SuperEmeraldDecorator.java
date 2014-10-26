package com.gigavoid.supermod.decorator;

import com.gigavoid.supermod.block.SuperBlocks;
import net.minecraft.block.Block;
import net.minecraft.world.World;

import java.util.Random;

public class SuperEmeraldDecorator extends SuperDecorator {
    @Override
    public void genDecorations(World p_76728_1_, Random p_76728_2_, int p_76728_3_, int p_76728_4_) {
        super.genDecorations(p_76728_1_, p_76728_2_, p_76728_3_, p_76728_4_);
        genBigTrees(p_76728_1_, p_76728_2_, p_76728_3_, p_76728_4_);
        genTrees(p_76728_1_, p_76728_2_, p_76728_3_, p_76728_4_);
        genFlowers(p_76728_1_, p_76728_2_, p_76728_3_, p_76728_4_);
    }

    private void genFlowers(World p_76728_1_, Random p_76728_2_, int p_76728_3_, int p_76728_4_)
    {
        int flowers = emeraldFlowersPerChunk + p_76728_2_.nextInt(5) - 2;
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

    private void genBigTrees(World world, Random random, int cx, int cy){
        int trees = emeraldBigTreesPerChunk;
        for (int i = trees; i > 0; i--) {
            int posX = cx + random.nextInt(16);
            int posY = cy + random.nextInt(16);
            for (int j = 128; j > 60; j--) {
                if (world.getBlock(posX, j, posY) == Block.getBlockById(2) || world.getBlock(posX, j, posY) == Block.getBlockById(3)) {
                    if (world.getBlock(posX, j + 1, posY) == Block.getBlockById(0) || world.getBlock(posX, j + 1, posY) == Block.getBlockById(9)) {
                        int height = 40 + random.nextInt(10) - 5;
                        for (int k = 0; k < 5; k++) {
                            int startheight = 5 + random.nextInt(height - 10);
                            int bposX = posX + random.nextInt(4) - 1;
                            int bposY = posY + random.nextInt(4) - 1;
                            if (bposX == 1)
                                bposX--;
                            else if (bposX == 2)
                                bposX++;
                            if (bposY == 1)
                                bposY--;
                            else if (bposY == 2)
                                bposY++;
                            world.setBlock(bposX, j + startheight, bposY, SuperBlocks.emeraldLog);
                            genTreeHead(world, bposX, j + startheight, bposY);
                        }
                        for (int k = j; k < j + height; k++) {
                            world.setBlock(posX, k + 1, posY, SuperBlocks.emeraldLog);
                            world.setBlock(posX + 1, k + 1, posY, SuperBlocks.emeraldLog);
                            world.setBlock(posX, k + 1, posY + 1, SuperBlocks.emeraldLog);
                            world.setBlock(posX + 1, k + 1, posY + 1, SuperBlocks.emeraldLog);
                        }
                        for (int k = j; k > j - 3; k--) {
                            if (world.getBlock(posX, k, posY) == Block.getBlockById(0) || world.getBlock(posX, k, posY) == Block.getBlockById(9))
                                world.setBlock(posX, k, posY, SuperBlocks.emeraldLog);
                            if (world.getBlock(posX + 1, k, posY) == Block.getBlockById(0) || world.getBlock(posX + 1, k, posY) == Block.getBlockById(9))
                                world.setBlock(posX + 1, k, posY, SuperBlocks.emeraldLog);
                            if (world.getBlock(posX, k, posY + 1) == Block.getBlockById(0) || world.getBlock(posX, k, posY + 1) == Block.getBlockById(9))
                                world.setBlock(posX, k, posY + 1, SuperBlocks.emeraldLog);
                            if (world.getBlock(posX + 1, k, posY + 1) == Block.getBlockById(0) || world.getBlock(posX + 1, k, posY + 1) == Block.getBlockById(9))
                                world.setBlock(posX + 1, k, posY + 1, SuperBlocks.emeraldLog);
                        }
                        genTreeHead(world, posX, j + height - 1, posY);
                        genTreeHead(world, posX + 1, j + height - 1, posY);
                        genTreeHead(world, posX, j + height - 1, posY + 1);
                        genTreeHead(world, posX + 1, j + height - 1, posY + 1);
                    }
                    break;
                }
            }
        }
    }

    private void genTrees(World world, Random random, int cx, int cy){
        int trees = emeraldTreesPerChunk;
        for (int i = trees; i > 0; i--) {
            int posX = cx + random.nextInt(16);
            int posY = cy + random.nextInt(16);
            for (int j = 128; j > 60; j--) {
                if (world.getBlock(posX, j, posY) == Block.getBlockById(2) || world.getBlock(posX, j, posY) == Block.getBlockById(3)) {
                    int height = 9 + random.nextInt(4) - 1;
                    for (int k = 0; k < height; k++){
                        world.setBlock(posX, j + k + 1, posY, SuperBlocks.emeraldLog);
                    }
                    genTreeHead(world, posX, j + height - 1, posY);
                    break;
                }
            }
        }
    }

    private void genTreeHead(World world, int x, int y, int z){
        for (int i = -3; i < 4; i++){
            for (int j = -3; j < 4; j++){
                for (int k = 0; k < 3; k++){
                    if (world.getBlock(x + i, y + k, z + j) == Block.getBlockById(0) && emeraldTreeHead[(i + 3)  + 7 * (j + 3) + 49 * k]){
                        world.setBlock(x + i, y + k, z + j, SuperBlocks.emeraldLeaves);
                    }
                }
            }
        }
    }
}
