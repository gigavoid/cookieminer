package com.gigavoid.supermod.northrend.biome;

import net.minecraft.block.Block;

public class BiomeGenNorthHighlands extends NorthrendBiomeGenBase {

    public BiomeGenNorthHighlands(int id, int weight){
        super(id, weight);

        setBiomeName("Northrend Highlands");
        setHeight(new Height(0.8f, .05f));
        topBlock = Block.getBlockFromName("snow").getDefaultState();
        fillerBlock = Block.getBlockFromName("snow").getDefaultState();
    }
}
