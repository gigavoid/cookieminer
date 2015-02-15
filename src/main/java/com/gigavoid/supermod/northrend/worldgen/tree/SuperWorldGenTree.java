package com.gigavoid.supermod.northrend.worldgen.tree;

import com.gigavoid.supermod.northrend.block.NorthrendBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenTrees;

import java.util.Random;

public class SuperWorldGenTree extends WorldGenTrees {
    private boolean northTreeHead[] = new boolean[5 * 5];

    public static enum TreeType{ REGULAR, FIR }

    TreeType type;

    public SuperWorldGenTree(boolean p_i45448_1_, TreeType type) {
        super(p_i45448_1_);
        this.type = type;
        setNorthTreeHead();
    }

    @Override
    public boolean generate(World p_76484_1_, Random p_76484_2_, BlockPos pos) {
        if (p_76484_1_.getBlockState(pos.add(0, -2, 0)) == NorthrendBlocks.northDirt.getDefaultState()) {
            if (type == TreeType.REGULAR)
                genTree(p_76484_1_, p_76484_2_, pos);
            else if (type == TreeType.FIR)
                genTreeFir(p_76484_1_, p_76484_2_, pos);
            return true;
        }
        return false;
    }

    private void genTree(World world, Random random, BlockPos pos) {
        if (world.getBlockState(pos.add(0, -1, 0)) == Block.getBlockFromName("snow") && pos.getY() < 80) {
            int height = 4 + random.nextInt(3);
            for (int k = - 1; k < height; k++) {
                world.setBlockState(pos.add(0, k, 0), NorthrendBlocks.northLog.getDefaultState());
            }
            world.setBlockState(pos.add(0, height, 0), NorthrendBlocks.northLeaves.getDefaultState());
            genTreeHead(world, random, pos.add(0, height - 1, 0));
        }
    }

    private void genTreeHead(World world, Random r, BlockPos pos) {
        IBlockState block;
        for (int i = -2; i < 3; i++) {
            for (int j = -2; j < 3; j++) {
                if ((world.getBlockState(pos.add(i, 0, j)) == Blocks.air || world.getBlockState(pos.add(i, 0, j)) == Blocks.snow_layer) && northTreeHead[(i + 2) + 5 * (j + 2)]) {
                    if (((i == -2 || i == 2) && (j == -1 || j == 1)) || ((i == -1 || i == 1) && (j == -2 || j == 2)))
                        block = .85f > r.nextFloat() ? NorthrendBlocks.northLeaves.getDefaultState() : Blocks.air.getDefaultState();
                    else
                        block = NorthrendBlocks.northLeaves.getDefaultState();
                    world.setBlockState(pos.add(i, 0, j), block);
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

    private void genTreeFir(World world, Random random, BlockPos pos) {
        if (world.getBlockState(pos.add(0, -1, 0)) == Block.getBlockFromName("snow") && pos.getY() < 80) {
            int height = 5 + random.nextInt(3);
            for (int k = - 1; k < height; k++) {
                world.setBlockState(pos.add(0, k, 0), NorthrendBlocks.northLog.getDefaultState());
            }
            genTreeHeadFir(world, random, pos, height);
        }
    }

    private void genTreeHeadFir(World world, Random r, BlockPos pos, int height) {
        IBlockState block;
        for (int i = -2; i < 3; i++) {
            for (int j = -2; j < 3; j++) {
                for (int k = -4; k < 2; k++) {
                    block = world.getBlockState(pos.add(i, k + height, j));
                    if ((world.getBlockState(pos.add(i, k + height, j)) == Blocks.air || world.getBlockState(pos.add(i, 0, j)) == Blocks.snow_layer)) {
                        block = Blocks.air.getDefaultState();
                        switch (k) {
                            case -4:
                                if ((i == -2 || i == 2) && (j != -2 && j != 2) || (i > -2 && i < 2))
                                    if (((i == -2 || i == 2) && (j == -1 || j == 1)) || ((i == -1 || i == 1) && (j == -2 || j == 2)))
                                        block = .95f > r.nextFloat() ? NorthrendBlocks.northLeaves.getDefaultState() : Blocks.air.getDefaultState();
                                    else
                                        block = NorthrendBlocks.northLeaves.getDefaultState();
                                break;
                            case -3:
                                if (((i == -2 || i == 2) && j == 0) || (i == -1 || i == 1) && (j != -2 && j != 2) || i == 0)
                                    block = NorthrendBlocks.northLeaves.getDefaultState();
                                break;
                            case -2:
                                if (i != -2 && i != 2 && j != -2 && j != 2)
                                    if (i == -1 && j == -1 || i == -1 && j == 1 || i == 1 && j == -1 || i == 1 && j == 1)
                                        block = .9f > r.nextFloat() ? NorthrendBlocks.northLeaves.getDefaultState() : Blocks.air.getDefaultState();
                                    else
                                        block = NorthrendBlocks.northLeaves.getDefaultState();
                                break;
                            case -1:
                                if (i > -2 && i < 2 && j > -2 && j < 2 && (i == 0 || j == 0))
                                    block = .95f > r.nextFloat() ? NorthrendBlocks.northLeaves.getDefaultState() : Blocks.air.getDefaultState();
                                break;
                            case 0:
                                if (i == 0 && j == 0)
                                    block = NorthrendBlocks.northLeaves.getDefaultState();
                                break;
                            case 1:
                                if (i == 0 && j == 0)
                                    block = .75f > r.nextFloat() ? NorthrendBlocks.northLeaves.getDefaultState() : Blocks.air.getDefaultState();
                                break;
                        }
                    }
                    world.setBlockState(pos.add(i, k + height, j), block);
                }
            }
        }
    }
}
