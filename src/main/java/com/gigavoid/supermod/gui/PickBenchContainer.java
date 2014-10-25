package com.gigavoid.supermod.gui;

import com.gigavoid.supermod.tileentity.PickBenchTileEntity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotFurnace;
import net.minecraft.item.ItemStack;

/**
 * Created by ineentho on 2014-10-25.
 */
public class PickBenchContainer extends Container {

    protected PickBenchTileEntity tileEntity;

    public PickBenchContainer (InventoryPlayer inventoryPlayer, PickBenchTileEntity te){
        tileEntity = te;

        // Pickaxe slot
        addSlotToContainer(new PickBenchSlot(PickBenchSlot.SlotType.Pick, te, 0, 56, 17));

        // Upgrade material slot
        addSlotToContainer(new PickBenchSlot(PickBenchSlot.SlotType.Mat, te, 1, 56, 53));

        // Output slot
        addSlotToContainer(new SlotFurnace(inventoryPlayer.player, te, 2, 116,35));

        //commonly used vanilla code that adds the player's inventory
        bindPlayerInventory(inventoryPlayer);
    }





    protected void bindPlayerInventory(InventoryPlayer inventoryPlayer) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 9; j++) {
                addSlotToContainer(new Slot(inventoryPlayer, j + i * 9 + 9,
                        8 + j * 18, 84 + i * 18));
            }
        }

        for (int i = 0; i < 9; i++) {
            addSlotToContainer(new Slot(inventoryPlayer, i, 8 + i * 18, 142));
        }
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer player, int slot) {
        return null;
    }

    @Override
    public boolean canInteractWith(EntityPlayer player) {
        return tileEntity.isUseableByPlayer(player);
    }
}