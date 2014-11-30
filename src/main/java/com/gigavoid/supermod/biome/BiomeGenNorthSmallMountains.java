package com.gigavoid.supermod.biome;

import net.minecraft.block.Block;

/**
 * Created by Rasmus on 2014-11-03.
 */
public class BiomeGenNorthSmallMountains extends SuperBiomeGenBaseNorthrend {

    public BiomeGenNorthSmallMountains(int id){
        super(id);

        setBiomeName("Northrend Mountains");
        setHeight(new Height(1.0f, .5f));
        topBlock = Block.getBlockFromName("snow").getDefaultState();
        fillerBlock = Block.getBlockFromName("snow").getDefaultState();
    }
}
