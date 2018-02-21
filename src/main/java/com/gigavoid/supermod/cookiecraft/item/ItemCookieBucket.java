package com.gigavoid.supermod.cookiecraft.item;

import com.gigavoid.supermod.cookiecraft.creativetab.CookiecraftCreativeTabs;
import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBucket;

public class ItemCookieBucket extends CookieBucketItemBase {
    public ItemCookieBucket(String name, Block containedBlock) {
        super(name, containedBlock);
        this.setContainerItem(Items.BUCKET);
        this.setCreativeTab(CookiecraftCreativeTabs.tabCookiecraft);
    }
}
