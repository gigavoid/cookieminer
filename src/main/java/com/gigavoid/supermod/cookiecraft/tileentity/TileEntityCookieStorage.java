package com.gigavoid.supermod.cookiecraft.tileentity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IChatComponent;
import net.minecraftforge.common.util.Constants;

public class TileEntityCookieStorage extends TileEntity implements IInventory{
    private long cookies;
	private ItemStack[] inv;

	public TileEntityCookieStorage() {
		inv = new ItemStack[2];
	}

	@Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);
        cookies = compound.getLong("Cookies");
		readInventoryCompound(compound);
    }

    @Override
    public void writeToNBT(NBTTagCompound compound) {
        compound.setDouble("Cookies", cookies);
		saveInventoryCompount(compound);
        super.writeToNBT(compound);
    }

    public void addCookies(long cookies) {
        setCookies(this.cookies + cookies);
        worldObj.markBlockForUpdate(pos);
    }

    public void setCookies(long cookies) {
        this.cookies = cookies;
        worldObj.markBlockForUpdate(pos);
    }

    public long getCookies() {
        return cookies;
    }

    @Override
    public Packet getDescriptionPacket() {
        NBTTagCompound compound = new NBTTagCompound();
        compound.setLong("Cookies", cookies);
        return new S35PacketUpdateTileEntity(pos, 1, compound);
    }

    @Override
    public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt) {
        NBTTagCompound compound = pkt.getNbtCompound();
        cookies = compound.getLong("Cookies");
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
		inv[slot] = stack;
		if (stack != null && stack.stackSize > getInventoryStackLimit()) {
			stack.stackSize = getInventoryStackLimit();
		}
	}

	@Override
	public int getInventoryStackLimit() {
		return 1;
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

	public int getField(int id)
	{
		return 0;
	}

	public void setField(int id, int value)
	{

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
		NBTTagList tagList = tagCompound.getTagList("Inventory", Constants.NBT.TAG_COMPOUND);
		for (int i = 0; i < tagList.tagCount(); i++) {
			NBTTagCompound tag = tagList.getCompoundTagAt(i);
			byte slot = tag.getByte("Slot");
			if (slot >= 0 && slot < inv.length) {
				inv[slot] = ItemStack.loadItemStackFromNBT(tag);
			}
		}
	}

	private void saveInventoryCompount(NBTTagCompound tagCompound) {
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
