package com.gigavoid.supermod.northrend.biome;

import com.gigavoid.supermod.northrend.block.NorthrendBlocks;
import com.gigavoid.supermod.northrend.worldgen.tree.SuperWorldGenTree;
import net.minecraft.block.Block;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

import java.util.Random;

public class BiomeGenNorthForest extends NorthrendBiomeGenBase {
    SuperWorldGenTree treeGen = new SuperWorldGenTree(true, SuperWorldGenTree.TreeType.REGULAR);

    public BiomeGenNorthForest(int id){
        super(id);
        this.setBiomeName("Northrend Forest");
        this.setHeight(new Height(0.1f, 0.1f));
        this.topBlock = Block.getBlockFromName("snow").getDefaultState();
        this.fillerBlock = NorthrendBlocks.northDirt.getDefaultState();
        this.theBiomeDecorator.treesPerChunk = 14;
    }

    @Override
    public WorldGenAbstractTree genBigTreeChance(Random r) {
        return treeGen;
    }
}