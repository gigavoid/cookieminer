package com.gigavoid.supermod.block;

import com.gigavoid.supermod.tileentity.TileEntityRopeWheel;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BlockRopeWheel extends Block implements ITileEntityProvider {

    protected BlockRopeWheel() {
        super(Material.wood);
        this.setCreativeTab(CreativeTabs.tabDecorations);
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public int getRenderType() {
        return -1;
    }

    @Override
    public boolean canReplace(World worldIn, BlockPos pos, EnumFacing side, ItemStack stack)
    {
        return this.canPlaceBlockOnSide(worldIn, pos, side);
    }

    @Override
    public boolean canPlaceBlockOnSide(World world, BlockPos pos, EnumFacing side) {
        EnumFacing dir = side;
        return (dir == EnumFacing.NORTH && world.isSideSolid(pos.add(0, 0, 1), EnumFacing.NORTH) && world.getBlockState(pos.add(0, 0, 1)) == SuperBlocks.pylon) ||
                (dir == EnumFacing.SOUTH && world.isSideSolid(pos.add(0, 0, -1), EnumFacing.SOUTH) && world.getBlockState(pos.add(0, 0, -1)) == SuperBlocks.pylon) ||
                (dir == EnumFacing.WEST  && world.isSideSolid(pos.add(1, 0, 0), EnumFacing.WEST) && world.getBlockState(pos.add(1, 0, 0)) == SuperBlocks.pylon) ||
                (dir == EnumFacing.EAST  && world.isSideSolid(pos.add(-1, 0, 0), EnumFacing.EAST) && world.getBlockState(pos.add(-1, 0, 0)) == SuperBlocks.pylon);
    }

    @Override
    public TileEntity createNewTileEntity(World p_149915_1_, int meta) {
        return new TileEntityRopeWheel();
    }

    @Override
    public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {

        TileEntityRopeWheel te = (TileEntityRopeWheel) world.getTileEntity(pos);
        te.direction = (short)(MathHelper.floor_double((double) (placer.rotationYaw * 4.0F / 360) + 0.50) & 3);

        System.out.println(te.direction);

        for(int i = 0; i < 2; i++) {

            if (te.direction == 0 && world.getBlockState(pos.add(0, 0, 1)) != SuperBlocks.pylon)
                te.direction = 1;

            if (te.direction == 1 && world.getBlockState(pos.add(-1, 0, 0)) != SuperBlocks.pylon)
                te.direction = 2;

            if (te.direction == 2 && world.getBlockState(pos.add(0, 0, -1)) != SuperBlocks.pylon)
                te.direction = 3;

            if (te.direction == 3 && world.getBlockState(pos.add(1, 0, 0)) != SuperBlocks.pylon)
                te.direction = 0;

        }

    }

}
