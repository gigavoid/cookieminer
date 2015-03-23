package com.gigavoid.supermod.ropeway.biome;

import net.minecraft.init.Blocks;

public class BiomeGenRopewaySkylands2 extends RopewayBiomeGenBase {

    public BiomeGenRopewaySkylands2(int id, int weight){
        super(id, weight);

        setBiomeName("Skyworld");
        setHeight(new Height(1.0f, 0.3f));
        topBlock = Blocks.grass.getDefaultState();
        fillerBlock = Blocks.dirt.getDefaultState();
    }
}
