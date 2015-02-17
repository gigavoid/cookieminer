package com.gigavoid.supermod.northrend.block;

import net.minecraft.block.BlockLog;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import java.util.Random;

public class BlockNorthLog extends BlockLog {
    public BlockNorthLog(){
        super();
        this.setHardness(1.0f);
        this.setHarvestLevel("axe", 0);
        this.setCreativeTab(CreativeTabs.tabBlock);
        this.setStepSound(soundTypeWood);
    }

    @Override
    public Item getItemDropped(IBlockState state, Random p_149650_2_, int p_149650_3_) {
        return Item.getItemFromBlock(this);
    }

    @Override
    public int getMetaFromState(IBlockState state)
    {
        switch ((EnumAxis)state.getValue(AXIS_PROP))
        {
            case X:
                return 1;
            case Y:
                return 2;
            case Z:
                return 3;
            default:
                return 0;
        }
    }

    @Override
    protected BlockState createBlockState()
    {
        return new BlockState(this, AXIS_PROP);
    }
}
