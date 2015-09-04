package com.gigavoid.supermod.cookiecraft.item;

import com.gigavoid.supermod.cookiecraft.creativetab.CookiecraftCreativeTabs;
import net.minecraft.item.Item;

public class ItemCookiePouch extends ItemCookiePouchBase {
	private long storage;

	public ItemCookiePouch(long storage) {
		this.storage = storage;
		this.setCreativeTab(CookiecraftCreativeTabs.tabCookiecraft);
		this.setMaxStackSize(1);
	}

	@Override
	public long getMaxStorage() {
		return storage;
	}

}
