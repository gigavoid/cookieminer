package com.gigavoid.supermod.cookiecraft.block;

import com.gigavoid.supermod.cookiecraft.cookie.AcceleratorNetwork;
import com.gigavoid.supermod.cookiecraft.cookie.CookieBlock;
import com.gigavoid.supermod.cookiecraft.cookie.CookieNetwork;
import com.gigavoid.supermod.cookiecraft.gui.GuiCookieUpgrade;
import com.gigavoid.supermod.cookiecraft.tileentity.TileEntityCookieAccelerator;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.List;

public class BlockCookieAcceleratorBase extends BlockCookieUpgradeBase implements ICookieUpgrade,ITileEntityProvider {
    public static final PropertyBool ACTIVE = PropertyBool.create("active");

    protected BlockCookieAcceleratorBase() {
        super(Material.rock);
        this.setDefaultState(this.blockState.getBaseState().withProperty(ACTIVE, false));
    }

    @Override
    public double getCPS(World world, BlockPos pos, IBlockState state) {
        TileEntityCookieAccelerator tileEntity = getTileEntity(world, pos);
        return tileEntity.isActive() ? 1 : 0;
    }

	@Override
	public int getGuiId() {
		return GuiCookieUpgrade.GUI_ID;
	}

    public void setActive(World world, BlockPos pos, boolean active){
        getTileEntity(world, pos).setIsActive(active);
    }


    @Override
    public void onNeighborBlockChange(World worldIn, BlockPos pos, IBlockState state, Block neighborBlock) {
        super.onNeighborBlockChange(worldIn, pos, state, neighborBlock);
        System.out.println("neigh change");
        AcceleratorNetwork.getNetwork(worldIn, pos).updateNetwork();
    }

    @Override
    public void onBlockDestroyedByPlayer(World worldIn, BlockPos pos, IBlockState state) {
        List<AcceleratorNetwork> neighborNetworks = AcceleratorNetwork.getNeighborNetworks(worldIn, pos);
        for (AcceleratorNetwork network: neighborNetworks) {
            network.updateNetwork();
        }
    }

    @Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
        super.onBlockPlacedBy(worldIn, pos, state, placer, stack);
        AcceleratorNetwork.getNetwork(worldIn, pos).updateNetwork();
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

    @Override
    protected BlockState createBlockState() {
        return new BlockState(this, ACTIVE);
    }

    @Override
    public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos) {
        return state.withProperty(ACTIVE, ((TileEntityCookieAccelerator)worldIn.getTileEntity(pos)).isActive());
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return 0;
    }
}
