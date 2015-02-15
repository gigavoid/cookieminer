package com.gigavoid.supermod.northrend.biome;

import net.minecraft.block.Block;
import net.minecraft.world.biome.BiomeGenBase;

public class BiomeGenNorthMountains extends NorthrendBiomeGenBase {

    public BiomeGenNorthMountains(int id){
        super(id);

        setBiomeName("Northrend Mountains");
        setHeight(new BiomeGenBase.Height(1.5f, .6f));
        topBlock = Block.getBlockFromName("snow").getDefaultState();
        fillerBlock = Block.getBlockFromName("snow").getDefaultState();
    }
}
