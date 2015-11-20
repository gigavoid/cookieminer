package com.gigavoid.supermod.cookiecraft.item;

import com.gigavoid.supermod.common.Register;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

public class CookiecraftItems {
    public static final ItemMagicCookie magicCookie = new ItemMagicCookie();
    public static final ItemCookieDough cookieDough = new ItemCookieDough();
    public static final ItemCookieGemMixture cookieGemMixture = new ItemCookieGemMixture();
    public static final ItemCookieGemMixtureIngot cookieGemMixtureIngot = new ItemCookieGemMixtureIngot();

    public static final ItemCookieGear cookieGear0 = new ItemCookieGear(0);
    public static final ItemCookieGear cookieGear1 = new ItemCookieGear(1);
    public static final ItemCookieGear cookieGear2 = new ItemCookieGear(2);
    public static final ItemCookieGear cookieGear3 = new ItemCookieGear(3);
    public static final ItemCookieGear cookieGear4 = new ItemCookieGear(4);

    public static final ItemCookiePouch leatherCookiePouch = new ItemCookiePouch(64);
    public static final ItemCookiePouch woodenCookiePouch = new ItemCookiePouch(256);
    public static final ItemCookiePouch stoneCookiePouch = new ItemCookiePouch(2048);
    public static final ItemCookiePouch ironCookiePouch = new ItemCookiePouch(131072);
    public static final ItemCookiePouch goldenCookiePouch = new ItemCookiePouch(33554432);
    public static final ItemCookiePouch diamondCookiePouch = new ItemCookiePouch(536870912);
    public static final ItemCookiePouch emeraldCookiePouch = new ItemCookiePouch(68719476736L);
    public static final ItemInfiniteCookiePouch infiniteCookiePouch = new ItemInfiniteCookiePouch();
    public static final ItemCookiePouchOverflow overflowCookiePouch = new ItemCookiePouchOverflow();



    public static void registerItems(Register register, FMLInitializationEvent event){
        register.registerItem(magicCookie, "cookie_magic", event);
        register.registerItem(cookieDough, "cookie_dough", event);
        register.registerItem(cookieGemMixture, "cookie_gem_mixture", event);
        register.registerItem(cookieGemMixtureIngot, "cookie_gem_mixture_ingot", event);

        /*register.registerItem(cookieGear0, "cookie_gear_0", event);
        register.registerItem(cookieGear1, "cookie_gear_1", event);
        register.registerItem(cookieGear2, "cookie_gear_2", event);
        register.registerItem(cookieGear3, "cookie_gear_3", event);
        register.registerItem(cookieGear4, "cookie_gear_4", event);*/

        register.registerItem(leatherCookiePouch, "cookie_pouch_leather", event);
        register.registerItem(woodenCookiePouch, "cookie_pouch_wood", event);
        register.registerItem(stoneCookiePouch, "cookie_pouch_stone", event);
        register.registerItem(ironCookiePouch, "cookie_pouch_iron", event);
        register.registerItem(goldenCookiePouch, "cookie_pouch_gold", event);
        register.registerItem(diamondCookiePouch, "cookie_pouch_diamond", event);
        register.registerItem(emeraldCookiePouch, "cookie_pouch_emerald", event);
        register.registerItem(infiniteCookiePouch, "cookie_pouch_infinite", event);
        register.registerItem(overflowCookiePouch, "cookie_pouch_overflow", event);
    }
}
