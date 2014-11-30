package com.gigavoid.supermod.item.misc;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

public class MagicEnderEyeItem extends Item {
    public MagicEnderEyeItem(){
        super();
        maxStackSize = 16;
        setCreativeTab(CreativeTabs.tabMisc);
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player)
    {
        if (player.getCurrentEquippedItem() != null && player.getCurrentEquippedItem().getItem() == this)
        {
            BlockPos playerPos = player.getPosition();
            createExplosion(world, null, playerPos.getX(), playerPos.getY(), playerPos.getZ(), 2.0f, true);
            itemStack.stackSize -= 1;
        }
        return itemStack;
    }

    public Explosion createExplosion(World world, Entity p_72876_1_, double p_72876_2_, double p_72876_4_, double p_72876_6_, float p_72876_8_, boolean p_72876_9_)
    {
        return world.newExplosion(p_72876_1_, p_72876_2_, p_72876_4_, p_72876_6_, p_72876_8_, true, p_72876_9_);
    }
}