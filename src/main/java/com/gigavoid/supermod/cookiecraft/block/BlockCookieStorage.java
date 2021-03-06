package com.gigavoid.supermod.cookiecraft.block;

import com.gigavoid.supermod.cookiecraft.creativetab.CookiecraftCreativeTabs;
import com.gigavoid.supermod.cookiecraft.gui.GuiCookieStorage;
import com.gigavoid.supermod.cookiecraft.tileentity.TileEntityCookieStorage;
import com.google.common.collect.ImmutableMap;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.Random;

public class BlockCookieStorage extends BlockCookieNetworkBase implements ITileEntityProvider, ICookieStorageBlock {
	private final int transferSpeed;
	private long storageCap;

    public BlockCookieStorage(String name, long storageCap, int transferSpeed) {
		super(name, Material.ROCK);
		this.storageCap = storageCap;
		this.transferSpeed = transferSpeed;
		setCreativeTab(CookiecraftCreativeTabs.tabCookiecraft);
	}

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return Item.getItemFromBlock(this);
    }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileEntityCookieStorage();
    }

    public TileEntityCookieStorage getTileEntity(World world, BlockPos pos) {
        return (TileEntityCookieStorage) world.getTileEntity(pos);
    }

    @Override
    public long getStorageCap() {
        return storageCap;
    }

	@Override
    public long getCurrentStorage(World world, BlockPos pos) {
        return getTileEntity(world, pos).getCookies();
    }

    @Override
    public void addCookies(World world, BlockPos pos, long numCookies) {
        getTileEntity(world, pos).addCookies(numCookies);
		world.scheduleUpdate(pos, this, this.tickRate(world));
	}

	@Override
	public long getTransferSpeed() {
		return transferSpeed;
	}

	@Override
	public int getGuiId() {
		return GuiCookieStorage.GUI_ID;
	}

	@Override
	public int tickRate(World worldIn) {
		return 1;
	}

	@Override
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
		if (!worldIn.isRemote) {
			if (getTileEntity(worldIn, pos).tick()) {
				worldIn.scheduleUpdate(pos, this, this.tickRate(worldIn));
			}
		}
	}

	@Override
	public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state) {
		if (!worldIn.isRemote) {
			worldIn.scheduleUpdate(pos, this, this.tickRate(worldIn));
		}
	}

	@Override
	public boolean shouldSideBeRendered(IBlockAccess worldIn, BlockPos pos, EnumFacing side) {
		return false;
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}
}
