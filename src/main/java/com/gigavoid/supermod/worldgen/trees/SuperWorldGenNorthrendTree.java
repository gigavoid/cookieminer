package com.gigavoid.supermod.worldgen.trees;

import com.gigavoid.supermod.block.SuperBlocks;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import sun.reflect.generics.tree.Tree;

import java.util.Random;

public class SuperWorldGenNorthrendTree extends WorldGenAbstractTree {
    private boolean northTreeHead[] = new boolean[5 * 5];

    public static enum TreeType{ REGULAR, FIR }

    TreeType type;

    public SuperWorldGenNorthrendTree(boolean p_i45448_1_, TreeType type) {
        super(p_i45448_1_);
        this.type = type;
        setNorthTreeHead();
    }

    @Override
    public boolean generate(World p_76484_1_, Random p_76484_2_, int p_76484_3_, int p_76484_4_, int p_76484_5_) {
        if (type == TreeType.REGULAR)
            genTree(p_76484_1_, p_76484_2_, p_76484_3_, p_76484_4_, p_76484_5_);
        else if (type == TreeType.FIR)
            genTreeFir(p_76484_1_, p_76484_2_, p_76484_3_, p_76484_4_, p_76484_5_);
        return true;
    }

    private void genTree(World world, Random random, int x, int y, int z) {
        if (world.getBlock(x, y - 1, z) == Block.getBlockFromName("snow") && y < 80) {
            int height = 4 + random.nextInt(3);
            for (int k = - 1; k < height; k++) {
                world.setBlock(x, y + k, z, SuperBlocks.northLog);
            }
            world.setBlock(x, y + height, z, SuperBlocks.northLeaves);
            genTreeHead(world, random, x, y + height - 1, z);
        }
    }

    private void genTreeHead(World world, Random r, int x, int y, int z) {
        Block block;
        for (int i = -2; i < 3; i++) {
            for (int j = -2; j < 3; j++) {
                if ((world.getBlock(x + i, y, z + j) == Blocks.air || world.getBlock(x + i, y, z + j) == Blocks.snow_layer) && northTreeHead[(i + 2) + 5 * (j + 2)]) {
                    if (((i == -2 || i == 2) && (j == -1 || j == 1)) || ((i == -1 || i == 1) && (j == -2 || j == 2)))
                        block = .85f > r.nextFloat() ? SuperBlocks.northLeaves : Blocks.air;
                    else
                        block = SuperBlocks.northLeaves;
                    world.setBlock(x + i, y, z + j, block);
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

    private void genTreeFir(World world, Random random, int x, int y, int z) {
        if (world.getBlock(x, y - 1, z) == Block.getBlockFromName("snow") && y < 80) {
            int height = 5 + random.nextInt(3);
            for (int k = - 1; k < height; k++) {
                world.setBlock(x, y + k, z, SuperBlocks.northLog);
            }
            genTreeHeadFir(world, random, x, y, z, height);
        }
    }

    private void genTreeHeadFir(World world, Random r, int x, int y, int z, int height) {
        Block block;
        for (int i = -2; i < 3; i++) {
            for (int j = -2; j < 3; j++) {
                for (int k = -4; k < 2; k++) {
                    block = world.getBlock(x + i, y + k + height, z + j);
                    if ((world.getBlock(x + i, y + k + height, z + j) == Blocks.air || world.getBlock(x + i, y, z + j) == Blocks.snow_layer)) {
                        block = Blocks.air;
                        switch (k) {
                            case -4:
                                if ((i == -2 || i == 2) && (j != -2 && j != 2) || (i > -2 && i < 2))
                                    if (((i == -2 || i == 2) && (j == -1 || j == 1)) || ((i == -1 || i == 1) && (j == -2 || j == 2)))
                                        block = .95f > r.nextFloat() ? SuperBlocks.northLeaves : Blocks.air;
                                    else
                                        block = SuperBlocks.northLeaves;
                                break;
                            case -3:
                                if (((i == -2 || i == 2) && j == 0) || (i == -1 || i == 1) && (j != -2 && j != 2) || i == 0)
                                    block = SuperBlocks.northLeaves;
                                break;
                            case -2:
                                if (i != -2 && i != 2 && j != -2 && j != 2)
                                    if (i == -1 && j == -1 || i == -1 && j == 1 || i == 1 && j == -1 || i == 1 && j == 1)
                                        block = .9f > r.nextFloat() ? SuperBlocks.northLeaves : Blocks.air;
                                    else
                                        block = SuperBlocks.northLeaves;
                                break;
                            case -1:
                                if (i > -2 && i < 2 && j > -2 && j < 2 && (i == 0 || j == 0))
                                    block = .95f > r.nextFloat() ? SuperBlocks.northLeaves : Blocks.air;
                                break;
                            case 0:
                                if (i == 0 && j == 0)
                                    block = SuperBlocks.northLeaves;
                                break;
                            case 1:
                                if (i == 0 && j == 0)
                                    block = .75f > r.nextFloat() ? SuperBlocks.northLeaves : Blocks.air;
                                break;
                        }
                    }
                    world.setBlock(x + i, y + k + height, z + j, block);
                }
            }
        }
    }
}
