package com.gigavoid.supermod.block;

import cpw.mods.fml.common.registry.GameRegistry;

public class SuperBlocks {

    public static final EmeraldLogBlock emeraldLog = new EmeraldLogBlock();
    public static final EmeraldFlowerBlock emeraldGrass = new EmeraldFlowerBlock();

    public static void initializeBlocks(){
        GameRegistry.registerBlock(emeraldLog, "Emerald Log");
        GameRegistry.registerBlock(emeraldGrass, "Emerald Grass");
    }
}
