package com.gigavoid.supermod.cookiecraft.tileentity;

import com.gigavoid.supermod.cookiecraft.block.ICookieStorageBlock;
import com.gigavoid.supermod.cookiecraft.item.ItemCookiePouchBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.Constants;

public class TileEntityCookieStorage extends TileEntity implements IInventory{
	public static final String NBT_COOKIES = "Cookies";
    private long cookies;
	private ItemStack[] inv;

	public TileEntityCookieStorage() {
		inv = new ItemStack[3];
	}

	@Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);
        setCookies(compound.getLong(NBT_COOKIES));
		readInventoryCompound(compound);
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        compound.setLong(NBT_COOKIES, cookies);
		saveInventoryCompound(compound);
        super.writeToNBT(compound);
		return compound;
	}

    public void addCookies(long cookies) {
        setCookies(this.cookies + cookies);

		if (world != null) {
			//TODO: Update?
		}
    }

    public void setCookies(long cookies) {
		long oldCookies = this.cookies;
        this.cookies = cookies;

		if (oldCookies != cookies) {
			updateOutputCookieStack();

			if (world != null) {
			    //TODO: Update?
			}
		}
    }

    public long getCookies() {
        return cookies;
    }

	@Override
	public NBTTagCompound getUpdateTag() {
		NBTTagCompound tag = super.getUpdateTag();
		tag.setLong(NBT_COOKIES, cookies);
		return tag;
	}

    @Override
    public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity pkt) {
        NBTTagCompound compound = pkt.getNbtCompound();
        setCookies(compound.getLong(NBT_COOKIES));
    }

	@Override
	public int getSizeInventory() {
		return inv.length;
	}

	@Override
	public boolean isEmpty() {
	    return inv.length == 0;
	}

	@Override
	public ItemStack getStackInSlot(int index) {
		ItemStack stack = inv[index];
		return stack;
	}

	@Override
	public ItemStack decrStackSize(int index, int amt) {
		ItemStack stack = getStackInSlot(index);

		if(stack != null) {
			if (stack.getCount() <= amt)
				setInventorySlotContents(index, null);
			else {
				stack = stack.splitStack(amt);
				if(stack.getCount() == 0)
					setInventorySlotContents(index, null);
			}
		}


		if (index == 2) {
			removeCookies(amt);
		}



		return stack;
	}

	@Override
	public ItemStack removeStackFromSlot(int index) {
		ItemStack  stack = getStackInSlot(index);
		if(stack != null)
			setInventorySlotContents(index, null);
		return stack;
	}

	@Override
	public void setInventorySlotContents(int slot, ItemStack stack) {
		if (world != null) {
			world.scheduleUpdate(pos, getBlockType(), 2);
		}

		inv[slot] = stack;
		if (stack != null && stack.getCount() > getInventoryStackLimit()) {
			stack.setCount(getInventoryStackLimit());
		}
	}

	@Override
	public int getInventoryStackLimit() {
		return 64;
	}

	@Override
	public boolean isUsableByPlayer(EntityPlayer playerIn) {
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

	private void readInventoryCompound(NBTTagCompound tagCompound) {
		NBTTagList tagList = tagCompound.getTagList("Inventory", Constants.NBT.TAG_COMPOUND);
		for (int i = 0; i < tagList.tagCount(); i++) {
			NBTTagCompound tag = tagList.getCompoundTagAt(i);
			byte slot = tag.getByte("Slot");
			if (slot >= 0 && slot < inv.length) {
				inv[slot] = new ItemStack(tag);
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

	public boolean tick() {
		return updateUpperSlot() || updateLowerSlot();
	}

	/**
	 * Place cookies into the item in the slot
	 */
	private boolean updateUpperSlot() {
		ItemStack stackInSlot = getStackInSlot(0);
		if (stackInSlot == null) {
			// No item to put cookies in
			return false;
		}

		ItemCookiePouchBase cookiePouch = (ItemCookiePouchBase) stackInSlot.getItem();
		if (cookiePouch.isFull(stackInSlot)) {
			// The item is already filled with cookies
			return false;
		}

		ICookieStorageBlock storageBlock = (ICookieStorageBlock) getBlockType();
		long blocksInStorage = storageBlock.getCurrentStorage(world, pos);

		if (blocksInStorage <= 0) {
			// There are no cookies left in the block
			return false;
		}

		long wantToTake = getTransferSpeed();
		long availableInBlock = getCookies();
		long placeAvailable = cookiePouch.getMaxStorage(stackInSlot) - cookiePouch.getCookies(stackInSlot);

		long toTake = Math.min(wantToTake, Math.min(availableInBlock, placeAvailable));
		if (toTake == 0 || !cookiePouch.canAddCookies(stackInSlot)) {
			return false;
		}

		removeCookies(toTake);
		cookiePouch.addCookies(stackInSlot, toTake);

		return true;

	}

	private void removeCookies(long toTake) {
		setCookies(getCookies() - toTake);
	}

	/**
	 * Suck items out of the item in the slot
	 */
	private boolean updateLowerSlot() {
		ItemStack stackInSlot = getStackInSlot(1);

		ICookieStorageBlock storageBlock = (ICookieStorageBlock) getBlockType();
		long spaceLeft = storageBlock.getStorageCap() - getCookies();

		if (stackInSlot == null)
			// No item to draw cookies out of
			return false;

		if (stackInSlot.getItem() instanceof ItemCookiePouchBase) {
			ItemCookiePouchBase cookiePouch = (ItemCookiePouchBase) stackInSlot.getItem();

			if (cookiePouch.getCookies(stackInSlot) <= 0)
				// No more cookies to empty from the item
				return false;



			if (spaceLeft <= 0)
				// No more space to add the new cookies to
				return false;

			addCookies(cookiePouch.takeCookies(stackInSlot, getTransferSpeed()));

			if (cookiePouch.shouldDestroy(stackInSlot)) {
				inv[1] = null;
			}
		} else if (stackInSlot.getItem() == Items.COOKIE) {
			if (stackInSlot.getCount() < 1) {
				return false;
			}

			if (spaceLeft <= 0) {
				// Full
				return false;
			}

			addCookies(1);
			stackInSlot.setCount(stackInSlot.getCount() - 1);

			if (stackInSlot.getCount() == 0) {
				inv[1] = null;
			}
		}

		return true;
	}

	private long getTransferSpeed() {
		ICookieStorageBlock storageBlock = (ICookieStorageBlock) getBlockType();
		return storageBlock.getTransferSpeed();
	}

	private void updateOutputCookieStack() {
		if (cookies == 0) {
			setInventorySlotContents(2, null);
		} else {
			int stackSize = (int) Math.min(cookies, 64);
			setInventorySlotContents(2, new ItemStack(Items.COOKIE, stackSize));
		}
	}
}
