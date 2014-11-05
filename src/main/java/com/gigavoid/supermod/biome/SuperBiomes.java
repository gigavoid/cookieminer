package com.gigavoid.supermod.biome;

import net.minecraftforge.common.BiomeManager;

public class SuperBiomes {

    public static final BiomeGenEmerald emeraldForest = new BiomeGenEmerald();
    public static final BiomeGenNorthForest northForest = new BiomeGenNorthForest();
    public static final BiomeGenNorthMountains northMountains = new BiomeGenNorthMountains();
    public static final BiomeGenNorthPlains northPlains = new BiomeGenNorthPlains();
    public static final BiomeGenNorthGlacier northGlacier = new BiomeGenNorthGlacier();

    public static void registerBiomes(){
        BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeManager.BiomeEntry(emeraldForest, 10));
        BiomeManager.addBiome(BiomeManager.BiomeType.DESERT, new BiomeManager.BiomeEntry(northForest, 10));
        BiomeManager.addBiome(BiomeManager.BiomeType.DESERT, new BiomeManager.BiomeEntry(northMountains, 10));
        BiomeManager.addBiome(BiomeManager.BiomeType.DESERT, new BiomeManager.BiomeEntry(northPlains, 10));
        BiomeManager.addBiome(BiomeManager.BiomeType.DESERT, new BiomeManager.BiomeEntry(northGlacier, 10));
    }
}
