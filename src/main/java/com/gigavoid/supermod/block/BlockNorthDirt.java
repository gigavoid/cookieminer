package com.gigavoid.supermod.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import java.util.Random;

/**
 * Created by Rasmus on 2014-11-06.
 */
public class BlockNorthDirt extends Block{
        public BlockNorthDirt(){
            super(Material.ice);
            this.setHardness(2.0f);
            this.setBlockTextureName("supermod:north_dirt");
            this.setHarvestLevel("pickaxe", 0);
            this.setCreativeTab(CreativeTabs.tabBlock);
            this.setBlockName("glacialIce");
            this.setStepSound(soundTypeSnow);
        }

        @Override
        public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
        {
            return Item.getItemFromBlock(this);
        }
}
