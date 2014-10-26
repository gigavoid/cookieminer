package com.gigavoid.supermod.item.misc;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

public class MagicEnderEyeItem extends Item {
    public MagicEnderEyeItem(){
        super();
        maxStackSize = 16;
        setCreativeTab(CreativeTabs.tabMisc);
        setTextureName("supermod:magic_ender_eye");
    }

    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player)
    {
        if (player.getCurrentEquippedItem() != null && player.getCurrentEquippedItem().getItem() == this)
        {
            createExplosion(world, null, player.getPosition(0).xCoord, player.getPosition(0).yCoord, player.getPosition(0).zCoord, 2.0f, true);
            itemStack.stackSize -= 1;
        }
        return itemStack;
    }

    public Explosion createExplosion(World world, Entity p_72876_1_, double p_72876_2_, double p_72876_4_, double p_72876_6_, float p_72876_8_, boolean p_72876_9_)
    {
        return world.newExplosion(p_72876_1_, p_72876_2_, p_72876_4_, p_72876_6_, p_72876_8_, true, p_72876_9_);
    }
}