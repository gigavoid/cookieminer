package com.gigavoid.supermod.northrend.worldgen.tree;

import com.gigavoid.supermod.northrend.block.NorthrendBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLog;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

import java.util.Random;

public class NorthrendWorldGenTree extends WorldGenAbstractTree {
    private boolean northTreeHead[] = new boolean[5 * 5];

    public static final PropertyEnum AXIS_PROP = PropertyEnum.create("axis", BlockLog.EnumAxis.class);
    public static enum TreeType{ DEFAULT, PINE, FIR, BIRCH}

    TreeType type;

    public NorthrendWorldGenTree(boolean p_i45448_1_, TreeType type) {
        super(p_i45448_1_);
        this.type = type;
        setNorthTreeHead();
    }

    @Override
    public boolean generate(World p_76484_1_, Random p_76484_2_, BlockPos pos) {
        boolean ret = false, noTreesNear = true;
        for (int i = 0; i < 2; i++){
            for (int j = -1; j < 2; j++){
                for (int k = -1; k < 2; k++){
                    int i1 = i == 0 ? 0 : 4;
                    noTreesNear = p_76484_1_.getBlockState(pos.add(j, i1, k)).getBlock() != NorthrendBlocks.northLog;
                }
            }
        }
        if (noTreesNear && p_76484_1_.getBlockState(pos.add(0, -2, 0)) == NorthrendBlocks.northDirt.getDefaultState()) {
            if (type == TreeType.PINE)
                genPineTree(p_76484_1_, p_76484_2_, pos);
            else if (type == TreeType.FIR)
                genTreeFir(p_76484_1_, p_76484_2_, pos);
            else if (type == TreeType.BIRCH)
                genTreeBirch(p_76484_1_, p_76484_2_, pos);
            else
                genPineTree(p_76484_1_, p_76484_2_, pos);
            ret = true;
        }
        return ret;
    }

    private void genPineTree(World world, Random random, BlockPos pos) {
        if (world.getBlockState(pos.add(0, -1, 0)).getBlock() == Block.getBlockFromName("snow") && pos.getY() < 80) {
            int height = 4 + random.nextInt(3);
            for (int k = - 1; k < height; k++) {
                world.setBlockState(pos.add(0, k, 0), NorthrendBlocks.northLog.getDefaultState().withProperty(AXIS_PROP, BlockLog.EnumAxis.func_176870_a(EnumFacing.Axis.Y)));
            }
            world.setBlockState(pos.add(0, height, 0), NorthrendBlocks.northLeaves.getDefaultState());
            genTreeHead(world, random, pos.add(0, height - 1, 0));
        }
    }

    private void genTreeHead(World world, Random r, BlockPos pos) {
        IBlockState block;
        for (int i = -2; i < 3; i++) {
            for (int j = -2; j < 3; j++) {
                if ((world.getBlockState(pos.add(i, 0, j)).getBlock() == Blocks.air || world.getBlockState(pos.add(i, 0, j)).getBlock() == Blocks.snow_layer) && northTreeHead[(i + 2) + 5 * (j + 2)]) {
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
        if (world.getBlockState(pos.add(0, -1, 0)).getBlock() == Block.getBlockFromName("snow") && pos.getY() < 80) {
            int height = 5 + random.nextInt(3);
            for (int k = - 1; k < height; k++) {
                world.setBlockState(pos.add(0, k, 0), NorthrendBlocks.northLog.getDefaultState().withProperty(AXIS_PROP, BlockLog.EnumAxis.func_176870_a(EnumFacing.Axis.Y)));
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
                    if ((world.getBlockState(pos.add(i, k + height, j)).getBlock() == Blocks.air || world.getBlockState(pos.add(i, 0, j)).getBlock() == Blocks.snow_layer)) {
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

    private void genTreeBirch(World world, Random random, BlockPos pos) {
        if (world.getBlockState(pos.add(0, -1, 0)).getBlock() == Block.getBlockFromName("snow") && pos.getY() < 80) {
            int height = 4 + random.nextInt(3);
            for (int k = - 1; k < height; k++) {
                this.func_175905_a(world, pos.offsetUp(k), Blocks.log, 2);
            }
            genTreeHeadBirch(world, random, pos, height);
        }
    }

    private void genTreeHeadBirch(World world, Random r, BlockPos pos, int height){
        IBlockState block;
        for (int i = -2; i < 3; i++){
            for (int j = -2; j < 3; j++){
                for (int k = -3; k < 1; k++){
                    block = world.getBlockState(pos.add(i, k + height, j));
                    if ((world.getBlockState(pos.add(i, k + height, j)).getBlock() == Blocks.air || world.getBlockState(pos.add(i, 0, j)).getBlock() == Blocks.snow_layer)) {
                        block = Blocks.air.getDefaultState();
                        if (k == 0) {
                            if (i > -2 && i < 2 && j > -2 && j < 2) {
                                block = NorthrendBlocks.northLeaves.getDefaultState();
                            }
                        } else if (k != -3) {
                            if (j != -2 && j != 2) {
                                if (i == -2 || i == 2) {
                                    block = NorthrendBlocks.northLeaves.getDefaultState();
                                }
                            }
                            else if (i != -2 && i != 2) {
                                block = NorthrendBlocks.northLeaves.getDefaultState();
                            }
                        } else {
                            if (j != -2 && j != 2) {
                                if (i == -2 || i == 2) {
                                    block = .5f > r.nextFloat() ? NorthrendBlocks.northLeaves.getDefaultState() : Blocks.air.getDefaultState();
                                }
                            }
                            else if (i != -2 && i != 2) {
                                block = .5f > r.nextFloat() ? NorthrendBlocks.northLeaves.getDefaultState() : Blocks.air.getDefaultState();
                            }
                        }
                    }
                    world.setBlockState(pos.add(i, k + height, j), block);
                }
            }
        }
    }
}
