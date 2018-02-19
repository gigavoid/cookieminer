package com.gigavoid.supermod.cookiecraft.worldgen;

import com.gigavoid.supermod.cookiecraft.block.BlockCookieOreUranium;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.Random;

public class CookiecraftWorldGenOre implements IWorldGenerator {
    private void generateSurface(World world, Random random, int chunkX, int chunkZ){
        for(int i = 0; i < 6; i++)
        {
            BlockPos pos = new BlockPos(chunkX + random.nextInt(16), random.nextInt(20), chunkZ + random.nextInt(16));
            (new WorldGenMinable(BlockCookieOreUranium.instance.getDefaultState(), random.nextInt(3) + 3)).generate(world, random, pos);
        }
    }

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
        if(world.provider.getDimension() == 0)
            generateSurface(world, random, chunkX*16,chunkZ*16);
    }
}
