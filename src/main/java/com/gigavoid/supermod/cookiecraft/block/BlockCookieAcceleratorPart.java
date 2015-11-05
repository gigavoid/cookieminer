package com.gigavoid.supermod.cookiecraft.block;

import com.gigavoid.supermod.cookiecraft.creativetab.CookiecraftCreativeTabs;
import com.gigavoid.supermod.cookiecraft.tileentity.TileEntityCookieAccelerator;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.util.BlockPos;
import net.minecraft.world.IBlockAccess;

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
