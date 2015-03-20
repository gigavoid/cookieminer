package com.gigavoid.supermod.northrend.item;

import com.gigavoid.supermod.northrend.creativetab.NorthrendCreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemHoe;

public class ItemNorthHoe extends ItemHoe {
    public ItemNorthHoe() {
        super(ToolMaterial.EMERALD);
        this.setCreativeTab(NorthrendCreativeTabs.tabNorthrend);
    }
}
