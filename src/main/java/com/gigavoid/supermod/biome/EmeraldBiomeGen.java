package com.gigavoid.supermod.biome;

import com.gigavoid.supermod.decorator.SuperDecorator;
import com.gigavoid.supermod.decorator.SuperEmeraldDecorator;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.biome.BiomeGenBase;

import java.util.Random;

public class EmeraldBiomeGen extends BiomeGenBase {

    public EmeraldBiomeGen(){
        super(40);


        setBiomeName("Emerald Forest");
        setHeight(new BiomeGenBase.Height(0.0f, 0.2f));
        setColor(0x00FF00);
        waterColorMultiplier = 0x44FF44;
        topBlock = Block.getBlockById(2);
        fillerBlock = Block.getBlockById(3);
        temperature = 1.0f;
        rainfall = 0.6f;
        /*decorator.gtype = SuperDecorator.GenType.EMERALD_FOREST;
        decorator.emeraldFlowersPerChunk = 2;
        decorator.emeraldBigTreesPerChunk = 1;
        decorator.emeraldTreesPerChunk = 5;*/
    }

    @Override
    public void decorate(World p_76728_1_, Random p_76728_2_, int p_76728_3_, int p_76728_4_)
    {
        theBiomeDecorator.decorateChunk(p_76728_1_, p_76728_2_, this, p_76728_3_, p_76728_4_);
        //decorator.decorate(p_76728_1_, p_76728_2_, p_76728_3_, p_76728_4_);
    }
}