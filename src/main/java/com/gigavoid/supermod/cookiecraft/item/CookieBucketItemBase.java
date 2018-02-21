package com.gigavoid.supermod.cookiecraft.item;

import com.gigavoid.supermod.cookiecraft.ModuleCookiecraft;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemBucket;

public class CookieBucketItemBase extends ItemBucket {
    protected String name;

    public CookieBucketItemBase(String name, Block containedBlock) {
        super(containedBlock);
        this.name = name;
        setUnlocalizedName(name);
        setRegistryName(name);
    }

    public void registerItemModel() {
        ModuleCookiecraft.proxy.registerItemRenderer(this, 0, name);
    }

    @Override
    public CookieBucketItemBase setCreativeTab(CreativeTabs tab) {
        super.setCreativeTab(tab);
        return this;
    }
}
