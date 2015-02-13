package com.gigavoid.supermod.ropeway.creativetab;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by Henrik on 2015-02-13.
 */
public class RopewayCreativeTabs {
    public static final CreativeTabs tabBlock = new CreativeTabs("ropewayTab")
    {
        @Override
        public Item getTabIconItem() {
            return Items.baked_potato;
        }
    };
}
