package com.gigavoid.supermod.northrend.biome;

import net.minecraft.block.Block;

public class BiomeGenNorthHighlands extends NorthrendBiomeGenBase {

    public BiomeGenNorthHighlands(int id){
        super(id);

        setBiomeName("Northrend Highlands");
        setHeight(new Height(0.8f, .15f));
        topBlock = Block.getBlockFromName("snow").getDefaultState();
        fillerBlock = Block.getBlockFromName("snow").getDefaultState();
    }
}
