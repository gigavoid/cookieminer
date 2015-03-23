package com.gigavoid.supermod.ropeway.biome;

import com.gigavoid.supermod.common.Register;
import com.gigavoid.supermod.northrend.biome.*;
import net.minecraftforge.common.BiomeManager;

public class RopewayBiomes {
    public static BiomeGenRopewaySkylands skylands;
    public static BiomeGenRopewaySkylands2 skylands2;

    public static void registerBiomes(Register register){
        skylands = new BiomeGenRopewaySkylands(register.getNextBiomeID(), 10);
        skylands2 = new BiomeGenRopewaySkylands2(register.getNextBiomeID(), 10);

        BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeManager.BiomeEntry(skylands, 0));
        BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeManager.BiomeEntry(skylands2, 0));
    }
}
