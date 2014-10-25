package com.gigavoid.supermod.gui;

import com.gigavoid.supermod.tileentity.PickBenchTileEntity;
import com.gigavoid.supermod.tileentity.VoidBenchTileEntity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotFurnace;
import net.minecraft.item.ItemStack;

/**
 * Created by ineentho on 2014-10-25.
 */
public class VoidBenchContainer extends Container {

    protected VoidBenchTileEntity tileEntity;

    public VoidBenchContainer(InventoryPlayer inventoryPlayer, VoidBenchTileEntity te){
        tileEntity = te;

        //the Slot constructor takes the IInventory and the slot number in that it binds to
        //and the x-y coordinates it resides on-screen

        addSlotToContainer(new PickBenchSlot(PickBenchSlot.SlotType.Mat, te, 1, 52, 35));
        addSlotToContainer(new SlotFurnace(inventoryPlayer.player, te, 2, 109, 35));

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