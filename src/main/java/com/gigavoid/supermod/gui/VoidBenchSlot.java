package com.gigavoid.supermod.gui;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class VoidBenchSlot extends Slot {

    private SlotType slotType;

    enum SlotType {
        Pick, Mat
    }

    public VoidBenchSlot(SlotType slotType, IInventory inventory, int i, int x, int y) {
        super(inventory, i, x, y);
        this.slotType = slotType;
    }

    @Override
    public boolean isItemValid(ItemStack stack) {
       return Math.random() > .5;
    }
}
