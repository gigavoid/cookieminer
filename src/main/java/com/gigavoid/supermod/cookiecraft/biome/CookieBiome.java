package com.gigavoid.supermod.cookiecraft.biome;

import com.gigavoid.supermod.northrend.block.NorthrendBlocks;
import net.minecraft.block.Block;
import net.minecraft.world.biome.BiomeGenBase;

public class CookieBiome extends BiomeGenBase {
    public CookieBiome(int id){
        super(id);
        setBiomeName("Cookieverse");
        setHeight(new Height(.0f, .2f));
        topBlock = Block.getBlockFromName("snow").getDefaultState();
        fillerBlock = NorthrendBlocks.northDirt.getDefaultState();
        this.spawnableCaveCreatureList.clear();
        this.spawnableCreatureList.clear();
        this.spawnableMonsterList.clear();
        this.spawnableWaterCreatureList.clear();
        //this.theBiomeDecorator = null;
    }
}
