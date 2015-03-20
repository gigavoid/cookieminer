package com.gigavoid.supermod.cookiecraft;

import com.gigavoid.supermod.common.module.Module;
import com.gigavoid.supermod.cookiecraft.block.CookiecraftBlocks;
import com.gigavoid.supermod.cookiecraft.tileentity.CookiecraftTileEntities;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ModuleCookiecraft extends Module{

    @Override
    public void preInit(FMLPreInitializationEvent e) {

    }

    @Override
    public void init(FMLInitializationEvent e) {
        CookiecraftBlocks.initializeBlocks(getRegister());
        CookiecraftTileEntities.registerTileEntities();
    }
}
