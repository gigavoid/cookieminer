package com.gigavoid.supermod.worldgen.trees;

import com.gigavoid.supermod.block.SuperBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSapling;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

import java.util.Random;

public class SuperWorldGenEmeraldTree extends WorldGenAbstractTree {
    private boolean emeraldTreeHead[] = new boolean[7 * 7 * 3];

    public SuperWorldGenEmeraldTree(boolean p_i45448_1_) {
        super(p_i45448_1_);
        setEmeraldTreeHead();
    }

    @Override
    public boolean generate(World p_76484_1_, Random p_76484_2_, BlockPos pos) {
        float a = p_76484_2_.nextFloat();
        if (a < .02f)
            genSuperTree(p_76484_1_, p_76484_2_, pos);
        else if (a < .15f)
            genBigTree(p_76484_1_, p_76484_2_, pos);
        else
            genTree(p_76484_1_, p_76484_2_, pos);
        return false;
    }

    private void genSuperTree(World world, Random random, BlockPos pos) {
        int height = 50 + random.nextInt(10) - 5;
        IBlockState block2 = world.getBlockState(pos.add(0, -1, 0));
        boolean isSoil = block2.getBlock().canSustainPlant(world, pos.add(0, -1, 0), EnumFacing.UP, (BlockSapling) Blocks.sapling);
        boolean groundExists = true;
        for (int i = -1; i < 2; i++){
            for (int j = -1; j < 2; j++){
                if(world.getBlockState(pos.add(i, -3, j)) != Blocks.air && world.getBlockState(pos.add(i, -3, j)) != Blocks.water && world.getBlockState(pos.add(i, -3, j)) != Blocks.flowing_water){
                    groundExists = false;
                }
            }
        }
        if (isSoil && groundExists && pos.getY() + height + 3 < 256) {
            for (int k = 0; k < 10; k++) {
                int startheight = 5 + random.nextInt(height - 10);
                int bposX = random.nextInt(5) - 2;
                int bposY = random.nextInt(5) - 2;
                if (bposX == -1)
                    bposX--;
                else if (bposX == 0)
                    bposX += 2;
                else if (bposX == 1)
                    bposX++;
                if (bposY == -1)
                    bposY--;
                else if (bposY == 0)
                    bposY += 2;
                else if (bposY == 1)
                    bposY++;
                world.setBlockState(pos.add(bposX, startheight, bposY), SuperBlocks.emeraldLog.getDefaultState());
                genTreeHead(world, pos.add(bposX, startheight, bposY));
            }
            for (int k = 0; k < height; k++) {
                world.setBlockState(pos.add(0, k, 0), SuperBlocks.emeraldLog.getDefaultState(), 0);
                world.setBlockState(pos.add(1, k, 0), SuperBlocks.emeraldLog.getDefaultState(), 0);
                world.setBlockState(pos.add(-1, k, 0), SuperBlocks.emeraldLog.getDefaultState(), 0);
                world.setBlockState(pos.add(0, k, 1), SuperBlocks.emeraldLog.getDefaultState(), 0);
                world.setBlockState(pos.add(0, k, -1), SuperBlocks.emeraldLog.getDefaultState(), 0);
                world.setBlockState(pos.add(1, k, 1), SuperBlocks.emeraldLog.getDefaultState(), 0);
                world.setBlockState(pos.add(1, k, -1), SuperBlocks.emeraldLog.getDefaultState(), 0);
                world.setBlockState(pos.add(-1, k, 1), SuperBlocks.emeraldLog.getDefaultState(), 0);
                world.setBlockState(pos.add(-1, k, -1), SuperBlocks.emeraldLog.getDefaultState(), 0);
            }

            for (int k = -1; k > -3; k--) {
                world.setBlockState(pos.add(0, k, 0), Blocks.dirt.getDefaultState(), 0);
                world.setBlockState(pos.add(1, k, 0), Blocks.dirt.getDefaultState(), 0);
                world.setBlockState(pos.add(-1, k, 0), Blocks.dirt.getDefaultState(), 0);
                world.setBlockState(pos.add(0, k, 1), Blocks.dirt.getDefaultState(), 0);
                world.setBlockState(pos.add(0, k, -1), Blocks.dirt.getDefaultState(), 0);
                world.setBlockState(pos.add(1, k, 1), Blocks.dirt.getDefaultState(), 0);
                world.setBlockState(pos.add(1, k, -1), Blocks.dirt.getDefaultState(), 0);
                world.setBlockState(pos.add(-1, k, 1), Blocks.dirt.getDefaultState(), 0);
                world.setBlockState(pos.add(-1, k, -1), Blocks.dirt.getDefaultState(), 0);
            }

            genTreeHead(world, pos.add(0, height - 1, 0));
            genTreeHead(world, pos.add(1, height - 1, 0));
            genTreeHead(world, pos.add(-1, height - 1, 0));
            genTreeHead(world, pos.add(0, height - 1, 1));
            genTreeHead(world, pos.add(0, height - 1, -1));
            genTreeHead(world, pos.add(1, height - 1, 1));
            genTreeHead(world, pos.add(1, height - 1, -1));
            genTreeHead(world, pos.add(-1, height - 1, 1));
            genTreeHead(world, pos.add(-1, height - 1, -1));
        }
    }

