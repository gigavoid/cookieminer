package com.gigavoid.supermod.cookiecraft.block;

import com.gigavoid.supermod.cookiecraft.creativetab.CookiecraftCreativeTabs;
import com.gigavoid.supermod.cookiecraft.gui.GuiCookieUpgrade;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.Random;

public class BlockCookieNuclearBaker extends BlockCookieUpgradeBase implements ICookieUpgrade {
    public static final PropertyBool ACTIVE = PropertyBool.create("active");

    public static final BlockCookieNuclearBaker instance = new BlockCookieNuclearBaker();

    private BlockCookieNuclearBaker(){
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
        return state.withProperty(ACTIVE, isActive(worldIn, pos));
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return 0;
    }

    @Override
    public boolean hasImportantUI() {
        return false;
    }

    @Override
    public int getGuiId() {
        return GuiCookieUpgrade.GUI_ID;
    }

    @Override
    public double getCPS(World world, BlockPos pos, IBlockState state) {
        return 0;
    }

    // Returns a nullvector if values are invalid. Else the BlockPos will describe the multiblock.
    private BlockPos getFaceDirections(IBlockAccess world, BlockPos pos){
        BlockPos result = BlockPos.ORIGIN;
        for (EnumFacing facing : EnumFacing.values()){
            if (world.getBlockState(pos.offset(facing)).getBlock() == instance){
                result = result.offset(facing);
            }
        }
        if (result.getX() == 0 || result.getY() == 0 || result.getZ() == 0){
            return BlockPos.ORIGIN;
        }
        return result;
    }

    // Returns nullvector if false, else BlockPos describing multiblock.
    private BlockPos isBuilt(IBlockAccess world, BlockPos pos){
        BlockPos faceDirs = getFaceDirections(world, pos);
        if (faceDirs == BlockPos.ORIGIN){
            return BlockPos.ORIGIN;
        }
        if (world.getBlockState(pos).getBlock() != instance || world.getBlockState(pos.add(faceDirs.getX(), 0, 0)).getBlock() != instance ||
                world.getBlockState(pos.add(0, 0, faceDirs.getZ())).getBlock() != instance || world.getBlockState(pos.add(faceDirs.getX(), 0, faceDirs.getZ())).getBlock() != instance ||
                world.getBlockState(pos.add(0, faceDirs.getY(), 0)).getBlock() != instance || world.getBlockState(pos.add(faceDirs.getX(), faceDirs.getY(), 0)).getBlock() != instance ||
                world.getBlockState(pos.add(0, faceDirs.getY(), faceDirs.getZ())).getBlock() != instance || world.getBlockState(pos.add(faceDirs.getX(), faceDirs.getY(), faceDirs.getZ())).getBlock() != instance) {
            return BlockPos.ORIGIN;
        }
        return faceDirs;
    }

    private boolean isActive(IBlockAccess world, BlockPos pos){
        boolean result = true;
        BlockPos faceDirs = isBuilt(world, pos);
        int startY = faceDirs.getY() == -1 ? 0 : 1, endY = faceDirs.getY() == -1 ? -3 : -2,
                xDir = faceDirs.getX(), zDir = faceDirs.getZ();
        if (faceDirs != BlockPos.ORIGIN){
            for (int x = 2 * xDir; x != -2 * xDir; x += (xDir * -1)){
                for (int z = 2 * zDir; z != -2 * zDir; z += (zDir * -1)){
                    for (int y = startY; y > endY; y--){
                        if (y == endY + 1){
                            if (world.getBlockState(pos.add(x, y, z)).getBlock() != Blocks.water){
                                result = false;
                            }
                        }
                        if (x != 0 && x != xDir){
                            if (world.getBlockState(pos.add(x, y, z)).getBlock() != Blocks.water){
                                result = false;
                            }
                        }
                        if (z != 0 && z != zDir){
                            if (world.getBlockState(pos.add(x, y, z)).getBlock() != Blocks.water){
                                result = false;
                            }
                        }
                    }
                }
            }
        }
        else{
            result = false;
        }
        return result;
    }
}
