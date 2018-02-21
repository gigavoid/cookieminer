package com.gigavoid.supermod.cookiecraft.block;

import com.gigavoid.supermod.cookiecraft.creativetab.CookiecraftCreativeTabs;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;

import java.util.Random;

public class BlockCookieBurntCookieBlock extends CookieBlockBase {
    public BlockCookieBurntCookieBlock(String name) {
        super(name, Material.GROUND);
        this.setHardness(-1.0f);
        this.setCreativeTab(CookiecraftCreativeTabs.tabCookiecraft);
        this.setSoundType(SoundType.GROUND);
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return Item.getItemFromBlock(this);
    }
}
