package com.gigavoid.supermod.worldgen;

import com.gigavoid.supermod.block.SuperBlocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.Random;

public class SuperWorldGenOre implements IWorldGenerator {
    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
        if (world.provider.getDimensionId() == 0)
            generateSurface(world, random, chunkX * 16, chunkZ * 16);
    }

    private void generateSurface(World world, Random random, int chunkX, int chunkZ) {
        for (int k=0; k<20; k++) {
            BlockPos pos = new BlockPos(chunkX + random.nextInt(16), random.nextInt(30), chunkZ + random.nextInt(16));
            (new WorldGenMinable(SuperBlocks.saxeliumOre.getDefaultState(), 13)).generate(world, random, pos);
        }
    }
}
