package com.gigavoid.supermod.bonus.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.world.IBlockAccess;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by SnuRRaN on 2015-02-14.
 */
public class BlockBonus extends Block {
    public BlockBonus() {
        super(Material.rock);
        this.setHardness(20.0f);
        this.setHarvestLevel("pickaxe", 3);
        this.setCreativeTab(CreativeTabs.tabBlock);
        this.setStepSound(soundTypeStone);
    }

    @Override
    public List<ItemStack> getDrops(IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {
        List<ItemStack> bonusItems=new ArrayList<ItemStack>();
        bonusItems.add(new ItemStack(Blocks.diamond_block));
        bonusItems.add(new ItemStack(Blocks.lapis_block,5));
        bonusItems.add(new ItemStack (Items.redstone,64));
        return bonusItems;
    }
}

