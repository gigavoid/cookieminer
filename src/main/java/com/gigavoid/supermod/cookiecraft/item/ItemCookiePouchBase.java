package com.gigavoid.supermod.cookiecraft.item;

import com.gigavoid.supermod.cookiecraft.creativetab.CookiecraftCreativeTabs;
import com.gigavoid.supermod.cookiecraft.util.CookieNumber;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

import java.util.List;

public abstract class ItemCookiePouchBase extends Item implements ICookieStorageItem {
	private static final String PROP_COOKIES = "cookies";

	public ItemCookiePouchBase() {
		this.setCreativeTab(CookiecraftCreativeTabs.tabCookiecraft);
		this.setMaxStackSize(1);
	}

	@Override
	public boolean showDurabilityBar(ItemStack stack) {
		return true;
	}

	@Override
	public double getDurabilityForDisplay(ItemStack stack) {
		return 1 - getCookies(stack) / (double)getMaxStorage();
	}

	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List tooltip, boolean advanced) {
		tooltip.add(String.format("Stored Cookies: %s/%s", CookieNumber.doubleToString(getCookies(stack)), CookieNumber.doubleToString(getMaxStorage())));
	}


	public void setCookies(ItemStack stack, long cookies) {
		setLong(stack, PROP_COOKIES, cookies);
	}

	public long getCookies(ItemStack stack) {
		return getLong(stack, PROP_COOKIES, 0);
	}


	private void setLong(ItemStack stack, String key, long val) {
		if (!stack.hasTagCompound())
		{
			stack.setTagCompound(new NBTTagCompound());
		}
		stack.getTagCompound().setLong(key, val);
	}

	private long getLong(ItemStack stack, String key, long def) {
		return stack.getTagCompound() != null && stack.getTagCompound().hasKey(key) ? stack.getTagCompound().getLong(key) : def;
	}

	public long getStorageCap(ItemStack stack) {
		return ((ICookieStorageItem)stack.getItem()).getMaxStorage();
	}

	public long takeCookies(ItemStack stack, long transferSpeed) {
		long cookiesToTake = Math.min(transferSpeed, getCookies(stack));
		setCookies(stack, getCookies(stack) - cookiesToTake);
		return cookiesToTake;
	}

	public boolean isFull(ItemStack stack) {
		return getStorageCap(stack) <= getCookies(stack);
	}

	public void addCookies(ItemStack stack, long toTake) {
		setCookies(stack, getCookies(stack) + toTake);
	}
}
