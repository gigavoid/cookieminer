package com.gigavoid.supermod.northrend.worldgen.gen;

import java.util.Random;

import com.gigavoid.supermod.bonus.block.BonusBlocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;

public class OreGen implements IWorldGenerator
{
    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
        if(world.provider.getDimensionId() == 2)
            generateSurface(world, random, chunkX * 16, chunkZ * 16);
    }

    private void generateSurface(World world, Random random, int chunkX, int chunkZ) {
        for(int k=0; k<20; k++) {
            int x = chunkX + random.nextInt(16);
            int y = random.nextInt(30);
            int z = chunkZ + random.nextInt(16);
            BlockPos pos = new BlockPos(x, y, z);
            (new WorldGenMinable(BonusBlocks.bonus.getDefaultState(), 13)).generate(world, random, pos);
        }
    }
}
