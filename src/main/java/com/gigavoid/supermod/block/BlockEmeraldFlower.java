package com.gigavoid.supermod.block;

import net.minecraft.block.BlockFlower;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Random;

public class BlockEmeraldFlower extends BlockFlower {
    public BlockEmeraldFlower() {
        super();
        this.setLightLevel(0.5f);
        this.setCreativeTab(CreativeTabs.tabDecorations);
        this.setTickRandomly(true);
    }

    @Override
    public EnumFlowerColor func_176495_j() {
        return EnumFlowerColor.YELLOW;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
        super.randomDisplayTick(worldIn, pos, state, rand);
        double d0 = (double)rand.nextFloat() - .5f;
        double d1 = (double)rand.nextFloat() - .5f;
        double d2 = (double)rand.nextFloat() - .5f;
        worldIn.spawnParticle(EnumParticleTypes.VILLAGER_HAPPY, pos.getX(), pos.getY(), pos.getZ(), d0, d1, d2, 0);
    }
}
