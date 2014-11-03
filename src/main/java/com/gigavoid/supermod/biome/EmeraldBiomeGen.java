package com.gigavoid.supermod.biome;

import com.gigavoid.supermod.decorator.SuperDecorator;
import com.gigavoid.supermod.decorator.SuperEmeraldDecorator;
import com.gigavoid.supermod.worldgen.trees.SuperWorldGenEmeraldTree;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.util.MathHelper;
import net.minecraft.world.ColorizerFoliage;
import net.minecraft.world.ColorizerGrass;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

import java.awt.*;
import java.util.Random;

public class EmeraldBiomeGen extends BiomeGenBase {
    SuperWorldGenEmeraldTree treeGen = new SuperWorldGenEmeraldTree(true);
    SuperEmeraldDecorator decorator = new SuperEmeraldDecorator();

    public EmeraldBiomeGen(){
        super(40);


        setBiomeName("Emerald Forest");
        setHeight(new BiomeGenBase.Height(0.0f, 0.2f));
        setColor(0x00FF00);
        waterColorMultiplier = 0x00FF00; //0x44FF44;
        topBlock = Block.getBlockById(2);
        fillerBlock = Block.getBlockById(3);
        temperature = 1.0f;
        rainfall = 0.6f;
        decorator.gtype = SuperDecorator.GenType.EMERALD_FOREST;
        decorator.emeraldFlowersPerChunk = 2;
    }

    @Override
    public void decorate(World p_76728_1_, Random p_76728_2_, int p_76728_3_, int p_76728_4_)
    {
        theBiomeDecorator.decorateChunk(p_76728_1_, p_76728_2_, this, p_76728_3_, p_76728_4_);
        decorator.decorate(p_76728_1_, p_76728_2_, p_76728_3_, p_76728_4_);
    }

    @Override
    public WorldGenAbstractTree func_150567_a(Random r) {
        return treeGen;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public int getBiomeGrassColor(int p_150558_1_, int p_150558_2_, int p_150558_3_)
    {
        return 0x00DD00;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public int getBiomeFoliageColor(int p_150571_1_, int p_150571_2_, int p_150571_3_)
    {
        return 0x00DD00;
    }
}