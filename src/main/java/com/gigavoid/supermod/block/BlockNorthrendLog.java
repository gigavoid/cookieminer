package com.gigavoid.supermod.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockLog;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import java.util.Random;

/**
 * Created by Rasmus on 2014-10-26.
 */
public class BlockNorthrendLog extends BlockLog {

    @SideOnly(Side.CLIENT)
    private IIcon eLogIconTop;

    public BlockNorthrendLog(){
        super();
        this.setHardness(1.0f);
        this.setBlockTextureName("supermod:log_north");
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
        this.blockIcon = par1IconRegister.registerIcon("supermod:log_north");
        this.eLogIconTop = par1IconRegister.registerIcon("supermod:log_north_top");
    }

    @Override
    public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
    {
        return Item.getItemFromBlock(this);
    }

    @Override
    public boolean canPlaceTorchOnTop(World world, int x, int y, int z) {
        return true;
    }
}
