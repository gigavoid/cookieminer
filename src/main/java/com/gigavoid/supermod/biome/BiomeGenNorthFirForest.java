package com.gigavoid.supermod.biome;

import com.gigavoid.supermod.block.SuperBlocks;
import com.gigavoid.supermod.worldgen.trees.SuperWorldGenNorthrendTree;
import net.minecraft.block.Block;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

import java.util.Random;

public class BiomeGenNorthFirForest extends SuperBiomeGenBaseNorthrend {
    SuperWorldGenNorthrendTree treeGen = new SuperWorldGenNorthrendTree(true, SuperWorldGenNorthrendTree.TreeType.FIR);

    public BiomeGenNorthFirForest(int id){
        super(id);
        setBiomeName("Northrend Fir Forest");
        setHeight(new Height(0.1f, 0.1f));
        topBlock = Block.getBlockFromName("snow");
        fillerBlock = SuperBlocks.northDirt;
        theBiomeDecorator.treesPerChunk = 14;
    }

    @Override
    public WorldGenAbstractTree func_150567_a(Random r) {
        return treeGen;
    }
}