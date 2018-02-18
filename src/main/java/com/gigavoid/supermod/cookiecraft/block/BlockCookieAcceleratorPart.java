package com.gigavoid.supermod.cookiecraft.block;

import com.gigavoid.supermod.cookiecraft.creativetab.CookiecraftCreativeTabs;

import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;

import java.util.Random;

public class BlockCookieAcceleratorPart extends BlockCookieAcceleratorBase {
    public static final BlockCookieAcceleratorPart instance = new BlockCookieAcceleratorPart();

    private BlockCookieAcceleratorPart() {
        super();
        setCreativeTab(CookiecraftCreativeTabs.tabCookiecraft);
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return Item.getItemFromBlock(this);
    }
}
