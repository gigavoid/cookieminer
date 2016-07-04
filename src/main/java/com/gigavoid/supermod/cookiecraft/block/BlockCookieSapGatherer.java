package com.gigavoid.supermod.cookiecraft.block;

import com.gigavoid.supermod.cookiecraft.ModuleCookiecraft;
import com.gigavoid.supermod.cookiecraft.creativetab.CookiecraftCreativeTabs;
import com.gigavoid.supermod.cookiecraft.gui.GuiCookieGenerator;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLeavesBase;
import net.minecraft.block.BlockLog;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.Random;

public class BlockCookieSapGatherer extends BlockCookieGeneratorBase implements ICookieGenerator {
    public static final PropertyBool ACTIVE = PropertyBool.create("active");

    public static final BlockCookieSapGatherer instance = new BlockCookieSapGatherer();

    private BlockCookieSapGatherer(){
        super(Material.rock);
        setCreativeTab(CookiecraftCreativeTabs.tabCookiecraft);
        this.setDefaultState(this.blockState.getBaseState().withProperty(ACTIVE, false));
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
        return state.withProperty(ACTIVE, isActive(worldIn, pos));
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return 0;
    }

    @Override
    public double getCPS(World world, BlockPos pos, IBlockState state) {
        if (isActive(world, pos)) {
            world.setBlockState(pos, state.withProperty(ACTIVE, true), 2);
            return ModuleCookiecraft.config.outputSapGatherer;
        }
        world.setBlockState(pos, blockState.getBaseState().withProperty(ACTIVE, false),2);
        return 0;
    }

    private boolean isActive(IBlockAccess world, BlockPos pos) {
        return isTree(world, pos.offset(EnumFacing.NORTH)) ||
                isTree(world, pos.offset(EnumFacing.EAST)) ||
                isTree(world, pos.offset(EnumFacing.SOUTH)) ||
                isTree(world, pos.offset(EnumFacing.WEST));
    }

    private boolean isTree(IBlockAccess world, BlockPos blockPos) {
        if (world.getBlockState(blockPos).getBlock() instanceof BlockLog){
            int height = 1;
            while(world.getBlockState(blockPos.up(height)).getBlock() instanceof BlockLog){
                height++;
            }
            return world.getBlockState(blockPos.up(height)).getBlock() instanceof BlockLeavesBase;
        }
        return false;
    }

	@Override
	public int getGuiId() {
		return GuiCookieGenerator.GUI_ID;
	}
}
