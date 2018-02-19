package com.gigavoid.supermod.cookiecraft.block;

import com.gigavoid.supermod.cookiecraft.ModuleCookiecraft;
import com.gigavoid.supermod.cookiecraft.creativetab.CookiecraftCreativeTabs;
import com.gigavoid.supermod.cookiecraft.tileentity.TileEntityMoonlightReflector;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.List;
import java.util.Random;

public class BlockCookieMoonlightReflector extends BlockCookieGeneratorBase implements ICookieGenerator, ITileEntityProvider {
    public static final PropertyBool ACTIVE = PropertyBool.create("active");

    public static final BlockCookieMoonlightReflector instance = new BlockCookieMoonlightReflector();

    private BlockCookieMoonlightReflector() {
        super(Material.ROCK);
        setCreativeTab(CookiecraftCreativeTabs.tabCookiecraft);
        this.setDefaultState(this.blockState.getBaseState().withProperty(ACTIVE, false));
    }

    @Override
    public boolean isFullCube(IBlockState state) {
        return false;
    }

    @Override
    public boolean isPassable(IBlockAccess blockAccess, BlockPos pos) {
        return false;
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
        TileEntityMoonlightReflector te = (TileEntityMoonlightReflector)worldIn.getTileEntity(pos);
        return state.withProperty(ACTIVE, te.isActive());
    }

    @Override
    public void addCollisionBoxesToList(World worldIn, BlockPos pos, IBlockState state, AxisAlignedBB mask, List list, Entity collidingEntity) {
        this.setBlockBounds(.0F, .0F, .0F, 1.0F, 0.75F, 1.0F);
        super.addCollisionBoxesToList(worldIn, pos, state, mask, list, collidingEntity);
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return 0;
    }

    @Override
    public double getCPS(World world, BlockPos pos, IBlockState state) {
        if (getTileEntity(world, pos).isActive()) {
            return ModuleCookiecraft.config.outputMoonlightReflector;
        }
        return 0;
    }

    @Override
    public boolean shouldSideBeRendered(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side) {
        return true;
    }

    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    public boolean isVisuallyOpaque() { return false; }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileEntityMoonlightReflector();
    }

    public TileEntityMoonlightReflector getTileEntity(World world, BlockPos pos) {
        return (TileEntityMoonlightReflector) world.getTileEntity(pos);
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
