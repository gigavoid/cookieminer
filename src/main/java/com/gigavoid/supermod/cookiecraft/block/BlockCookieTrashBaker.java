package com.gigavoid.supermod.cookiecraft.block;

import com.gigavoid.supermod.cookiecraft.creativetab.CookiecraftCreativeTabs;
import com.gigavoid.supermod.cookiecraft.gui.GuiCookieUpgrade;
import com.gigavoid.supermod.cookiecraft.tileentity.TileEntityCactusMasher;
import com.gigavoid.supermod.cookiecraft.tileentity.TileEntityTrashBaker;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

import java.util.Random;

public class BlockCookieTrashBaker extends BlockCookieUpgradeBase implements ICookieUpgrade, ITileEntityProvider {
    public static final PropertyDirection FACING = PropertyDirection.create("facing");

    protected BlockCookieTrashBaker() {
        super(Material.rock);
        setCreativeTab(CookiecraftCreativeTabs.tabCookiecraft);
        this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
    }

    @Override
    public int getMetaFromState(IBlockState state)
    {
        return ((EnumFacing)state.getValue(FACING)).getIndex();
    }

    @Override
    protected BlockState createBlockState() {
        return new BlockState(this, FACING);
    }

    @Override
    public IBlockState onBlockPlaced(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) {
        return this.getDefaultState().withProperty(FACING, placer.func_174811_aO().getOpposite());
    }


    /**
     * Copied from BlockDispenser
     */
    private void setDefaultDirection(World worldIn, BlockPos pos, IBlockState state)
    {
        if (!worldIn.isRemote)
        {
            EnumFacing enumfacing = (EnumFacing)state.getValue(FACING);
            boolean flag = worldIn.getBlockState(pos.offsetNorth()).getBlock().isFullBlock();
            boolean flag1 = worldIn.getBlockState(pos.offsetSouth()).getBlock().isFullBlock();

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
                boolean flag2 = worldIn.getBlockState(pos.offsetWest()).getBlock().isFullBlock();
                boolean flag3 = worldIn.getBlockState(pos.offsetEast()).getBlock().isFullBlock();

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

    @Override
    public double getCPS(World world, BlockPos pos, IBlockState state) {
        // No CPS at all, all cookies comes from converting items into cookies
        return 0;
    }

	@Override
	public int getGuiId() {
		return GuiCookieUpgrade.GUI_ID;
	}

	@Override
	public boolean hasImportantUI() {
		return false;
	}

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileEntityTrashBaker();
    }

    @Override
    public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state) {
        this.setDefaultDirection(worldIn, pos, state);
    }

    public TileEntityTrashBaker getTileEntity(World world, BlockPos pos) {
        return (TileEntityTrashBaker) world.getTileEntity(pos);
    }

}
