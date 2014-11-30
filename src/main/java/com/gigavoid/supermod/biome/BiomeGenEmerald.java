package com.gigavoid.supermod.biome;

import com.gigavoid.supermod.decorator.SuperDecorator;
import com.gigavoid.supermod.decorator.SuperEmeraldDecorator;
import com.gigavoid.supermod.worldgen.trees.SuperWorldGenEmeraldTree;
import net.minecraft.block.Block;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Random;

public class BiomeGenEmerald extends BiomeGenBase {
    SuperWorldGenEmeraldTree treeGen = new SuperWorldGenEmeraldTree(true);
    SuperEmeraldDecorator decorator = new SuperEmeraldDecorator();

    public BiomeGenEmerald(int id){
        super(id);
        setBiomeName("Emerald Forest");
        setHeight(new BiomeGenBase.Height(0.0f, 0.2f));
        setColor(0x00FF00);
        waterColorMultiplier = 0x00FF00; //0x44FF44;
        topBlock = Block.getStateById(2);
        fillerBlock = Block.getStateById(3);
        temperature = 1.0f;
        rainfall = 0.6f;
        theBiomeDecorator.treesPerChunk = 10;
        decorator.gtype = SuperDecorator.GenType.EMERALD_FOREST;
        decorator.emeraldFlowersPerChunk = 1;
    }

    @Override
    public void func_180624_a(World p_76728_1_, Random p_76728_2_, BlockPos pos)
    {
        theBiomeDecorator.func_180292_a(p_76728_1_, p_76728_2_, this, pos);
        decorator.func_180292_a(p_76728_1_, p_76728_2_, this, pos);
    }

    @Override
    public WorldGenAbstractTree genBigTreeChance(Random r) {
        return treeGen;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public int getModdedBiomeGrassColor(int p_150558_1_)
    {
        return 0x00DD00;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public int getModdedBiomeFoliageColor(int p_150571_1_)
    {
        return 0x00DD00;
    }
}