package com.gigavoid.supermod.cookiecraft.block;

import com.gigavoid.supermod.SuperMod;
import com.gigavoid.supermod.cookiecraft.ModuleCookiecraft;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class CookieBlockBase extends Block {
    protected String name;

    public CookieBlockBase(String name, Material material) {
        super(material);
        this.name = name;
        setUnlocalizedName(name);
        setRegistryName(SuperMod.MODID + ":" + name);
    }

    public void registerItemModel(Item itemBlock) {
        ModuleCookiecraft.proxy.registerItemRenderer(itemBlock, 0, SuperMod.MODID + ":" + name);
    }

    public Item createItemBlock() {
        return new ItemBlock(this).setRegistryName(getRegistryName());
    }

    @Override
    public CookieBlockBase setCreativeTab(CreativeTabs tab) {
        super.setCreativeTab(tab);
        return this;
    }
}
