package com.example.supermod;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;

@Mod(modid = SuperMod.MODID, version = SuperMod.VERSION)
public class SuperMod
{
    public static final String MODID = "The Super Mod";
    public static final String VERSION = "1.0";
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {

    }
}
