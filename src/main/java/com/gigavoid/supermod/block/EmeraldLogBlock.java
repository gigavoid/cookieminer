package com.gigavoid.supermod.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class EmeraldLogBlock extends Block {
    public EmeraldLogBlock(Material material){
        super(material);
        this.setHardness(1.0f);
        this.setBlockTextureName("supermod:eLogSide");
        this.setHarvestLevel("axe", 0);
        this.setCreativeTab(CreativeTabs.tabBlock);
        this.setBlockName("emeraldLog");
        this.setStepSound(soundTypeWood);
    }
}
