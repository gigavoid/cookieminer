package com.gigavoid.supermod.biome;

import com.gigavoid.supermod.block.SuperBlocks;
import com.gigavoid.supermod.decorator.NorthrendDecorator;
import com.gigavoid.supermod.decorator.SuperDecorator;
import com.gigavoid.supermod.entity.EntityYeti;
import net.minecraft.block.Block;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;

import java.util.Random;

/**
 * Created by Rasmus on 2014-11-03.
 */
public class BiomeGenNorthGlacier extends SuperBiomeGenBaseNorthrend {

    public BiomeGenNorthGlacier() {
        super(44);

        setBiomeName("Northrend Glacier");
        setHeight(new BiomeGenBase.Height(-1f, 0.1f));
        waterColorMultiplier = 0xFFFFFF;
        topBlock = SuperBlocks.northStone;
        fillerBlock = SuperBlocks.northStone;
        spawnableCaveCreatureList.clear();
        spawnableCreatureList.clear();
        spawnableMonsterList.clear();
        spawnableWaterCreatureList.clear();
        spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(EntityYeti.class, 2, 1, 1));
        spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(EntitySkeleton.class, 2, 1, 1));
        temperature = 0.0f;
        rainfall = 1.0f;
    }
}
