package com.gigavoid.supermod.decorator;

import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeDecorator;

import java.util.Random;

public class SuperDecorator extends BiomeDecorator {

    public static enum GenType {EMERALD_FOREST, NORTHREND_FOREST, NORTHREND_MOUNTAINS, NORTHREND_GLACIER};

    public GenType gtype;

    public int emeraldFlowersPerChunk;

    public SuperDecorator(){ }

    public void decorate(World p_76728_1_, Random p_76728_2_, int p_76728_3_, int p_76728_4_)
    {
            genDecorations(p_76728_1_, p_76728_2_, p_76728_3_, p_76728_4_);
    }

    public void genDecorations(World p_76728_1_, Random p_76728_2_, int p_76728_3_, int p_76728_4_){}
}
