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

public class BlockPortalConnector extends BlockCookieUpgradeBase implements ICookieUpgrade {

    public static final PropertyBool ACTIVE = PropertyBool.create("active");


    public BlockPortalConnector(){
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
        return state.withProperty(ACTIVE, isNextToPortal(worldIn, pos));
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return 0;
    }

    @Override
    public double getCPS(World world, BlockPos pos, IBlockState state) {
        if (isNextToPortal(world, pos)) {
            world.setBlockState(pos, state.withProperty(ACTIVE, true), 2);
            return 1000d;
        }
        world.setBlockState(pos, blockState.getBaseState().withProperty(ACTIVE, false),2);
        return 0;
    }

    private boolean isNextToPortal(IBlockAccess world, BlockPos pos) {
        return isNextToOnePortal(world, pos.offsetNorth()) ||
                isNextToOnePortal(world, pos.offsetEast()) ||
                isNextToOnePortal(world, pos.offsetSouth()) ||
                isNextToOnePortal(world, pos.offsetWest());
    }

    private boolean isNextToOnePortal(IBlockAccess world, BlockPos blockPos) {
        return world.getBlockState(blockPos).getBlock() == CookiecraftBlocks.portalCookiecraft;
    }

	@Override
	public int getGuiId() {
		return GuiCookieUpgrade.GUI_ID;
	}
}
