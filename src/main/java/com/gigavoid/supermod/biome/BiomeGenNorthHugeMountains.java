package com.gigavoid.supermod.biome;

import net.minecraft.block.Block;

/**
 * Created by Rasmus on 2014-11-03.
 */
public class BiomeGenNorthHugeMountains extends SuperBiomeGenBaseNorthrend {

    public BiomeGenNorthHugeMountains(int id){
        super(id);

        setBiomeName("Northrend Huge Mountains");
        setHeight(new Height(2.5f, .8f));
        topBlock = Block.getBlockFromName("snow").getDefaultState();
        fillerBlock = Block.getBlockFromName("snow").getDefaultState();
    }
}
