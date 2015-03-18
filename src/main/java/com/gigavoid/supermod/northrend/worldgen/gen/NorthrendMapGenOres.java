package com.gigavoid.supermod.northrend.worldgen.gen;

import java.util.Random;

import com.gigavoid.supermod.bonus.block.BonusBlocks;
import com.gigavoid.supermod.northrend.ModuleNorthrend;
import com.gigavoid.supermod.northrend.biome.NorthrendBiomes;
import com.gigavoid.supermod.northrend.block.NorthrendBlocks;
import com.gigavoid.supermod.northrend.worldgen.custom.NorthrendWorldGenMinable;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.fml.common.IWorldGenerator;

public class NorthrendMapGenOres implements IWorldGenerator
{
    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
        if(world.provider.getDimensionId() == ModuleNorthrend.dimensionId)
            generateSurface(world, random, chunkX * 16, chunkZ * 16);
    }

    private void generateSurface(World world, Random random, int chunkX, int chunkZ) {
        int rn = 95 + random.nextInt(15);
        for(int k = 0; k < rn; k++) {
            int x = chunkX + random.nextInt(16);
            int y = random.nextInt(255);
            int z = chunkZ + random.nextInt(16);
            BlockPos pos = new BlockPos(x, y, z);
            (new NorthrendWorldGenMinable(NorthrendBlocks.coalOre.getDefaultState(), 4 + random.nextInt(13), NorthrendBlocks.northStone)).generate(world, random, pos);
        }
        rn = 70 + random.nextInt(20);
        for(int k = 0; k < rn; k++) {
            int x = chunkX + random.nextInt(16);
            int y = random.nextInt(128);
            int z = chunkZ + random.nextInt(16);
            BlockPos pos = new BlockPos(x, y, z);
            (new NorthrendWorldGenMinable(NorthrendBlocks.ironOre.getDefaultState(), 3 + random.nextInt(7), NorthrendBlocks.northStone)).generate(world, random, pos);
        }
        rn = 17 + random.nextInt(6);
        for(int k = 0; k < rn; k++) {
            int x = chunkX + random.nextInt(16);
            int y = random.nextInt(45);
            int z = chunkZ + random.nextInt(16);
            BlockPos pos = new BlockPos(x, y, z);
            (new NorthrendWorldGenMinable(NorthrendBlocks.goldOre.getDefaultState(), 2 + random.nextInt(7), NorthrendBlocks.northStone)).generate(world, random, pos);
        }
        rn = 8 + random.nextInt(4);
        for(int k = 0; k < rn; k++) {
            int x = chunkX + random.nextInt(16);
            int y = random.nextInt(35);
            int z = chunkZ + random.nextInt(16);
            BlockPos pos = new BlockPos(x, y, z);
            (new NorthrendWorldGenMinable(NorthrendBlocks.mithrilOre.getDefaultState(), 2 + random.nextInt(2), NorthrendBlocks.northStone)).generate(world, random, pos);
        }
        rn = 4 + random.nextInt(4);
        for(int k = 0; k < rn; k++) {
            int x = chunkX + random.nextInt(16);
            int y = random.nextInt(16);
            int z = chunkZ + random.nextInt(16);
            BlockPos pos = new BlockPos(x, y, z);
            (new NorthrendWorldGenMinable(NorthrendBlocks.diamondOre.getDefaultState(), 2 + random.nextInt(3), NorthrendBlocks.northStone)).generate(world, random, pos);
        }
        rn = 2 + random.nextInt(2);
        for(int k = 0; k < rn; k++) {
            int x = chunkX + random.nextInt(16);
            int y = random.nextInt(40);
            int z = chunkZ + random.nextInt(16);
            BlockPos pos = new BlockPos(x, y, z);
            (new NorthrendWorldGenMinable(NorthrendBlocks.emeraldOre.getDefaultState(), 1 + random.nextInt(3), NorthrendBlocks.northStone)).generate(world, random, pos);
        }
        rn = 12 + random.nextInt(6);
        for(int k = 0; k < rn; k++) {
            int x = chunkX + random.nextInt(16);
            int y = random.nextInt(25);
            int z = chunkZ + random.nextInt(16);
            BlockPos pos = new BlockPos(x, y, z);
            (new NorthrendWorldGenMinable(NorthrendBlocks.lapisOre.getDefaultState(), 2 + random.nextInt(5), NorthrendBlocks.northStone)).generate(world, random, pos);
        }
        if (random.nextFloat() > .999f){
            int x = chunkX + random.nextInt(16);
            int y = random.nextInt(40);
            int z = chunkZ + random.nextInt(16);
            BlockPos pos = new BlockPos(x, y, z);
            (new NorthrendWorldGenMinable(BonusBlocks.bonus.getDefaultState(), 1, NorthrendBlocks.northStone)).generate(world, random, pos);
        }
        rn = random.nextInt(3);
        for(int k = 0; k < rn; k++) {
            int x = chunkX + random.nextInt(16);
            int y = 45 + random.nextInt(10);
            int z = chunkZ + random.nextInt(16);
            BlockPos pos = new BlockPos(x, y, z);
            (new NorthrendWorldGenMinable(NorthrendBlocks.dragonBone.getDefaultState(), 6 + random.nextInt(5), NorthrendBlocks.glacialIce)).generate(world, random, pos);
        }
        int x = chunkX + random.nextInt(16);
        int y = 5 + random.nextInt(50);
        int z = chunkZ + random.nextInt(16);
        BlockPos pos = new BlockPos(x, y, z);
        if (world.getBiomeGenForCoords(pos) == NorthrendBiomes.northHugeMountains) {
            (new NorthrendWorldGenMinable(NorthrendBlocks.frostGemOre.getDefaultState(), 1, NorthrendBlocks.northStone)).generate(world, random, pos);
        }
    }
}
