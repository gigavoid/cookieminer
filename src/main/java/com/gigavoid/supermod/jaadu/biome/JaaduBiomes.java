package com.gigavoid.supermod.jaadu.biome;

import net.minecraftforge.common.BiomeManager;

/**
 * Created by Rasmus on 2/18/2015.
 */
public class JaaduBiomes {
    public static final BiomeGenJaaduSky jaaduSky = new BiomeGenJaaduSky(56);

    public static void registerBiomes() {
        BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeManager.BiomeEntry(jaaduSky, 0));
    }
}
