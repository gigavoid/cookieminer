package com.gigavoid.supermod.ropeway.biome;

import net.minecraft.init.Blocks;

public class BiomeGenRopewayForest extends RopewayBiomeGenBase {

    public BiomeGenRopewayForest(int id, int weight){
        super(id, weight);

        setBiomeName("Skyland Forest");
        setHeight(new Height(-1.0f, 0.3f));
        topBlock = Blocks.grass.getDefaultState();
        fillerBlock = Blocks.dirt.getDefaultState();
        theBiomeDecorator.treesPerChunk = 11;
    }
}
