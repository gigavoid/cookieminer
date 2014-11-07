package com.gigavoid.supermod.worldgen.trees;

import com.gigavoid.supermod.block.SuperBlocks;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

import java.util.Random;

public class SuperWorldGenNorthrendTree extends WorldGenAbstractTree {
    private boolean northTreeHead[] = new boolean[5 * 5];

    public SuperWorldGenNorthrendTree(boolean p_i45448_1_) {
        super(p_i45448_1_);
        setNorthTreeHead();
    }

    @Override
    public boolean generate(World p_76484_1_, Random p_76484_2_, int p_76484_3_, int p_76484_4_, int p_76484_5_) {
        genTree(p_76484_1_, p_76484_2_, p_76484_3_, p_76484_4_, p_76484_5_);
        return true;
    }

    private void genTree(World world, Random random, int x, int y, int z) {
        if (world.getBlock(x, y - 1, z) == Block.getBlockFromName("snow") && y < 80) {
            int height = 4 + random.nextInt(3);
            for (int k = - 1; k < height; k++) {
                world.setBlock(x, y + k, z, SuperBlocks.northLog);
            }
            world.setBlock(x, y + height, z, SuperBlocks.northLeaves);
            genTreeHead(world, x, y + height - 1, z);
        }
    }

    private void genTreeHead(World world, int x, int y, int z) {
        for (int i = -2; i < 3; i++) {
            for (int j = -2; j < 3; j++) {
                if (world.getBlock(x + i, y, z + j) == Block.getBlockById(0) && northTreeHead[(i + 2) + 5 * (j + 2)]) {
                    world.setBlock(x + i, y, z + j, SuperBlocks.northLeaves);
                }
            }
        }
    }

    private void setNorthTreeHead() {
        northTreeHead[1] = northTreeHead[23] = true;
        northTreeHead[2] = northTreeHead[22] = true;
        northTreeHead[3] = northTreeHead[21] = true;

        for (int i = 5; i < 20; i++) {
            northTreeHead[i] = true;
        }
    }
}
