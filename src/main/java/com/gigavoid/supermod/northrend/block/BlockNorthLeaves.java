package com.gigavoid.supermod.northrend.block;

import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.ArrayList;
import java.util.List;

public class BlockNorthLeaves extends BlockLeaves {
    public BlockNorthLeaves(){
        super();
        this.setHardness(1.0f);
        this.setCreativeTab(CreativeTabs.tabBlock);
        this.setStepSound(soundTypeGrass);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public EnumWorldBlockLayer getBlockLayer()
    {
        return EnumWorldBlockLayer.TRANSLUCENT;
    }

    @Override
    public List<ItemStack> onSheared(ItemStack item, IBlockAccess world, BlockPos pos, int fortune) {
        List<ItemStack> list = new ArrayList<ItemStack>();
        list.add(new ItemStack(Item.getItemFromBlock(this)));
        return list;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public int getBlockColor() {
        return 0xFFFFFF;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public int getRenderColor(IBlockState state) {
        return 0xFFFFFF;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public int colorMultiplier(IBlockAccess worldIn, BlockPos pos, int renderPass) {
        return 0xFFFFFF;
    }

    @Override
    public BlockPlanks.EnumType func_176233_b(int p_176233_1_) {
        return BlockPlanks.EnumType.SPRUCE;
    }

    @Override
    public boolean shouldSideBeRendered(IBlockAccess worldIn, BlockPos pos, EnumFacing side) {
        return true;
    }

    @Override
    public boolean isVisuallyOpaque() { return false; }

    @Override
    public int getMetaFromState(IBlockState state) { return 0; }

    @Override
    protected BlockState createBlockState()
    {
        return new BlockState(this, BlockLeaves.field_176236_b);
    }

    @Override
    public boolean isOpaqueCube() { return false; }
}
