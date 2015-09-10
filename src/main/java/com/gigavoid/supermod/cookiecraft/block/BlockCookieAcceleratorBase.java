package com.gigavoid.supermod.cookiecraft.block;

import com.gigavoid.supermod.cookiecraft.cookie.CookieBlock;
import com.gigavoid.supermod.cookiecraft.cookie.CookieNetwork;
import com.gigavoid.supermod.cookiecraft.gui.GuiCookieUpgrade;
import com.gigavoid.supermod.cookiecraft.tileentity.TileEntityCookieAccelerator;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockCookieAcceleratorBase extends BlockCookieUpgradeBase implements ICookieUpgrade,ITileEntityProvider {
    protected BlockCookieAcceleratorBase() {
        super(Material.rock);
    }

    @Override
    public double getCPS(World world, BlockPos pos, IBlockState state) {
        return 0;
    }

	@Override
	public int getGuiId() {
		return GuiCookieUpgrade.GUI_ID;
	}

    public void setActive(IBlockAccess world, BlockPos pos, boolean active){
        TileEntityCookieAccelerator tileEntity = getTileEntity(world, pos);
        tileEntity.setIsActive(active);
    }

    @Override
    public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state) {
        if (!worldIn.isRemote) {
            CookieBlock controlBlock = CookieNetwork.getNetwork(worldIn, pos).findAcceleratorControl();
            if (controlBlock != null) {
                ((BlockCookieAcceleratorControl) worldIn.getBlockState(controlBlock.getPos()).getBlock()).updateAcceleratorBlocks(worldIn, controlBlock.getPos());
            }
        }
    }

    @Override
	public boolean hasImportantUI() {
		return false;
	}

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileEntityCookieAccelerator();
    }

    public TileEntityCookieAccelerator getTileEntity(IBlockAccess world, BlockPos pos) {
        return (TileEntityCookieAccelerator)world.getTileEntity(pos);
    }
}
