package com.gigavoid.supermod.northrend.item;

import com.gigavoid.supermod.common.Register;
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

    public static void registerItems(FMLInitializationEvent e, Register register){
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
    }
}
