package com.gigavoid.supermod.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockLeaves;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.IIcon;

public class BlockEmeraldLeaves extends BlockLeaves {

    IIcon icon;

    public BlockEmeraldLeaves(){
        super();
        this.setHardness(1.0f);
        this.setBlockTextureName("leaves_jungle");
        this.setCreativeTab(CreativeTabs.tabBlock);
        this.setBlockName("emeraldLeaves");
        this.setStepSound(soundTypeGrass);
    }

    @Override
    public IIcon getIcon(int p_149691_1_, int p_149691_2_) {
        return icon;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister p_149651_1_)
    {
        this.icon = p_149651_1_.registerIcon("leaves_jungle");
    }

    @Override
    public String[] func_150125_e() {
        return new String[] {"Emerald"};
    }

    @Override
    public boolean isOpaqueCube(){ return false;}
}
