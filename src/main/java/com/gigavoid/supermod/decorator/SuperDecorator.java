package com.gigavoid.supermod.decorator;

import net.minecraft.world.World;

import java.util.Random;

public class SuperDecorator {

    public static enum GenType {EMERALD_FOREST};

    GenType gtype;

    public int emeraldFlowersPerChunk;
    public int emeraldTreesPerChunk;
    public int emeraldTreeHeight;

    public SuperDecorator(){
    }

    public void decorate(World p_76728_1_, Random p_76728_2_, int p_76728_3_, int p_76728_4_)
    {
        boolean doGen = gtype == GenType.EMERALD_FOREST;
        if(doGen) {
            genDecorations(p_76728_1_, p_76728_2_, p_76728_3_, p_76728_4_);
        }
    }

    public void genDecorations(World p_76728_1_, Random p_76728_2_, int p_76728_3_, int p_76728_4_){

    }
}
