package com.gigavoid.supermod.cookiecraft.block;

import com.gigavoid.supermod.cookiecraft.cookie.CookieNetwork;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public class BlockCookieUpgradeBase extends Block {
    public BlockCookieUpgradeBase(Material material) {
        super(material);
    }

    @Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
        if (!worldIn.isRemote)
            CookieNetwork.getNetwork(worldIn, pos).updateNetwork(worldIn, pos);
    }

    @Override
    public void onNeighborBlockChange(World worldIn, BlockPos pos, IBlockState state, Block neighborBlock) {
        if (!worldIn.isRemote)
            CookieNetwork.getNetwork(worldIn, pos).updateNetwork(worldIn, pos);
    }
}
