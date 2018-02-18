package com.gigavoid.supermod.cookiecraft.tileentity;

import com.gigavoid.supermod.cookiecraft.block.BlockCookieCrafter;
import com.gigavoid.supermod.cookiecraft.cookie.CookieBlock;
import com.gigavoid.supermod.cookiecraft.cookie.CookieNetwork;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TileEntityTrashBaker extends TileEntityCookieGenerator implements IInventory, ITickable {
    private ItemStack inv;

    private static Map<Item, Double> trashToCookies;

    static {
        trashToCookies = new HashMap<Item, Double>();
        trashToCookies.put(Item.getItemFromBlock(Blocks.COBBLESTONE), 1/64d);
        trashToCookies.put(Item.getItemFromBlock(Blocks.NETHERRACK), 1/64d);
        trashToCookies.put(Item.getItemFromBlock(Blocks.DIRT), 1/64d);

        trashToCookies.put(Item.getItemFromBlock(Blocks.STONE), 1/32d);
        trashToCookies.put(Item.getItemFromBlock(Blocks.SAND), 1/32d);
        trashToCookies.put(Item.getItemFromBlock(Blocks.SANDSTONE), 1/32d);

        trashToCookies.put(Item.getItemFromBlock(Blocks.GRAVEL), 1/16d);

        trashToCookies.put(Items.ROTTEN_FLESH, 1/2d);
    }


    @Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);
        readInventoryCompound(compound);
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        saveInventoryCompound(compound);
        super.writeToNBT(compound);
        return compound;
    }

    public boolean tick() {
        if (inv != null && inv.getCount() >= 1) {
            double reward = trashToCookies.get(inv.getItem());
            CookieBlock crafter = CookieNetwork.getNetwork(getWorld(), getPos()).findCore();
            if (crafter == null) {
                return false;
            }

            decrStackSize(0, 1);
            TileEntityCookieCrafter tileEntity = BlockCookieCrafter.getTileEntity(getWorld(), crafter.getPos());
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
        world.scheduleUpdate(pos, getBlockType(), 2);
        return index == 0 ? inv : null;
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

        inv = stack;
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

    private void readInventoryCompound(NBTTagCompound tagCompound) {
        inv = new ItemStack(tagCompound.getCompoundTag("inv"));
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
        if (this.world != null && !this.world.isRemote)
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
        List list = worldIn.getEntitiesWithinAABB(EntityItem.class, new AxisAlignedBB(pos.getX(), pos.getY(), pos.getZ(), pos.getX() + 1.0D, pos.getY() + 1.1D, pos.getZ() + 1.0D), null);
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
            ItemStack itemstack = p_145898_1_.getItem().copy();
            ItemStack itemstack1 = transferToInventory(itemstack);

            if (itemstack1 != null && itemstack1.getCount() != 0)
            {
                p_145898_1_.setItem(itemstack1);
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

        if (!trashToCookies.containsKey(itemstack.getItem()))
            return itemstack;

        int toTake = 0;

        if (inv == null) {
            toTake = Math.min(itemstack.getCount(), itemstack.getMaxStackSize());
        } else if (inv.getItem() == itemstack.getItem() && inv.getCount() < inv.getMaxStackSize()) {
           toTake =  Math.min(itemstack.getCount(), inv.getMaxStackSize() - inv.getCount());
        }


        if (inv == null) {
            inv = new ItemStack(itemstack.getItem(), toTake);
        } else {
            inv.setCount(inv.getCount() + toTake);
        }
        itemstack.setCount(itemstack.getCount() - toTake);

        return itemstack;
    }
}
