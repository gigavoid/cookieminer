package com.gigavoid.supermod.item.pickaxe;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public abstract class ProgressivePickaxeItem extends ItemPickaxe {
    protected ProgressivePickaxeItem(ToolMaterial material) {
        super(material);
    }

    @Override
    public boolean showDurabilityBar(ItemStack stack) {
        return true;
    }

    @Override
    public double getDurabilityForDisplay(ItemStack stack)
    {
        return 1 - (double)stack.getItemDamageForDisplay() / (double)stack.getMaxDamage();
    }

    @Override
    public boolean onBlockDestroyed(ItemStack itemStack, World p_150894_2_, Block p_150894_3_, int p_150894_4_, int p_150894_5_, int p_150894_6_, EntityLivingBase entityLivingBase) {
        super.onBlockDestroyed(itemStack, p_150894_2_, p_150894_3_, p_150894_4_, p_150894_5_, p_150894_6_, entityLivingBase);

        if(itemStack.getItemDamage() == itemStack.getMaxDamage()) {
            if(entityLivingBase instanceof EntityPlayer) {
                EntityPlayer player = (EntityPlayer) entityLivingBase;
                ItemStack newPickaxe = createNewPickaxe();
                player.inventory.setInventorySlotContents(player.inventory.currentItem, newPickaxe);
            }
        }

        return true;
    }

    public abstract ItemStack createNewPickaxe();
}