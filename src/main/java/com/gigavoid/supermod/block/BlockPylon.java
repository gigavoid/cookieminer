package com.gigavoid.supermod.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

/**
 * Created by ineentho on 2014-11-03.
 */
public class BlockPylon extends Block {
    protected BlockPylon() {
        super(Material.wood);
        this.setCreativeTab(CreativeTabs.tabDecorations);
        this.setBlockTextureName("supermod:pylon");
        this.setBlockName("pylon");
    }
}
