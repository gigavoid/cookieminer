package com.gigavoid.supermod.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockOldLeaf;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.IIcon;
import net.minecraft.world.ColorizerFoliage;
import net.minecraft.world.IBlockAccess;

public class NorthLeavesBlock extends BlockOldLeaf {

    IIcon icon;

    public NorthLeavesBlock(){
        super();
        this.setHardness(1.0f);
        this.setBlockTextureName("supermod:northLeaves");
        this.setCreativeTab(CreativeTabs.tabBlock);
        this.setBlockName("emeraldLeaves");
        this.setStepSound(soundTypeGrass);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public int getRenderColor(int p_149741_1_)
    {
        return Integer.MAX_VALUE;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public int colorMultiplier(IBlockAccess p_149720_1_, int p_149720_2_, int p_149720_3_, int p_149720_4_)
    {
        return Integer.MAX_VALUE;
    }


    @Override
    public IIcon getIcon(int p_149691_1_, int p_149691_2_) {
        return this.icon;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister p_149651_1_)
    {
        this.icon = p_149651_1_.registerIcon("supermod:northLeaves");
    }

    @Override
    public String[] func_150125_e() {
        return new String[] {"Emerald"};
    }

    @Override
    public boolean isOpaqueCube(){ return false;}
}
