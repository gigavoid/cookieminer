package com.gigavoid.supermod.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockFlower;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;


import java.util.List;
import java.util.Random;

public class BlockEmeraldFlower extends BlockFlower {
    public BlockEmeraldFlower() {
        super();
        this.setLightLevel(0.5f);
        this.setCreativeTab(CreativeTabs.tabDecorations);
        this.setTickRandomly(true);
    }

    @Override
    public void updateTick(World p_149734_1_, int p_149734_2_, int p_149734_3_, int p_149734_4_, Random p_149734_5_) {
        super.randomDisplayTick(p_149734_1_, p_149734_2_, p_149734_3_, p_149734_4_, p_149734_5_);
        double d0 = (double)p_149734_5_.nextFloat() - .5f;
        double d1 = (double)p_149734_5_.nextFloat() - .5f;
        double d2 = (double)p_149734_5_.nextFloat() - .5f;
        p_149734_1_.spawnParticle("happyVillager", p_149734_2_ + 0.5, p_149734_3_ + 0.5, p_149734_4_ + 0.5, d0, d1, d2);
    }
}
