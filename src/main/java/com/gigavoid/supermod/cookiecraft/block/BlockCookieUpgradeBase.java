package com.gigavoid.supermod.cookiecraft.block;

import com.gigavoid.supermod.SuperMod;
import com.gigavoid.supermod.cookiecraft.cookie.CookieNetwork;
import com.gigavoid.supermod.cookiecraft.gui.GuiCookieCrafter;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public abstract class BlockCookieUpgradeBase extends Block {
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

	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ) {
		if (playerIn.isSneaking())
			return false;

		playerIn.openGui(SuperMod.instance, getGuiId(), worldIn, pos.getX(), pos.getY(), pos.getZ());
		return true;
	}

	public abstract int getGuiId();


}
