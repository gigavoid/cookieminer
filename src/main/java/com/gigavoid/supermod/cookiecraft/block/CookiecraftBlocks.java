package com.gigavoid.supermod.cookiecraft.block;

import com.gigavoid.supermod.common.Register;

public class CookiecraftBlocks {
    public static final BlockCookieCrafter cookieCrafter = new BlockCookieCrafter();
    public static final BlockPortalCookiecraft portalCookiecraft = new BlockPortalCookiecraft();
    public static final BlockCookieBlock cookieBlock = new BlockCookieBlock();
    public static final BlockCookieDoughCollector cookieDoughCollector = new BlockCookieDoughCollector();
    public static final BlockBurntCookieBlock burntCookieBlock = new BlockBurntCookieBlock();
    public static final BlockPortalConnector portalConnector = new BlockPortalConnector();
    public static final BlockCookieLavaConverter lavaConverter = new BlockCookieLavaConverter();
    public static final BlockCookieMoonlightReflector monlightReflector = new BlockCookieMoonlightReflector();
    public static final BlockCookieStorage cookieStorage = new BlockCookieStorage();
    public static final BlockCookiePortalActivator activator = new BlockCookiePortalActivator();
    public static final BlockCookiePipe pipe = new BlockCookiePipe();
    public static final BlockCactusMasher cactusMasher = new BlockCactusMasher();
    public static final BlockCocoaCircuit cocoaCircuit = new BlockCocoaCircuit();
    public static final BlockCookieFarm cookieFarm = new BlockCookieFarm();
    public static final BlockCookieSteamer cookieSteamer = new BlockCookieSteamer();

    public static void initializeBlocks(Register register) {
        register.registerBlock(cookieCrafter, "cookie_crafter");
        register.registerBlock(portalCookiecraft, "cookie_portal");
        register.registerBlock(cookieBlock, "cookie_block");
        register.registerBlock(cookieDoughCollector, "cookie_dough_collector");
        register.registerBlock(burntCookieBlock, "cookie_burnt_block");
        register.registerBlock(portalConnector, "cookie_portal_connector");
        register.registerBlock(lavaConverter, "cookie_lava_converter");
        register.registerBlock(monlightReflector, "cookie_moonlight_reflector");
        register.registerBlock(cookieStorage, "cookie_storage");
        register.registerBlock(activator, "cookie_portal_activator");
        register.registerBlock(pipe, "cookie_pipe");
        register.registerBlock(cactusMasher, "cactus_masher");
        register.registerBlock(cocoaCircuit, "cocoa_circuit");
        register.registerBlock(cookieFarm, "cookie_farm");
        register.registerBlock(cookieSteamer, "cookie_steamer");
    }
}
