package com.gigavoid.supermod.cookiecraft.item;

import com.gigavoid.supermod.common.Register;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

/**
 * Created by Lukas on 2015-03-21.
 */
public class CookiecraftItems {
    public static final ItemCookieDough cookieDough = new ItemCookieDough();

    public static void initializeItems(FMLInitializationEvent e,Register register){
        register.registerItem(cookieDough, "cookie_dough", e);
    }
}