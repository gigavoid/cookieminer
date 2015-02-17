package com.gigavoid.supermod.northrend.biome;

import com.gigavoid.supermod.northrend.block.NorthrendBlocks;
import net.minecraft.block.Block;
import net.minecraft.world.biome.BiomeGenBase;

/**
 * Created by Rasmus on 2/15/2015.
 */
public class BiomeGenNorthBlight extends NorthrendBiomeGenBase{

    public BiomeGenNorthBlight(int id, int weight){
        super(id, weight);

        setBiomeName("Northrend Plains");
        setHeight(new BiomeGenBase.Height(.2f, .05f));
        topBlock = NorthrendBlocks.blight.getDefaultState();
        fillerBlock = NorthrendBlocks.blight.getDefaultState();
    }
}
