package com.gigavoid.supermod.cookiecraft.block;

import com.gigavoid.supermod.cookiecraft.ModuleCookiecraft;
import com.gigavoid.supermod.cookiecraft.creativetab.CookiecraftCreativeTabs;
import com.gigavoid.supermod.cookiecraft.gui.GuiCookieUpgrade;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.Random;

public class BlockCookieLavaConverter extends BlockCookieUpgradeBase implements ICookieUpgrade {
    public static final PropertyBool ACTIVE = PropertyBool.create("active");

    public static final BlockCookieLavaConverter instance = new BlockCookieLavaConverter();

    private BlockCookieLavaConverter() {
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
        return state.withProperty(ACTIVE, nrOfLavaBlocks(worldIn, pos) != 0);
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return 0;
    }

    @Override
    public double getCPS(World world, BlockPos pos, IBlockState state) {
        int cps = nrOfLavaBlocks(world, pos);
        if (cps != 0) {
            world.setBlockState(pos, state.withProperty(ACTIVE, true), 2);
            return ModuleCookiecraft.config.outputLavaConverter * cps / 25;
        }
        world.setBlockState(pos, blockState.getBaseState().withProperty(ACTIVE, false), 2);
        return 0;
    }

    @Override
    public boolean hasImportantUI() {
        return false;
    }

    private int nrOfLavaBlocks(IBlockAccess world, BlockPos pos) {
        int lavaBlocks = 0;

        for (int i = -1; i < 2; i++){
            for (int j = -1; j < 2; j++){
                for (int k = -1; k < 2; k++){
                    lavaBlocks += isLava(world, pos.add(i, j, k)) ? 1 : 0;
                }
            }
        }

        return lavaBlocks;
    }

    private boolean isLava(IBlockAccess world, BlockPos blockPos) {
        return world.getBlockState(blockPos).getBlock() == Blocks.lava || world.getBlockState(blockPos).getBlock() == Blocks.flowing_lava;
    }

	@Override
	public int getGuiId() {
		return GuiCookieUpgrade.GUI_ID;
	}
}
