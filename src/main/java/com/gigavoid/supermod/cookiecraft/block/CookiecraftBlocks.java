package com.gigavoid.supermod.cookiecraft.block;

import com.gigavoid.supermod.common.Register;

public class CookiecraftBlocks {
    public static final BlockCookieCrafter cookieCrafter = new BlockCookieCrafter();
    public static final BlockCookiePortalCookiecraft portalCookiecraft = new BlockCookiePortalCookiecraft();
    public static final BlockCookieBlock cookieBlock = new BlockCookieBlock();
    public static final BlockCookieDoughCollector cookieDoughCollector = new BlockCookieDoughCollector();
    public static final BlockCookieBurntCookieBlock burntCookieBlock = new BlockCookieBurntCookieBlock();
    public static final BlockCookiePortalConnector portalConnector = new BlockCookiePortalConnector();
    public static final BlockCookieLavaConverter lavaConverter = new BlockCookieLavaConverter();
    public static final BlockCookieMoonlightReflector monlightReflector = new BlockCookieMoonlightReflector();
    public static final BlockCookiePortalActivator activator = new BlockCookiePortalActivator();
    public static final BlockCookiePipe pipe = new BlockCookiePipe();
    public static final BlockCookieCactusMasher cactusMasher = new BlockCookieCactusMasher();
    public static final BlockCookieCocoaCircuit cocoaCircuit = new BlockCookieCocoaCircuit();
    public static final BlockCookieFarm cookieFarm = new BlockCookieFarm();
    public static final BlockCookieSteamer cookieSteamer = new BlockCookieSteamer();
    public static final BlockCookieVacuumOven vacuumOven = new BlockCookieVacuumOven();
    public static final BlockCookieIonChanneler ionChanneler = new BlockCookieIonChanneler();
    public static final BlockCookieTrashBaker trashBaker = new BlockCookieTrashBaker();

    public static final BlockCookieStorage cookieStorageWood = new BlockCookieStorage(256, 1);
    public static final BlockCookieStorage cookieStorageIron = new BlockCookieStorage(16384, 64);
    public static final BlockCookieStorage cookieStorageGold = new BlockCookieStorage(262144, 4096);
    public static final BlockCookieStorage cookieStorageDiamond = new BlockCookieStorage(200000000, 1000000);
    public static final BlockCookieStorage cookieStorageEnder = new BlockCookieStorage(68719476736L * 2, 100000000);

    // AcceleratorBlocks
    public static final BlockCookieAcceleratorControl cookieAcceleratorControl = new BlockCookieAcceleratorControl();
    public static final BlockCookieAcceleratorPart cookieAcceleratorWall = new BlockCookieAcceleratorPart();

    public static void initializeBlocks(Register register) {
        register.registerBlock(cookieCrafter, "cookie_crafter");
        register.registerBlock(portalCookiecraft, "cookie_portal");
        register.registerBlock(cookieBlock, "cookie_block");
        register.registerBlock(cookieDoughCollector, "cookie_dough_collector");
        register.registerBlock(burntCookieBlock, "cookie_burnt_block");
        register.registerBlock(portalConnector, "cookie_portal_connector");
        register.registerBlock(lavaConverter, "cookie_lava_converter");
        register.registerBlock(monlightReflector, "cookie_moonlight_reflector");
        register.registerBlock(activator, "cookie_portal_activator");
        register.registerBlock(pipe, "cookie_pipe");
        register.registerBlock(cactusMasher, "cookie_cactus_masher");
        register.registerBlock(cocoaCircuit, "cookie_cocoa_circuit");
        register.registerBlock(cookieFarm, "cookie_farm");
        register.registerBlock(cookieSteamer, "cookie_steamer");
        register.registerBlock(vacuumOven, "cookie_vacuum_oven");
        register.registerBlock(ionChanneler, "cookie_ion_channeler");
        register.registerBlock(trashBaker, "cookie_trash_baker");

        register.registerBlock(cookieStorageWood, "cookie_storage_wood");
        register.registerBlock(cookieStorageIron, "cookie_storage_iron");
        register.registerBlock(cookieStorageGold, "cookie_storage_gold");
        register.registerBlock(cookieStorageDiamond, "cookie_storage_diamond");
        register.registerBlock(cookieStorageEnder, "cookie_storage_ender");

        register.registerBlock(cookieAcceleratorControl, "cookie_accelerator_control");
        register.registerBlock(cookieAcceleratorWall, "cookie_accelerator_part");
    }
}
