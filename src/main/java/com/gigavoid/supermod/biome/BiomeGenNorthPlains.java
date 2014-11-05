package com.gigavoid.supermod.biome;

import com.gigavoid.supermod.entity.EntityYeti;
import net.minecraft.block.Block;
import net.minecraft.world.biome.BiomeGenBase;

/**
 * Created by Rasmus on 2014-11-03.
 */
public class BiomeGenNorthPlains extends BiomeGenBase {
    public BiomeGenNorthPlains(){
        super(43);

        setBiomeName("Northrend Plains");
        setHeight(new BiomeGenBase.Height(.2f, .05f));
        waterColorMultiplier = 0xFFFFFF;
        topBlock = Block.getBlockFromName("snow");
        fillerBlock = Block.getBlockFromName("snow");
        spawnableCaveCreatureList.clear();
        spawnableCreatureList.clear();
        spawnableMonsterList.clear();
        spawnableWaterCreatureList.clear();
        spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(EntityYeti.class, 2, 1, 1));
        temperature = 0.0f;
        rainfall = 1.0f;
    }
}
