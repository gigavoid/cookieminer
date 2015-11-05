package com.gigavoid.supermod.cookiecraft.item;

import com.gigavoid.supermod.cookiecraft.block.BlockCookieBlock;
import com.gigavoid.supermod.cookiecraft.block.BlockCookiePortalCookiecraft;
import com.gigavoid.supermod.cookiecraft.block.CookiecraftBlocks;
import com.gigavoid.supermod.cookiecraft.creativetab.CookiecraftCreativeTabs;
import net.minecraft.block.Block;
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
        this.setMaxDamage(16);
    }

    @Override
    public boolean hasEffect(ItemStack par1ItemStack){
        return true;
    }

    @Override
    public boolean onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ) {
        if (!playerIn.canPlayerEdit(pos, side, stack))
        {
            return false;
        }
        else
        {
            if (BlockCookieBlock.instance != worldIn.getBlockState(pos).getBlock() && (worldIn.getBlockState(pos).getBlock() == Blocks.sand || worldIn.getBlockState(pos).getBlock() == Blocks.gravel
                || worldIn.getBlockState(pos).getBlock() == Blocks.cobblestone || worldIn.getBlockState(pos).getBlock() == Blocks.netherrack || worldIn.getBlockState(pos).getBlock() == Blocks.grass
                || worldIn.getBlockState(pos).getBlock() == Blocks.sandstone || worldIn.getBlockState(pos).getBlock() == Blocks.dirt || worldIn.getBlockState(pos).getBlock() == Blocks.stone))
            {
                worldIn.setBlockState(pos, BlockCookieBlock.instance.getDefaultState());
                stack.damageItem(1, playerIn);
            }
            else if (BlockCookieBlock.instance == worldIn.getBlockState(pos).getBlock() && Blocks.air != worldIn.getBlockState(pos).getBlock()){
                if (BlockCookiePortalCookiecraft.instance.func_176548_d(worldIn, pos.offset(side))) {
                    stack.damageItem(1, playerIn);
                }
            }

            return true;
        }
    }
}
