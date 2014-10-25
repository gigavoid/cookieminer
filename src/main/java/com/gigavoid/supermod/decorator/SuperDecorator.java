package com.gigavoid.supermod.decorator;

import net.minecraft.world.World;

import java.util.Random;

public class SuperDecorator {

    public static enum GenType {EMERALD_FOREST};

    public GenType gtype;

    public int emeraldFlowersPerChunk;
    public int emeraldBigTreesPerChunk;
    public int emeraldTreesPerChunk;

    public boolean treeHead[] = new boolean[7 * 7 * 3];

    public SuperDecorator(){
        setTreeHead();
    }

    public void decorate(World p_76728_1_, Random p_76728_2_, int p_76728_3_, int p_76728_4_)
    {
        boolean doGen = gtype == GenType.EMERALD_FOREST;
        if(doGen) {
            genDecorations(p_76728_1_, p_76728_2_, p_76728_3_, p_76728_4_);
        }
    }

    public void genDecorations(World p_76728_1_, Random p_76728_2_, int p_76728_3_, int p_76728_4_){}

    public void setTreeHead(){
        //FirstLayer
        treeHead[2] = treeHead[46] = true;
        treeHead[3] = treeHead[45] = true;
        treeHead[4] = treeHead[44] = true;
        treeHead[8] = treeHead[40] = true;
        treeHead[9] = treeHead[39] = true;
        treeHead[10] = treeHead[38] = true;
        treeHead[11] = treeHead[37] = true;
        treeHead[12] = treeHead[36] = true;

        for (int i = 14; i < 35; i++)
            treeHead[i] = true;

        //Second layer
        treeHead[59] = treeHead[87] = true;
        treeHead[65] = treeHead[81] = true;
        treeHead[66] = treeHead[80] = true;
        treeHead[67] = treeHead[79] = true;
        treeHead[71] = true;
        treeHead[72] = true;
        treeHead[73] = true;
        treeHead[74] = true;
        treeHead[75] = true;

        //Third layer
        treeHead[115] = treeHead[129] = true;
        treeHead[121] = true;
        treeHead[122] = true;
        treeHead[123] = true;
    }
}
