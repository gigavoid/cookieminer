package com.gigavoid.supermod.cookiecraft.worldgen;

import com.gigavoid.supermod.common.Register;

public class CookiecraftWorldGens {
    public static void initializeWorldGens(Register register){
        register.registerWorldGenerator(new CookiecraftWorldGenOre(), 13);
    }
}
