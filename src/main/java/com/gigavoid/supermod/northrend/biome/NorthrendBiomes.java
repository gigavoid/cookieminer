package com.gigavoid.supermod.northrend.biome;

import com.gigavoid.supermod.common.Register;
import net.minecraftforge.common.BiomeManager;

public class NorthrendBiomes {
    public static BiomeGenNorthPineForest northForest;
    public static BiomeGenNorthFirForest northFirForest;
    public static BiomeGenNorthMountains northMountains;
    public static BiomeGenNorthPlains northPlains;
    public static BiomeGenNorthGlacier northGlacier;
    public static BiomeGenNorthHighlands northHighlands;
    public static BiomeGenNorthHugeMountains northHugeMountains;
    public static BiomeGenNorthHills northHills;
    public static BiomeGenNorthBirchForest northBirchForest;
    public static BiomeGenNorthBlight northBlight;
    public static BiomeGenNorthSpikes northSpikes;

    public static void registerBiomes(Register register){
        northForest = new BiomeGenNorthPineForest(register.getNextBiomeID(), 10);
        northFirForest = new BiomeGenNorthFirForest(register.getNextBiomeID(), 10);
        northMountains = new BiomeGenNorthMountains(register.getNextBiomeID(), 30);
        northPlains = new BiomeGenNorthPlains(register.getNextBiomeID(), 60);
        northGlacier = new BiomeGenNorthGlacier(register.getNextBiomeID(), 60);
        northHighlands = new BiomeGenNorthHighlands(register.getNextBiomeID(), 30);
        northHugeMountains = new BiomeGenNorthHugeMountains(register.getNextBiomeID(), 10);
        northHills = new BiomeGenNorthHills(register.getNextBiomeID(), 60);
        northBirchForest = new BiomeGenNorthBirchForest(register.getNextBiomeID(), 10);
        northBlight = new BiomeGenNorthBlight(register.getNextBiomeID(), 10);
        northSpikes = new BiomeGenNorthSpikes(register.getNextBiomeID(), 5);

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
    }
}
