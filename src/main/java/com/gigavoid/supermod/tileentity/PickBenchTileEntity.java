package com.gigavoid.supermod.tileentity;

import com.gigavoid.supermod.progpick.ProgPickUpgrades;
import com.gigavoid.supermod.item.pickaxe.ProgressivePickaxeItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.Constants;


public class PickBenchTileEntity extends TileEntity implements IInventory {


    private ItemStack[] inv;

    public PickBenchTileEntity() {
        inv = new ItemStack[3];
    }

    @Override
    public int getSizeInventory() {
        return inv.length;
    }

    @Override
    public ItemStack getStackInSlot(int slot) {
        return inv[slot];
    }

    @Override
    public ItemStack decrStackSize(int slot, int amt) {
        ItemStack stack = getStackInSlot(slot);
        if(stack != null) {
            if (stack.stackSize <= amt)
                setInventorySlotContents(slot, null);
            else {
                stack = stack.splitStack(amt);
                if(stack.stackSize == 0)
                    setInventorySlotContents(slot, null);
            }
        }
        return stack;
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int slot) {
        ItemStack  stack = getStackInSlot(slot);
        if(stack != null)
            setInventorySlotContents(slot, null);
        return stack;

    }

    public boolean canUpgrade() {
        return inv[1] != null && ProgPickUpgrades.upgrades.get(inv[1].getItem()).reqLevel <= ProgPickUpgrades.getLevel(inv[1]);
    }

    public boolean isBothInputsFilled() {
        return inv[0] != null && inv[1] != null;
    }

    public String getErrorMessage() {
        return "Req level: " + ProgPickUpgrades.upgrades.get(inv[1].getItem()).reqLevel;
    }

    @Override
    public void setInventorySlotContents(int slot, ItemStack stack) {
        inv[slot] = stack;
        if (stack != null && stack.stackSize > getInventoryStackLimit()) {
            stack.stackSize = getInventoryStackLimit();
        }

        if (slot == 0 || slot == 1) {
            if (inv[0] != null && inv[0].getItem() instanceof ProgressivePickaxeItem &&
                    inv[1] != null) {

                inv[2] = inv[0].copy();


                ProgPickUpgrades.setExp(inv[2], 0);
                ProgPickUpgrades.setLevel(inv[2], ProgPickUpgrades.getLevel(inv[0]) + 1);
                ProgPickUpgrades.upgrade(inv[2], inv[1].getItem());

            } else {
                inv[2] = null;
            }
        } else {
            if (stack == null) {
                // Take out item from the output slot
                decrStackSize(0, 1);
                decrStackSize(1, 1);
            }
        }
    }

    @Override
    public String getInventoryName() {
        return "pickBenchTileEntity";
    }

    @Override
    public boolean hasCustomInventoryName() {
        return false;
    }

    @Override
    public int getInventoryStackLimit() {
        return 64;
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer player) {
        return worldObj.getTileEntity(xCoord, yCoord, zCoord) == this &&
                player.getDistanceSq(xCoord + 0.5, yCoord + 0.5, zCoord + 0.5) < 64;
    }

    @Override
    public void openInventory() {

    }

    @Override
    public void closeInventory() {

    }



    @Override
    public boolean isItemValidForSlot(int slot, ItemStack stack) {
        return false;
    }

    @Override
    public void readFromNBT(NBTTagCompound tagCompound) {
        super.readFromNBT(tagCompound);

        NBTTagList tagList = tagCompound.getTagList("Inventory", Constants.NBT.TAG_COMPOUND);
        for (int i = 0; i < tagList.tagCount(); i++) {
            NBTTagCompound tag = tagList.getCompoundTagAt(i);
            byte slot = tag.getByte("Slot");
            if (slot >= 0 && slot < inv.length) {
                inv[slot] = ItemStack.loadItemStackFromNBT(tag);
            }
        }
    }

    @Override
    public void writeToNBT(NBTTagCompound tagCompound) {
        super.writeToNBT(tagCompound);

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



}
