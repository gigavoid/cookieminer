package com.gigavoid.supermod.cookiecraft.block;

import com.gigavoid.supermod.cookiecraft.creativetab.CookiecraftCreativeTabs;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.List;

public class BlockCookiePipe extends Block implements ICookieBlock {
    public static final PropertyBool NORTH = PropertyBool.create("north");
    public static final PropertyBool SOUTH = PropertyBool.create("south");
    public static final PropertyBool EAST = PropertyBool.create("east");
    public static final PropertyBool WEST = PropertyBool.create("west");
    public static final PropertyBool UP = PropertyBool.create("up");
    public static final PropertyBool DOWN = PropertyBool.create("down");

    public BlockCookiePipe(){
        super(Material.iron);
        this.setCreativeTab(CookiecraftCreativeTabs.tabCookiecraft);
    }

    public void addCollisionBoxesToList(World worldIn, BlockPos pos, IBlockState state, AxisAlignedBB mask, List list, Entity collidingEntity)
    {
        boolean north = this.isNeighborACookieBlock(worldIn, pos, EnumFacing.NORTH);
        boolean south = this.isNeighborACookieBlock(worldIn, pos, EnumFacing.SOUTH);
        boolean west = this.isNeighborACookieBlock(worldIn, pos, EnumFacing.WEST);
        boolean east = this.isNeighborACookieBlock(worldIn, pos, EnumFacing.EAST);
        boolean up = this.isNeighborACookieBlock(worldIn, pos, EnumFacing.UP);
        boolean down = this.isNeighborACookieBlock(worldIn, pos, EnumFacing.DOWN);
        float xMin = 0.3125F;
        float xMax = 0.6875F;
        float zMin = 0.3125F;
        float zMax = 0.6875F;
        float yMin = 0.3125F;
        float yMax = 0.6875F;

        if (down)
        {
            yMin = 0.0F;
        }

        if (up)
        {
            yMax = 1.0F;
        }

        if (down || up)
        {
            this.setBlockBounds(xMin, yMin, zMin, xMax, yMax, zMax);
            super.addCollisionBoxesToList(worldIn, pos, state, mask, list, collidingEntity);
        }

        yMin = 0.3125F;
        yMax = 0.6875F;

        if (north)
        {
            zMin = 0.0F;
        }
        if (south)
        {
            zMax = 1.0F;
        }

        if (west || east || !down && !up)
        {
            this.setBlockBounds(xMin, yMin, zMin, xMax, yMax, zMax);
            super.addCollisionBoxesToList(worldIn, pos, state, mask, list, collidingEntity);
        }

        zMin = 0.3125F;
        zMax = 0.6875F;

        if (west)
        {
            xMin = 0.0F;
        }
        if (east)
        {
            xMax = 1.0F;
        }

        if (west || east || !down && !up || !north && !south)
        {
            this.setBlockBounds(xMin, yMin, zMin, xMax, yMax, zMax);
            super.addCollisionBoxesToList(worldIn, pos, state, mask, list, collidingEntity);
        }

        if (north)
        {
            zMin = 0.0F;
        }

        if (south)
        {
            zMax = 1.0F;
        }
        if (down)
        {
            yMin = 0.0F;
        }
        if (up)
        {
            yMax = 1.0F;
        }

        this.setBlockBounds(xMin, yMin, zMin, xMax, yMax, zMax);
    }

    public void setBlockBoundsBasedOnState(IBlockAccess access, BlockPos pos)
    {
        boolean north = this.isNeighborACookieBlock(access, pos, EnumFacing.NORTH);
        boolean south = this.isNeighborACookieBlock(access, pos, EnumFacing.SOUTH);
        boolean west = this.isNeighborACookieBlock(access, pos, EnumFacing.WEST);
        boolean east = this.isNeighborACookieBlock(access, pos, EnumFacing.EAST);
        boolean up = this.isNeighborACookieBlock(access, pos, EnumFacing.UP);
        boolean down = this.isNeighborACookieBlock(access, pos, EnumFacing.DOWN);
        float xMin = 0.3125F;
        float xMax = 0.6875F;
        float zMin = 0.3125F;
        float zMax = 0.6875F;
        float yMin = 0.3125F;
        float yMax = 0.6875F;

        if (north)
        {
            zMin = 0.0F;
        }

        if (south)
        {
            zMax = 1.0F;
        }

        if (west)
        {
            xMin = 0.0F;
        }

        if (east)
        {
            xMax = 1.0F;
        }
        if (down)
        {
            yMin = 0.0F;
        }
        if (up)
        {
            yMax = 1.0F;
        }

        this.setBlockBounds(xMin, yMin, zMin, xMax, yMax, zMax);
    }

    @Override
    protected BlockState createBlockState() {
        return new BlockState(this, NORTH, SOUTH, EAST, WEST, UP, DOWN);
    }

    @Override
    public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos) {
        return state.withProperty(NORTH, isNeighborACookieBlock(worldIn, pos, EnumFacing.NORTH))
                .withProperty(SOUTH, isNeighborACookieBlock(worldIn, pos, EnumFacing.SOUTH))
                .withProperty(EAST, isNeighborACookieBlock(worldIn, pos, EnumFacing.EAST))
                .withProperty(WEST, isNeighborACookieBlock(worldIn, pos, EnumFacing.WEST))
                .withProperty(UP, isNeighborACookieBlock(worldIn, pos, EnumFacing.UP))
                .withProperty(DOWN, isNeighborACookieBlock(worldIn, pos, EnumFacing.DOWN));
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return 0;
    }

    @Override
    public boolean shouldSideBeRendered(IBlockAccess worldIn, BlockPos pos, EnumFacing side) {
        return true;
    }

    @Override
    public boolean isVisuallyOpaque() { return false; }

    @Override
    public boolean isOpaqueCube() { return false; }

    private boolean isNeighborACookieBlock(IBlockAccess world, BlockPos pos, EnumFacing facing){
        return world.getBlockState(pos.offset(facing)).getBlock() instanceof ICookieBlock;
    }
}
