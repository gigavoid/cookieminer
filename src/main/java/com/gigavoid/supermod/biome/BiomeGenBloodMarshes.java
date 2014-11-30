package com.gigavoid.supermod.biome;

import com.gigavoid.supermod.worldgen.trees.SuperWorldGenBloodTree;
import net.minecraft.block.Block;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Random;

/**
 * Created by Rasmus on 2014-11-06.
 */
public class BiomeGenBloodMarshes extends BiomeGenBase {
    SuperWorldGenBloodTree treeGen = new SuperWorldGenBloodTree(true);

    public BiomeGenBloodMarshes(int id){
        super(id);
        setBiomeName("Blood Marshes");
        setHeight(new BiomeGenBase.Height(-0.1f, 0.01f));
        setColor(0x00FF00);
        waterColorMultiplier = 0xFF0000; //0x44FF44;
        topBlock = Block.getStateById(2);
        fillerBlock = Block.getStateById(3);
        temperature = 1.0f;
        rainfall = 0.6f;
        theBiomeDecorator.treesPerChunk = 4;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public int getModdedBiomeGrassColor(int p_150558_1_)
    {
        return 0xAA0000;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public int getModdedBiomeFoliageColor(int p_150571_1_)
    {
        return 0xAA0000;
    }

    @Override
    public WorldGenAbstractTree genBigTreeChance(Random r) {
        return treeGen;
    }
}
