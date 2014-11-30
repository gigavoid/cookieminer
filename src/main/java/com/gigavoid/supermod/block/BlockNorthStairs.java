package com.gigavoid.supermod.block;

import net.minecraft.block.BlockStairs;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import java.util.Random;

/**
 * Created by Rasmus on 2014-11-23.
 */
public class BlockNorthStairs extends BlockStairs {


    protected BlockNorthStairs(int p_i45428_2_)
    {
        super(SuperBlocks.northPlanks.getDefaultState());
        this.setHardness(.75f);
        this.setResistance(2.0f);
        this.setStepSound(SuperBlocks.northPlanks.stepSound);
        this.setLightOpacity(255);
        this.setCreativeTab(CreativeTabs.tabBlock);
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return Item.getItemFromBlock(this);
    }
}
