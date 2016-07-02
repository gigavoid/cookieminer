package com.gigavoid.supermod.cookiecraft.container;

import com.gigavoid.supermod.cookiecraft.item.ICookieStorageItem;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotCookieStorage extends Slot {

	enum SlotType {
		INPUT, OUTPUT, SINGLE_OUTPUT
	}

	private final SlotType slotType;

	public SlotCookieStorage(IInventory inv, int x, int y, int z, SlotType slotType) {
		super(inv, x, y, z);

		this.slotType = slotType;
	}

	@Override
	public boolean isItemValid(ItemStack stack) {
		if ( this.slotType == SlotType.INPUT) {
			return stack.getItem() instanceof ICookieStorageItem || stack.getItem() == Items.cookie;
		} else if (this.slotType == SlotType.OUTPUT) {
			return stack.getItem() instanceof ICookieStorageItem;
		} else if (this.slotType == SlotType.SINGLE_OUTPUT) {
			return false;
		}

		return false;
	}
}
