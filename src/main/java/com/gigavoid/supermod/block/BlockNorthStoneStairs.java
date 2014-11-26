package com.gigavoid.supermod.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.IIcon;

/**
 * Created by Rasmus on 2014-11-23.
 */
public class BlockNorthStoneStairs extends BlockStairs {
    private Block parentNorthBlock;
    private int meta;

    protected BlockNorthStoneStairs(int p_i45428_2_)
    {
        super(SuperBlocks.northCobble, p_i45428_2_);
        parentNorthBlock = SuperBlocks.northCobble;
        meta = p_i45428_2_;
        this.setHardness(.75f);
        this.setResistance(2.0f);
        this.setStepSound(SuperBlocks.northCobble.stepSound);
        this.setLightOpacity(255);
        this.setCreativeTab(CreativeTabs.tabBlock);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int p_149691_1_, int p_149691_2_)
    {
        return parentNorthBlock.getIcon(p_149691_1_, 0);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister p_149651_1_) {}
}
