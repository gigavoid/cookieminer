package com.gigavoid.supermod.northrend.block;

import com.gigavoid.supermod.northrend.creativetab.NorthrendCreativeTabs;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.Random;

public class BlockNorthSlab extends BlockSlab {


    protected BlockNorthSlab(int p_i45428_2_)
    {
        super(Material.wood);
        this.setHardness(.75f);
        this.setResistance(2.0f);
        this.setStepSound(NorthrendBlocks.northPlanks.stepSound);
        this.setLightOpacity(255);
        this.setCreativeTab(NorthrendCreativeTabs.tabNorthrend);
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return Item.getItemFromBlock(this);
    }

    @Override
    public Object func_176553_a(ItemStack p_176553_1_) {
        return null;
    }

    @Override
    public IProperty func_176551_l() {
        return null;
    }

    @Override
    public boolean isDouble() {
        return false;
    }

    @Override
    public String getFullSlabName(int p_150002_1_) {
        return "north slab";
    }
}
