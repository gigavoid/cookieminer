package com.gigavoid.supermod.northrend.creativetab;

import com.gigavoid.supermod.northrend.item.NorthrendItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class NorthrendCreativeTabs {
    public static final CreativeTabs tabNorthrend = new CreativeTabs("northrendTab")
    {
        @Override
        public Item getTabIconItem() {
            return NorthrendItems.frostGem;
        }
    };
}
