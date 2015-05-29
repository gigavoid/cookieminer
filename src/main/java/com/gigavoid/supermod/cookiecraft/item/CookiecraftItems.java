package com.gigavoid.supermod.cookiecraft.item;

import com.gigavoid.supermod.common.Register;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

public class CookiecraftItems {
    public static final ItemMagicCookie magicCookie = new ItemMagicCookie();
    public static final ItemCookieBox cookieBox = new ItemCookieBox();
    public static final ItemCookieDough cookieDough = new ItemCookieDough();

    public static final ItemCookieGear cookieGear0 = new ItemCookieGear(0);
    public static final ItemCookieGear cookieGear1 = new ItemCookieGear(1);
    public static final ItemCookieGear cookieGear2 = new ItemCookieGear(2);
    public static final ItemCookieGear cookieGear3 = new ItemCookieGear(3);
    public static final ItemCookieGear cookieGear4 = new ItemCookieGear(4);

    public static void registerItems(Register register, FMLInitializationEvent event){
        register.registerItem(magicCookie, "cookie_magic", event);
        register.registerItem(cookieBox, "cookie_box", event);
        register.registerItem(cookieDough, "cookie_dough", event);

        register.registerItem(cookieGear0, "cookie_gear_0", event);
        register.registerItem(cookieGear1, "cookie_gear_1", event);
        register.registerItem(cookieGear2, "cookie_gear_2", event);
        register.registerItem(cookieGear3, "cookie_gear_3", event);
        register.registerItem(cookieGear4, "cookie_gear_4", event);
    }
}
