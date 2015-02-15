package com.gigavoid.supermod.northrend.biome;

import net.minecraft.block.Block;
import net.minecraft.world.biome.BiomeGenBase;

public class BiomeGenNorthPlains extends NorthrendBiomeGenBase {

    public BiomeGenNorthPlains(int id){
        super(id);

        setBiomeName("Northrend Plains");
        setHeight(new BiomeGenBase.Height(.2f, .05f));
        topBlock = Block.getBlockFromName("snow").getDefaultState();
        fillerBlock = Block.getBlockFromName("snow").getDefaultState();
    }
}
