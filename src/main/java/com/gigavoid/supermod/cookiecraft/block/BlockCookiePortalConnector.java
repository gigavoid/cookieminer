package com.gigavoid.supermod.cookiecraft.block;

import com.gigavoid.supermod.cookiecraft.ModuleCookiecraft;
import com.gigavoid.supermod.cookiecraft.creativetab.CookiecraftCreativeTabs;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.Random;

public class BlockCookiePortalConnector extends BlockCookieGeneratorBase implements ICookieGenerator {
    public static final PropertyBool ACTIVE = PropertyBool.create("active");

    public static final BlockCookiePortalConnector instance = new BlockCookiePortalConnector();

    private BlockCookiePortalConnector(){
        super(Material.ROCK);
        setCreativeTab(CookiecraftCreativeTabs.tabCookiecraft);
        this.setDefaultState(this.blockState.getBaseState().withProperty(ACTIVE, false));
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return Item.getItemFromBlock(this);
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer (this, ACTIVE);
    }

    @Override
    public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos) {
        return state.withProperty(ACTIVE, isNextToPortal(worldIn, pos));
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return 0;
    }

    @Override
    public double getCPS(World world, BlockPos pos, IBlockState state) {
        if (isNextToPortal(world, pos)) {
            world.setBlockState(pos, state.withProperty(ACTIVE, true), 2);
            return ModuleCookiecraft.config.outputPortalConnector;
        }
        world.setBlockState(pos, blockState.getBaseState().withProperty(ACTIVE, false),2);
        return 0;
    }

    private boolean isNextToPortal(IBlockAccess world, BlockPos pos) {
        return isNextToOnePortal(world, pos.offset(EnumFacing.NORTH)) ||
                isNextToOnePortal(world, pos.offset(EnumFacing.EAST)) ||
                isNextToOnePortal(world, pos.offset(EnumFacing.SOUTH)) ||
                isNextToOnePortal(world, pos.offset(EnumFacing.WEST));
    }

    private boolean isNextToOnePortal(IBlockAccess world, BlockPos blockPos) {
        return world.getBlockState(blockPos).getBlock() == BlockCookiePortalCookiecraft.instance;
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
