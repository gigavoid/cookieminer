package com.gigavoid.supermod.cookiecraft.tileentity;

import com.gigavoid.supermod.cookiecraft.block.BlockCookieCrafter;
import com.gigavoid.supermod.cookiecraft.cookie.CookieBlock;
import com.gigavoid.supermod.cookiecraft.cookie.CookieNetwork;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IChatComponent;

public class TileEntityCactusMasher extends TileEntity implements IInventory {
    private ItemStack inv;

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

    /**
     * Convert 1 cactus into 1 cookie
     */
    public boolean tick() {
        if (inv != null && inv.stackSize >= 1) {
            CookieBlock crafter = CookieNetwork.getNetwork(getWorld(), getPos()).findCore();
            if (crafter == null) {
                return false;
            }

            decrStackSize(0, 1);
            TileEntityCookieCrafter tileEntity = BlockCookieCrafter.getTileEntity(getWorld(), crafter.getPos());
            tileEntity.setLeftover(tileEntity.getLeftover() + 1);
            return true;
        }
        return false;
    }

    @Override
    public int getSizeInventory() {
        return 1;
    }

    @Override
    public ItemStack getStackInSlot(int index) {
        worldObj.scheduleUpdate(pos, getBlockType(), 2);
        return index == 0 ? inv : null;
    }

    @Override
    public ItemStack decrStackSize(int index, int amt) {
        ItemStack stack = getStackInSlot(index);
        if(stack != null) {
            if (stack.stackSize <= amt)
                setInventorySlotContents(index, null);
            else {
                stack = stack.splitStack(amt);
                if(stack.stackSize == 0)
                    setInventorySlotContents(index, null);
            }
        }
        return stack;
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int index) {
        ItemStack  stack = getStackInSlot(index);
        if(stack != null)
            setInventorySlotContents(index, null);
        return stack;
    }

    @Override
    public void setInventorySlotContents(int slot, ItemStack stack) {

        inv = stack;
        if (stack != null && stack.stackSize > getInventoryStackLimit()) {
            stack.stackSize = getInventoryStackLimit();
        }
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
        return Block.getBlockFromItem(stack.getItem()) == Blocks.cactus;
    }

    @Override
    public int getField(int id) {
        return 0;
    }

    @Override
    public void setField(int id, int value) {

    }

    @Override
    public int getFieldCount() {
        return 0;
    }

    @Override
    public void clear() {

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
        inv = ItemStack.loadItemStackFromNBT(tagCompound.getCompoundTag("inv"));
    }

    private void saveInventoryCompound(NBTTagCompound tagCompound) {
        NBTTagCompound invCompound = new NBTTagCompound();
        if (inv != null) {
            inv.writeToNBT(invCompound);
        }
        tagCompound.setTag("inv", invCompound);
    }

}
