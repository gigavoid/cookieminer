package com.gigavoid.supermod.biome;

import com.gigavoid.supermod.decorator.NorthrendDecorator;
import com.gigavoid.supermod.decorator.SuperDecorator;
import com.gigavoid.supermod.entity.EntityYeti;
import net.minecraft.block.Block;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;

import java.util.Random;

/**
 * Created by Rasmus on 2014-11-03.
 */
public class BiomeGenNorthMountains extends SuperBiomeGenBaseNorthrend {

    public BiomeGenNorthMountains(int id){
        super(id);

        setBiomeName("Northrend Mountains");
        setHeight(new BiomeGenBase.Height(1.5f, .6f));
        topBlock = Block.getBlockFromName("snow");
        fillerBlock = Block.getBlockFromName("snow");
    }
}
