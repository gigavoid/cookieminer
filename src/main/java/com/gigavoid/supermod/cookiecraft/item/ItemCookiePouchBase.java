package com.gigavoid.supermod.cookiecraft.item;

import com.gigavoid.supermod.cookiecraft.cookie.CookieStorageItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.List;

public abstract class ItemCookiePouchBase extends Item implements ICookieStorageItem {

	@Override
	public boolean showDurabilityBar(ItemStack stack) {
		return true;
	}

	@Override
	public double getDurabilityForDisplay(ItemStack stack) {
		CookieStorageItem storage = new CookieStorageItem(stack);
		return 1 - storage.getCookies() / (double)getMaxStorage();
	}

	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List tooltip, boolean advanced) {
		CookieStorageItem storage = new CookieStorageItem(stack);
		tooltip.add("Stored Cookies: " + storage.getCookies() + "/" + getMaxStorage());
	}
}
