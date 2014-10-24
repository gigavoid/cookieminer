package com.gigavoid.supermod.item.pickaxe;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
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
                ItemStack newPickaxe = createNewPickaxe(itemStack);
                player.inventory.setInventorySlotContents(player.inventory.currentItem, newPickaxe);
            }
        }

        return true;
    }

    public int getLevel(ItemStack stack) {
        return stack.getTagCompound() != null && stack.getTagCompound().hasKey("level") ? stack.getTagCompound().getInteger("level") : 1;
    }

    public abstract ItemStack createNewPickaxe(ItemStack oldPick);

    protected void setLevel(ItemStack newPick, int level) {
        if (!newPick.hasTagCompound())
        {
            newPick.setTagCompound(new NBTTagCompound());
        }
        newPick.getTagCompound().setInteger("level", level);
    }

    @Override
    public float getDigSpeed(ItemStack stack, Block block, int meta) {
        return super.getDigSpeed(stack, block, meta) * getSpeedMultiplier(stack);
    }

    @Override
    public String getItemStackDisplayName(ItemStack stack) {
        return super.getItemStackDisplayName(stack) + " (Level " + getLevel(stack) + ")";
    }

    public float getSpeedMultiplier(ItemStack stack) {
        return (float) (getLevel(stack) * 1.1);
    }
}