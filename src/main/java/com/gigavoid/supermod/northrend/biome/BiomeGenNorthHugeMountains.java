package com.gigavoid.supermod.northrend.biome;

import net.minecraft.block.Block;

public class BiomeGenNorthHugeMountains extends NorthrendBiomeGenBase {
    public BiomeGenNorthHugeMountains(int id, int weight){
        super(id, weight);

        setBiomeName("Northrend Huge Mountains");
        setHeight(new Height(2.5f, 1.25f));
        topBlock = Block.getBlockFromName("snow").getDefaultState();
        fillerBlock = Block.getBlockFromName("snow").getDefaultState();
    }
}