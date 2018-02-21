package com.gigavoid.supermod.cookiecraft.block;

import com.gigavoid.supermod.SuperMod;
import com.gigavoid.supermod.cookiecraft.cookie.CookieNetwork;
import com.gigavoid.supermod.cookiecraft.creativetab.CookiecraftCreativeTabs;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Random;

public class BlockCookiePipe extends CookieBlockBase implements ICookieBlock {
    public static final PropertyBool NORTH = PropertyBool.create("north");
    public static final PropertyBool SOUTH = PropertyBool.create("south");
    public static final PropertyBool EAST = PropertyBool.create("east");
    public static final PropertyBool WEST = PropertyBool.create("west");
    public static final PropertyBool UP = PropertyBool.create("up");
    public static final PropertyBool DOWN = PropertyBool.create("down");

    public BlockCookiePipe(String name){
        super(name, Material.IRON);
        this.setCreativeTab(CookiecraftCreativeTabs.tabCookiecraft);
        this.setHardness(3.5F);
    }

    @Override
    public boolean isFullCube(IBlockState state) {
        return false;
    }

    @Override
    public boolean isPassable(IBlockAccess worldIn, BlockPos pos) {
        return false;
    }

    @Override
    public Block setBlockUnbreakable() {
        return super.setBlockUnbreakable();
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return Item.getItemFromBlock(this);
    }

    @Override
    public void addCollisionBoxToList(IBlockState state, World worldIn, BlockPos pos, AxisAlignedBB entityBox, List<AxisAlignedBB> collidingBoxes, @Nullable Entity entityIn, boolean isActualState) {
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
            AxisAlignedBB aabb = new AxisAlignedBB(xMin, yMin, zMin, xMax, yMax, zMax);
            addCollisionBoxToList(pos, entityBox, collidingBoxes, aabb);
            super.addCollisionBoxToList(state, worldIn, pos, entityBox, collidingBoxes, entityIn, isActualState);
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
            AxisAlignedBB aabb = new AxisAlignedBB(xMin, yMin, zMin, xMax, yMax, zMax);
            addCollisionBoxToList(pos, entityBox, collidingBoxes, aabb);
            super.addCollisionBoxToList(state, worldIn, pos, entityBox, collidingBoxes, entityIn, isActualState);
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
            AxisAlignedBB aabb = new AxisAlignedBB(xMin, yMin, zMin, xMax, yMax, zMax);
            addCollisionBoxToList(pos, entityBox, collidingBoxes, aabb);
            super.addCollisionBoxToList(state, worldIn, pos, entityBox, collidingBoxes, entityIn, isActualState);
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

        AxisAlignedBB aabb = new AxisAlignedBB(xMin, yMin, zMin, xMax, yMax, zMax);
        addCollisionBoxToList(pos, entityBox, collidingBoxes, aabb);
        super.addCollisionBoxToList(state, worldIn, pos, entityBox, collidingBoxes, entityIn, isActualState);
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

        //this.setBlockBounds(xMin, yMin, zMin, xMax, yMax, zMax);
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer (this, NORTH, SOUTH, EAST, WEST, UP, DOWN);
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

    public boolean isVisuallyOpaque() { return false; }

    @Override
    public boolean isOpaqueCube() { return false; }

    private boolean isNeighborACookieBlock(IBlockAccess world, BlockPos pos, EnumFacing facing){
        return world.getBlockState(pos.offset(facing)).getBlock() instanceof ICookieBlock;
    }

    @Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
        if (!worldIn.isRemote)
            CookieNetwork.getNetwork(worldIn, pos).updateNetwork();
    }

    @Override
    public void onNeighborBlockChange(World worldIn, BlockPos pos, IBlockState state, Block neighborBlock) {
        if (!worldIn.isRemote)
            CookieNetwork.getNetwork(worldIn, pos).updateNetwork();
    }
}
