package com.gigavoid.supermod.bettertools.item;


import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import static com.gigavoid.supermod.common.Register.registerItem;

/**
 * Created by Lukas on 2015-02-14.
 */
public class BetterToolsItems {
    public static final ItemPickaxeAxe obsidianPickaxeAxe = new ItemPickaxeAxe();
    public static final ItemIronStick ironStick = new ItemIronStick();
    public static void initializeItems(FMLInitializationEvent event){
        registerItem(obsidianPickaxeAxe, "obsidian_pickaxeaxe", event);
        registerItem(ironStick, "iron_stick", event);
    }
}