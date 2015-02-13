package com.gigavoid.supermod.common.module;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * Created by Henrik on 2015-02-13.
*/
public abstract class Module {
    public void preInit(FMLPreInitializationEvent e) {} ;
    public void init(FMLInitializationEvent e) {};
    public void postInit(FMLPostInitializationEvent e) {};
}
