package com.gigavoid.supermod.northrend.biome;

import com.gigavoid.supermod.northrend.block.NorthrendBlocks;
import com.gigavoid.supermod.northrend.worldgen.tree.SuperWorldGenTree;
import net.minecraft.block.Block;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenTrees;

import java.util.Random;

public class BiomeGenNorthFirForest extends NorthrendBiomeGenBase {
    SuperWorldGenTree treeGen = new SuperWorldGenTree(true, SuperWorldGenTree.TreeType.FIR);

    public BiomeGenNorthFirForest(int id){
        super(id);
        setBiomeName("Northrend Fir Forest");
        setHeight(new Height(0.1f, 0.1f));
        topBlock = Block.getBlockFromName("snow").getDefaultState();
        fillerBlock = NorthrendBlocks.northDirt.getDefaultState();
        theBiomeDecorator.treesPerChunk = 14;
        worldGeneratorTrees = treeGen;
    }

    @Override
    public WorldGenAbstractTree genBigTreeChance(Random r) {
        return treeGen;
    }
}