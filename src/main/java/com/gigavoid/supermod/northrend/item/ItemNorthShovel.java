package com.gigavoid.supermod.northrend.item;

import com.gigavoid.supermod.northrend.creativetab.NorthrendCreativeTabs;
import net.minecraft.item.ItemSpade;

public class ItemNorthShovel extends ItemSpade {
    public ItemNorthShovel() {
        super(ToolMaterial.EMERALD);
        this.setCreativeTab(NorthrendCreativeTabs.tabNorthrend);
    }
}
