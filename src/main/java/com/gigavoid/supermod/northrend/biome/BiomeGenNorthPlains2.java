package com.gigavoid.supermod.northrend.biome;

import net.minecraft.block.Block;

public class BiomeGenNorthPlains2 extends NorthrendBiomeGenBase {

    public BiomeGenNorthPlains2(int id){
        super(id);

        setBiomeName("Northrend Plains");
        setHeight(new Height(.2f, .05f));
        topBlock = Block.getBlockFromName("snow").getDefaultState();
        fillerBlock = Block.getBlockFromName("snow").getDefaultState();
    }
}
