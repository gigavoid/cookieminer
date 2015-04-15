package com.gigavoid.supermod.northrend.item;

import com.gigavoid.supermod.common.Register;
import com.gigavoid.supermod.northrend.creativetab.NorthrendCreativeTabs;
import net.minecraft.item.ItemFood;
import net.minecraft.potion.Potion;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

public class NorthrendItems {
    public static ItemNorthPickaxe dragonbonePickaxe = new ItemNorthPickaxe();
    public static ItemNorthPickaxe mithrilPickaxe = new ItemNorthPickaxe();
    public static ItemNorthSword mithrilSword = new ItemNorthSword();
    public static ItemNorthAxe mithrilAxe = new ItemNorthAxe();
    public static ItemNorthHoe mithrilHoe = new ItemNorthHoe();
    public static ItemNorthShovel mithrilShovel = new ItemNorthShovel();
    public static ItemNorthDragonbone dragonbone = new ItemNorthDragonbone();
    public static ItemNorthFrostGem frostGem = new ItemNorthFrostGem();
    public static ItemNorthMithrilIngot mithrilIngot = new ItemNorthMithrilIngot();
    public static ItemNorthPearl northPearl = new ItemNorthPearl();
    public static ItemFood glaciemStem = new ItemFood(0, 0, false).setPotionEffect(Potion.poison.id, 20, 0, 1.0F);
    public static ItemFood boiledGlaciemStem = new ItemFood(5, 0.7F, false);

    public static void registerItems(FMLInitializationEvent e, Register register){
        glaciemStem.setCreativeTab(NorthrendCreativeTabs.tabNorthrend);
        boiledGlaciemStem.setCreativeTab(NorthrendCreativeTabs.tabNorthrend);

        register.registerItem(dragonbonePickaxe, "north_dragonbone_pickaxe", e);
        register.registerItem(mithrilPickaxe, "north_mithril_pickaxe", e);
        register.registerItem(mithrilSword, "north_mithril_sword", e);
        register.registerItem(mithrilAxe, "north_mithril_axe", e);
        register.registerItem(mithrilHoe, "north_mithril_hoe", e);
        register.registerItem(mithrilShovel, "north_mithril_shovel", e);
        register.registerItem(dragonbone, "north_dragonbone", e);
        register.registerItem(frostGem, "north_frost_gem", e);
        register.registerItem(mithrilIngot, "north_mithril_ingot", e);
        register.registerItem(northPearl, "north_pearl", e);
        register.registerItem(glaciemStem, "north_glaciem_stem", e);
        register.registerItem(boiledGlaciemStem, "north_glaciem_stem_boiled", e);
    }
}
