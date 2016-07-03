package com.gigavoid.supermod.cookiecraft.block;

import com.gigavoid.supermod.cookiecraft.creativetab.CookiecraftCreativeTabs;
import com.gigavoid.supermod.cookiecraft.gui.GuiCookieCrafter;
import com.gigavoid.supermod.cookiecraft.item.CookiecraftItems;
import com.gigavoid.supermod.cookiecraft.item.ItemCookiePouchOverflow;
import com.gigavoid.supermod.cookiecraft.tileentity.TileEntityCookieCrafter;
import com.gigavoid.supermod.cookiecraft.cookie.CookieNetwork;
import net.minecraft.block.BlockDispenser;
import net.minecraft.block.BlockSourceImpl;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.dispenser.IPosition;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

import java.util.Random;

public class BlockCookieCrafter extends BlockCookieNetworkBlockBase implements ITileEntityProvider, ICookieGenerator {
    public static final PropertyDirection FACING = PropertyDirection.create("facing");

    public static final BlockCookieCrafter instance = new BlockCookieCrafter();

    private BlockCookieCrafter() {
        super(Material.rock);
        setCreativeTab(CookiecraftCreativeTabs.tabCookiecraft);
        this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return Item.getItemFromBlock(this);
    }

    @Override
    public IBlockState onBlockPlaced(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) {
        return this.getDefaultState().withProperty(FACING, placer.getHorizontalFacing().getOpposite());
    }

    /**
     * Copied from BlockDispenser
     */
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
        throwCookies(worldIn, pos);
        if (!worldIn.isRemote)
        {
            worldIn.scheduleUpdate(pos, this, this.tickRate(worldIn));
        }
    }

	@Override
	public int getGuiId() {
		return GuiCookieCrafter.GUI_ID;
	}

	private void throwCookies(World worldIn, BlockPos blockPos) {
        TileEntityCookieCrafter tileEntity = getTileEntity(worldIn, blockPos);
        double cps = tileEntity.getCPS();

        double cookiesToCreate = cps + tileEntity.getLeftover();
        long wholeCookies = (long) cookiesToCreate;
        tileEntity.setLeftover(cookiesToCreate - wholeCookies);

        if (wholeCookies == 0) {
            // No more cookies to take care of
            return;
        }

        // Store as many cookies as possible in storage units
        wholeCookies = CookieNetwork.getNetwork(worldIn, blockPos).storeCookies(wholeCookies);

        if (wholeCookies == 0) {
            // All cookies did fit in the storage units, so there are no more cookies to take care of
            return;
        }

        // Dispense the cookies that did not fit into the storage
        BlockSourceImpl blockSource = new BlockSourceImpl(worldIn, blockPos);

        if (wholeCookies > 64) {
            ItemStack overflowStack = new ItemStack(CookiecraftItems.overflowCookiePouch);
            ((ItemCookiePouchOverflow) overflowStack.getItem()).initialize(overflowStack, wholeCookies);
            dispenseStack(blockSource, overflowStack);
        } else {
            dispenseStack(blockSource, new ItemStack(Items.cookie, (int) wholeCookies));
        }
    }

    private void dispenseStack(IBlockSource source, ItemStack stack)
    {
        EnumFacing enumfacing = BlockDispenser.getFacing(source.getBlockMetadata());
        IPosition iposition = BlockDispenser.getDispensePosition(source);
        doDispense(source.getWorld(), stack, 6, enumfacing, iposition);

        // Smoke
        source.getWorld().playAuxSFX(2000, source.getBlockPos(), enumfacing.getFrontOffsetX() + 1 + (enumfacing.getFrontOffsetZ() + 1) * 3);

        // Sound
        source.getWorld().playAuxSFX(1000, source.getBlockPos(), 0);
    }

    private static void doDispense(World worldIn, ItemStack stack, int speed, EnumFacing p_82486_3_, IPosition position)
    {
        double d0 = position.getX();
        double d1 = position.getY();
        double d2 = position.getZ();

        if (p_82486_3_.getAxis() == EnumFacing.Axis.Y)
        {
            d1 -= 0.125D;
        }
        else
        {
            d1 -= 0.15625D;
        }

        EntityItem entityitem = new EntityItem(worldIn, d0, d1, d2, stack);
        double d3 = worldIn.rand.nextDouble() * 0.1D + 0.2D;
        entityitem.motionX = (double)p_82486_3_.getFrontOffsetX() * d3;
        entityitem.motionY = 0.20000000298023224D;
        entityitem.motionZ = (double)p_82486_3_.getFrontOffsetZ() * d3;
        entityitem.motionX += worldIn.rand.nextGaussian() * 0.007499999832361937D * (double)speed;
        entityitem.motionY += worldIn.rand.nextGaussian() * 0.007499999832361937D * (double)speed;
        entityitem.motionZ += worldIn.rand.nextGaussian() * 0.007499999832361937D * (double)speed;
        worldIn.spawnEntityInWorld(entityitem);
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

    @Override
    public double getCPS(World world, BlockPos pos, IBlockState state) {
        return 1/60;
    }

    public static TileEntityCookieCrafter getTileEntity(World world, BlockPos pos) {
        return (TileEntityCookieCrafter) world.getTileEntity(pos);
    }
}
