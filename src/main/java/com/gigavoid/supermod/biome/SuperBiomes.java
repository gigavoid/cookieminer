package com.gigavoid.supermod.biome;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.WorldChunkManager;
import net.minecraftforge.common.BiomeManager;

import java.util.ArrayList;
import java.util.Arrays;

public class SuperBiomes {

    public static final BiomeGenEmerald emeraldForest = new BiomeGenEmerald();
    public static final BiomeGenNorthForest northForest = new BiomeGenNorthForest();
    public static final BiomeGenNorthMountains northMountains = new BiomeGenNorthMountains();

    public static void registerBiomes(){
        BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeManager.BiomeEntry(emeraldForest, 10));
        BiomeManager.addBiome(BiomeManager.BiomeType.ICY, new BiomeManager.BiomeEntry(northForest, 10));
        BiomeManager.addBiome(BiomeManager.BiomeType.COOL, new BiomeManager.BiomeEntry(northMountains, 1000000));
    }
}
