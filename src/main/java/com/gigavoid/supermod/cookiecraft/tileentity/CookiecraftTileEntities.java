package com.gigavoid.supermod.cookiecraft.tileentity;

import net.minecraftforge.fml.common.registry.GameRegistry;

public class CookiecraftTileEntities {
    public static void registerTileEntities() {
        GameRegistry.registerTileEntity(TileEntityCookieCrafter.class, "cookie_crafter");
        GameRegistry.registerTileEntity(TileEntityCookieStorage.class, "cookie_storage");
        GameRegistry.registerTileEntity(TileEntityMoonlightReflector.class, "moonlight_reflector");
        GameRegistry.registerTileEntity(TileEntityCactusMasher.class, "cactus_masher");
        GameRegistry.registerTileEntity(TileEntityTrashBaker.class, "trash_baker");
        GameRegistry.registerTileEntity(TileEntityCookieAccelerator.class, "cookie_accelerator");
        GameRegistry.registerTileEntity(TileEntitySlimeCompressor.class, "slime_compressor");
        GameRegistry.registerTileEntity(TileEntityCookieGenerator.class, "cookie_generic_generator");
        GameRegistry.registerTileEntity(TileEntityBakingTable.class, "baking_table");
    }
}