    private void genBigTree(World world, Random random, BlockPos pos) {
        int height = 25 + random.nextInt(10);
        IBlockState block2 = world.getBlockState(pos.add(0, -1, 0));
        boolean isSoil = block2.getBlock().canSustainPlant(world, pos.add(0, -1, 0), EnumFacing.UP, (BlockSapling) Blocks.sapling);
        if (isSoil && pos.getY() + height + 3 < 256) {
            for (int k = 0; k < 5; k++) {
                int startheight = 5 + random.nextInt(height - 10);
                int bposX = random.nextInt(4) - 1;
                int bposY = random.nextInt(4) - 1;
                if (bposX == 0)
                    bposX--;
                else if (bposX == 1)
                    bposX++;
                if (bposY == 0)
                    bposY--;
                else if (bposY == 1)
                    bposY++;
                world.setBlockState(pos.add(bposX, startheight, bposY), SuperBlocks.emeraldLog.getDefaultState(), 0);
                genTreeHead(world, pos.add(bposX, startheight, bposY));
            }
            for (int k = 0; k < height; k++) {
                world.setBlockState(pos.add(0, k, 0), SuperBlocks.emeraldLog.getDefaultState(), 0);
                world.setBlockState(pos.add(1, k, 0), SuperBlocks.emeraldLog.getDefaultState(), 0);
                world.setBlockState(pos.add(0, k, 1), SuperBlocks.emeraldLog.getDefaultState(), 0);
                world.setBlockState(pos.add(1, k, 1), SuperBlocks.emeraldLog.getDefaultState(), 0);
            }

            for (int k = -1; k > -3; k--) {
                world.setBlockState(pos.add(0, k, 0), Blocks.dirt.getDefaultState(), 0);
                world.setBlockState(pos.add(1, k, 0), Blocks.dirt.getDefaultState(), 0);
                world.setBlockState(pos.add(0, k, 1), Blocks.dirt.getDefaultState(), 0);
                world.setBlockState(pos.add(1, k, 1), Blocks.dirt.getDefaultState(), 0);
            }

            genTreeHead(world, pos.add(0, height - 1, 0));
            genTreeHead(world, pos.add(1, height - 1, 0));
            genTreeHead(world, pos.add(0, height - 1, 1));
            genTreeHead(world, pos.add(1, height - 1, 1));
        }
    }

    private void genTree(World world, Random random, BlockPos pos) {
        int height = 8 + random.nextInt(4);
        IBlockState block2 = world.getBlockState(pos.add(0, -1, 0));
        boolean isSoil = block2.getBlock().canSustainPlant(world, pos.add(0, -1, 0), EnumFacing.UP, (BlockSapling) Blocks.sapling);
        if (isSoil && pos.getY() + height + 3 < 256) {
            for (int k = 0; k < height; k++) {
                world.setBlockState(pos.add(0, k, 0), SuperBlocks.emeraldLog.getDefaultState(), 0);
            }
            world.setBlockState(pos.add(0, -1, 0), Blocks.dirt.getDefaultState(), 0);
            genTreeHead(world, pos.add(0, height - 1, 0));
        }
    }

    private void genTreeHead(World world, BlockPos pos) {
        for (int i = -3; i < 4; i++) {
            for (int j = -3; j < 4; j++) {
                for (int k = 0; k < 3; k++) {
                    if (world.getBlockState(pos.add(i, k, j)) == Block.getBlockById(0) && emeraldTreeHead[(i + 3) + 7 * (j + 3) + 49 * k]) {
                        world.setBlockState(pos.add(i, k, j), SuperBlocks.emeraldLeaves.getDefaultState(), 0);
                    }
                }
            }
        }
    }

    private void setEmeraldTreeHead(){
        //FirstLayer
        emeraldTreeHead[2] = emeraldTreeHead[46] = true;
        emeraldTreeHead[3] = emeraldTreeHead[45] = true;
        emeraldTreeHead[4] = emeraldTreeHead[44] = true;
        emeraldTreeHead[8] = emeraldTreeHead[40] = true;
        emeraldTreeHead[9] = emeraldTreeHead[39] = true;
        emeraldTreeHead[10] = emeraldTreeHead[38] = true;
        emeraldTreeHead[11] = emeraldTreeHead[37] = true;
        emeraldTreeHead[12] = emeraldTreeHead[36] = true;

        for (int i = 14; i < 35; i++)
            emeraldTreeHead[i] = true;

        //Second layer
        emeraldTreeHead[59] = emeraldTreeHead[87] = true;
        emeraldTreeHead[65] = emeraldTreeHead[81] = true;
        emeraldTreeHead[66] = emeraldTreeHead[80] = true;
        emeraldTreeHead[67] = emeraldTreeHead[79] = true;
        emeraldTreeHead[71] = true;
        emeraldTreeHead[72] = true;
        emeraldTreeHead[73] = true;
        emeraldTreeHead[74] = true;
        emeraldTreeHead[75] = true;

        //Third layer
        emeraldTreeHead[115] = emeraldTreeHead[129] = true;
        emeraldTreeHead[121] = true;
        emeraldTreeHead[122] = true;
        emeraldTreeHead[123] = true;
    }
}
