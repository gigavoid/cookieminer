package com.gigavoid.supermod.cookiecraft.item;

import com.gigavoid.supermod.cookiecraft.creativetab.CookiecraftCreativeTabs;
import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBucket;

public class ItemCookieBucket extends ItemBucket {
    public ItemCookieBucket(Block containedBlock) {
        super(containedBlock);
        this.setContainerItem(Items.bucket);
        this.setCreativeTab(CookiecraftCreativeTabs.tabCookiecraft);
    }
}
