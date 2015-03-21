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
    public static ItemDragonbone dragonbone = new ItemDragonbone();
    public static ItemFrostGem frostGem = new ItemFrostGem();
    public static ItemMithrilIngot mithrilIngot = new ItemMithrilIngot();

    public static void registerItems(FMLInitializationEvent e, Register register){
        register.registerItem(dragonbonePickaxe, "dragonbone_pickaxe", e);
        register.registerItem(mithrilPickaxe, "mithril_pickaxe", e);
        register.registerItem(mithrilSword, "mithril_sword", e);
        register.registerItem(mithrilAxe, "mithril_axe", e);
        register.registerItem(mithrilHoe, "mithril_hoe", e);
        register.registerItem(mithrilShovel, "mithril_shovel", e);
        register.registerItem(dragonbone, "dragonbone", e);
        register.registerItem(frostGem, "frost_gem", e);
        register.registerItem(mithrilIngot, "mithril_ingot", e);
    }
}
