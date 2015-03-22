package com.gigavoid.supermod.northrend.block;

import com.gigavoid.supermod.northrend.creativetab.NorthrendCreativeTabs;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockNorthPortalActivater extends Block {
    public BlockNorthPortalActivater(){
        super(Material.glass);
        this.setHardness(1.0f);
        this.setCreativeTab(NorthrendCreativeTabs.tabNorthrend);
        this.setStepSound(soundTypeGrass);
    }

    @Override
    public AxisAlignedBB getCollisionBoundingBox(World worldIn, BlockPos pos, IBlockState state) {
        return null;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public EnumWorldBlockLayer getBlockLayer()
    {
        return EnumWorldBlockLayer.TRANSLUCENT;
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

    @Override
    public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state)
    {
        if (worldIn.provider.getDimensionId() > 0 || !NorthrendBlocks.portalNorthrend.func_176548_d(worldIn, pos))
        {
            worldIn.setBlockToAir(pos);
        }
    }
}
