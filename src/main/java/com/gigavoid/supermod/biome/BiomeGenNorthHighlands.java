package com.gigavoid.supermod.biome;

import net.minecraft.block.Block;

/**
 * Created by Rasmus on 2014-11-03.
 */
public class BiomeGenNorthHighlands extends SuperBiomeGenBaseNorthrend {

    public BiomeGenNorthHighlands(int id){
        super(id);

        setBiomeName("Northrend Highlands");
        setHeight(new Height(0.8f, .15f));
        topBlock = Block.getBlockFromName("snow");
        fillerBlock = Block.getBlockFromName("snow");
    }
}
