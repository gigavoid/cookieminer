package com.gigavoid.supermod.ropeway.biome;

import com.gigavoid.supermod.common.Register;
import net.minecraftforge.common.BiomeManager;

public class RopewayBiomes {
    public static BiomeGenRopewaySkylands skylands;
    public static BiomeGenRopewayForest forest;
    public static BiomeGenRopewayAbyss abyss;

    public static void registerBiomes(Register register){
        skylands = new BiomeGenRopewaySkylands(register.getNextBiomeID(), 10);
        forest = new BiomeGenRopewayForest(register.getNextBiomeID(), 10);
        abyss = new BiomeGenRopewayAbyss(register.getNextBiomeID(), 30);

        BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeManager.BiomeEntry(skylands, 0));
        BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeManager.BiomeEntry(forest, 0));
        BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeManager.BiomeEntry(abyss, 0));
    }
}
