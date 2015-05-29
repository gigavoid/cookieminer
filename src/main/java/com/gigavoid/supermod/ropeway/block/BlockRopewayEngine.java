package com.gigavoid.supermod.ropeway.block;

import com.gigavoid.supermod.ropeway.creativetab.RopewayCreativeTabs;
import com.gigavoid.supermod.ropeway.tileentity.TileEntityRopewayEngine;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.Vec3i;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.awt.*;

public class BlockRopewayEngine extends Block implements ITileEntityProvider {
    public static final PropertyDirection rotation = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);

    protected BlockRopewayEngine() {
        super(Material.rock);
        this.setCreativeTab(RopewayCreativeTabs.tabBlock);
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public boolean isVisuallyOpaque() {
        return false;
    }

    @Override
    public boolean canReplace(World worldIn, BlockPos pos, EnumFacing side, ItemStack stack) {
        return canPlaceBlockOnSide(worldIn, pos, side);
    }

    @Override
    public boolean isTranslucent() {
        return super.isTranslucent();
    }

    @Override
    public int getRenderType() {
        return -1;
    }

    @Override
    public boolean canPlaceBlockOnSide(World world, BlockPos pos, EnumFacing side) {
        return placeOnSide(world, pos, side, new Vec3i(0, 0, 1), EnumFacing.NORTH) ||
               placeOnSide(world, pos, side, new Vec3i(0, 0, -1), EnumFacing.SOUTH) ||
               placeOnSide(world, pos, side, new Vec3i(1, 0, 0), EnumFacing.WEST) ||
               placeOnSide(world, pos, side, new Vec3i(-1, 0, 0), EnumFacing.EAST);
    }

    private boolean placeOnSide(World world, BlockPos pos, EnumFacing side, Vec3i diff, EnumFacing direction) {
        return side == direction && world.isSideSolid(pos.add(diff), direction) && world.getBlockState(pos.add(diff)).getBlock() == RopewayBlocks.pylon;
    }

    @Override
    protected BlockState createBlockState() {
        return new BlockState(this, rotation);
    }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileEntityRopewayEngine();
    }

    @Override
    public void onNeighborBlockChange(World worldIn, BlockPos pos, IBlockState state, Block neighborBlock) {
        super.onNeighborBlockChange(worldIn, pos, state, neighborBlock);

        EnumFacing direction = (EnumFacing) state.getValue(rotation);

        switch (direction) {
            case NORTH:
                popIfNoPylon(worldIn, pos, pos.offsetSouth());
                break;
            case EAST:
                popIfNoPylon(worldIn, pos, pos.offsetWest());
                break;
            case SOUTH:
                popIfNoPylon(worldIn, pos, pos.offsetNorth());
                break;
            case WEST:
                popIfNoPylon(worldIn, pos, pos.offsetEast());
                break;
        }
    }

    private void popIfNoPylon(World worldIn,BlockPos engine, BlockPos pylon) {
        if(worldIn.getBlockState(pylon).getBlock() != RopewayBlocks.pylon)
            worldIn.destroyBlock(engine, true);
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return ((EnumFacing)state.getValue(rotation)).getIndex();
    }

    @Override
    public IBlockState onBlockPlaced(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) {
        return this.getDefaultState().withProperty(rotation, facing);
    }
}
