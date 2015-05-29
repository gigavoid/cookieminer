package com.gigavoid.supermod.cookiecraft.container;

import com.gigavoid.supermod.cookiecraft.item.ICookieStorageItem;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotCookieStorage extends Slot {

	public SlotCookieStorage(IInventory inv, int x, int y, int z) {
		super(inv, x, y, z);
	}

	@Override
	public boolean isItemValid(ItemStack stack) {
		return stack.getItem() instanceof ICookieStorageItem;
	}
}
