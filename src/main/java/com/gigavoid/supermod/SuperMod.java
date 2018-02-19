package com.gigavoid.supermod;

import com.gigavoid.supermod.common.module.ModuleLoader;
import com.gigavoid.supermod.cookiecraft.ModuleCookiecraft;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = SuperMod.MODID, name = SuperMod.MODNAME, version = SuperMod.VERSION, dependencies = "required-after:Forge@[11.16.0.1865,)", useMetadata = true)
public class SuperMod
{
    @Mod.Instance("supermod")
    public static SuperMod instance;
    public static final String MODID = "supermod";
    public static final String MODNAME = "Supermod - Cookiecraft";
    public static final String VERSION = "1.1";

    private ModuleLoader moduleLoader = new ModuleLoader();
    
    public SuperMod() {
        moduleLoader.registerModule(new ModuleCookiecraft());
    }

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event){
        moduleLoader.preInit(event);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
        moduleLoader.init(event);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        moduleLoader.postInit(event);
    }
}
