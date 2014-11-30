package com.gigavoid.supermod.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.world.World;

import java.util.Random;

public class BlockSaxeliumOre extends Block {
    public BlockSaxeliumOre(){
        super(Material.rock);
        this.setHardness(1.0f);

        this.setHarvestLevel("pickaxe", 4);
        this.setCreativeTab(CreativeTabs.tabBlock);
        this.setStepSound(soundTypeMetal);
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return Item.getItemFromBlock(this);
    }
}
