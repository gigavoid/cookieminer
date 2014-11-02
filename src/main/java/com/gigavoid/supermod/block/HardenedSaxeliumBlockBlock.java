package com.gigavoid.supermod.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class HardenedSaxeliumBlockBlock extends Block {

    protected HardenedSaxeliumBlockBlock() {
        super(Material.rock);
        this.setBlockName("saxeliumBlock");
        this.setStepSound(soundTypeStone);
        this.setHardness(10f);
        this.setBlockTextureName("supermod:dairBlock");
        this.setCreativeTab(CreativeTabs.tabBlock);
    }
}
