package com.gigavoid.supermod.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import java.util.Random;

/**
 * Created by Rasmus on 2014-11-21.
 */
public class BlockIonCannon extends Block {
    public BlockIonCannon (){
        super(Material.rock);
        this.setHardness(1.0f);
        this.setHarvestLevel("axe", 0);
        this.setCreativeTab(CreativeTabs.tabBlock);
        this.setStepSound(soundTypeWood);
    }

    @Override
    public Item getItemDropped(IBlockState state, Random p_149650_2_, int p_149650_3_) {
        return Item.getItemFromBlock(this);
    }
}
