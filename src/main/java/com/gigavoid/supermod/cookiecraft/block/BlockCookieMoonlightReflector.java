package com.gigavoid.supermod.cookiecraft.block;

import com.gigavoid.supermod.cookiecraft.cookie.CookieNetwork;
import com.gigavoid.supermod.cookiecraft.creativetab.CookiecraftCreativeTabs;
import com.gigavoid.supermod.cookiecraft.gui.GuiCookieUpgrade;
import com.gigavoid.supermod.cookiecraft.tileentity.TileEntityCookieCrafter;
import com.gigavoid.supermod.cookiecraft.tileentity.TileEntityMoonlightReflector;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

public class BlockCookieMoonlightReflector extends BlockCookieUpgradeBase implements ICookieUpgrade, ITileEntityProvider {
    protected BlockCookieMoonlightReflector() {
        super(Material.rock);
        setCreativeTab(CookiecraftCreativeTabs.tabCookiecraft);
        setTickRandomly(true);
    }

    @Override
    public double getCPS(World world, BlockPos pos, IBlockState state) {
        if (!world.isDaytime() && isTopBlock(world, pos)){
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
    public int tickRate(World worldIn) {
        return 5 * 20;
    }

    @Override
    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
        TileEntityMoonlightReflector tileEntity = getTileEntity(worldIn, pos);

        boolean isActive = isTopBlock(worldIn, pos) && !worldIn.isDaytime();

        if (isActive != tileEntity.isActive()) {
            // State has changed since last check
            if (!worldIn.isRemote) {
                CookieNetwork.getNetwork(worldIn, pos).updateNetwork(worldIn, pos);
            }
        }

        tileEntity.setIsActive(isActive);
    }

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
