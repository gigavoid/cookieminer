package com.gigavoid.supermod.cookiecraft.tileentity;

import com.gigavoid.supermod.cookiecraft.block.BlockCookieCrafter;
import com.gigavoid.supermod.cookiecraft.cookie.CookieNetwork;
import net.minecraft.block.Block;
import net.minecraft.command.IEntitySelector;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.server.gui.IUpdatePlayerListBox;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityHopper;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IChatComponent;
import net.minecraft.world.World;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TileEntityTrashBaker extends TileEntity implements IInventory, IUpdatePlayerListBox {
    private ItemStack inv;

    private static Map<Item, Integer> trashToCookies;

    static {
        trashToCookies = new HashMap<Item, Integer>();
        trashToCookies.put(Item.getItemFromBlock(Blocks.cobblestone), 1);
        trashToCookies.put(Item.getItemFromBlock(Blocks.stone), 1);
        trashToCookies.put(Items.rotten_flesh, 2);
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

    public boolean tick() {
        if (inv != null && inv.stackSize >= 1) {
            int reward = trashToCookies.get(inv.getItem());
            decrStackSize(0, 1);
            TileEntityCookieCrafter tileEntity = BlockCookieCrafter.getTileEntity(getWorld(), CookieNetwork.getNetwork(getWorld(), getPos()).findCrafter().getPos());
            tileEntity.setLeftover(tileEntity.getLeftover() + reward);
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
        return trashToCookies.containsKey(stack.getItem());
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
        if (inv != null)
            inv.writeToNBT(invCompound);
        tagCompound.setTag("inv", invCompound);
    }

    /***
     * Stuff copied from TileEntityHopper
     */

    public void update()
    {
        if (this.worldObj != null && !this.worldObj.isRemote)
        {
            grabFloatingItems();

            tick();
        }
    }

    private void grabFloatingItems() {
        EntityItem entityitem = func_145897_a(getWorld(), getPos());

        if (entityitem != null)
        {
            func_145898_a(entityitem);
        }
    }

    private EntityItem func_145897_a(World worldIn, BlockPos pos)
    {
        List list = worldIn.func_175647_a(EntityItem.class, new AxisAlignedBB(pos.getX(), pos.getY(), pos.getZ(), pos.getX() + 2.0D, pos.getY() + 2.0D, pos.getZ() + 2.0D), IEntitySelector.selectAnything);
        return list.size() > 0 ? (EntityItem)list.get(0) : null;
    }

    private boolean func_145898_a(EntityItem p_145898_1_)
    {
        boolean flag = false;

        if (p_145898_1_ == null)
        {
            return false;
        }
        else
        {
            ItemStack itemstack = p_145898_1_.getEntityItem().copy();
            ItemStack itemstack1 = transferToInventory(itemstack);

            if (itemstack1 != null && itemstack1.stackSize != 0)
            {
                p_145898_1_.setEntityItemStack(itemstack1);
            }
            else
            {
                flag = true;
                p_145898_1_.setDead();
            }

            return flag;
        }
    }

    private ItemStack transferToInventory(ItemStack itemstack) {

        int toTake = 0;

        if (inv == null) {
            toTake = Math.min(itemstack.stackSize, itemstack.getMaxStackSize());
        } else if (inv.getItem() == itemstack.getItem() && inv.stackSize < inv.getMaxStackSize()) {
           toTake =  Math.min(itemstack.stackSize, inv.getMaxStackSize() - inv.stackSize);
        }


        if (inv == null) {
            inv = new ItemStack(itemstack.getItem(), toTake);
        } else {
            inv.stackSize += toTake;
        }
        itemstack.stackSize -= toTake;

        return itemstack;
    }
}
