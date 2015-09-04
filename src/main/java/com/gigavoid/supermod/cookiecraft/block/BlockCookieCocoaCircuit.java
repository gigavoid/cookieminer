package com.gigavoid.supermod.cookiecraft.block;

import com.gigavoid.supermod.cookiecraft.creativetab.CookiecraftCreativeTabs;
import com.gigavoid.supermod.cookiecraft.gui.GuiCookieUpgrade;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockCookieCocoaCircuit extends BlockCookieUpgradeBase implements ICookieUpgrade {
    public static final PropertyBool ACTIVE = PropertyBool.create("active");

    protected BlockCookieCocoaCircuit() {
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
        return state.withProperty(ACTIVE, true); // world.isBlockPowered(pos)
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return 0;
    }

    @Override
    public double getCPS(World world, BlockPos pos, IBlockState state) {
        return world.isBlockPowered(pos) ? 1 : 0;
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
