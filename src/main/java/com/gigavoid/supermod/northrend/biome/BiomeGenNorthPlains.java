package com.gigavoid.supermod.northrend.biome;

import com.gigavoid.supermod.northrend.worldgen.tree.NorthrendWorldGenBloodBeech;
import net.minecraft.block.Block;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

import java.util.Random;

public class BiomeGenNorthPlains extends NorthrendBiomeGenBase {
    private NorthrendWorldGenBloodBeech treeGen = new NorthrendWorldGenBloodBeech(true, 4);

    public BiomeGenNorthPlains(int id, int weight){
        super(id, weight);

        setBiomeName("Northrend Plains");
        setHeight(new BiomeGenBase.Height(.25f, .05f));
        topBlock = Block.getBlockFromName("snow").getDefaultState();
        fillerBlock = Block.getBlockFromName("snow").getDefaultState();
        theBiomeDecorator.treesPerChunk = 6;
    }

    @Override
    public WorldGenAbstractTree genBigTreeChance(Random r) {
        return treeGen;
    }
}
