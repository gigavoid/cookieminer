package com.gigavoid.supermod.bettertools.item;


import com.gigavoid.supermod.common.Register;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

public class BetterToolsItems {
    public static final ItemPickaxeAxe obsidianPickaxeAxe = new ItemPickaxeAxe();
    public static final ItemIronStick ironStick = new ItemIronStick();
    public static final ItemPickaxeShovel obsidianPickaxeShovel = new ItemPickaxeShovel();

    public static void initializeItems(FMLInitializationEvent event, Register register){
        register.registerItem(obsidianPickaxeAxe, "obsidian_pickaxeaxe", event);
        register.registerItem(ironStick, "iron_stick", event);
        register.registerItem(obsidianPickaxeShovel, "obsidian_pickaxeshovel", event);
    }
}