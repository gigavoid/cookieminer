package com.gigavoid.supermod.northrend.biome;

import com.gigavoid.supermod.northrend.block.NorthrendBlocks;
import com.gigavoid.supermod.northrend.worldgen.tree.WorldGenTree;
import net.minecraft.block.Block;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

import java.util.Random;

public class BiomeGenNorthBirchForest extends NorthrendBiomeGenBase {
    WorldGenTree treeGen = new WorldGenTree(true, WorldGenTree.TreeType.BIRCH);

    public BiomeGenNorthBirchForest(int id, int weight){
        super(id, weight);
        setBiomeName("Northrend Birch Forest");
        setHeight(new Height(0.1f, 0.1f));
        topBlock = Block.getBlockFromName("snow").getDefaultState();
        fillerBlock = NorthrendBlocks.northDirt.getDefaultState();
        theBiomeDecorator.treesPerChunk = 14;
    }

    @Override
    public WorldGenAbstractTree genBigTreeChance(Random r) {
        return treeGen;
    }
}