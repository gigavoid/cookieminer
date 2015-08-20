package com.gigavoid.supermod.cookiecraft.block;

import com.gigavoid.supermod.cookiecraft.cookie.CookieNetwork;
import com.gigavoid.supermod.cookiecraft.creativetab.CookiecraftCreativeTabs;
import com.gigavoid.supermod.cookiecraft.gui.GuiCookieUpgrade;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

public class BlockCookieMoonlightReflector extends BlockCookieUpgradeBase implements ICookieUpgrade {
    boolean isTopBlock = false;
    protected BlockCookieMoonlightReflector() {
        super(Material.rock);
        setCreativeTab(CookiecraftCreativeTabs.tabCookiecraft);
        setTickRandomly(true);
    }

    @Override
    public double getCPS(World world, BlockPos pos, IBlockState state) {
        if (!world.isDaytime() && isTopBlock){
            return 4d;
        }
        return 0;
    }

	@Override
	public int getGuiId() {
		return GuiCookieUpgrade.GUI_ID;
	}

	@Override
	public boolean hasImportantUI() {
		return false;
	}

    @Override
    public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state) {
        isTopBlock = isTopBlock(worldIn, pos);
    }

    @Override
    public int tickRate(World worldIn) {
        return 5 * 60;
    }

    @Override
    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
        isTopBlock = isTopBlock(worldIn, pos);
        if (!worldIn.isRemote) {
            CookieNetwork.getNetwork(worldIn, pos).updateNetwork(worldIn, pos);
        }
    }

    private boolean isTopBlock(World world, BlockPos pos){
        for (int i = pos.getY() + 1; i < 256; i++){
            if (world.getBlockState(new BlockPos(pos.getX(), i, pos.getZ())).getBlock() != Blocks.air){
                return false;
            }
        }
        return true;
    }
}
