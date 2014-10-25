package com.gigavoid.supermod.item;

import cpw.mods.fml.common.registry.GameRegistry;

public class SuperItems {

    public static final ProgressivePickaxeItem progressivePickaxe = new ProgressivePickaxeItem();

    public static void initializeItems() {
        GameRegistry.registerItem(progressivePickaxe, "progressivePickaxe");
    }
}
