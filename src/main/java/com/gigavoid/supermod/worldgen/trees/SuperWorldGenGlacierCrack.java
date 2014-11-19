package com.gigavoid.supermod.worldgen.trees;

import com.gigavoid.supermod.block.SuperBlocks;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

import java.util.Random;

/**
 * Created by Rasmus on 2014-11-07.
 */
public class SuperWorldGenGlacierCrack extends WorldGenAbstractTree {
    public SuperWorldGenGlacierCrack(boolean b){ super(b); }

    @Override
    public boolean generate(World p_76484_1_, Random p_76484_2_, int p_76484_3_, int p_76484_4_, int p_76484_5_) {
        genCrack(p_76484_1_, p_76484_2_, p_76484_3_, p_76484_4_, p_76484_5_);
        return true;
    }

    private void genCrack(World world, Random random, int x, int y, int z){
        if (world.getBlock(x, y, z) == Blocks.snow_layer && y < 80) {
            int dirX = random.nextInt(2);
            int dirZ = random.nextInt(2);
            int diffX = 0, diffZ = 0;
            int currentY = y;
            if (dirX == 0)
                dirX = -1;
            if (dirZ == 0)
                dirZ = -1;

            int length = random.nextInt(15) + 20;

            for (int i = 0; i < length; i++) {
                int nextX = random.nextInt(2);
                int nextZ = random.nextInt(2);
                if (nextX == 0 && nextZ == 0)
                    nextZ = 1;
                Block block = world.getBlock(x + diffX + nextX * dirX, currentY, z + diffZ + nextZ * dirZ);
                while (block == SuperBlocks.glacialIce || block == Blocks.snow_layer) {
                    world.setBlock(x + diffX + nextX * dirX, currentY, z + diffZ + nextZ * dirZ, Blocks.air);
                    currentY--;
                    block = world.getBlock(x + diffX + nextX * dirX, currentY, z + diffZ + nextZ * dirZ);
                }
                diffX++;
                diffZ++;
            }
        }
    }
}
