package com.gigavoid.supermod.northrend.biome;

import net.minecraft.block.Block;

public class BiomeGenNorthHills extends NorthrendBiomeGenBase {

    public BiomeGenNorthHills(int id){
        super(id);

        setBiomeName("Northrend Hills");
        setHeight(new Height(0.7f, .4f));
        topBlock = Block.getBlockFromName("snow").getDefaultState();
        fillerBlock = Block.getBlockFromName("snow").getDefaultState();
    }
}
