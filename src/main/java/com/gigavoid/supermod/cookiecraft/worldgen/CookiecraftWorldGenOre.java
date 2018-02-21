package com.gigavoid.supermod.cookiecraft.worldgen;

import com.gigavoid.supermod.cookiecraft.block.CookiecraftBlocks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.Random;

public class CookiecraftWorldGenOre implements IWorldGenerator {
    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
        if(world.provider.getDimension() == 0)
            generateOverworld(world, random, chunkX * 16,chunkZ * 16, chunkGenerator, chunkProvider);
    }

    private void generateOverworld(World world, Random random, int x, int y, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
        generateOre(CookiecraftBlocks.oreUranium.getDefaultState(), world, random, x, y, 8, 32, 3, 6, 6);
    }

    private void generateOre(IBlockState ore, World world, Random random, int chunkX, int chunkZ, int minHeight, int maxHeight, int minSize, int maxSize, int chances) {
        int deltaHeight = maxHeight - minHeight;
        int deltaSize = maxSize - minSize;

        for(int i = 0; i < chances; i++)
        {
            int x = chunkX + random.nextInt(16);
            int y = minHeight + random.nextInt(deltaHeight);
            int z = chunkZ + random.nextInt(16);
            BlockPos pos = new BlockPos(x, y, z);

            int size = minSize + random.nextInt(deltaSize);
            WorldGenMinable generator = new WorldGenMinable(ore, size);
            generator.generate(world, random, pos);
        }
    }
}
