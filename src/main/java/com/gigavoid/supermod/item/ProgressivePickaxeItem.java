package com.gigavoid.supermod.item;

import com.gigavoid.supermod.item.SuperItems;
import cpw.mods.fml.client.config.GuiConfigEntries;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagByteArray;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

import java.util.List;

public class ProgressivePickaxeItem extends ItemPickaxe {
    private String material;
    private int level;

    public ProgressivePickaxeItem() {
        super(ToolMaterial.WOOD);
        setMaxDamage(4);
    }

    public void setToolLevel(int level) {
        this.level = level;

    }

    @Override
    public int getHarvestLevel(ItemStack stack, String toolClass) {
        return super.getHarvestLevel(stack, toolClass) == -1 ? -1 : 4;
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
                itemStack.setItemDamage(0);
                setLevel(itemStack, getLevel(itemStack) + 1);
            }
        }

        return true;
    }

    public int getLevel(ItemStack stack) {
        return stack.getTagCompound() != null && stack.getTagCompound().hasKey("level") ? stack.getTagCompound().getInteger("level") : 1;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getMaterial() {
        return material;
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer entityPlayer, List description, boolean par4) {
        description.add(EnumChatFormatting.GRAY + "Level " + getLevel(stack));
    }

    protected void setLevel(ItemStack stack, int level) {
        if (!stack.hasTagCompound())
        {
            stack.setTagCompound(new NBTTagCompound());
        }
        stack.getTagCompound().setInteger("level", level);

        Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("Your pickaxe just leveled to " + getLevel(stack) + "!"));

    }

    @Override
    public float getDigSpeed(ItemStack stack, Block block, int meta) {
        return super.getDigSpeed(stack, block, meta) * getSpeedMultiplier(stack);
    }

    @Override
    public String getItemStackDisplayName(ItemStack stack) {
        return "Progressive Pickaxe (Level " + getLevel(stack) + ")";
    }



    public float getSpeedMultiplier(ItemStack stack) {
        return (float) (getLevel(stack) * 1.1);
    }
}