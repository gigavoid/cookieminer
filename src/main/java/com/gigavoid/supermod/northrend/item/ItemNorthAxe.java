package com.gigavoid.supermod.northrend.item;

import com.gigavoid.supermod.northrend.creativetab.NorthrendCreativeTabs;
import net.minecraft.item.ItemAxe;

public class ItemNorthAxe extends ItemAxe {
    public ItemNorthAxe() {
        super(ToolMaterial.EMERALD);
        this.setCreativeTab(NorthrendCreativeTabs.tabNorthrend);
    }
}
