package com.gigavoid.supermod.northrend.item;

import com.gigavoid.supermod.northrend.creativetab.NorthrendCreativeTabs;
import net.minecraft.item.ItemSword;

public class ItemNorthSword extends ItemSword {
    public ItemNorthSword(){
        super(ToolMaterial.EMERALD);
        this.setCreativeTab(NorthrendCreativeTabs.tabNorthrend);
    }
}
