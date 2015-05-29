package com.gigavoid.supermod.northrend.item;

import com.gigavoid.supermod.northrend.block.NorthrendBlocks;
import com.gigavoid.supermod.northrend.creativetab.NorthrendCreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class ItemNorthPearl extends Item {
    public ItemNorthPearl(){
        this.maxStackSize = 1;
        this.setMaxDamage(128);
        this.setCreativeTab(NorthrendCreativeTabs.tabNorthrend);
    }

    @Override
    public boolean onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ) {
        pos = pos.offset(side);

        if (!playerIn.func_175151_a(pos, side, stack))
        {
            return false;
        }
        else
        {
            if (Blocks.water == worldIn.getBlockState(pos).getBlock() || Blocks.flowing_water == worldIn.getBlockState(pos).getBlock()){
                worldIn.setBlockState(pos, Blocks.ice.getDefaultState());
                return true;
            }
            else if (Blocks.lava == worldIn.getBlockState(pos).getBlock() || Blocks.flowing_lava == worldIn.getBlockState(pos).getBlock()){
                worldIn.setBlockState(pos, Blocks.obsidian.getDefaultState());
                return true;
            }
            else if (Blocks.air == worldIn.getBlockState(pos).getBlock()){
                worldIn.setBlockState(pos, NorthrendBlocks.snowLayerMod.getDefaultState());
                return true;
            }

            stack.damageItem(1, playerIn);
            return true;
        }
    }
}
