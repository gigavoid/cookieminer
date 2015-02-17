package com.gigavoid.supermod.northrend.biome;

import net.minecraft.block.Block;

public class BiomeGenNorthHugeMountains extends NorthrendBiomeGenBase {

    public BiomeGenNorthHugeMountains(int id){
        super(id);

        setBiomeName("Northrend Huge Mountains");
        setHeight(new Height(3f, .75f));
        topBlock = Block.getBlockFromName("snow").getDefaultState();
        fillerBlock = Block.getBlockFromName("snow").getDefaultState();
    }
}
