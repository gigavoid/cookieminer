package com.gigavoid.supermod.northrend.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

public class BlockBlight extends Block {
    public BlockBlight() {
        super(Material.ground);
        this.setHardness(2.0f);
        this.setHarvestLevel("pickaxe", 0);
        this.setCreativeTab(CreativeTabs.tabBlock);
        this.setStepSound(soundTypeCloth);
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return Item.getItemFromBlock(this);
    }
}
