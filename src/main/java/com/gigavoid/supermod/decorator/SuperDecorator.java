package com.gigavoid.supermod.decorator;

import net.minecraft.util.BlockPos;
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
    public void func_180292_a(World p_76728_1_, Random p_76728_2_, BiomeGenBase bgb, BlockPos pos)
    {
        if (gtype == GenType.EMERALD_FOREST)
            genDecorations(p_76728_1_, p_76728_2_, pos);
        else if (gtype == GenType.NORTHREND)
            genDecorations(bgb);
    }

    public void genDecorations(World p_76728_1_, Random p_76728_2_, BlockPos pos){}

    public void genDecorations(BiomeGenBase p_150513_1_){}
}
