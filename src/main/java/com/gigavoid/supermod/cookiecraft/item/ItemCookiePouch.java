package com.gigavoid.supermod.cookiecraft.item;


public class ItemCookiePouch extends ItemCookiePouchBase {
	private long storage;

	public ItemCookiePouch(long storage) {
		this.storage = storage;
	}

	@Override
	public long getMaxStorage() {
		return storage;
	}

}
