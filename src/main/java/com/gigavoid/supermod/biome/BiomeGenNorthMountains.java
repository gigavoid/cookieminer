package com.gigavoid.supermod.biome;

import com.gigavoid.supermod.decorator.NorthrendDecorator;
import com.gigavoid.supermod.decorator.SuperDecorator;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;

import java.util.Random;

/**
 * Created by Rasmus on 2014-11-03.
 */
public class BiomeGenNorthMountains extends BiomeGenBase {
    NorthrendDecorator decorator = new NorthrendDecorator();

    public BiomeGenNorthMountains(){
        super(42);

        setBiomeName("Northrend Mountains");
        setHeight(new BiomeGenBase.Height(2.5f, .7f));
        waterColorMultiplier = 0xFFFFFF;
        decorator.gtype = SuperDecorator.GenType.NORTHREND;
        topBlock = Block.getBlockFromName("snow");
        fillerBlock = Block.getBlockFromName("snow");
        temperature = 0.0f;
        rainfall = 1.0f;
    }

    @Override
    public void decorate(World p_76728_1_, Random p_76728_2_, int p_76728_3_, int p_76728_4_)
    {
        decorator.decorateChunk(p_76728_1_, p_76728_2_, this, p_76728_3_, p_76728_4_);
    }
}
