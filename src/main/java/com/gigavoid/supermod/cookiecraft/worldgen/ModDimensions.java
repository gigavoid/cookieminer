package com.gigavoid.supermod.cookiecraft.worldgen;

import com.gigavoid.supermod.SuperMod;
import net.minecraft.world.DimensionType;
import net.minecraftforge.common.DimensionManager;

public class ModDimensions {
    public static DimensionType cookieverseDimensionType;

    public static void init() {
        registerDimensionTypes();
        registerDimensions();
    }

    private static void registerDimensions() {
        DimensionManager.registerDimension(1 /* TODO: Add from config */, cookieverseDimensionType);
    }

    private static void registerDimensionTypes() {
        cookieverseDimensionType = DimensionType.register(SuperMod.MODID, "_Cookieverse", 1 /* TODO: Add from config */, CookiecraftWorldProvider.class, false);
    }
}
