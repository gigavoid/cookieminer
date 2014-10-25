package com.gigavoid.supermod.biome;

import com.gigavoid.supermod.block.SuperBlocks;
import com.gigavoid.supermod.worldgen.SuperWorldGenTrees;
import net.minecraft.block.Block;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

import java.util.Random;

public class EmeraldBiomeGen extends BiomeGenBase {

    SuperWorldGenTrees wgt;

    public EmeraldBiomeGen(){
        super(40);

        wgt = new SuperWorldGenTrees(false, 30, 3, false);

        setBiomeName("Emerald Forest");
        setHeight(new BiomeGenBase.Height(0.0f, 0.2f));
        waterColorMultiplier = 500000; //59000; //-27943653
        topBlock = Block.getBlockById(2);
        fillerBlock = Block.getBlockById(3);
        temperature = 1.0f;
        rainfall = 0.6f;
        theBiomeDecorator.treesPerChunk = 12;
    }

    @Override
    public WorldGenAbstractTree func_150567_a(Random p_150567_1_)
    {
        return (WorldGenAbstractTree)this.wgt;
    }
}
