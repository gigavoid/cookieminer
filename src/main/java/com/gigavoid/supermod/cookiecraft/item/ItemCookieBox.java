package com.gigavoid.supermod.cookiecraft.item;

import com.gigavoid.supermod.cookiecraft.creativetab.CookiecraftCreativeTabs;
import com.gigavoid.supermod.cookiecraft.cookie.CookieStorageItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.List;

public class ItemCookieBox extends ItemCookieBoxBase {
	public ItemCookieBox() {
		this.setCreativeTab(CookiecraftCreativeTabs.tabCookiecraft);
	}

	@Override
	public long getMaxStorage() {
		return 1000;
	}
}
