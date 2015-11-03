package com.gigavoid.supermod.cookiecraft.block;

import com.gigavoid.supermod.cookiecraft.cookie.AcceleratorNetwork;
import com.gigavoid.supermod.cookiecraft.cookie.CookieBlock;
import com.gigavoid.supermod.cookiecraft.cookie.CookieNetwork;
import com.gigavoid.supermod.cookiecraft.creativetab.CookiecraftCreativeTabs;
import com.gigavoid.supermod.cookiecraft.tileentity.TileEntityCookieAccelerator;
import com.gigavoid.supermod.cookiecraft.util.CookieAcceleratorBlockPos;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.Random;

public class BlockCookieAcceleratorControl extends BlockCookieAcceleratorBase {
    public static final PropertyDirection FACING = PropertyDirection.create("facing");

    public BlockCookieAcceleratorControl() {
        super();
        setCreativeTab(CookiecraftCreativeTabs.tabCookiecraft);
        this.setDefaultState(this.blockState.getBaseState().withProperty(ACTIVE, false).withProperty(FACING, EnumFacing.NORTH));
    }

    @Override
    public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos) {
        return super.getActualState(state, worldIn, pos).withProperty(FACING, worldIn.getBlockState(pos).getValue(FACING));
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return Item.getItemFromBlock(this);
    }

    @Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
        AcceleratorNetwork.getNetwork(worldIn, pos).updateNetwork();
    }

    @Override
    public IBlockState onBlockPlaced(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) {
        return this.getDefaultState().withProperty(FACING, placer.getHorizontalFacing().getOpposite());
    }

    @Override
    protected BlockState createBlockState() {
        return new BlockState(this, ACTIVE, FACING);
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return ((EnumFacing)state.getValue(FACING)).getIndex();
    }

    @Override
    public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state) {
        super.onBlockAdded(worldIn, pos, state);
        AcceleratorNetwork.getNetwork(worldIn, pos).updateNetwork();
        this.setDefaultDirection(worldIn, pos, state);
    }

    private void setDefaultDirection(World worldIn, BlockPos pos, IBlockState state)
    {
        if (!worldIn.isRemote)
        {
            EnumFacing enumfacing = (EnumFacing)state.getValue(FACING);
            boolean flag = worldIn.getBlockState(pos.offset(EnumFacing.NORTH)).getBlock().isFullBlock();
            boolean flag1 = worldIn.getBlockState(pos.offset(EnumFacing.SOUTH)).getBlock().isFullBlock();

            if (enumfacing == EnumFacing.NORTH && flag && !flag1)
            {
                enumfacing = EnumFacing.SOUTH;
            }
            else if (enumfacing == EnumFacing.SOUTH && flag1 && !flag)
            {
                enumfacing = EnumFacing.NORTH;
            }
            else
            {
                boolean flag2 = worldIn.getBlockState(pos.offset(EnumFacing.WEST)).getBlock().isFullBlock();
                boolean flag3 = worldIn.getBlockState(pos.offset(EnumFacing.EAST)).getBlock().isFullBlock();

                if (enumfacing == EnumFacing.WEST && flag2 && !flag3)
                {
                    enumfacing = EnumFacing.EAST;
                }
                else if (enumfacing == EnumFacing.EAST && flag3 && !flag2)
                {
                    enumfacing = EnumFacing.WEST;
                }
            }

            worldIn.setBlockState(pos, state.withProperty(FACING, enumfacing), 2);
        }
    }

    public void updateAcceleratorBlocks(World world, BlockPos pos){
        boolean built = isAcceleratorBuilt(world, pos);
        AcceleratorNetwork.getNetwork(world, pos).updateAcceleratorBlocks(built);
        CookieNetwork.getNetwork(world, pos).updateNetwork();
        System.out.println(built);
    }

    private boolean isAcceleratorBuilt(World world, BlockPos pos){
        boolean north = world.getBlockState(pos.offset(EnumFacing.NORTH)).getBlock() instanceof BlockCookieAcceleratorBase;
        boolean east = world.getBlockState(pos.offset(EnumFacing.EAST)).getBlock() instanceof BlockCookieAcceleratorBase;

        int length = 0;
        while (length < 64){
            if (north){
                if (world.getBlockState(pos.offset(EnumFacing.NORTH)).getBlock() instanceof BlockCookieAcceleratorBase) {
                    length++;
                }
                else
                    break;
            }
            else if (world.getBlockState(pos.offset(EnumFacing.SOUTH, length)).getBlock() instanceof BlockCookieAcceleratorBase) {
                length++;
            }
            else
                break;
        }

        if (length < 8){
            return false;
        }

        ArrayList<BlockPos> acceleratorBlocks = new ArrayList<BlockPos>();

        boolean outerConnected = true;
        for (int i = 0; i < length && outerConnected; i++){
            outerConnected = checkBlocksAtLength(world, new CookieAcceleratorBlockPos(pos), i, length, north, east, acceleratorBlocks);
        }


        for (BlockPos p : acceleratorBlocks){
            ((BlockCookieAcceleratorBase)world.getBlockState(p).getBlock()).setActive(world, p, outerConnected);
        }

        return outerConnected;
    }

    private boolean checkBlocksAtLength(IBlockAccess world, CookieAcceleratorBlockPos pos, int interval, int length, boolean north, boolean east, ArrayList<BlockPos> acceleratorBlocks){
        if (world.getBlockState(pos.offsetNorthSouth(interval, north)).getBlock() instanceof BlockCookieAcceleratorBase){
            acceleratorBlocks.add(pos.offsetNorthSouth(interval, north));
        }
        else
            return false;

        if (world.getBlockState(pos.offsetEastWest(interval, east)).getBlock() instanceof BlockCookieAcceleratorBase){
            acceleratorBlocks.add(pos.offsetEastWest(interval, east));
        }
        else
            return false;

        if (world.getBlockState(pos.offsetNorthSouth(interval, north).offsetEastWest(length - 1, east)).getBlock() instanceof BlockCookieAcceleratorBase) {
            acceleratorBlocks.add(pos.offsetNorthSouth(interval, north).offsetEastWest(length - 1, east));
        }
        else
            return false;
        if (world.getBlockState(pos.offsetEastWest(interval, east).offsetNorthSouth(length - 1, north)).getBlock() instanceof BlockCookieAcceleratorBase){
            acceleratorBlocks.add(pos.offsetEastWest(interval, east).offsetNorthSouth(length - 1, north));
        }
        else
            return false;
        return true;
    }
}