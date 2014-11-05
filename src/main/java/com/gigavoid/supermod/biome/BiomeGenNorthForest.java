package com.gigavoid.supermod.biome;

import com.gigavoid.supermod.decorator.NorthrendDecorator;
import com.gigavoid.supermod.decorator.SuperDecorator;
import com.gigavoid.supermod.decorator.SuperEmeraldDecorator;
import com.gigavoid.supermod.worldgen.trees.SuperWorldGenNorthrendTree;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

import java.util.Random;

public class BiomeGenNorthForest extends BiomeGenBase {
    SuperWorldGenNorthrendTree treeGen = new SuperWorldGenNorthrendTree(true);
    NorthrendDecorator decorator = new NorthrendDecorator();

    public BiomeGenNorthForest(){
        super(41);

        theBiomeDecorator.treesPerChunk = 14;
        setBiomeName("Northrend Forest");
        setHeight(new Height(0.1f, 0.1f));
        waterColorMultiplier = 0xFFFFFF;
        decorator.gtype = SuperDecorator.GenType.NORTHREND;
        topBlock = Block.getBlockFromName("snow");
        fillerBlock = Block.getBlockById(3);
        temperature = 0.0f;
        rainfall = 1.0f;
    }

    @Override
    public void decorate(World p_76728_1_, Random p_76728_2_, int p_76728_3_, int p_76728_4_)
    {
        decorator.decorateChunk(p_76728_1_, p_76728_2_, this, p_76728_3_, p_76728_4_);
    }

    @Override
    public WorldGenAbstractTree func_150567_a(Random r) {
        return treeGen;
    }
}