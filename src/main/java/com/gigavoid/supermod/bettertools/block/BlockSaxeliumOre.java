package com.gigavoid.supermod.bettertools.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import java.util.Random;

/**
 * Created by Lukas on 2015-02-18.
 */
public class BlockSaxeliumOre extends Block {
    protected BlockSaxeliumOre() {
        super(Material.rock);
        this.setHardness(1.0f);

        this.setHarvestLevel("pickaxe", 4);
        this.setCreativeTab(CreativeTabs.tabBlock);
    }

    public Item getItemDropped(IBlockState state, Random rand, int fortune){
        return Item.getItemFromBlock(this);
    }
}