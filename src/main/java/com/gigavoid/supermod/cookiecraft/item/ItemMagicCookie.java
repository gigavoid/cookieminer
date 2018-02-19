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
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
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
    public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if (!player.canPlayerEdit(pos, facing, stack))
        {
            return EnumActionResult.FAIL;
        }
        else
        {
            if (BlockCookieBlock.instance != worldIn.getBlockState(pos).getBlock() && (worldIn.getBlockState(pos).getBlock() == Blocks.SAND || worldIn.getBlockState(pos).getBlock() == Blocks.GRASS
                    || worldIn.getBlockState(pos).getBlock() == Blocks.COBBLESTONE || worldIn.getBlockState(pos).getBlock() == Blocks.NETHERRACK || worldIn.getBlockState(pos).getBlock() == Blocks.GRAVEL
                    || worldIn.getBlockState(pos).getBlock() == Blocks.SANDSTONE || worldIn.getBlockState(pos).getBlock() == Blocks.DIRT || worldIn.getBlockState(pos).getBlock() == Blocks.STONE))
            {
                worldIn.setBlockState(pos, BlockCookieBlock.instance.getDefaultState());
                stack.damageItem(1, player);
            }
            else if (BlockCookieBlock.instance == worldIn.getBlockState(pos).getBlock() && Blocks.AIR != worldIn.getBlockState(pos).getBlock()){
                if (BlockCookiePortalCookiecraft.instance.func_176548_d(worldIn, pos.offset(facing))) {
                    stack.damageItem(1, player);
                }
            }

            return EnumActionResult.SUCCESS;
        }
    }
}
