package com.gigavoid.supermod;

import com.gigavoid.supermod.common.module.ModuleLoader;
import com.gigavoid.supermod.cookiecraft.ModuleCookiecraft;
import com.gigavoid.supermod.cookiecraft.item.CookiecraftItems;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.rmi.registry.Registry;

@Mod(modid = SuperMod.MODID, name = SuperMod.MODNAME, version = SuperMod.VERSION)
public class SuperMod
{
    public static final String MODID = "supermod";
    public static final String MODNAME = "Supermod - Cookieminer";
    public static final String VERSION = "1.1";

    @Mod.Instance(MODID)
    public static SuperMod instance;

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
