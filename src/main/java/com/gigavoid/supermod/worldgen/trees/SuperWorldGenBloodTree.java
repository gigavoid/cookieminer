package com.gigavoid.supermod.worldgen.trees;

import com.gigavoid.supermod.block.SuperBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSapling;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraftforge.common.util.ForgeDirection;

import java.util.Random;

public class SuperWorldGenBloodTree extends WorldGenAbstractTree {

    public SuperWorldGenBloodTree(boolean p_i45448_1_) {
        super(p_i45448_1_);
    }

    @Override
    public boolean generate(World p_76484_1_, Random p_76484_2_, int p_76484_3_, int p_76484_4_, int p_76484_5_) {
        genTree(p_76484_1_, p_76484_2_, p_76484_3_, p_76484_4_, p_76484_5_);
        return true;
    }

    private void genTree(World world, Random random, int x, int y, int z) {
        int height = 6 + random.nextInt(3);
        Block block2 = world.getBlock(x, y - 1, z);
        boolean isSoil = block2.canSustainPlant(world, x, y - 1, z, ForgeDirection.UP, (BlockSapling) Blocks.sapling);
        if (isSoil && y + height + 3 < 256) {
            for (int k = 0; k < height; k++) {
                if (k < (height / 2))
                    world.setBlock(x, y + k, z, SuperBlocks.bone);
                else
                    world.setBlock(x, y + k, z, SuperBlocks.meat);
                if (k > height / 4 && k < height - 1) {
                    world.setBlock(x + 1, y + k, z, SuperBlocks.meat);
                    world.setBlock(x, y + k, z + 1, SuperBlocks.meat);
                    world.setBlock(x - 1, y + k, z, SuperBlocks.meat);
                    world.setBlock(x, y + k, z - 1, SuperBlocks.meat);
                    if (k == height / 2 || k == (height / 2) + 1) {
                        int r = random.nextInt(10);
                        if (random.nextInt(10) < 6) world.setBlock(x + 2, y + k, z, SuperBlocks.meat);
                        if (random.nextInt(10) < 6) world.setBlock(x, y + k, z + 2, SuperBlocks.meat);
                        if (random.nextInt(10) < 6) world.setBlock(x - 2, y + k, z, SuperBlocks.meat);
                        if (random.nextInt(10) < 6) world.setBlock(x, y + k, z - 2, SuperBlocks.meat);
                        if (random.nextInt(10) < 6) world.setBlock(x + 1, y + k, z + 1, SuperBlocks.meat);
                        if (random.nextInt(10) < 6) world.setBlock(x - 1, y + k, z + 1, SuperBlocks.meat);
                        if (random.nextInt(10) < 6) world.setBlock(x - 1, y + k, z - 1, SuperBlocks.meat);
                        if (random.nextInt(10) < 6) world.setBlock(x + 1, y + k, z - 1, SuperBlocks.meat);
                    }
                }
            }
        }
    }
}
