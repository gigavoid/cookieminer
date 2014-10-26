package com.gigavoid.supermod.item.material;

import net.minecraft.block.BlockTNT;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

/**
 * Created by Rasmus on 2014-10-26.
 */
public class MagicEnderEyeItem extends Item {
    public MagicEnderEyeItem(){
        super();
        maxStackSize = 16;
        setCreativeTab(CreativeTabs.tabMisc);
        setTextureName("supermod:magic_ender_eye");
        setMaxDamage(1);
    }

    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player)
    {
        if (player.getCurrentEquippedItem() != null && player.getCurrentEquippedItem().getItem() == this)
        {
            world.createExplosion(null, (int)player.getPosition(0).xCoord, (int)player.getPosition(0).yCoord, (int)player.getPosition(0).zCoord, 4.0f, true);
        }
        return new ItemStack(this, itemStack.stackSize - 1);
    }
}
