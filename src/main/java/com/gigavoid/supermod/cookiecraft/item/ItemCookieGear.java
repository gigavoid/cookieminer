package com.gigavoid.supermod.cookiecraft.item;

import com.gigavoid.supermod.cookiecraft.creativetab.CookiecraftCreativeTabs;
import net.minecraft.item.Item;

public class ItemCookieGear extends Item {
    private int tier = 0;

    public ItemCookieGear(int tier) {
        this.tier = tier;
        this.setCreativeTab(CookiecraftCreativeTabs.tabCookiecraft);
    }

    public int getTier(){return tier;}

    public void setTier(int tier){
        this.tier = tier;
    }
}
