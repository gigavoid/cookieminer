package com.gigavoid.supermod.worldgen.trees;

import com.gigavoid.supermod.block.SuperBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
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
    public boolean generate(World p_76484_1_, Random p_76484_2_, BlockPos pos) {
        genIgloo(p_76484_1_, p_76484_2_, pos);
        return true;
    }

    private void genIgloo(World world, Random random, BlockPos pos){
        if (.9999f < random.nextFloat()) {
            boolean canPlaceIgloo = true, invert, alignZ;
            int setI, setJ;
            invert = 0.5 < random.nextFloat();
            alignZ = 0.5 < random.nextFloat();
            IBlockState block;
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
                            if (world.getBlockState(pos.add(i, k, j)) == Blocks.air) {
                                canPlaceIgloo = false;
                            }
                        } else if (canPlaceIgloo) {
                            block = world.getBlockState(pos.add(setI, k, setJ));
                            block = charToBlock(structureIgloo.charAt(7 * 8 * (k + 1) + 7 * (j + 3) + (i + 3)), block);
                            if (block != Blocks.bed && block != Blocks.beacon)
                                world.setBlockState(pos.add(setI, k, setJ), block);
                            else {
                                if (block == Blocks.beacon) {
                                    block = Blocks.bed.getDefaultState();
                                    if (setI < 0)
                                        world.setBlockState(pos.add(setI, k, setJ), block, 9);
                                    else if (setI > 0)
                                        world.setBlockState(pos.add(setI, k, setJ), block, 11);
                                    else if (setJ < 0)
                                        world.setBlockState(pos.add(setI, k, setJ), block, 10);
                                    else if (setJ > 0)
                                        world.setBlockState(pos.add(setI, k, setJ), block, 8);
                                } else {
                                    if (setI < 0)
                                        world.setBlockState(pos.add(setI, k, setJ), block, 1);
                                    else if (setI > 0)
                                        world.setBlockState(pos.add(setI, k, setJ), block, 3);
                                    else if (setJ < 0)
                                        world.setBlockState(pos.add(setI, k, setJ), block, 2);
                                    else if (setJ > 0)
                                        world.setBlockState(pos.add(setI, k, setJ), block, 0);
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

    private IBlockState charToBlock(char c, IBlockState block){
        switch(c) {
            default: return block;
            case 'n': return block;
            case 'p': return Blocks.packed_ice.getDefaultState();
            case 's': return Blocks.snow.getDefaultState();
            case 't': return Blocks.torch.getDefaultState();
            case 'b': return Blocks.crafting_table.getDefaultState();
            case 'c': return Blocks.chest.getDefaultState();
            case 'i': return Blocks.ice.getDefaultState();
            case 'f': return Blocks.bed.getDefaultState();
            case 'h': return Blocks.beacon.getDefaultState();
            case 'a': return Blocks.air.getDefaultState();
        }
    }
}
