package com.gigavoid.supermod.biome;

import net.minecraftforge.common.BiomeManager;

public class SuperBiomes {

    public static final BiomeGenEmerald emeraldForest = new BiomeGenEmerald();
    public static final BiomeGenBloodMarshes bloodMarsh = new BiomeGenBloodMarshes();
    public static final BiomeGenNorthForest northForest = new BiomeGenNorthForest();
    public static final BiomeGenNorthMountains northMountains = new BiomeGenNorthMountains();
    public static final BiomeGenNorthPlains northPlains = new BiomeGenNorthPlains();
    public static final BiomeGenNorthGlacier northGlacier = new BiomeGenNorthGlacier();
    public static final BiomeGenCityRuins cityRuins = new BiomeGenCityRuins();

    public static void registerBiomes(){
        BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeManager.BiomeEntry(emeraldForest, 10));
        BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeManager.BiomeEntry(bloodMarsh, 10));
        BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeManager.BiomeEntry(cityRuins, 1000000));
        BiomeManager.addBiome(BiomeManager.BiomeType.ICY, new BiomeManager.BiomeEntry(northForest, 0));
        BiomeManager.addBiome(BiomeManager.BiomeType.ICY, new BiomeManager.BiomeEntry(northMountains, 0));
        BiomeManager.addBiome(BiomeManager.BiomeType.ICY, new BiomeManager.BiomeEntry(northPlains, 0));
        BiomeManager.addBiome(BiomeManager.BiomeType.ICY, new BiomeManager.BiomeEntry(northGlacier, 0));
    }
}
