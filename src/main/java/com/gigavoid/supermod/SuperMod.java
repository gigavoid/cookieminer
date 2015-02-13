package com.gigavoid.supermod;

import com.gigavoid.supermod.ropeway.RopewayModule;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = SuperMod.MODID, version = SuperMod.VERSION)
public class SuperMod
{
    @Mod.Instance("supermod")
    public static SuperMod instance;
    public static final String MODID = "supermod";
    public static final String VERSION = "1.0";
    
    public static final RopewayModule ropeway = new RopewayModule();

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event){
        ropeway.preInit();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
        ropeway.init();
    }
}
