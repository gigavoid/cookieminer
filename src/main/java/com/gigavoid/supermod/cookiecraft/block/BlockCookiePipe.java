package com.gigavoid.supermod.cookiecraft.block;

import com.gigavoid.supermod.cookiecraft.creativetab.CookiecraftCreativeTabs;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

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
