package com.gigavoid.supermod.worldgen.trees;

import com.gigavoid.supermod.block.SuperBlocks;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

import java.util.Random;

/**
 * Created by Rasmus on 2014-11-07.
 */
public class SuperWorldGenIgloo extends WorldGenAbstractTree {
    String structureIgloo;

    public SuperWorldGenIgloo(boolean b){
        super(b);
        initIgloo();
    }

    @Override
    public boolean generate(World p_76484_1_, Random p_76484_2_, int p_76484_3_, int p_76484_4_, int p_76484_5_) {
        genIgloo(p_76484_1_, p_76484_2_, p_76484_3_, p_76484_4_, p_76484_5_);
        return true;
    }

    private void genIgloo(World world, Random random, int x, int y, int z){
        if (.9999f < random.nextFloat()) {
            boolean canPlaceIgloo = true, invert, alignZ;
            int setI, setJ;
            invert = 0.5 < random.nextFloat();
            alignZ = 0.5 < random.nextFloat();
            Block block;
            for (int i = -3; i < 4; i++) {//x
                for (int j = -3; j < 5; j++) {//z
                    for (int k = -2; k < 4; k++) {//y
                        setI = i;
                        setJ = j;
                        if (alignZ) {
                            setI = j;
                            setJ = i;
                        }
                        setI = invert ? setI * -1 : setI;
                        setJ = invert ? setJ * -1 : setJ;
                        if (k == -2) {
                            if (world.getBlock(i + x, k + y, j + z) == Blocks.air) {
                                canPlaceIgloo = false;
                            }
                        } else if (canPlaceIgloo) {
                            block = world.getBlock(setI + x, k + y, setJ + z);
                            block = charToBlock(structureIgloo.charAt(7 * 8 * (k + 1) + 7 * (j + 3) + (i + 3)), block);
                            if (block != Blocks.bed && block != Blocks.beacon)
                                world.setBlock(setI + x, k + y, setJ + z, block);
                            else {
                                if (block == Blocks.beacon) {
                                    block = Blocks.bed;
                                    if (setI < 0)
                                        world.setBlock(setI + x, k + y, setJ + z, block, 9, 2);
                                    else if (setI > 0)
                                        world.setBlock(setI + x, k + y, setJ + z, block, 11, 2);
                                    else if (setJ < 0)
                                        world.setBlock(setI + x, k + y, setJ + z, block, 10, 2);
                                    else if (setJ > 0)
                                        world.setBlock(setI + x, k + y, setJ + z, block, 8, 2);
                                } else {
                                    if (setI < 0)
                                        world.setBlock(setI + x, k + y, setJ + z, block, 1, 2);
                                    else if (setI > 0)
                                        world.setBlock(setI + x, k + y, setJ + z, block, 3, 2);
                                    else if (setJ < 0)
                                        world.setBlock(setI + x, k + y, setJ + z, block, 2, 2);
                                    else if (setJ > 0)
                                        world.setBlock(setI + x, k + y, setJ + z, block, 0, 2);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private void initIgloo(){
        structureIgloo =
                "nnpspnn" +
                "nnpspnn" +
                "npssspn" +
                "psssssp" +
                "psssssp" +
                "psssssp" +
                "npssspn" +
                "nnpppnn" +

                "nnpapnn" +
                "nnpapnn" +
                "npaaapn" +
                "pbaaaap" +
                "paaaaap" +
                "paafacp" +
                "npahapn" +
                "nnpppnn" +

                "nnpapnn" +
                "nnpapnn" +
                "npaaapn" +
                "paaaaap" +
                "iaaaaai" +
                "paaaaap" +
                "npaaapn" +
                "nnpppnn" +

                "nnnpnnn" +
                "nnnpnnn" +
                "nnpppnn" +
                "npptppn" +
                "ppaaapp" +
                "nppappn" +
                "nnpppnn" +
                "nnnnnnn" +

                "nnnnnnn" +
                "nnnnnnn" +
                "nnnnnnn" +
                "nnnpnnn" +
                "nnpppnn" +
                "nnnpnnn" +
                "nnnnnnn" +
                "nnnnnnn";
    }

    private Block charToBlock(char c, Block block){
        switch(c) {
            default: return block;
            case 'n': return block;
            case 'p': return Blocks.packed_ice;
            case 's': return Blocks.snow;
            case 't': return Blocks.torch;
            case 'b': return Blocks.crafting_table;
            case 'c': return Blocks.chest;
            case 'i': return Blocks.ice;
            case 'f': return Blocks.bed;
            case 'h': return Blocks.beacon;
            case 'a': return Blocks.air;
        }
    }
}
