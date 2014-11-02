package com.gigavoid.supermod.biome;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;

import java.util.Random;

public class NorthForestBiomeGen extends BiomeGenBase {

    public NorthForestBiomeGen(){
        super(41);


        setBiomeName("Northrend Forest");
        setHeight(new Height(0.1f, 0.2f));
        waterColorMultiplier = 0xFFFFFF;
        topBlock = Block.getBlockFromName("snow");
        fillerBlock = Block.getBlockById(3);
        temperature = 0.0f;
        rainfall = 1.0f;
    }

    @Override
    public void decorate(World p_76728_1_, Random p_76728_2_, int p_76728_3_, int p_76728_4_)
    {
        //decorator.decorate(p_76728_1_, p_76728_2_, p_76728_3_, p_76728_4_);
}
}