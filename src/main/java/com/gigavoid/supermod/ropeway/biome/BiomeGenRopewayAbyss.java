package com.gigavoid.supermod.ropeway.biome;

import net.minecraft.init.Blocks;

public class BiomeGenRopewayAbyss extends RopewayBiomeGenBase {

    public BiomeGenRopewayAbyss(int id, int weight){
        super(id, weight);

        setBiomeName("Abyss");
        setHeight(new Height(1.0f, 0.3f));
        topBlock = Blocks.grass.getDefaultState();
        fillerBlock = Blocks.dirt.getDefaultState();
    }
}
