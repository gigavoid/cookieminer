package com.gigavoid.supermod.cookiecraft.block;

import com.gigavoid.supermod.cookiecraft.creativetab.CookiecraftCreativeTabs;
import com.gigavoid.supermod.cookiecraft.gui.GuiCookieGenerator;
import com.gigavoid.supermod.cookiecraft.tileentity.TileEntityTrashBaker;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

public class BlockCookieTrashBaker extends BlockCookieGeneratorBase implements ICookieGenerator, ITileEntityProvider {
    public static final BlockCookieTrashBaker instance = new BlockCookieTrashBaker();

    private BlockCookieTrashBaker() {
        super(Material.rock);
        setCreativeTab(CookiecraftCreativeTabs.tabCookiecraft);
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return Item.getItemFromBlock(this);
    }

    @Override
    public double getCPS(World world, BlockPos pos, IBlockState state) {
        // No CPS at all, all cookies comes from converting items into cookies
        return 0;
    }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileEntityTrashBaker();
    }


    public TileEntityTrashBaker getTileEntity(World world, BlockPos pos) {
        return (TileEntityTrashBaker) world.getTileEntity(pos);
    }

}
