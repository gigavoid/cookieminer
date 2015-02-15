package com.gigavoid.supermod.northrend.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import java.util.Random;

public class BlockBlight extends Block {
    public BlockBlight() {
        super(Material.ice);
        this.setHardness(2.0f);
        this.setHarvestLevel("pickaxe", 0);
        this.setCreativeTab(CreativeTabs.tabBlock);
        this.setStepSound(soundTypeSnow);
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return Item.getItemFromBlock(this);
    }
}
