package com.gigavoid.supermod.cookiecraft.item;

import com.gigavoid.supermod.cookiecraft.creativetab.CookiecraftCreativeTabs;
import com.gigavoid.supermod.cookiecraft.upgrade.MultiplicativeBoost;
import net.minecraft.item.Item;

public class ItemFlatCPSUpgrade extends CookieItemBase implements IItemCookieUpgrade {
    private final double cps;

    public ItemFlatCPSUpgrade(String name, double cps) {
        super(name);
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
