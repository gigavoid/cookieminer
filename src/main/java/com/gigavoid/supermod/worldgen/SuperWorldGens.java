package com.gigavoid.supermod.worldgen;

import net.minecraftforge.fml.common.registry.GameRegistry;

public class SuperWorldGens {

    public static void initializeWorldGens(){

        GameRegistry.registerWorldGenerator(new SuperWorldGenOre(), 13);
        //GameRegistry.registerWorldGenerator(new SuperWorldGenEmeraldTrees(), 14);
    }
}
