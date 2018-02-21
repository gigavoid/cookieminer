package com.gigavoid.supermod.cookiecraft.item;

import com.gigavoid.supermod.SuperMod;
import com.gigavoid.supermod.cookiecraft.ModuleCookiecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CookieItemBase extends Item{
    protected String name;

    public CookieItemBase(String name) {
        this.name = name;
        setUnlocalizedName(name);
        setRegistryName(name);
    }

    public void registerItemModel() {
        ModuleCookiecraft.proxy.registerItemRenderer(this, 0, SuperMod.MODID + ":" + name);
    }

    @Override
    public CookieItemBase setCreativeTab(CreativeTabs tab) {
        super.setCreativeTab(tab);
        return this;
    }
}
