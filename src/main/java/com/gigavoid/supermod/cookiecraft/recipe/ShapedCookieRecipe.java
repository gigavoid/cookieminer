package com.gigavoid.supermod.cookiecraft.recipe;

import com.gigavoid.supermod.cookiecraft.item.ICookieStorageItem;
import com.gigavoid.supermod.cookiecraft.item.ItemCookiePouchBase;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBucket;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShapedCookieRecipe implements IRecipe {
    private final long cookiesRequired;

    public ItemStack getResult() {
        return result;
    }

    public List<ItemStack> getRecipe() {
        return recipe;
    }

    public long getCookiesRequired() {
        return cookiesRequired;
    }

    public boolean isConsumeCookieItem() {
        return consumeCookieItem;
    }

    private List<ItemStack> recipe;
    private ItemStack result;
    private boolean consumeCookieItem;

    public ShapedCookieRecipe(ItemStack result, long cookiesRequired, boolean consumeCookieItem, String shape1, String shape2, String shape3, Object ... args) {
        this.cookiesRequired = cookiesRequired;
        this.result = result;
        this.consumeCookieItem = consumeCookieItem;

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
                if (consumeCookieItem) {
                    // It has to be the exact correct item

                    if (!isItem(i, ic, itemStack.getItem())) {
                        // Wrong item was in the slot
                        return false;
                    }
                }


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
        return result.copy();
    }

    @Override
    public boolean canFit(int width, int height) {
        return false;
    }

    @Override
    public ItemStack getRecipeOutput() {
        return null;
    }

    private boolean isItem(int slot, InventoryCrafting ic, Item item) {
        return ic.getStackInSlot(slot) != null && ic.getStackInSlot(slot).getItem() == item;
    }

    private boolean isCookieStorage(long numCookies, ItemStack stackInSlot) {
        if (stackInSlot != null && stackInSlot.getItem() instanceof ICookieStorageItem) {
            return ((ItemCookiePouchBase)stackInSlot.getItem()).getCookies(stackInSlot) >= numCookies;
        }
        return false;
    }

    @Override
    public IRecipe setRegistryName(ResourceLocation name) {
        return null;
    }

    @Nullable
    @Override
    public ResourceLocation getRegistryName() {
        return null;
    }

    @Override
    public Class<IRecipe> getRegistryType() {
        return null;
    }
}
