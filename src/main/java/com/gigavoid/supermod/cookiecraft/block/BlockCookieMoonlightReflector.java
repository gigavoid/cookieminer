package com.gigavoid.supermod.cookiecraft.block;

import com.gigavoid.supermod.cookiecraft.creativetab.CookiecraftCreativeTabs;
import com.gigavoid.supermod.cookiecraft.gui.GuiCookieUpgrade;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public class BlockCookieMoonlightReflector extends BlockCookieUpgradeBase implements ICookieUpgrade {
    protected BlockCookieMoonlightReflector() {
        super(Material.rock);
        setCreativeTab(CookiecraftCreativeTabs.tabCookiecraft);
    }

    @Override
    public double getCPS(World world, BlockPos pos, IBlockState state) {
        if (!world.isDaytime() && isTopBlock(world, pos)){
            return 1/15d;
        }
        return 0;
    }

    private boolean isTopBlock(World world, BlockPos pos){
        boolean result = true;
        int height = pos.getY();
        while(result && height <= 255){
            if (world.getBlockState(new BlockPos(pos.getX(), height, pos.getZ())).getBlock() == Blocks.air){
                result = false;
            }
            height++;
        }
        return result;
    }

	@Override
	public int getGuiId() {
		return GuiCookieUpgrade.GUI_ID;
	}

	@Override
	public boolean hasImportantUI() {
		return false;
	}
}
