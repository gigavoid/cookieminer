package com.gigavoid.supermod.gui;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ineentho on 2014-10-25.
 */
public class ProgPickUpgrades {
    public static Map<Item, String> upgrades = new HashMap<Item, String>();

    static {
        upgrades.put(Items.emerald, "speed");
        upgrades.put(Items.diamond, "horRadius");
        upgrades.put(Item.getItemFromBlock(Blocks.diamond_block), "vertRadius");
    }

    public static boolean isUpgradeable(Item item) {
        for(Item key : upgrades.keySet()) {
            if(key == item)
                return true;
        }
        return false;
    }

    public static void upgrade(ItemStack stack, Item item) {
        String upgradeWith = upgrades.get(item);



    }

    public static void setProperty(ItemStack stack, String prop, int val) {
        if (!stack.hasTagCompound())
        {
            stack.setTagCompound(new NBTTagCompound());
        }
        stack.getTagCompound().setInteger(prop, val);
    }

    public static int getProperty(ItemStack stack, String prop, int def) {
        return stack.getTagCompound() != null && stack.getTagCompound().hasKey(prop) ? stack.getTagCompound().getInteger(prop) : def;
    }


    // Level
    public static void setLevel(ItemStack stack, int level) {
        setProperty(stack, "level", level);
    }

    public static int getLevel(ItemStack stack) {
        return getProperty(stack, "level", 1);
    }


    // Exp
    public static int getExp(ItemStack stack) {
        return getProperty(stack, "exp", 0);
    }

    public static void setExp(ItemStack stack,int amm) {
        setProperty(stack, "exp", amm);
    }

    public static boolean isFullExp(ItemStack stack) {
        return getExp(stack) >= getMaxExp(stack);
    }

    public static int getMaxExp(ItemStack stack) {
        return 20;
    }

    public static void giveExp(ItemStack stack, int amm) {
        setExp(stack, getExp(stack) + amm);
    }

}
