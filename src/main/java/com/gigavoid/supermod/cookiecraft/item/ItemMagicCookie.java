package com.gigavoid.supermod.cookiecraft.item;

import com.gigavoid.supermod.cookiecraft.block.CookiecraftBlocks;
import com.gigavoid.supermod.cookiecraft.creativetab.CookiecraftCreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class ItemMagicCookie extends Item {
    public ItemMagicCookie(){
        this.setCreativeTab(CookiecraftCreativeTabs.tabCookiecraft);
    }

    @Override
    public boolean onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ) {
        if (!playerIn.func_175151_a(pos, side, stack))
        {
            return false;
        }
        else
        {
            if (CookiecraftBlocks.cookieBlock != worldIn.getBlockState(pos).getBlock() && worldIn.getBlockState(pos).getBlock().isSolidFullCube()){
                worldIn.setBlockState(pos, CookiecraftBlocks.cookieBlock.getDefaultState());
                return true;
            }
            else if (CookiecraftBlocks.cookieBlock == worldIn.getBlockState(pos).getBlock() && Blocks.air != worldIn.getBlockState(pos).getBlock()){
                worldIn.setBlockState(pos.offset(side), CookiecraftBlocks.activator.getDefaultState());
            }

            stack.damageItem(1, playerIn);
            return true;
        }
    }
}
