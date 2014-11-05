package com.gigavoid.supermod.biome;

import net.minecraft.block.Block;
import net.minecraft.world.biome.BiomeGenBase;

/**
 * Created by Rasmus on 2014-11-03.
 */
public class BiomeGenNorthGlacier extends BiomeGenBase{
        public BiomeGenNorthGlacier(){
            super(44);

            setBiomeName("Northrend Glacier");
            setHeight(new BiomeGenBase.Height(-1f, 0.1f));
            waterColorMultiplier = 0xFFFFFF;
            topBlock = Block.getBlockFromName("stone");
            fillerBlock = Block.getBlockFromName("stone");
            temperature = 0.0f;
            rainfall = 1.0f;
        }
}
