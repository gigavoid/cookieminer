package com.gigavoid.supermod.worldgen.trees;

import com.gigavoid.supermod.block.SuperBlocks;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

import java.util.Random;

public class SuperWorldGenEmeraldTree extends WorldGenAbstractTree {
    public boolean emeraldTreeHead[] = new boolean[7 * 7 * 3];

    public SuperWorldGenEmeraldTree(boolean p_i45448_1_) {
        super(p_i45448_1_);
        setEmeraldTreeHead();
    }

    @Override
    public boolean generate(World p_76484_1_, Random p_76484_2_, int p_76484_3_, int p_76484_4_, int p_76484_5_) {
        genSuperTree(p_76484_1_, p_76484_2_, p_76484_3_, p_76484_4_, p_76484_5_);
        return false;
    }

    private void genSuperTree(World world, Random random, int x, int y, int z) {
        if (world.getBlock(x, y + 1, z) == Block.getBlockById(0) || world.getBlock(x, y + 1, z) == Block.getBlockById(9)) {
            int height = 70 + random.nextInt(10) - 5;
            for (int k = 0; k < 10; k++) {
                int startheight = 5 + random.nextInt(height - 10);
                int bposX = x + random.nextInt(4) - 1;
                int bposY = z + random.nextInt(4) - 1;
                if (bposX == 1)
                    bposX--;
                else if (bposX == 2)
                    bposX++;
                if (bposY == 1)
                    bposY--;
                else if (bposY == 2)
                    bposY++;
                world.setBlock(bposX, y + startheight, bposY, SuperBlocks.emeraldLog);
                genTreeHead(world, bposX, y + startheight, bposY);
            }
            for (int k = y; k < y + height; k++) {
                this.setBlockAndNotifyAdequately(world, x, k + 1, z, SuperBlocks.emeraldLog, 0);
                this.setBlockAndNotifyAdequately(world, x + 1, k + 1, z, SuperBlocks.emeraldLog, 0);
                this.setBlockAndNotifyAdequately(world, x - 1, k + 1, z, SuperBlocks.emeraldLog, 0);
                this.setBlockAndNotifyAdequately(world, x, k + 1, z + 1, SuperBlocks.emeraldLog, 0);
                this.setBlockAndNotifyAdequately(world, x, k + 1, z - 1, SuperBlocks.emeraldLog, 0);
                this.setBlockAndNotifyAdequately(world, x + 1, k + 1, z + 1, SuperBlocks.emeraldLog, 0);
                this.setBlockAndNotifyAdequately(world, x - 1, k + 1, z + 1, SuperBlocks.emeraldLog, 0);
                this.setBlockAndNotifyAdequately(world, x + 1, k + 1, z - 1, SuperBlocks.emeraldLog, 0);
                this.setBlockAndNotifyAdequately(world, x - 1, k + 1, z - 1, SuperBlocks.emeraldLog, 0);
            }
            genTreeHead(world, x, y + height - 1, z);
            genTreeHead(world, x + 1, y + height - 1, z);
            genTreeHead(world, x - 1, y + height - 1, z);
            genTreeHead(world, x, y + height - 1, z + 1);
            genTreeHead(world, x, y + height - 1, z - 1);
            genTreeHead(world, x + 1, y + height - 1, z + 1);
            genTreeHead(world, x - 1, y + height - 1, z + 1);
            genTreeHead(world, x + 1, y + height - 1, z - 1);
            genTreeHead(world, x - 1, y + height - 1, z - 1);
        }
    }

    private void genBigTree(World world, Random random, int x, int y, int z) {
        if (world.getBlock(x, y + 1, z) == Block.getBlockById(0) || world.getBlock(x, y + 1, z) == Block.getBlockById(9)) {
            int height = 40 + random.nextInt(10) - 5;
            for (int k = 0; k < 5; k++) {
                int startheight = 5 + random.nextInt(height - 10);
                int bposX = x + random.nextInt(4) - 1;
                int bposY = z + random.nextInt(4) - 1;
                if (bposX == 1)
                    bposX--;
                else if (bposX == 2)
                    bposX++;
                if (bposY == 1)
                    bposY--;
                else if (bposY == 2)
                    bposY++;
                this.setBlockAndNotifyAdequately(world, bposX, y + startheight, bposY, SuperBlocks.emeraldLog, 0);
                genTreeHead(world, bposX, y + startheight, bposY);
            }
            for (int k = y; k < y + height; k++) {
                this.setBlockAndNotifyAdequately(world, x, k + 1, z, SuperBlocks.emeraldLog, 0);
                this.setBlockAndNotifyAdequately(world, x + 1, k + 1, z, SuperBlocks.emeraldLog, 0);
                this.setBlockAndNotifyAdequately(world, x, k + 1, z + 1, SuperBlocks.emeraldLog, 0);
                this.setBlockAndNotifyAdequately(world, x + 1, k + 1, z + 1, SuperBlocks.emeraldLog, 0);
            }
            for (int k = y; k > y - 3; k--) {
                if (world.getBlock(x, k, z) == Block.getBlockById(0) || world.getBlock(x, k, z) == Block.getBlockById(9))
                    this.setBlockAndNotifyAdequately(world, x, k, z, SuperBlocks.emeraldLog, 0);
                if (world.getBlock(x + 1, k, z) == Block.getBlockById(0) || world.getBlock(x + 1, k, z) == Block.getBlockById(9))
                    this.setBlockAndNotifyAdequately(world, x + 1, k, z, SuperBlocks.emeraldLog, 0);
                if (world.getBlock(x, k, z + 1) == Block.getBlockById(0) || world.getBlock(x, k, z + 1) == Block.getBlockById(9))
                    this.setBlockAndNotifyAdequately(world, x, k, z + 1, SuperBlocks.emeraldLog, 0);
                if (world.getBlock(x + 1, k, z + 1) == Block.getBlockById(0) || world.getBlock(x + 1, k, z + 1) == Block.getBlockById(9))
                    this.setBlockAndNotifyAdequately(world, x + 1, k, z + 1, SuperBlocks.emeraldLog, 0);
            }
            genTreeHead(world, x, y + height - 1, z);
            genTreeHead(world, x + 1, y + height - 1, z);
            genTreeHead(world, x, y + height - 1, z + 1);
            genTreeHead(world, x + 1, y + height - 1, z + 1);
        }
    }

    private void genTree(World world, Random random, int x, int y, int z) {
        int height = 9 + random.nextInt(4) - 1;
        for (int k = 0; k < height; k++) {
            this.setBlockAndNotifyAdequately(world, x, y + k + 1, x, SuperBlocks.emeraldLog, 0);
        }
        genTreeHead(world, x, y + height - 1, x);


    }

    private void genTreeHead(World world, int x, int y, int z) {
        for (int i = -3; i < 4; i++) {
            for (int j = -3; j < 4; j++) {
                for (int k = 0; k < 3; k++) {
                    if (world.getBlock(x + i, y + k, z + j) == Block.getBlockById(0) && emeraldTreeHead[(i + 3) + 7 * (j + 3) + 49 * k]) {
                        this.setBlockAndNotifyAdequately(world, x + i, y + k, z + j, SuperBlocks.emeraldLeaves, 0);
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
