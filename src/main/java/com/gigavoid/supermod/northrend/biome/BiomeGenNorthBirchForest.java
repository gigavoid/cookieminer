package com.gigavoid.supermod.northrend.biome;

import com.gigavoid.supermod.northrend.block.NorthrendBlocks;
import com.gigavoid.supermod.northrend.worldgen.tree.NorthrendWorldGenTree;
import net.minecraft.block.Block;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

import java.util.Random;

public class BiomeGenNorthBirchForest extends NorthrendBiomeGenBase {
    NorthrendWorldGenTree treeGen = new NorthrendWorldGenTree(true, NorthrendWorldGenTree.TreeType.BIRCH);

    public BiomeGenNorthBirchForest(int id, int weight){
        super(id, weight);
        setBiomeName("Northrend Birch Forest");
        setHeight(new Height(0.05f, 0.05f));
        topBlock = Block.getBlockFromName("snow").getDefaultState();
        fillerBlock = NorthrendBlocks.northDirt.getDefaultState();
        theBiomeDecorator.treesPerChunk = 14;
    }

    @Override
    public WorldGenAbstractTree genBigTreeChance(Random r) {
        return treeGen;
    }
}