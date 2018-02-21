package com.gigavoid.supermod.cookiecraft.block;

import com.gigavoid.supermod.cookiecraft.ModuleCookiecraft;
import com.gigavoid.supermod.cookiecraft.creativetab.CookiecraftCreativeTabs;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.Random;

public class BlockCookieIonChanneler extends BlockCookieGeneratorBase implements ICookieGenerator {
    public static final PropertyBool ACTIVE = PropertyBool.create("active");
    public static final PropertyBool TOP = PropertyBool.create("top");
    public static final PropertyBool BOTTOM = PropertyBool.create("bottom");

    public BlockCookieIonChanneler(String name) {
        super(name, Material.ROCK);
        setCreativeTab(CookiecraftCreativeTabs.tabCookiecraft);
        this.setDefaultState(this.blockState.getBaseState().withProperty(ACTIVE, false).withProperty(TOP, true).withProperty(BOTTOM, true));
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return Item.getItemFromBlock(this);
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer (this, ACTIVE, TOP, BOTTOM);
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
        return isTowerBuilt(world, pos) ? ModuleCookiecraft.config.outputIonChanneler : 0;
    }

    private boolean isTowerBuilt(IBlockAccess world, BlockPos pos){
        int nrOfParts = 1;
        for (int i = 1; i < 5; i++){
            if (world.getBlockState(pos.offset(EnumFacing.UP, i)).getBlock() == CookiecraftBlocks.ionChanneler){
                nrOfParts++;
            }
            else
                break;
        }
        if (nrOfParts < 5){
            for (int i = 1; i < 5; i++){
                if (world.getBlockState(pos.offset(EnumFacing.DOWN, i)).getBlock() == CookiecraftBlocks.ionChanneler){
                    nrOfParts++;
                }
                else
                    break;
            }
        }
        return nrOfParts == 4;
    }

    private boolean isTop(IBlockAccess world, BlockPos pos){
        return world.getBlockState(pos.offset(EnumFacing.UP)).getBlock() != CookiecraftBlocks.ionChanneler;
    }

    private boolean isBottom(IBlockAccess world, BlockPos pos){
        return world.getBlockState(pos.offset(EnumFacing.DOWN)).getBlock() != CookiecraftBlocks.ionChanneler;
    }

    @Override
    public boolean shouldSideBeRendered(IBlockAccess worldIn, BlockPos pos, EnumFacing side) {
        return false;
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }
}
