package com.gigavoid.supermod.cookiecraft.block;

import com.gigavoid.supermod.cookiecraft.cookie.CookieNetwork;
import com.gigavoid.supermod.cookiecraft.creativetab.CookiecraftCreativeTabs;
import com.gigavoid.supermod.cookiecraft.gui.GuiCookieUpgrade;
import com.gigavoid.supermod.cookiecraft.tileentity.TileEntityCookieCrafter;
import com.gigavoid.supermod.cookiecraft.tileentity.TileEntityMoonlightReflector;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.ChunkCache;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.List;
import java.util.Random;

public class BlockCookieMoonlightReflector extends BlockCookieUpgradeBase implements ICookieUpgrade, ITileEntityProvider {
    public static final PropertyBool ACTIVE = PropertyBool.create("active");

    protected BlockCookieMoonlightReflector() {
        super(Material.rock);
        setCreativeTab(CookiecraftCreativeTabs.tabCookiecraft);
        this.setDefaultState(this.blockState.getBaseState().withProperty(ACTIVE, false));
    }

    @Override
    public boolean isFullCube() {
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
    protected BlockState createBlockState() {
        return new BlockState(this, ACTIVE);
    }

    @Override
    public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos) {
        return worldIn.getBlockState(pos);
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
        //System.out.println("GET CPS" + getTileEntity(world, pos).isActive());
        if (getTileEntity(world, pos).isActive()) {
            world.setBlockState(pos, state.withProperty(ACTIVE, true), 2);
            return 32d;
        }
        world.setBlockState(pos, state.withProperty(ACTIVE, false), 2);
        return 0;
    }

	@Override
	public int getGuiId() {
		return GuiCookieUpgrade.GUI_ID;
	}

    @Override
    public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state) {
        if (!worldIn.isRemote) {
            worldIn.scheduleUpdate(pos, this, this.tickRate(worldIn));
        }
    }

    @Override
	public boolean hasImportantUI() {
		return false;
	}

    @Override
    public int tickRate(World worldIn) {
        return 5 * 20;
    }

    @Override
    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
        TileEntityMoonlightReflector tileEntity = getTileEntity(worldIn, pos);

        boolean isActive = isTopBlock(worldIn, pos) && !worldIn.isDaytime();


        if (isActive != tileEntity.isActive()) {
            tileEntity.setIsActive(isActive);
            CookieNetwork.getNetwork(worldIn, pos).updateNetwork(worldIn, pos);
        }

        worldIn.scheduleUpdate(pos, this, this.tickRate(worldIn));
    }

    @Override
    public boolean shouldSideBeRendered(IBlockAccess worldIn, BlockPos pos, EnumFacing side) {
        return true;
    }

    @Override
    public boolean isVisuallyOpaque() { return false; }

    @Override
    public boolean isOpaqueCube() { return false; }

    private boolean isTopBlock(World world, BlockPos pos){
        for (int i = pos.getY() + 1; i < 256; i++){
            if (world.getBlockState(new BlockPos(pos.getX(), i, pos.getZ())).getBlock() != Blocks.air){
                return false;
            }
        }
        return true;
    }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileEntityMoonlightReflector();
    }

    public TileEntityMoonlightReflector getTileEntity(World world, BlockPos pos) {
        return (TileEntityMoonlightReflector) world.getTileEntity(pos);
    }
}
