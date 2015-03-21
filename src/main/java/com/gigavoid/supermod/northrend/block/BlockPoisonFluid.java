package com.gigavoid.supermod.northrend.block;

import com.gigavoid.supermod.northrend.creativetab.NorthrendCreativeTabs;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;

public class BlockPoisonFluid extends BlockFluidClassic {
    public BlockPoisonFluid(Fluid fluid, Material material) {
        super(fluid, material);
        setCreativeTab(NorthrendCreativeTabs.tabNorthrend);
    }

    @Override
    public boolean canDisplace(IBlockAccess world, BlockPos pos) {
        if (world.getBlockState(pos).getBlock().getMaterial().isLiquid()) return false;
        return super.canDisplace(world, pos);
    }

    @Override
    public boolean displaceIfPossible(World world, BlockPos pos) {
        if (world.getBlockState(pos).getBlock().getMaterial().isLiquid()) return false;
        return super.displaceIfPossible(world, pos);
    }
}
