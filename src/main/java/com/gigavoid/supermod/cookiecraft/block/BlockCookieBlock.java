package com.gigavoid.supermod.cookiecraft.block;

import com.gigavoid.supermod.cookiecraft.creativetab.CookiecraftCreativeTabs;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;

import java.util.Random;

public class BlockCookieBlock extends CookieBlockBase {
    public BlockCookieBlock(String name) {
        super(name, Material.GROUND);
        this.setHardness(2.0f);
        this.setHarvestLevel("pickaxe", 0);
        this.setCreativeTab(CookiecraftCreativeTabs.tabCookiecraft);
        this.setSoundType(SoundType.GROUND);
    }
    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return Item.getItemFromBlock(this);
    }
}