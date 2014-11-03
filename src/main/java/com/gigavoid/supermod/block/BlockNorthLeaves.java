package com.gigavoid.supermod.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockOldLeaf;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.IIcon;
import net.minecraft.world.ColorizerFoliage;
import net.minecraft.world.IBlockAccess;

public class BlockNorthLeaves extends BlockLeaves {

    IIcon icon;

    public BlockNorthLeaves(){
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
        return 0xFFFFFF;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public int colorMultiplier(IBlockAccess p_149720_1_, int p_149720_2_, int p_149720_3_, int p_149720_4_)
    {
        return 0xFFFFFF;
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

    @Override
    @SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(IBlockAccess p_149646_1_, int p_149646_2_, int p_149646_3_, int p_149646_4_, int p_149646_5_)
    {
        //Block block = p_149646_1_.getBlock(p_149646_2_, p_149646_3_, p_149646_4_);
        return true;
    }
}
