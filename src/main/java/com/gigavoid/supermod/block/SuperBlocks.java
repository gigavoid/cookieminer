package com.gigavoid.supermod.block;

import cpw.mods.fml.common.registry.GameRegistry;

public class SuperBlocks {

<<<<<<< HEAD
    public static final EmeraldLogBlock emeraldLog = new EmeraldLogBlock(Material.wood);
    public static final SuperStoneBlock superStone = new SuperStoneBlock();

    public static void initializeBlocks(){
        GameRegistry.registerBlock(emeraldLog, "Emerald Log");
        GameRegistry.registerBlock(superStone, "Super Stone");
=======
    public static final EmeraldLogBlock emeraldLog = new EmeraldLogBlock();
    public static final EmeraldFlowerBlock emeraldFlower = new EmeraldFlowerBlock();
    public static final OPBlock opblock = new OPBlock();

    public static void initializeBlocks(){
        GameRegistry.registerBlock(emeraldLog, "emeraldLog");
        GameRegistry.registerBlock(emeraldFlower, "emeraldFlower");
        GameRegistry.registerBlock(opblock, "op");
>>>>>>> c69c24a82606151ad13f22662e3d70fdefb52ea2
    }
}
