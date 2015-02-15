package com.gigavoid.supermod.northrend.biome;

import net.minecraft.block.Block;

public class BiomeGenNorthSmallMountains extends NorthrendBiomeGenBase {

    public BiomeGenNorthSmallMountains(int id){
        super(id);

        setBiomeName("Northrend Mountains");
        setHeight(new Height(1.0f, .5f));
        topBlock = Block.getBlockFromName("snow").getDefaultState();
        fillerBlock = Block.getBlockFromName("snow").getDefaultState();
    }
}
