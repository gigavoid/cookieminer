package com.gigavoid.supermod.decorator;

import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.biome.BiomeGenBase;

import java.util.Random;

public class SuperDecorator extends BiomeDecorator {

    public static enum GenType {EMERALD_FOREST, NORTHREND};

    public GenType gtype;

    public int emeraldFlowersPerChunk;

    public SuperDecorator(){ }

    @Override
    public void decorateChunk(World p_76728_1_, Random p_76728_2_, BiomeGenBase bgb, int p_76728_3_, int p_76728_4_)
    {
        if (gtype == GenType.EMERALD_FOREST)
            genDecorations(p_76728_1_, p_76728_2_, p_76728_3_, p_76728_4_);
        else if (gtype == GenType.NORTHREND)
            genDecorations(bgb);
    }

    public void genDecorations(World p_76728_1_, Random p_76728_2_, int p_76728_3_, int p_76728_4_){}

    public void genDecorations(BiomeGenBase p_150513_1_){}
}
