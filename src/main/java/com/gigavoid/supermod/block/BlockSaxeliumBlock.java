package com.gigavoid.supermod.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockSaxeliumBlock extends Block {

    protected BlockSaxeliumBlock() {
        super(Material.rock);
        this.setBlockName("saxeliumBlock");
        this.setStepSound(soundTypeStone);
        this.setHardness(2.5f);
        this.setBlockTextureName("supermod:dairBlock");
        this.setCreativeTab(CreativeTabs.tabBlock);
    }
}