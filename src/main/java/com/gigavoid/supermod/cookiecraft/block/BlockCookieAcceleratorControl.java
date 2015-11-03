package com.gigavoid.supermod.cookiecraft.block;

import com.gigavoid.supermod.cookiecraft.cookie.AcceleratorNetwork;
import com.gigavoid.supermod.cookiecraft.cookie.CookieBlock;
import com.gigavoid.supermod.cookiecraft.cookie.CookieNetwork;
import com.gigavoid.supermod.cookiecraft.creativetab.CookiecraftCreativeTabs;
import com.gigavoid.supermod.cookiecraft.tileentity.TileEntityCookieAccelerator;
import com.gigavoid.supermod.cookiecraft.util.CookieAcceleratorBlockPos;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.Random;

public class BlockCookieAcceleratorControl extends BlockCookieAcceleratorBase {
    public static final PropertyDirection FACING = PropertyDirection.create("facing");

    public BlockCookieAcceleratorControl() {
        super();
        setCreativeTab(CookiecraftCreativeTabs.tabCookiecraft);
        this.setDefaultState(this.blockState.getBaseState().withProperty(ACTIVE, false).withProperty(FACING, EnumFacing.NORTH));
    }

    @Override
    public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos) {
        return super.getActualState(state, worldIn, pos).withProperty(FACING, worldIn.getBlockState(pos).getValue(FACING));
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return Item.getItemFromBlock(this);
    }

    @Override
    protected BlockState createBlockState() {
        return new BlockState(this, ACTIVE, FACING);
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return ((EnumFacing)state.getValue(FACING)).getIndex();
    }

    @Override
    public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state) {
        super.onBlockAdded(worldIn, pos, state);
        this.setDefaultDirection(worldIn, pos, state);
    }

    private void setDefaultDirection(World worldIn, BlockPos pos, IBlockState state)
    {
        EnumFacing enumfacing = (EnumFacing)state.getValue(FACING);
        boolean flag = worldIn.getBlockState(pos.offset(EnumFacing.NORTH)).getBlock().isFullBlock();
        boolean flag1 = worldIn.getBlockState(pos.offset(EnumFacing.SOUTH)).getBlock().isFullBlock();

        if (enumfacing == EnumFacing.NORTH && flag && !flag1)
        {
            enumfacing = EnumFacing.SOUTH;
        }
        else if (enumfacing == EnumFacing.SOUTH && flag1 && !flag)
        {
            enumfacing = EnumFacing.NORTH;
        }
        else
        {
            boolean flag2 = worldIn.getBlockState(pos.offset(EnumFacing.WEST)).getBlock().isFullBlock();
            boolean flag3 = worldIn.getBlockState(pos.offset(EnumFacing.EAST)).getBlock().isFullBlock();

            if (enumfacing == EnumFacing.WEST && flag2 && !flag3)
            {
                enumfacing = EnumFacing.EAST;
            }
            else if (enumfacing == EnumFacing.EAST && flag3 && !flag2)
            {
                enumfacing = EnumFacing.WEST;
            }
        }

        worldIn.setBlockState(pos, state.withProperty(FACING, enumfacing), 2);
    }
}