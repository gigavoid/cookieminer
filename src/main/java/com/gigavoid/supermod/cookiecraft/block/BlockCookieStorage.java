package com.gigavoid.supermod.cookiecraft.block;

import com.gigavoid.supermod.SuperMod;
import com.gigavoid.supermod.cookiecraft.creativetab.CookiecraftCreativeTabs;
import com.gigavoid.supermod.cookiecraft.gui.GuiCookieCrafter;
import com.gigavoid.supermod.cookiecraft.gui.GuiCookieStorage;
import com.gigavoid.supermod.cookiecraft.tileentity.TileEntityCookieStorage;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class BlockCookieStorage extends BlockCookieUpgradeBase implements ITileEntityProvider, ICookieStorage {
    public BlockCookieStorage(){
        super(Material.rock);
        setCreativeTab(CookiecraftCreativeTabs.tabCookiecraft);
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
        return 1000;
    }

    @Override
    public long getCurrentStorage(World world, BlockPos pos) {
        return getTileEntity(world, pos).getCookies();
    }

    @Override
    public void addCookies(World world, BlockPos pos, long numCookies) {
        getTileEntity(world, pos).addCookies(numCookies);
    }

	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ) {
		TileEntity tileEntity = worldIn.getTileEntity(pos);
		if (tileEntity == null || playerIn.isSneaking()) {
			return false;
		}

		playerIn.openGui(SuperMod.instance, GuiCookieStorage.GUI_ID, worldIn, pos.getX(), pos.getY(), pos.getZ());
		return true;
	}
}
