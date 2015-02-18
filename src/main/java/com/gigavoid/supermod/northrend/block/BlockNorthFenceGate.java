package com.gigavoid.supermod.northrend.block;

import net.minecraft.block.BlockFenceGate;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockState;
import net.minecraft.creativetab.CreativeTabs;

import javax.annotation.OverridingMethodsMustInvokeSuper;

public class BlockNorthFenceGate extends BlockFenceGate {
    public BlockNorthFenceGate(){
        super();
        this.setCreativeTab(CreativeTabs.tabRedstone);
    }

    @Override
    protected BlockState createBlockState()
    {
        return new BlockState(this, new IProperty[] {FACING, field_176466_a, field_176465_b, field_176467_M});
    }
}
