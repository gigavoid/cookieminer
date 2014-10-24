package com.gigavoid.supermod.block;

import net.minecraft.block.BlockFlower;
import net.minecraft.creativetab.CreativeTabs;

public class EmeraldFlowerBlock extends BlockFlower {
    public EmeraldFlowerBlock(){
        super(0);
        this.setLightLevel(1.0f);
        this.setCreativeTab(CreativeTabs.tabDecorations);
        this.setBlockName("emeraldFlower");
    }
}
