package com.gigavoid.supermod.cookiecraft.tileentity;

import com.gigavoid.supermod.cookiecraft.cookie.CookieNetwork;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IChatComponent;
import net.minecraftforge.common.util.Constants;

public class TileEntityCookieGenerator extends TileEntity implements IInventory {
    private ItemStack[] inv;

    public TileEntityCookieGenerator() {
        inv = new ItemStack[4];
    }

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);
        readInventoryCompound(compound);
    }

    @Override
    public void writeToNBT(NBTTagCompound compound) {
        saveInventoryCompound(compound);
        super.writeToNBT(compound);
    }

    @Override
    public int getSizeInventory() {
        return inv.length;
    }

    @Override
    public ItemStack getStackInSlot(int index) {
        return inv[index];
    }

    @Override
    public ItemStack decrStackSize(int index, int amt) {
        ItemStack stack = getStackInSlot(index);

        if (stack != null) {
            if (stack.stackSize <= amt)
                setInventorySlotContents(index, null);
            else {
                stack = stack.splitStack(amt);
                if (stack.stackSize == 0)
                    setInventorySlotContents(index, null);
            }
        }

        return stack;
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int index) {
        ItemStack stack = getStackInSlot(index);
        if (stack != null)
            setInventorySlotContents(index, null);
        return stack;
    }

    @Override
    public void setInventorySlotContents(int slot, ItemStack stack) {
        inv[slot] = stack;
        if (stack != null && stack.stackSize > getInventoryStackLimit()) {
            stack.stackSize = getInventoryStackLimit();
        }
        CookieNetwork.getNetwork(worldObj, pos).updateNetwork();
    }

    @Override
    public int getInventoryStackLimit() {
        return 64;
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer playerIn) {
        return playerIn.getDistanceSq(pos) < 64;
    }

    @Override
    public void openInventory(EntityPlayer playerIn) {

    }

    @Override
    public void closeInventory(EntityPlayer playerIn) {

    }

    @Override
    public boolean isItemValidForSlot(int index, ItemStack stack) {
        return false;
    }

    public int getField(int id) {
        return 0;
    }

    public void setField(int id, int value) {

    }

    @Override
    public int getFieldCount() {
        return 0;
    }

    @Override
    public void clear() {
        for (int i = 0; i < inv.length; i++) {
            inv[i] = null;
        }
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public boolean hasCustomName() {
        return false;
    }

    @Override
    public IChatComponent getDisplayName() {
        return null;
    }

    private void readInventoryCompound(NBTTagCompound tagCompound) {
        NBTTagList tagList = tagCompound.getTagList("Inventory", Constants.NBT.TAG_COMPOUND);
        for (int i = 0; i < tagList.tagCount(); i++) {
            NBTTagCompound tag = tagList.getCompoundTagAt(i);
            byte slot = tag.getByte("Slot");
            if (slot >= 0 && slot < inv.length) {
                inv[slot] = ItemStack.loadItemStackFromNBT(tag);
            }
        }
    }

    private void saveInventoryCompound(NBTTagCompound tagCompound) {
        NBTTagList itemList = new NBTTagList();
        for (int i = 0; i < inv.length; i++) {
            ItemStack stack = inv[i];
            if (stack != null) {
                NBTTagCompound tag = new NBTTagCompound();
                tag.setByte("Slot", (byte) i);
                stack.writeToNBT(tag);
                itemList.appendTag(tag);
            }
        }
        tagCompound.setTag("Inventory", itemList);
    }

    public ItemStack[] getUpgrades() {
        return inv;
    }
}