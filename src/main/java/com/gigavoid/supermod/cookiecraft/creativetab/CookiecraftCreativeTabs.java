package com.gigavoid.supermod.cookiecraft.creativetab;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class CookiecraftCreativeTabs {
    public static final CreativeTabs tabCookiecraft = new CreativeTabs("cookiecraftTab")
    {
        @Override
        public Item getTabIconItem() {
            return Items.cookie;
        }
    };
}
