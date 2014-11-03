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
    private IIcon icon;

    public BlockEmeraldFlower() {
        super(0);
        this.setLightLevel(0.5f);
        this.setCreativeTab(CreativeTabs.tabDecorations);
        this.setBlockTextureName("supermod:flower_emerald");
        this.setBlockName("emeraldFlower");
        this.setTickRandomly(true);
    }

    @Override
    public void randomDisplayTick(World p_149734_1_, int p_149734_2_, int p_149734_3_, int p_149734_4_, Random p_149734_5_) {
        super.randomDisplayTick(p_149734_1_, p_149734_2_, p_149734_3_, p_149734_4_, p_149734_5_);
        p_149734_1_.spawnParticle("happyVillager", p_149734_2_ + 0.5, p_149734_3_ + 0.5, p_149734_4_ + 0.5, 0.0D, 0.0D, 0.0D);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int p_149691_1_, int p_149691_2_)
    {
        return this.icon;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister p_149651_1_)
    {
        this.icon = p_149651_1_.registerIcon("supermod:flower_emerald");
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item p_149666_1_, CreativeTabs p_149666_2_, List p_149666_3_)
    {
        p_149666_3_.add(new ItemStack(p_149666_1_, 1, 0));
    }
}
