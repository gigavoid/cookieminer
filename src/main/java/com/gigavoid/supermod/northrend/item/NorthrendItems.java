package com.gigavoid.supermod.northrend.item;

import com.gigavoid.supermod.common.Register;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

public class NorthrendItems {
    public static ItemDragonbonePickaxe dragonbonePickaxe = new ItemDragonbonePickaxe();
    public static ItemDragonbone dragonbone = new ItemDragonbone();
    public static ItemFrostGem frostGem = new ItemFrostGem();
    public static ItemMithrilIngot mithrilIngot = new ItemMithrilIngot();

    public static void registerItems(FMLInitializationEvent e, Register register){
        register.registerItem(dragonbonePickaxe, "dragonbone_pickaxe", e);
        register.registerItem(dragonbone, "dragonbone", e);
        register.registerItem(frostGem, "frost_gem", e);
        register.registerItem(mithrilIngot, "mithril_ingot", e);
    }
}
