package com.gigavoid.supermod.northrend.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import java.util.Random;

/**
 * Created by Rasmus on 2014-11-23.
 */
public class BlockNorthStoneStairs extends BlockStairs {
    private Block parentNorthBlock;
    private int meta;

    protected BlockNorthStoneStairs(int p_i45428_2_)
    {
        super(NorthrendBlocks.northCobble.getDefaultState());
        parentNorthBlock = NorthrendBlocks.northCobble;
        meta = p_i45428_2_;
        this.setHardness(.75f);
        this.setResistance(2.0f);
        this.setStepSound(NorthrendBlocks.northCobble.stepSound);
        this.setLightOpacity(255);
        this.setCreativeTab(CreativeTabs.tabBlock);
    }

    @Override
    public Item getItemDropped(IBlockState state, Random p_149650_2_, int p_149650_3_) {
        return Item.getItemFromBlock(this);
    }
}
