package com.gigavoid.supermod.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class SaxeliumBlockBlock extends Block {

    protected SaxeliumBlockBlock() {
        super(Material.rock);
        this.setBlockName("saxeliumBlock");
        this.setStepSound(soundTypeStone);
        this.setHardness(2.5f);
        this.setBlockTextureName("supermod:HardSaxBlock");
        this.setCreativeTab(CreativeTabs.tabBlock);
    }
}