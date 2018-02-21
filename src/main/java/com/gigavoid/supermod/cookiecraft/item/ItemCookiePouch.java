package com.gigavoid.supermod.cookiecraft.item;


import net.minecraft.item.ItemStack;

public class ItemCookiePouch extends ItemCookiePouchBase {
	private long storage;

	public ItemCookiePouch(String name, long storage) {
		super(name);
		this.storage = storage;
	}

	@Override
	public long getMaxStorage(ItemStack stack) {
		return storage;
	}

	@Override
	public boolean canAddCookies(ItemStack stack) {
		return true;
	}

	public long getStorage() {
		return storage;
	}
}
