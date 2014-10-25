package com.gigavoid.supermod;

import com.gigavoid.supermod.biome.SuperBiomes;
import com.gigavoid.supermod.block.SuperBlocks;
import com.gigavoid.supermod.item.SuperItems;
import com.gigavoid.supermod.keybinding.SuperKeyBinds;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = SuperMod.MODID, version = SuperMod.VERSION)
public class SuperMod
{
    public static final String MODID = "supermod";
    public static final String VERSION = "1.0";

    @EventHandler
    public void preInit(FMLPreInitializationEvent event){
        SuperBlocks.initializeBlocks();
        SuperItems.initializeItems();
        SuperBiomes.registerBiomes();
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        SuperKeyBinds.registerKeybinds();
    }
}
