package com.gigavoid.supermod.northrend.biome;

import com.gigavoid.supermod.northrend.worldgen.tree.WorldGenIgloo;
import net.minecraft.init.Blocks;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

import java.util.Random;

public class BiomeGenNorthGlacier extends NorthrendBiomeGenBase {
    WorldGenIgloo iglooGen = new WorldGenIgloo(true);

    public BiomeGenNorthGlacier(int id, int weight){
        super(id, weight);

        setBiomeName("Northrend Glacier");
        setHeight(new Height(-1.0f, 0.1f));
        topBlock = Blocks.snow.getDefaultState();
        fillerBlock = Blocks.snow.getDefaultState();
        theBiomeDecorator.treesPerChunk = 1;
    }

    @Override
    public WorldGenAbstractTree genBigTreeChance(Random r) {
        return iglooGen;
    }
}
