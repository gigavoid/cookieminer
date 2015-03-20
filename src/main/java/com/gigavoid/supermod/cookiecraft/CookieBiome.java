package com.gigavoid.supermod.cookiecraft;

import com.gigavoid.supermod.northrend.block.NorthrendBlocks;
import net.minecraft.block.Block;
import net.minecraft.world.biome.BiomeGenBase;

public class CookieBiome extends BiomeGenBase {
    public CookieBiome(int id){
        super(id);
        setBiomeName("Northrend Birch Forest");
        setHeight(new Height(0.05f, 0.05f));
        topBlock = Block.getBlockFromName("snow").getDefaultState();
        fillerBlock = NorthrendBlocks.northDirt.getDefaultState();
    }
}
