package com.gigavoid.supermod.cookiecraft.block;

import com.gigavoid.supermod.cookiecraft.creativetab.CookiecraftCreativeTabs;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;

import java.util.Random;

public class BlockBurntCookieBlock extends Block {
    public BlockBurntCookieBlock() {
        super(Material.ground);
        this.setHardness(-1.0f);
        this.setCreativeTab(CookiecraftCreativeTabs.tabCookiecraft);
        this.setStepSound(soundTypeGravel);
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return Item.getItemFromBlock(this);
    }
}
