package com.gigavoid.supermod.cookiecraft.recipe;

import com.gigavoid.supermod.cookiecraft.block.CookiecraftBlocks;
import com.gigavoid.supermod.cookiecraft.cookie.CookieStorageItem;
import com.gigavoid.supermod.cookiecraft.item.ICookieStorageItem;
import com.gigavoid.supermod.cookiecraft.item.ItemCookiePouchBase;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShapedCookieRecepie implements IRecipe{
    private final int cookiesRequired;
    private List<ItemStack> recipe;

    public ShapedCookieRecepie(int cookiesRequired, String shape1, String shape2, String shape3, Object ... args) {
        this.cookiesRequired = cookiesRequired;

        Map<String, ItemStack> letterMap = new HashMap<String, ItemStack>();

        String key = null;
        for(Object o : args) {
            if (key == null) {
                key = String.valueOf(o);
            } else {
                letterMap.put(key, (ItemStack) o);
                key = null;
            }
        }

        recipe = new ArrayList<ItemStack>();
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                String line;
                if (row == 0)
                    line = shape1;
                else if (row == 1)
                    line = shape2;
                else
                    line = shape3;

                String ch = String.valueOf(line.charAt(col));
                recipe.add(letterMap.get(ch));
            }
        }
    }

    @Override
    public boolean matches(InventoryCrafting ic, World worldIn) {
        for (int i = 0; i < recipe.size(); i++) {
            ItemStack itemStack = recipe.get(i);
            if (itemStack == null) {
                if (ic.getStackInSlot(i) != null) {
                    // There was an item in a slot that should be empty
                    return false;
                }
            }
            else if (itemStack.getItem() instanceof ItemCookiePouchBase) {
                if (!isCookieStorage(cookiesRequired, ic.getStackInSlot(i))) {
                    // Not enough cookies!
                    return false;
                }
            }
            else {
                if (!isItem(i, ic, itemStack.getItem())) {
                    // Wrong item was in the slot
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public ItemStack getCraftingResult(InventoryCrafting ic) {
        return new ItemStack(CookiecraftBlocks.lavaConverter );
    }

    @Override
    public int getRecipeSize() {
        return 9;
    }

    @Override
    public ItemStack getRecipeOutput() {
        return null;
    }

    @Override
    public ItemStack[] func_179532_b(InventoryCrafting inv) {
        ItemStack stackInSlot = inv.getStackInSlot(4);
        CookieStorageItem storage = new CookieStorageItem(stackInSlot);
        storage.takeCookies(cookiesRequired);
        ItemStack[] ret = new ItemStack[inv.getSizeInventory()];
        for (int i = 0; i < ret.length; i++)
        {
            ret[i] = null;
        }
        ret[4] = stackInSlot;
        return ret;
    }

    private boolean isItem(int slot, InventoryCrafting ic, Item item) {
        return ic.getStackInSlot(slot) != null && ic.getStackInSlot(slot).getItem() == item;
    }

    private boolean isCookieStorage(int numCookies, ItemStack stackInSlot) {
        if (stackInSlot != null && stackInSlot.getItem() instanceof ICookieStorageItem) {
            CookieStorageItem storage = new CookieStorageItem(stackInSlot);
            return storage.getCookies() >= numCookies;
        }
        return false;
    }

}
