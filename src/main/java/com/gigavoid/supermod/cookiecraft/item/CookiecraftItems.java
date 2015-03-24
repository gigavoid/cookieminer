package com.gigavoid.supermod.cookiecraft.item;

import com.gigavoid.supermod.common.Register;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

/**
 * Created by Lukas on 2015-03-21.
 */
public class CookiecraftItems {
    public static final ItemMagicCookie magicCookie = new ItemMagicCookie();
    public static final ItemCookieBox cookieBox = new ItemCookieBox();
    public static final ItemCookieDough cookieDough = new ItemCookieDough();

    public static void registerItems(Register register, FMLInitializationEvent event){
        register.registerItem(magicCookie, "cookie_magic", event);
        register.registerItem(cookieBox, "cookie_box", event);
        register.registerItem(cookieDough, "cookie_dough", event);
    }
}
