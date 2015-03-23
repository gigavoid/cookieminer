package com.gigavoid.supermod.cookiecraft.block;

import com.gigavoid.supermod.cookiecraft.creativetab.CookiecraftCreativeTabs;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockCoockiePortalActivator extends Block {
    public BlockCoockiePortalActivator(){
        super(Material.glass);
        this.setHardness(1.0f);
        this.setCreativeTab(null);
        this.setStepSound(soundTypeGrass);
    }

    @Override
    public AxisAlignedBB getCollisionBoundingBox(World worldIn, BlockPos pos, IBlockState state) {
        return null;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public EnumWorldBlockLayer getBlockLayer() {
        return EnumWorldBlockLayer.TRANSLUCENT;
    }

    @Override
    public boolean isVisuallyOpaque() { return false; }

    @Override
    public boolean isOpaqueCube() { return false; }

    @Override
    public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state)
    {
        if (worldIn.provider.getDimensionId() > 0 || !CookiecraftBlocks.portalCookiecraft.func_176548_d(worldIn, pos))
        {
            worldIn.setBlockToAir(pos);
        }
    }
}