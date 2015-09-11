package com.gigavoid.supermod.cookiecraft.block;

import com.gigavoid.supermod.cookiecraft.cookie.CookieNetwork;
import com.gigavoid.supermod.cookiecraft.creativetab.CookiecraftCreativeTabs;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.Random;

public class BlockCookieAcceleratorControl extends BlockCookieAcceleratorBase {
    public static final PropertyDirection FACING = PropertyDirection.create("facing");

    public BlockCookieAcceleratorControl() {
        super();
        setCreativeTab(CookiecraftCreativeTabs.tabCookiecraft);
        this.setDefaultState(this.blockState.getBaseState().withProperty(ACTIVE, false).withProperty(FACING, EnumFacing.NORTH));
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return Item.getItemFromBlock(this);
    }

    @Override
    public IBlockState onBlockPlaced(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) {
        return this.getDefaultState().withProperty(FACING, placer.func_174811_aO().getOpposite());
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
        this.setDefaultDirection(worldIn, pos, state);
    }

    private void setDefaultDirection(World worldIn, BlockPos pos, IBlockState state)
    {
        if (!worldIn.isRemote)
        {
            EnumFacing enumfacing = (EnumFacing)state.getValue(FACING);
            boolean flag = worldIn.getBlockState(pos.offsetNorth()).getBlock().isFullBlock();
            boolean flag1 = worldIn.getBlockState(pos.offsetSouth()).getBlock().isFullBlock();

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
                boolean flag2 = worldIn.getBlockState(pos.offsetWest()).getBlock().isFullBlock();
                boolean flag3 = worldIn.getBlockState(pos.offsetEast()).getBlock().isFullBlock();

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
        if (!world.isRemote) {
            boolean built = isAcceleratorBuilt(world, pos);
            CookieNetwork.getNetwork(world, pos).updateAcceleratorBlocks(built);
            System.out.println(built);
        }
    }

    private boolean isAcceleratorBuilt(IBlockAccess world, BlockPos pos){
        boolean north = world.getBlockState(pos.offsetNorth()).getBlock() instanceof BlockCookieAcceleratorBase;
        boolean east = world.getBlockState(pos.offsetEast()).getBlock() instanceof BlockCookieAcceleratorBase;

        int length = 0;
        while (length < 64){
            if (north){
                if (world.getBlockState(pos.offsetNorth(length)).getBlock() instanceof BlockCookieAcceleratorBase) {
                    length++;
                }
                else
                    break;
            }
            else if (world.getBlockState(pos.offsetSouth(length)).getBlock() instanceof BlockCookieAcceleratorBase) {
                length++;
            }
            else
                break;
        }

        if (length < 8){
            return false;
        }

        boolean outerConnected = true;
        for (int i = 0; i < length && outerConnected; i++){
            if (north && east){
                if (!(world.getBlockState(pos.offsetNorth(i)).getBlock() instanceof BlockCookieAcceleratorBase)){
                    outerConnected = false;
                }
                if (!(world.getBlockState(pos.offsetEast(i)).getBlock() instanceof BlockCookieAcceleratorBase)){
                    outerConnected = false;
                }
                if (!(world.getBlockState(pos.offsetNorth(i).offsetEast(length - 1)).getBlock() instanceof BlockCookieAcceleratorBase)){
                    outerConnected = false;
                }
                if (!(world.getBlockState(pos.offsetEast(i).offsetNorth(length - 1)).getBlock() instanceof BlockCookieAcceleratorBase)){
                    outerConnected = false;
                }
            }
            if (north && !east){
                if (!(world.getBlockState(pos.offsetNorth(i)).getBlock() instanceof BlockCookieAcceleratorBase)){
                    outerConnected = false;
                }
                if (!(world.getBlockState(pos.offsetWest(i)).getBlock() instanceof BlockCookieAcceleratorBase)){
                    outerConnected = false;
                }
                if (!(world.getBlockState(pos.offsetNorth(i).offsetWest(length - 1)).getBlock() instanceof BlockCookieAcceleratorBase)){
                    outerConnected = false;
                }
                if (!(world.getBlockState(pos.offsetWest(i).offsetNorth(length - 1)).getBlock() instanceof BlockCookieAcceleratorBase)){
                    outerConnected = false;
                }
            }
            if (!north && east){
                if (!(world.getBlockState(pos.offsetSouth(i)).getBlock() instanceof BlockCookieAcceleratorBase)){
                    outerConnected = false;
                }
                if (!(world.getBlockState(pos.offsetEast(i)).getBlock() instanceof BlockCookieAcceleratorBase)){
                    outerConnected = false;
                }
                if (!(world.getBlockState(pos.offsetSouth(i).offsetEast(length - 1)).getBlock() instanceof BlockCookieAcceleratorBase)){
                    outerConnected = false;
                }
                if (!(world.getBlockState(pos.offsetEast(i).offsetSouth(length - 1)).getBlock() instanceof BlockCookieAcceleratorBase)){
                    outerConnected = false;
                }
            }
            if (!north && !east){
                if (!(world.getBlockState(pos.offsetSouth(i)).getBlock() instanceof BlockCookieAcceleratorBase)){
                    outerConnected = false;
                }
                if (!(world.getBlockState(pos.offsetWest(i)).getBlock() instanceof BlockCookieAcceleratorBase)){
                    outerConnected = false;
                }
                if (!(world.getBlockState(pos.offsetSouth(i).offsetWest(length - 1)).getBlock() instanceof BlockCookieAcceleratorBase)){
                    outerConnected = false;
                }
                if (!(world.getBlockState(pos.offsetWest(i).offsetSouth(length - 1)).getBlock() instanceof BlockCookieAcceleratorBase)){
                    outerConnected = false;
                }
            }
        }

        return outerConnected;
    }
}


