package com.gigavoid.supermod.block;

import cpw.mods.fml.common.registry.GameRegistry;

public class SuperBlocks {

    public static final EmeraldLogBlock emeraldLog = new EmeraldLogBlock();
    public static final EmeraldFlowerBlock emeraldFlower = new EmeraldFlowerBlock();
    public static final OPBlock opblock = new OPBlock();
    public static final SuperStoneBlock superStone = new SuperStoneBlock();
    public static final PickaxeToolbenchBlock pickaxeToolbench = new PickaxeToolbenchBlock();

    public static void initializeBlocks(){
        GameRegistry.registerBlock(emeraldLog, "emeraldLog");
        GameRegistry.registerBlock(emeraldFlower, "emeraldFlower");
        GameRegistry.registerBlock(opblock, "op");
        GameRegistry.registerBlock(superStone, "stoneBlock");
        GameRegistry.registerBlock(pickaxeToolbench, "pickaxeToolbench");
    }
}
