package com.gigavoid.supermod.cookiecraft.item;

import com.gigavoid.supermod.cookiecraft.creativetab.CookiecraftCreativeTabs;
import com.gigavoid.supermod.cookiecraft.upgrade.MultiplicativeBoost;
import net.minecraft.item.Item;

public class ItemFlatCPSUpgrade extends Item implements IItemCookieUpgrade {
    private final double cps;

    public ItemFlatCPSUpgrade(double cps) {
        setCreativeTab(CookiecraftCreativeTabs.tabCookiecraft);
        this.cps = cps;
    }

    @Override
    public double getFlatBoost() {
        return this.cps;
    }

    @Override
    public MultiplicativeBoost getMultiplicativeBoost() {
        return null;
    }
}
