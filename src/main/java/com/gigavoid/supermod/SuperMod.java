package com.gigavoid.supermod;

import com.gigavoid.supermod.block.GenericBlock;
import com.gigavoid.supermod.block.SuperBlocks;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

@Mod(modid = SuperMod.MODID, version = SuperMod.VERSION)
public class SuperMod
{
    public static final String MODID = "supermod";
    public static final String VERSION = "1.0";

    public SuperBlocks sBlocks;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event){
        sBlocks.initializeBlocks();
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {

    }
}
