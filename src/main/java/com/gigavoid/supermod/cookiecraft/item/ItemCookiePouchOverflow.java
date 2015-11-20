package com.gigavoid.supermod.cookiecraft.item;

import net.minecraft.item.ItemStack;

/***
 * Overflow pouch which you only can remove items from and disappears when out of cookies.
 */
public class ItemCookiePouchOverflow extends ItemCookiePouchBase{
    private static final String PROP_START_COOKIES = "cookies";


    @Override
    public long getMaxStorage(ItemStack stack) {
        return getLong(stack, PROP_START_COOKIES, 64);
    }

    @Override
    public boolean canAddCookies(ItemStack stack) {
        return false;
    }

    @Override
    public void addCookies(ItemStack stack, long toTake) {
        System.err.println("WARNING: Tried to add cookies to an overflow pouch");
    }

    /***
     * Should be run on each new Overflow Pouch that's created
     */
    public void initialize(ItemStack stack, int startingCookies) {
        setLong(stack, PROP_START_COOKIES, startingCookies);
    }
}
