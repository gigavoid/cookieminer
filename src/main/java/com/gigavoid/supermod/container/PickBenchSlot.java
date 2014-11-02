package com.gigavoid.supermod.container;

import com.gigavoid.supermod.progpick.ProgPickUpgrades;
import com.gigavoid.supermod.item.pickaxe.ProgressivePickaxeItem;
import com.gigavoid.supermod.tileentity.PickBenchTileEntity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

/**
 * Created by ineentho on 2014-10-25.
 */
public class PickBenchSlot extends Slot {

    private SlotType slotType;
    private PickBenchTileEntity tileEntity;

    enum SlotType {
        Pick, Mat
    }

    public PickBenchSlot(SlotType slotType, PickBenchTileEntity tileEntity, int i, int x, int y) {
        super(tileEntity, i, x, y);
        this.slotType = slotType;
        this.tileEntity = tileEntity;
    }

    @Override
    public boolean isItemValid(ItemStack stack) {
        if(slotType == SlotType.Mat)
            return ProgPickUpgrades.isUpgradeable(stack);

        return stack.getItem() instanceof ProgressivePickaxeItem && ProgPickUpgrades.isFullExp(stack);
    }
}
