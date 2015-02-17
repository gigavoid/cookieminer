package com.gigavoid.supermod.northrend.biome;

import net.minecraftforge.common.BiomeManager;

public class NorthrendBiomes {
    public static final BiomeGenNorthForest northForest = new BiomeGenNorthForest(40, 10);
    public static final BiomeGenNorthFirForest northFirForest = new BiomeGenNorthFirForest(41, 10);
    public static final BiomeGenNorthMountains northMountains = new BiomeGenNorthMountains(42, 30);
    public static final BiomeGenNorthPlains northPlains = new BiomeGenNorthPlains(43, 60);
    public static final BiomeGenNorthGlacier northGlacier = new BiomeGenNorthGlacier(44, 60);
    public static final BiomeGenNorthHighlands northHighlands = new BiomeGenNorthHighlands(45, 30);
    public static final BiomeGenNorthHugeMountains northHugeMountains = new BiomeGenNorthHugeMountains(46, 10);
    public static final BiomeGenNorthHills northHills = new BiomeGenNorthHills(47, 60);
    public static final BiomeGenNorthBirchForest northBirchForest = new BiomeGenNorthBirchForest(48, 10);
    public static final BiomeGenNorthBlight northBlight = new BiomeGenNorthBlight(49, 10);
    public static final BiomeGenNorthSpikes northSpikes = new BiomeGenNorthSpikes(50, 7);

    public static void registerBiomes(){
        BiomeManager.addBiome(BiomeManager.BiomeType.ICY, new BiomeManager.BiomeEntry(northForest, 0));
        BiomeManager.addBiome(BiomeManager.BiomeType.ICY, new BiomeManager.BiomeEntry(northFirForest, 0));
        BiomeManager.addBiome(BiomeManager.BiomeType.ICY, new BiomeManager.BiomeEntry(northMountains, 0));
        BiomeManager.addBiome(BiomeManager.BiomeType.ICY, new BiomeManager.BiomeEntry(northPlains, 0));
        BiomeManager.addBiome(BiomeManager.BiomeType.ICY, new BiomeManager.BiomeEntry(northGlacier, 0));
        BiomeManager.addBiome(BiomeManager.BiomeType.ICY, new BiomeManager.BiomeEntry(northHighlands, 0));
        BiomeManager.addBiome(BiomeManager.BiomeType.ICY, new BiomeManager.BiomeEntry(northHugeMountains, 0));
        BiomeManager.addBiome(BiomeManager.BiomeType.ICY, new BiomeManager.BiomeEntry(northHills, 0));
        BiomeManager.addBiome(BiomeManager.BiomeType.ICY, new BiomeManager.BiomeEntry(northBirchForest, 0));
        BiomeManager.addBiome(BiomeManager.BiomeType.ICY, new BiomeManager.BiomeEntry(northBlight, 0));
        BiomeManager.addBiome(BiomeManager.BiomeType.ICY, new BiomeManager.BiomeEntry(northSpikes, 0));
    }
}
