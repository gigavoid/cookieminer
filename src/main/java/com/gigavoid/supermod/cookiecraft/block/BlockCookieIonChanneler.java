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

public class BlockCookieIonChanneler extends BlockCookieUpgradeBase implements ICookieUpgrade {
    public static final PropertyBool ACTIVE = PropertyBool.create("active");
    public static final PropertyBool TOP = PropertyBool.create("top");
    public static final PropertyBool BOTTOM = PropertyBool.create("bottom");

    protected BlockCookieIonChanneler() {
        super(Material.rock);
        setCreativeTab(CookiecraftCreativeTabs.tabCookiecraft);
        this.setDefaultState(this.blockState.getBaseState().withProperty(ACTIVE, false).withProperty(TOP, true).withProperty(BOTTOM, true));
    }

    @Override
    protected BlockState createBlockState() {
        return new BlockState(this, ACTIVE, TOP, BOTTOM);
    }

    @Override
    public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos) {
        return state.withProperty(ACTIVE, isTowerBuilt(worldIn, pos))
                .withProperty(TOP, isTop(worldIn, pos))
                .withProperty(BOTTOM, isBottom(worldIn, pos));
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return 0;
    }

    @Override
    public double getCPS(World world, BlockPos pos, IBlockState state) {
        return isTowerBuilt(world, pos) ? 65536 : 0;
    }

	@Override
	public int getGuiId() {
		return GuiCookieUpgrade.GUI_ID;
	}

	@Override
    public boolean hasImportantUI() {
        return false;
    }

    private boolean isTowerBuilt(IBlockAccess world, BlockPos pos){
        int nrOfParts = 1;
        for (int i = 1; i < 5; i++){
            if (world.getBlockState(pos.offsetUp(i)).getBlock() == CookiecraftBlocks.ionChanneler){
                nrOfParts++;
            }
            else
                break;
        }
        if (nrOfParts < 5){
            for (int i = 1; i < 5; i++){
                if (world.getBlockState(pos.offsetDown(i)).getBlock() == CookiecraftBlocks.ionChanneler){
                    nrOfParts++;
                }
                else
                    break;
            }
        }
        return nrOfParts == 4;
    }

    private boolean isTop(IBlockAccess world, BlockPos pos){
        return world.getBlockState(pos.offsetUp()).getBlock() != CookiecraftBlocks.ionChanneler;
    }

    private boolean isBottom(IBlockAccess world, BlockPos pos){
        return world.getBlockState(pos.offsetDown()).getBlock() != CookiecraftBlocks.ionChanneler;
    }
}
