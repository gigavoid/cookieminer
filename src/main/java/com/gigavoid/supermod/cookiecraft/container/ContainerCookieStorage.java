package com.gigavoid.supermod.cookiecraft.container;

import com.gigavoid.supermod.cookiecraft.tileentity.TileEntityCookieStorage;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotFurnaceFuel;
import net.minecraft.inventory.SlotFurnaceOutput;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.tileentity.TileEntityFurnace;

public class ContainerCookieStorage extends Container {
private TileEntityCookieStorage tileEntity;

	public ContainerCookieStorage(InventoryPlayer playerInventory, TileEntityCookieStorage tileEntity) {

		this.tileEntity = tileEntity;

		this.addSlotToContainer(new SlotCookieStorage(tileEntity, 0, 32, 16, SlotCookieStorage.SlotType.OUTPUT));
		this.addSlotToContainer(new SlotCookieStorage(tileEntity, 1, 32, 52, SlotCookieStorage.SlotType.INPUT));
		this.addSlotToContainer(new SlotCookieStorage(tileEntity, 2, 11, 16, SlotCookieStorage.SlotType.SINGLE_OUTPUT));

		bindPlayerInventory(playerInventory);
	}

	@Override
	public boolean canInteractWith(EntityPlayer playerIn) {
		return tileEntity.isUsableByPlayer(playerIn);
	}

	private void bindPlayerInventory(InventoryPlayer inventoryPlayer) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 9; j++) {
				addSlotToContainer(new Slot(inventoryPlayer, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
			}
		}

		for (int i = 0; i < 9; i++) {
			addSlotToContainer(new Slot(inventoryPlayer, i, 8 + i * 18, 142));
		}
	}

	@Override
	public ItemStack transferStackInSlot(EntityPlayer playerIn, int index) {
		ItemStack itemstack = null;
		Slot slot = (Slot)this.inventorySlots.get(index);

		if (slot != null && slot.getHasStack())
		{
			ItemStack stack = slot.getStack();
			itemstack = stack.copy();

			if (!this.mergeItemStack(stack, 2, 38, true))
			{
				return null;
			}

			if (stack.getCount() == 0)
			{
				slot.putStack(null);
			}
			else
			{
				slot.onSlotChanged();
			}

			if (stack.getCount() == itemstack.getCount())
			{
				return null;
			}

			slot.onTake(playerIn, stack);
		}

		return itemstack;
	}
}
