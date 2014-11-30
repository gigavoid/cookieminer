package com.gigavoid.supermod.biome;

import com.gigavoid.supermod.block.SuperBlocks;
import com.gigavoid.supermod.entity.EntityYeti;
import com.gigavoid.supermod.worldgen.trees.SuperWorldGenNorthrendTree;
import net.minecraft.block.Block;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

import java.util.Random;

public class BiomeGenNorthForest extends SuperBiomeGenBaseNorthrend {
    SuperWorldGenNorthrendTree treeGen = new SuperWorldGenNorthrendTree(true, SuperWorldGenNorthrendTree.TreeType.REGULAR);

    public BiomeGenNorthForest(int id){
        super(id);
        setBiomeName("Northrend Forest");
        setHeight(new Height(0.1f, 0.1f));
        topBlock = Block.getBlockFromName("snow").getDefaultState();
        fillerBlock = SuperBlocks.northDirt.getDefaultState();
        theBiomeDecorator.treesPerChunk = 14;
    }

    @Override
    public WorldGenAbstractTree genBigTreeChance(Random r) {
        return treeGen;
    }
}