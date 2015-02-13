package com.gigavoid.supermod.ropeway.block;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

/**
 * Created by Henrik on 2015-02-13.
 */
public class CreativeTabRopeway extends CreativeTabs{

    public CreativeTabRopeway() {
        super("ropewayTab");
    }

    @Override
    public Item getTabIconItem() {
        return Items.baked_potato;
    }
}
