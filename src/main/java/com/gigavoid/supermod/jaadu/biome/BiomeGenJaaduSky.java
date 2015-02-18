package com.gigavoid.supermod.jaadu.biome;

import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeGenBase;

public class BiomeGenJaaduSky extends JaaduBiomeGenBase{
    public BiomeGenJaaduSky(int id){
    super(id);

    setBiomeName("Jaadu Biome");
    setHeight(new BiomeGenBase.Height(.0f, 3.0f));
    topBlock = Blocks.grass.getDefaultState();
    fillerBlock = Blocks.dirt.getDefaultState();
}
}
