package com.gigavoid.supermod.biome;

import com.gigavoid.supermod.worldgen.trees.SuperWorldGenNorthrendTree;
import net.minecraft.block.Block;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

import java.util.Random;

public class BiomeGenNorthForest extends BiomeGenBase {
    SuperWorldGenNorthrendTree treeGen = new SuperWorldGenNorthrendTree(true);

    public BiomeGenNorthForest(){
        super(41);

        theBiomeDecorator.treesPerChunk = 14;
        setBiomeName("Northrend Forest");
        setHeight(new Height(0.1f, 0.1f));
        waterColorMultiplier = 0xFFFFFF;
        topBlock = Block.getBlockFromName("snow");
        fillerBlock = Block.getBlockById(3);
        temperature = 0.0f;
        rainfall = 1.0f;
    }

    @Override
    public WorldGenAbstractTree func_150567_a(Random r) {
        return treeGen;
    }
}