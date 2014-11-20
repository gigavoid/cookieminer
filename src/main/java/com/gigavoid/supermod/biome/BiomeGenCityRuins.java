package com.gigavoid.supermod.biome;

import com.gigavoid.supermod.block.SuperBlocks;
import com.gigavoid.supermod.decorator.CityDecorator;
import com.gigavoid.supermod.decorator.SuperDecorator;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

import java.util.Random;

/**
 * Created by Rasmus on 2014-11-19.
 */
public class BiomeGenCityRuins extends  BiomeGenBase {
    CityDecorator decorator = new CityDecorator();

    public BiomeGenCityRuins(){
        super(46);
        setBiomeName("Old City");
        setHeight(new BiomeGenBase.Height(-0.1f, .0f));
        setColor(0x00FF00);
        waterColorMultiplier = 0x888888; //0x44FF44;
        topBlock = Block.getBlockById(2);
        fillerBlock = Block.getBlockById(3);
        temperature = 1.0f;
        rainfall = 0.6f;
        decorator.gtype = SuperDecorator.GenType.CITY;
        decorator.corner = SuperBlocks.cityPillarBlock;
        decorator.lamp = SuperBlocks.cityLampBlock;
        decorator.wall = SuperBlocks.cityBlock;
        decorator.commonTreasure = SuperBlocks.cityInactivePowercoreBlock;
        decorator.uncommonTreasure = SuperBlocks.cityActivePowercoreBlock;
        decorator.window = Blocks.glass_pane;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public int getBiomeGrassColor(int p_150558_1_, int p_150558_2_, int p_150558_3_)
    {
        return 0x888D88;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public int getBiomeFoliageColor(int p_150571_1_, int p_150571_2_, int p_150571_3_) {
        return 0x888D88;
    }

    @Override
    public void decorate(World p_76728_1_, Random p_76728_2_, int p_76728_3_, int p_76728_4_)
    {
        theBiomeDecorator.decorateChunk(p_76728_1_, p_76728_2_, this, p_76728_3_, p_76728_4_);
        decorator.decorateChunk(p_76728_1_, p_76728_2_, this, p_76728_3_, p_76728_4_);
    }
}