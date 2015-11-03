package com.gigavoid.supermod.cookiecraft.block;

import com.gigavoid.supermod.cookiecraft.cookie.CookieBlock;
import com.gigavoid.supermod.cookiecraft.cookie.CookieNetwork;
import com.gigavoid.supermod.cookiecraft.gui.GuiCookieUpgrade;
import com.gigavoid.supermod.cookiecraft.tileentity.TileEntityCookieAccelerator;
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
        TileEntityCookieAccelerator tileEntity = getTileEntity(world, pos);
        tileEntity.setIsActive(active);
        world.getBlockState(pos);
        System.out.println("Set active" + active);
//        world.setBlockState(pos, world.getBlockState(pos).withProperty(ACTIVE, active));
    }

    @Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
        super.onBlockPlacedBy(worldIn, pos, state, placer, stack);
        checkAcceleratorMultiblock(worldIn, pos);
    }

    @Override
    public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state) {
        checkAcceleratorMultiblock(worldIn, pos);
    }

    private void checkAcceleratorMultiblock(World worldIn, BlockPos pos) {
        CookieBlock controlBlock = CookieNetwork.getNetwork(worldIn, pos).findAcceleratorControl();
        if (controlBlock != null) {
            ((BlockCookieAcceleratorControl) worldIn.getBlockState(controlBlock.getPos()).getBlock()).updateAcceleratorBlocks(worldIn, controlBlock.getPos());
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
