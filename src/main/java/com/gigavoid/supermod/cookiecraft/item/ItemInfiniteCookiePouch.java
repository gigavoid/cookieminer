package com.gigavoid.supermod.cookiecraft.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

import java.util.List;

public class ItemInfiniteCookiePouch extends ItemCookiePouchBase {
    @Override
    public long getMaxStorage(ItemStack stack) {
        return Long.MAX_VALUE;
    }

    @Override
    public boolean canAddCookies(ItemStack stack) {
        return true;
    }

    @Override
    public boolean isFull(ItemStack stack) {
        return false;
    }

    @Override
    public long getCookies(ItemStack stack) {
        return getMaxStorage(stack) / 2;
    }

    @Override
    public void setCookies(ItemStack stack, long cookies) {

    }

    @Override
    public long takeCookies(ItemStack stack, long transferSpeed) {
        return transferSpeed;
    }

    @Override
    public void addCookies(ItemStack stack, long toTake) {

    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer playerIn, List tooltip, boolean advanced) {
        tooltip.add("Stored Cookies: Infinite");
    }

    @Override
    public boolean showDurabilityBar(ItemStack stack) {
        return false;
    }
}
