package com.gigavoid.supermod;

import com.gigavoid.supermod.Recipies.SuperRecipie;
import com.gigavoid.supermod.biome.SuperBiomes;
import com.gigavoid.supermod.block.SuperBlocks;
import com.gigavoid.supermod.gui.SuperGuiHandler;
import com.gigavoid.supermod.item.SuperItems;
import com.gigavoid.supermod.keybinding.SuperKeyBinds;
import com.gigavoid.supermod.worldgen.SuperWorldGens;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = SuperMod.MODID, version = SuperMod.VERSION)
public class SuperMod
{
    @Mod.Instance("supermod")
    public static SuperMod instance;

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
        SuperWorldGens.initializeWorldGens();
        SuperKeyBinds.registerKeybinds();
        SuperGuiHandler.initializeGuis();
        SuperRecipie.initializeRecipes();
    }
}
