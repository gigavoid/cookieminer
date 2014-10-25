package com.gigavoid.supermod.worldgen;

import com.gigavoid.supermod.block.SuperBlocks;
import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;

import java.util.Random;

public class SuperWorldGenOre implements IWorldGenerator {

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
        if(world.provider.dimensionId==0)
            generateSurface(world, random, chunkX * 16, chunkZ * 16);
    }

    private void generateSurface(World world, Random random, int chunkX, int chunkZ) {
        for(int k=0; k<100; k++) {
            int firstBlockXCoord = chunkX + random.nextInt(16);
            int firstBlockYCoord = random.nextInt(64);
            int firstBlockZCoord = chunkZ + random.nextInt(16);
            (new WorldGenMinable(SuperBlocks.opblock, 13)).generate(world, random, firstBlockXCoord, firstBlockYCoord, firstBlockZCoord);
        }
    }
}
