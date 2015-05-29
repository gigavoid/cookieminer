package com.gigavoid.supermod.cookiecraft.biome;

import com.gigavoid.supermod.cookiecraft.block.CookiecraftBlocks;
import com.gigavoid.supermod.northrend.block.NorthrendBlocks;
import net.minecraft.block.Block;
import net.minecraft.world.biome.BiomeGenBase;

public class CookieBiome extends CookiecraftBiomeGenBase {
    public CookieBiome(int id, int weight){
        super(id, weight);
        setBiomeName("Cookieverse");
        setHeight(new Height(.0f, .2f));
        topBlock = CookiecraftBlocks.cookieBlock.getDefaultState();
        fillerBlock = CookiecraftBlocks.cookieBlock.getDefaultState();
        this.spawnableCaveCreatureList.clear();
        this.spawnableCreatureList.clear();
        this.spawnableMonsterList.clear();
        this.spawnableWaterCreatureList.clear();
    }
}
