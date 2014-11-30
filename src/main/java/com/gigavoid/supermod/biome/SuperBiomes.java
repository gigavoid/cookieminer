package com.gigavoid.supermod.biome;

import net.minecraftforge.common.BiomeManager;

public class SuperBiomes {

    public static final BiomeGenEmerald emeraldForest = new BiomeGenEmerald(40);
    public static final BiomeGenBloodMarshes bloodMarsh = new BiomeGenBloodMarshes(41);
    public static final BiomeGenNorthForest northForest = new BiomeGenNorthForest(42);
    public static final BiomeGenNorthFirForest northFirForest = new BiomeGenNorthFirForest(43);
    public static final BiomeGenNorthMountains northMountains = new BiomeGenNorthMountains(44);
    public static final BiomeGenNorthPlains northPlains = new BiomeGenNorthPlains(45);
    public static final BiomeGenNorthGlacier northGlacier = new BiomeGenNorthGlacier(46);
    public static final BiomeGenNorthHighlands northHighlands = new BiomeGenNorthHighlands(47);
    public static final BiomeGenNorthHugeMountains northHugeMountains = new BiomeGenNorthHugeMountains(48);
    public static final BiomeGenNorthSmallMountains northSmallMountains = new BiomeGenNorthSmallMountains(49);

    public static void registerBiomes(){
        BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeManager.BiomeEntry(emeraldForest, 10));
        BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeManager.BiomeEntry(bloodMarsh, 10));
        BiomeManager.addBiome(BiomeManager.BiomeType.ICY, new BiomeManager.BiomeEntry(northForest, 0));
        BiomeManager.addBiome(BiomeManager.BiomeType.ICY, new BiomeManager.BiomeEntry(northFirForest, 0));
        BiomeManager.addBiome(BiomeManager.BiomeType.ICY, new BiomeManager.BiomeEntry(northMountains, 0));
        BiomeManager.addBiome(BiomeManager.BiomeType.ICY, new BiomeManager.BiomeEntry(northPlains, 0));
        BiomeManager.addBiome(BiomeManager.BiomeType.ICY, new BiomeManager.BiomeEntry(northGlacier, 0));
        BiomeManager.addBiome(BiomeManager.BiomeType.ICY, new BiomeManager.BiomeEntry(northHighlands, 0));
        BiomeManager.addBiome(BiomeManager.BiomeType.ICY, new BiomeManager.BiomeEntry(northHugeMountains, 0));
    }
}
