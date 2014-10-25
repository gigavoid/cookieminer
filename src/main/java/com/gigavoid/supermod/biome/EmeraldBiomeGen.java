package com.gigavoid.supermod.biome;

import com.gigavoid.supermod.decorator.SuperDecorator;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;

import java.util.Random;

public class EmeraldBiomeGen extends BiomeGenBase {

    SuperDecorator decorator = new SuperDecorator();

    public EmeraldBiomeGen(){
        super(40);


        setBiomeName("Emerald Forest");
        setHeight(new BiomeGenBase.Height(0.0f, 0.2f));
        waterColorMultiplier = 500000; //59000; //-27943653
        topBlock = Block.getBlockById(2);
        fillerBlock = Block.getBlockById(3);
        temperature = 1.0f;
        rainfall = 0.6f;
        decorator.emeraldFlowersPerChunk = 6;
        decorator.emeraldTreePerChunk = 4;
    }

    @Override
    public void decorate(World p_76728_1_, Random p_76728_2_, int p_76728_3_, int p_76728_4_)
    {
        decorator.decorate(p_76728_1_, p_76728_2_, p_76728_3_, p_76728_4_);
    }
}