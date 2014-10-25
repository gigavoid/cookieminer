package com.gigavoid.supermod.block;

import net.minecraft.block.BlockFlower;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.world.World;


import java.util.Random;

public class EmeraldFlowerBlock extends BlockFlower {
    public EmeraldFlowerBlock() {
        super(0);
        this.setLightLevel(0.5f);
        this.setCreativeTab(CreativeTabs.tabDecorations);
        this.setBlockName("emeraldFlower");
        this.setBlockTextureName("supermod:flower_emerald");
        this.setTickRandomly(true);
    }

    @Override
    public void randomDisplayTick(World p_149734_1_, int p_149734_2_, int p_149734_3_, int p_149734_4_, Random p_149734_5_) {
        super.randomDisplayTick(p_149734_1_, p_149734_2_, p_149734_3_, p_149734_4_, p_149734_5_);
        p_149734_1_.spawnParticle("happyVillager", p_149734_2_ + 0.5, p_149734_3_ + 0.5, p_149734_4_ + 0.5, 0.0D, 0.0D, 0.0D);
    }
}
