package com.gigavoid.supermod.biome;

import net.minecraftforge.common.BiomeManager;

public class SuperBiomes {

    public static final EmeraldBiomeGen emeraldBiomeGen = new EmeraldBiomeGen();
    public static final NorthForestBiomeGen northForestBiomeGen = new NorthForestBiomeGen();

    public static void registerBiomes(){
        BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeManager.BiomeEntry(emeraldBiomeGen, 1000000));
        BiomeManager.addBiome(BiomeManager.BiomeType.ICY, new BiomeManager.BiomeEntry(northForestBiomeGen, 10));
    }
}
