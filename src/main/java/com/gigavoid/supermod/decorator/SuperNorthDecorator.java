package com.gigavoid.supermod.decorator;

import com.gigavoid.supermod.block.SuperBlocks;
import net.minecraft.block.Block;
import net.minecraft.world.World;

import java.util.Random;

public class SuperNorthDecorator extends SuperDecorator {
    @Override
    public void genDecorations(World p_76728_1_, Random p_76728_2_, int p_76728_3_, int p_76728_4_) {
        super.genDecorations(p_76728_1_, p_76728_2_, p_76728_3_, p_76728_4_);
        genTrees(p_76728_1_, p_76728_2_, p_76728_3_, p_76728_4_);
    }

    private void genTrees(World world, Random random, int cx, int cy){
        int trees = northTreesPerChunk;
        for (int i = trees; i > 0; i--) {
            int posX = cx + random.nextInt(16);
            int posY = cy + random.nextInt(16);
            for (int j = 128; j > 61; j--) {
                if (world.getBlock(posX, j, posY) == Block.getBlockFromName("snow")) {
                    int height = 4 + random.nextInt(3) - 1;
                    for (int k = 0; k < height; k++){
                        world.setBlock(posX, j + k, posY, SuperBlocks.northLog);
                    }
                    this.setBlockAndNotifyAdequately(world, posX, j + height + 1, posY, SuperBlocks.northLeaves, 0);
                    genTreeHead(world, posX, j + height - 1, posY);
                    break;
                }
            }
        }
    }

    private void genTreeHead(World world, int x, int y, int z){
        for (int i = -2; i < 3; i++){
            for (int j = -2; j < 3; j++){
                if (world.getBlock(x + i, y, z + j) == Block.getBlockById(0) && northTreeHead[(i + 2) + 5 * (j + 2)]) {
                    this.setBlockAndNotifyAdequately(world, x + i, y, z + j, SuperBlocks.northLeaves, 0);
                }
            }
        }
    }
}
