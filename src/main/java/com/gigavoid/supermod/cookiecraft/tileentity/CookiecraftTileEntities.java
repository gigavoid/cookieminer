package com.gigavoid.supermod.cookiecraft.tileentity;

import net.minecraftforge.fml.common.registry.GameRegistry;

public class CookiecraftTileEntities {
    public static void registerTileEntities() {
        GameRegistry.registerTileEntity(TileEntityCookieCrafter.class, "cookie_crafter");
        GameRegistry.registerTileEntity(TileEntityCookieStorage.class, "cookie_storage");
        GameRegistry.registerTileEntity(TileEntityMoonlightReflector.class, "moonlight_reflector");
    }
}
