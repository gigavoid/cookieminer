package com.gigavoid.supermod.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLog;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.IIcon;

public class EmeraldLogBlock extends BlockLog {

    @SideOnly(Side.CLIENT)
    private IIcon eLogIconTop;

    public EmeraldLogBlock(){
        super();
        this.setHardness(1.0f);
        this.setBlockTextureName("supermod:eLogSide");
        this.setHarvestLevel("axe", 0);
        this.setCreativeTab(CreativeTabs.tabBlock);
        this.setBlockName("emeraldLog");
        this.setStepSound(soundTypeWood);
    }

    @Override
    public IIcon getIcon(int par1, int par2)
    {
        return par1 == 1 ? this.eLogIconTop : (par1 == 0 ? this.eLogIconTop : this.blockIcon);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister par1IconRegister)
    {
        this.blockIcon = par1IconRegister.registerIcon("supermod:eLogSide");
        this.eLogIconTop = par1IconRegister.registerIcon("supermod:eLogBT");
    }
}
