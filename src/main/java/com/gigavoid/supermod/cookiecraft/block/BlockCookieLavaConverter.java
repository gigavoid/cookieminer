package com.gigavoid.supermod.cookiecraft.block;

import com.gigavoid.supermod.cookiecraft.creativetab.CookiecraftCreativeTabs;
import com.gigavoid.supermod.cookiecraft.gui.GuiCookieUpgrade;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockCookieLavaConverter extends BlockCookieUpgradeBase implements ICookieUpgrade {
    public static final PropertyBool ACTIVE = PropertyBool.create("active");

    protected BlockCookieLavaConverter() {
        super(Material.rock);
        setCreativeTab(CookiecraftCreativeTabs.tabCookiecraft);
        this.setDefaultState(this.blockState.getBaseState().withProperty(ACTIVE, false));
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
            return 4 * cps;
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
