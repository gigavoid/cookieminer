package com.gigavoid.supermod.cookiecraft.item;

import net.minecraft.item.ItemStack;

public interface ICookieStorageItem {
	long getMaxStorage(ItemStack stack);
	boolean canAddCookies(ItemStack stack);
}
