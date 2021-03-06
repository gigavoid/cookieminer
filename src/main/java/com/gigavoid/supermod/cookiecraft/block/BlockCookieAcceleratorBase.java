package com.gigavoid.supermod.cookiecraft.block;

import com.gigavoid.supermod.cookiecraft.ModuleCookiecraft;
import com.gigavoid.supermod.cookiecraft.cookie.AcceleratorNetwork;
import com.gigavoid.supermod.cookiecraft.gui.GuiCookieGenerator;
import com.gigavoid.supermod.cookiecraft.tileentity.TileEntityCookieAccelerator;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.List;

public class BlockCookieAcceleratorBase extends BlockCookieGeneratorBase implements ICookieGenerator,ITileEntityProvider {
    public static final PropertyBool ACTIVE = PropertyBool.create("active");

    protected BlockCookieAcceleratorBase(String name) {
        super(name, Material.ROCK);
        this.setDefaultState(this.blockState.getBaseState().withProperty(ACTIVE, false));
    }

    @Override
    public double getCPS(World world, BlockPos pos, IBlockState state) {
        TileEntityCookieAccelerator tileEntity = (TileEntityCookieAccelerator) getTileEntity(world, pos);
        return tileEntity.isActive() ? ModuleCookiecraft.config.outputCookieAccelerator : 0;
    }

    public void setActive(World world, BlockPos pos, boolean active){
        ((TileEntityCookieAccelerator)getTileEntity(world, pos)).setIsActive(active);
    }


    @Override
    public boolean shouldSideBeRendered(IBlockAccess worldIn, BlockPos pos, EnumFacing side) {
        return false;
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
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
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileEntityCookieAccelerator();
    }

    public TileEntityCookieAccelerator getTileEntity(IBlockAccess world, BlockPos pos) {
        return (TileEntityCookieAccelerator)world.getTileEntity(pos);
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, ACTIVE);
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
