package com.gigavoid.supermod.northrend.worldgen.gen;

import java.util.Random;

import com.gigavoid.supermod.bonus.block.BonusBlocks;
import com.gigavoid.supermod.northrend.ModuleNorthrend;
import com.gigavoid.supermod.northrend.block.NorthrendBlocks;
import com.gigavoid.supermod.northrend.worldgen.custom.WorldGenMinable;
import net.minecraft.block.state.pattern.BlockHelper;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.fml.common.IWorldGenerator;

import javax.sql.rowset.Predicate;

public class MapGenOres implements IWorldGenerator
{
    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
        if(world.provider.getDimensionId() == ModuleNorthrend.dimensionId)
            generateSurface(world, random, chunkX * 16, chunkZ * 16);
    }

    private void generateSurface(World world, Random random, int chunkX, int chunkZ) {
        int rn = 85 + random.nextInt(15);
        for(int k = 0; k < rn; k++) {
            int x = chunkX + random.nextInt(16);
            int y = random.nextInt(255);
            int z = chunkZ + random.nextInt(16);
            BlockPos pos = new BlockPos(x, y, z);
            (new WorldGenMinable(NorthrendBlocks.coalOre.getDefaultState(), 4 + random.nextInt(13), NorthrendBlocks.northStone)).generate(world, random, pos);
        }
        rn = 55 + random.nextInt(10);
        for(int k = 0; k < rn; k++) {
            int x = chunkX + random.nextInt(16);
            int y = random.nextInt(128);
            int z = chunkZ + random.nextInt(16);
            BlockPos pos = new BlockPos(x, y, z);
            (new WorldGenMinable(NorthrendBlocks.ironOre.getDefaultState(), 3 + random.nextInt(7), NorthrendBlocks.northStone)).generate(world, random, pos);
        }
        rn = 14 + random.nextInt(6);
        for(int k = 0; k < rn; k++) {
            int x = chunkX + random.nextInt(16);
            int y = random.nextInt(45);
            int z = chunkZ + random.nextInt(16);
            BlockPos pos = new BlockPos(x, y, z);
            (new WorldGenMinable(NorthrendBlocks.goldOre.getDefaultState(), 2 + random.nextInt(7), NorthrendBlocks.northStone)).generate(world, random, pos);
        }
        rn = 2 + random.nextInt(3);
        for(int k = 0; k < rn; k++) {
            int x = chunkX + random.nextInt(16);
            int y = random.nextInt(16);
            int z = chunkZ + random.nextInt(16);
            BlockPos pos = new BlockPos(x, y, z);
            (new WorldGenMinable(NorthrendBlocks.diamondOre.getDefaultState(), 2 + random.nextInt(3), NorthrendBlocks.northStone)).generate(world, random, pos);
        }
        rn = 1 + random.nextInt(2);
        for(int k = 0; k < rn; k++) {
            int x = chunkX + random.nextInt(16);
            int y = random.nextInt(40);
            int z = chunkZ + random.nextInt(16);
            BlockPos pos = new BlockPos(x, y, z);
            (new WorldGenMinable(NorthrendBlocks.emeraldOre.getDefaultState(), 1 + random.nextInt(3), NorthrendBlocks.northStone)).generate(world, random, pos);
        }
        rn = 8 + random.nextInt(6);
        for(int k = 0; k < rn; k++) {
            int x = chunkX + random.nextInt(16);
            int y = random.nextInt(25);
            int z = chunkZ + random.nextInt(16);
            BlockPos pos = new BlockPos(x, y, z);
            (new WorldGenMinable(NorthrendBlocks.lapisOre.getDefaultState(), 2 + random.nextInt(5), NorthrendBlocks.northStone)).generate(world, random, pos);
        }
        if (random.nextFloat() > .999f){
            int x = chunkX + random.nextInt(16);
            int y = random.nextInt(40);
            int z = chunkZ + random.nextInt(16);
            BlockPos pos = new BlockPos(x, y, z);
            (new WorldGenMinable(BonusBlocks.bonus.getDefaultState(), 1, NorthrendBlocks.northStone)).generate(world, random, pos);
        }
        rn = 14 + random.nextInt(6);
        for(int k = 0; k < rn; k++) {
            int x = chunkX + random.nextInt(16);
            int y = 40 + random.nextInt(25);
            int z = chunkZ + random.nextInt(16);
            BlockPos pos = new BlockPos(x, y, z);
            (new WorldGenMinable(NorthrendBlocks.northPlanks.getDefaultState(), 6 + random.nextInt(5), NorthrendBlocks.glacialIce)).generate(world, random, pos);
        }
    }
}
