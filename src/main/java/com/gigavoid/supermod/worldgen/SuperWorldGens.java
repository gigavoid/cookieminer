package com.gigavoid.supermod.worldgen;


import com.gigavoid.supermod.decorator.SuperDecorator;
import cpw.mods.fml.common.registry.GameRegistry;

public class SuperWorldGens {

    public static void initializeWorldGens(){

        GameRegistry.registerWorldGenerator(new SuperWorldGenOre(), 13);
        GameRegistry.registerWorldGenerator(new SuperWorldGenTrees(), 14);
    }
}
