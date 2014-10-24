package com.gigavoid.supermod.biome;

import net.minecraftforge.common.BiomeManager;

public class SuperBiomes {

    public static final EmeraldBiomeGen emeraldBiomeGen = new EmeraldBiomeGen();

    public static void registerBiomes(){
        BiomeManager.addSpawnBiome(emeraldBiomeGen);
    }
}
