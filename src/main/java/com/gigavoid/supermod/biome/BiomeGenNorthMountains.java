package com.gigavoid.supermod.biome;

import net.minecraft.block.Block;
import net.minecraft.world.biome.BiomeGenBase;

/**
 * Created by Rasmus on 2014-11-03.
 */
public class BiomeGenNorthMountains extends BiomeGenBase {

    public BiomeGenNorthMountains(){
        super(42);

        setBiomeName("Northrend Mountains");
        setHeight(new BiomeGenBase.Height(2.3f, 0.7f));
        waterColorMultiplier = 0xFFFFFF;
        topBlock = Block.getBlockFromName("snow");
        fillerBlock = Block.getBlockFromName("snow");
        temperature = 0.0f;
        rainfall = 1.0f;
    }
}
