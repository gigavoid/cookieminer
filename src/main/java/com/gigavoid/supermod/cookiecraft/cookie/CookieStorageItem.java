package com.gigavoid.supermod.cookiecraft.cookie;

import com.gigavoid.supermod.cookiecraft.item.ICookieStorageItem;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class CookieStorageItem {
	private static final String PROP_COOKIES = "cookies";

	private ItemStack stack;

	public CookieStorageItem(ItemStack stack) {
		this.stack = stack;
	}

	public void setCookies(long cookies) {
		setLong(PROP_COOKIES, cookies);
	}

	public long getCookies() {
		return getLong(PROP_COOKIES, 0);
	}


	private void setLong(String key, long val) {
		if (!stack.hasTagCompound())
		{
			stack.setTagCompound(new NBTTagCompound());
		}
		stack.getTagCompound().setLong(key, val);
	}

	private long getLong(String key, long def) {
		return stack.getTagCompound() != null && stack.getTagCompound().hasKey(key) ? stack.getTagCompound().getLong(key) : def;
	}

	public long getTransferSpeed() {
		return ((ICookieStorageItem)stack.getItem()).getTransferSpeed();
	}

	public long getStorageCap() {
		return ((ICookieStorageItem)stack.getItem()).getMaxStorage();
	}

	public long takeCookies(long transferSpeed) {
		long cookiesToTake = Math.min(transferSpeed, getCookies());
		setCookies(getCookies() - cookiesToTake);
		return cookiesToTake;
	}

	public boolean isFull() {
		return getStorageCap() <= getCookies();
	}

	public void addCookies(long toTake) {
		setCookies(getCookies() + toTake);
	}
}
