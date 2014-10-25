package com.gigavoid.supermod.worldgen;


import cpw.mods.fml.common.registry.GameRegistry;

public class SuperWorldGens {

    public static void initializeWorldGens(){
        GameRegistry.registerWorldGenerator(new SuperWorldGenOre(), 13);
    }
}
