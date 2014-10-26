package com.gigavoid.supermod.item.material;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class EmptyVoidStoneItem extends Item {
    public EmptyVoidStoneItem(){
        super();
        setCreativeTab(CreativeTabs.tabMaterials);
        setTextureName("supermod:empty_void_stone");
    }
}
