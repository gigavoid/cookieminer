package com.gigavoid.supermod.northrend.biome;

import net.minecraftforge.common.BiomeManager;

public class NorthrendBiomes {

    public static final BiomeGenNorthForest northForest = new BiomeGenNorthForest(40);
    public static final BiomeGenNorthFirForest northFirForest = new BiomeGenNorthFirForest(41);
    public static final BiomeGenNorthMountains northMountains = new BiomeGenNorthMountains(42);
    public static final BiomeGenNorthPlains northPlains = new BiomeGenNorthPlains(43);
    public static final BiomeGenNorthGlacier northGlacier = new BiomeGenNorthGlacier(44);
    public static final BiomeGenNorthHighlands northHighlands = new BiomeGenNorthHighlands(45);
    public static final BiomeGenNorthHugeMountains northHugeMountains = new BiomeGenNorthHugeMountains(46);
    public static final BiomeGenNorthHills northSmallMountains = new BiomeGenNorthHills(47);
    public static final BiomeGenNorthBirchForest northBirchForest = new BiomeGenNorthBirchForest(48);
    public static final BiomeGenNorthBlight northBlight = new BiomeGenNorthBlight(49);
    public static final BiomeGenNorthPlains2 northPlains2 = new BiomeGenNorthPlains2(50);
    public static final BiomeGenNorthSpikes northSpikes = new BiomeGenNorthSpikes(51);

    public static void registerBiomes(){
        BiomeManager.addBiome(BiomeManager.BiomeType.ICY, new BiomeManager.BiomeEntry(northForest, 0));
        BiomeManager.addBiome(BiomeManager.BiomeType.ICY, new BiomeManager.BiomeEntry(northFirForest, 0));
        BiomeManager.addBiome(BiomeManager.BiomeType.ICY, new BiomeManager.BiomeEntry(northMountains, 0));
        BiomeManager.addBiome(BiomeManager.BiomeType.ICY, new BiomeManager.BiomeEntry(northPlains, 0));
        BiomeManager.addBiome(BiomeManager.BiomeType.ICY, new BiomeManager.BiomeEntry(northGlacier, 0));
        BiomeManager.addBiome(BiomeManager.BiomeType.ICY, new BiomeManager.BiomeEntry(northHighlands, 0));
        BiomeManager.addBiome(BiomeManager.BiomeType.ICY, new BiomeManager.BiomeEntry(northHugeMountains, 0));
        BiomeManager.addBiome(BiomeManager.BiomeType.ICY, new BiomeManager.BiomeEntry(northSmallMountains, 0));
        BiomeManager.addBiome(BiomeManager.BiomeType.ICY, new BiomeManager.BiomeEntry(northBirchForest, 0));
        BiomeManager.addBiome(BiomeManager.BiomeType.ICY, new BiomeManager.BiomeEntry(northBlight, 0));
        BiomeManager.addBiome(BiomeManager.BiomeType.ICY, new BiomeManager.BiomeEntry(northPlains2, 0));
        BiomeManager.addBiome(BiomeManager.BiomeType.ICY, new BiomeManager.BiomeEntry(northSpikes, 0));
    }
}
