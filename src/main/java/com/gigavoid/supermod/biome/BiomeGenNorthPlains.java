package com.gigavoid.supermod.biome;

import com.gigavoid.supermod.decorator.NorthrendDecorator;
import com.gigavoid.supermod.decorator.SuperDecorator;
import com.gigavoid.supermod.entity.EntityYeti;
import com.gigavoid.supermod.worldgen.trees.SuperWorldGenIgloo;
import com.gigavoid.supermod.worldgen.trees.SuperWorldGenNorthrendTree;
import net.minecraft.block.Block;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

import java.util.Random;

/**
 * Created by Rasmus on 2014-11-03.
 */
public class BiomeGenNorthPlains extends SuperBiomeGenBaseNorthrend {

    public BiomeGenNorthPlains(int id){
        super(id);

        setBiomeName("Northrend Plains");
        setHeight(new BiomeGenBase.Height(.2f, .05f));
        topBlock = Block.getBlockFromName("snow").getDefaultState();
        fillerBlock = Block.getBlockFromName("snow").getDefaultState();
    }
}
