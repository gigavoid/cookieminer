package com.gigavoid.supermod.bettertools.worldgen;

import com.gigavoid.supermod.bettertools.block.BetterToolsBlocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.Random;

/**
 * Created by Lukas on 2015-02-18.
 */
public class BetterToolsWorldGenOre implements IWorldGenerator{

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
        if(world.provider.getDimensionId() == 0)
            generateSurface(world, random, chunkX*16,chunkZ*16);
    }
    private void generateSurface(World world, Random random, int chunkX, int chunkZ){
        for(int i = 0; i<20; i++)
        {
            BlockPos pos = new BlockPos(chunkX+random.nextInt(16),random.nextInt(30), chunkZ+random.nextInt(16));
            (new WorldGenMinable(BetterToolsBlocks.saxeliumOre.getDefaultState(), 13)).generate(world,random,pos);
        }
    }
}
