package com.gigavoid.supermod.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;

import java.util.Random;

/**
 * Created by Rasmus on 2014-11-21.
 */
public class BlockIonCannon extends Block {

    @SideOnly(Side.CLIENT)
    private IIcon IconFront;

    public BlockIonCannon (){
        super(Material.rock);
        this.setHardness(1.0f);
        this.setBlockTextureName("supermod:eLogSide");
        this.setHarvestLevel("axe", 0);
        this.setCreativeTab(CreativeTabs.tabBlock);
        this.setBlockName("emeraldLog");
        this.setStepSound(soundTypeWood);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int p_149691_1_, int p_149691_2_)
    {
        int k = p_149691_2_ & 12;
        if (k == 0 && (p_149691_1_ == 1 || p_149691_1_ == 0))
            return this.IconFront;
        else if (k == 4 && (p_149691_1_ == 5 || p_149691_1_ == 4))
            return this.IconFront;
        else if (k == 8 && (p_149691_1_ == 2 || p_149691_1_ == 3))
            return this.IconFront;
        else
            return this.blockIcon;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister par1IconRegister)
    {
        this.blockIcon = par1IconRegister.registerIcon("supermod:log_north");
        this.IconFront = par1IconRegister.registerIcon("supermod:log_north_top");
    }

    @Override
    public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
    {
        return Item.getItemFromBlock(this);
    }
}
