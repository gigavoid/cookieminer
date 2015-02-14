package com.gigavoid.supermod;

import com.gigavoid.supermod.bonus.ModuleBonus;
import com.gigavoid.supermod.common.module.ModuleLoader;
import com.gigavoid.supermod.northrend.ModuleNorthrend;
import com.gigavoid.supermod.ropeway.ModuleRopeway;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = SuperMod.MODID, version = SuperMod.VERSION)
public class SuperMod
{
    @Mod.Instance("supermod")
    public static SuperMod instance;
    public static final String MODID = "supermod";
    public static final String VERSION = "1.0";

    private ModuleLoader moduleLoader = new ModuleLoader();
    
    public SuperMod() {
        moduleLoader.registerModule(new ModuleRopeway());
        moduleLoader.registerModule(new ModuleNorthrend());
        moduleLoader.registerModule(new ModuleBonus());
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
