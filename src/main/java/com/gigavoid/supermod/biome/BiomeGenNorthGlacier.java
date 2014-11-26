package com.gigavoid.supermod.biome;

import com.gigavoid.supermod.block.SuperBlocks;
import com.gigavoid.supermod.worldgen.trees.SuperWorldGenIgloo;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

import java.util.Random;

/**
 * Created by Rasmus on 2014-11-03.
 */
public class BiomeGenNorthGlacier extends SuperBiomeGenBaseNorthrend {
    SuperWorldGenIgloo iglooGen = new SuperWorldGenIgloo(true);

    public BiomeGenNorthGlacier(int id) {
        super(id);

        setBiomeName("Northrend Glacier");
        setHeight(new BiomeGenBase.Height(-1f, 0.1f));
        topBlock = SuperBlocks.northStone;
        fillerBlock = SuperBlocks.northStone;
        theBiomeDecorator.treesPerChunk = 1;
    }

    @Override
    public WorldGenAbstractTree func_150567_a(Random r) {
        return iglooGen;
    }
}
