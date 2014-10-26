package com.gigavoid.supermod.container;

import com.gigavoid.supermod.item.SuperItems;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class VoidBenchSlot extends Slot {

    public VoidBenchSlot(IInventory inventory, int i, int x, int y) {
        super(inventory, i, x, y);
    }

    @Override
    public boolean isItemValid(ItemStack stack) {
        return stack.getItem() == SuperItems.emptyVoidStone;
    }
}
