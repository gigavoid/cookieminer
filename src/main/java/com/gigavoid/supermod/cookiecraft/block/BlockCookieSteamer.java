package com.gigavoid.supermod.cookiecraft.block;

import com.gigavoid.supermod.cookiecraft.ModuleCookiecraft;
import com.gigavoid.supermod.cookiecraft.creativetab.CookiecraftCreativeTabs;
import com.gigavoid.supermod.cookiecraft.gui.GuiCookieGenerator;
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

public class BlockCookieSteamer extends BlockCookieGeneratorBase implements ICookieGenerator {
    public static final PropertyBool ACTIVE = PropertyBool.create("active");

    public static final BlockCookieSteamer instance = new BlockCookieSteamer();

    private BlockCookieSteamer() {
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
        return state.withProperty(ACTIVE, isAboveWater(worldIn, pos));
    }

    private boolean isAboveWater(IBlockAccess world, BlockPos pos){
        return world.getBlockState(pos.down()).getBlock() == Blocks.water;
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return 0;
    }

    @Override
    public double getCPS(World world, BlockPos pos, IBlockState state) {
        return isAboveWater(world, pos) ? ModuleCookiecraft.config.outputCookieStreamer : 0;
    }

	@Override
	public int getGuiId() {
		return GuiCookieGenerator.GUI_ID;
	}
}
