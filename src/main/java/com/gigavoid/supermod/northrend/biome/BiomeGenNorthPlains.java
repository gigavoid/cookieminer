package com.gigavoid.supermod.northrend.biome;

import net.minecraft.block.Block;
import net.minecraft.world.biome.BiomeGenBase;

public class BiomeGenNorthPlains extends NorthrendBiomeGenBase {

    public BiomeGenNorthPlains(int id, int weight){
        super(id, weight);

        setBiomeName("Northrend Plains");
        setHeight(new BiomeGenBase.Height(.25f, .05f));
        topBlock = Block.getBlockFromName("snow").getDefaultState();
        fillerBlock = Block.getBlockFromName("snow").getDefaultState();
    }
}
