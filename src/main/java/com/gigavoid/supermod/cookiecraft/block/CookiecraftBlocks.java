package com.gigavoid.supermod.cookiecraft.block;

import com.gigavoid.supermod.common.Register;

public class CookiecraftBlocks {
    public static final BlockCookieCrafter cookieCrafter = new BlockCookieCrafter();
    public static final BlockPortalCookiecraft portalCookiecraft = new BlockPortalCookiecraft();
    public static final BlockCookieBlock cookieBlock = new BlockCookieBlock();
    public static final BlockCookieDoughCollector cookieDoughCollector = new BlockCookieDoughCollector();
    public static final BlockBurntCookieBlock burntCookieBlock = new BlockBurntCookieBlock();
    public static final BlockPortalConnector portalConnector = new BlockPortalConnector();
    public static final BlockCookieStorage cookieStorage = new BlockCookieStorage();
    public static final BlockCoockiePortalActivator activator = new BlockCoockiePortalActivator();
    public static final CheatBlock cb = new CheatBlock();

    public static void initializeBlocks(Register register) {
        register.registerBlock(cookieCrafter, "cookie_crafter");
        register.registerBlock(portalCookiecraft, "cookie_portal");
        register.registerBlock(cookieBlock, "cookie_block");
        register.registerBlock(cookieDoughCollector, "cookie_dough_collector");
        register.registerBlock(burntCookieBlock, "burnt_cookie_block");
        register.registerBlock(portalConnector, "portal_connector");
        register.registerBlock(cookieStorage, "cookie_storage");
        register.registerBlock(activator, "cp_activator");
        register.registerBlock(cb, "cb");
    }
}
