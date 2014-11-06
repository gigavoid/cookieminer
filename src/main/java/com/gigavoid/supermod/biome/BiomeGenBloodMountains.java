package com.gigavoid.supermod.biome;

import com.gigavoid.supermod.decorator.SuperDecorator;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.world.biome.BiomeGenBase;

/**
 * Created by Rasmus on 2014-11-06.
 */
public class BiomeGenBloodMountains extends BiomeGenBase {

    public BiomeGenBloodMountains(){
        super(45);
        setBiomeName("Emerald Forest");
        setHeight(new BiomeGenBase.Height(0.0f, 0.5f));
        setColor(0x00FF00);
        waterColorMultiplier = 0xFF0000; //0x44FF44;
        topBlock = Block.getBlockById(2);
        fillerBlock = Block.getBlockById(3);
        temperature = 1.0f;
        rainfall = 0.6f;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public int getBiomeGrassColor(int p_150558_1_, int p_150558_2_, int p_150558_3_)
    {
        return 0xAA0000;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public int getBiomeFoliageColor(int p_150571_1_, int p_150571_2_, int p_150571_3_)
    {
        return 0xAA0000;
    }
}
