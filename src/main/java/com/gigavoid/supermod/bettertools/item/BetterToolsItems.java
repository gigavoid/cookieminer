package com.gigavoid.supermod.bettertools.item;

import static com.gigavoid.supermod.common.Register.registerItem;

/**
 * Created by Lukas on 2015-02-14.
 */
public class BetterToolsItems {
    public static final ItemPickaxeAxe pickaxeAxe = new ItemPickaxeAxe();
    public static void initializeItems(){
        registerItem(pickaxeAxe, "pickaxe_axe");
    }
}