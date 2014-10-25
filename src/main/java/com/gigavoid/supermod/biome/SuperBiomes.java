package com.gigavoid.supermod.biome;

import net.minecraftforge.common.BiomeManager;

public class SuperBiomes {

    public static final EmeraldBiomeGen emeraldBiomeGen = new EmeraldBiomeGen();

    public static void registerBiomes(){
        BiomeManager.addSpawnBiome(emeraldBiomeGen);
        BiomeManager.addBiome(BiomeManager.BiomeType.DESERT, new BiomeManager.BiomeEntry(emeraldBiomeGen, 5000));
        BiomeManager.addBiome(BiomeManager.BiomeType.COOL, new BiomeManager.BiomeEntry(emeraldBiomeGen, 5000));
    }
}
