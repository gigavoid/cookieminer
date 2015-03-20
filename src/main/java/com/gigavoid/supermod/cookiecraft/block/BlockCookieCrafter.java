package com.gigavoid.supermod.cookiecraft.block;

import com.gigavoid.supermod.cookiecraft.creativetab.CookiecraftCreativeTabs;
import com.gigavoid.supermod.cookiecraft.tileentity.TileEntityCookieCrafter;
import net.minecraft.block.Block;
import net.minecraft.block.BlockPistonBase;
import net.minecraft.block.BlockSourceImpl;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.dispenser.BehaviorDefaultDispenseItem;
import net.minecraft.dispenser.IBehaviorDispenseItem;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityDispenser;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.RegistryDefaulted;
import net.minecraft.world.World;

import java.util.Random;

public class BlockCookieCrafter extends Block implements ITileEntityProvider {
    public static final PropertyDirection FACING = PropertyDirection.create("facing");
    public static final RegistryDefaulted dispenseBehaviorRegistry = new RegistryDefaulted(new BehaviorDefaultDispenseItem());


    public BlockCookieCrafter() {
        super(Material.rock);
        setCreativeTab(CookiecraftCreativeTabs.tabCookiecraft);
        this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
    }

    @Override
    public IBlockState onBlockPlaced(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) {
        return this.getDefaultState().withProperty(FACING, placer.func_174811_aO().getOpposite());
    }

    /**
     * Copied from BlockDispenser
     */
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

    @Override
    public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state) {
        if (!worldIn.isRemote) {
            worldIn.scheduleUpdate(pos, this, this.tickRate(worldIn));
        }
        this.setDefaultDirection(worldIn, pos, state);
    }

    @Override
    public int tickRate(World worldIn) {
        return 20;
    }

    @Override
    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
        if (!worldIn.isRemote)
        {
            throwCookie(worldIn, pos);
            worldIn.scheduleUpdate(pos, this, this.tickRate(worldIn));
        }
    }

    private void throwCookie(World worldIn, BlockPos blockPos) {
        ItemStack cookie = new ItemStack(Items.cookie);
        BlockSourceImpl blockSource = new BlockSourceImpl(worldIn, blockPos);

        getDispensBehaviour(cookie).dispense(blockSource, cookie);
    }

    protected IBehaviorDispenseItem getDispensBehaviour(ItemStack itemStack)
    {
        return (IBehaviorDispenseItem)dispenseBehaviorRegistry.getObject(itemStack == null ? null : itemStack.getItem());
    }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileEntityCookieCrafter();
    }

    @Override
    public int getMetaFromState(IBlockState state)
    {
        return ((EnumFacing)state.getValue(FACING)).getIndex();
    }

    @Override
    protected BlockState createBlockState() {
        return new BlockState(this, FACING);
    }
}
