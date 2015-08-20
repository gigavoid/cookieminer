package com.gigavoid.supermod.ropeway.biome;

import net.minecraft.init.Blocks;

public class BiomeGenRopewayDesert extends RopewayBiomeGenBase {

    public BiomeGenRopewayDesert(int id, int weight){
        super(id, weight);

        setBiomeName("Skyland Desert");
        setHeight(new Height(-1.0f, 0.3f));
        topBlock = Blocks.sand.getDefaultState();
        fillerBlock = Blocks.sand.getDefaultState();
    }
}
