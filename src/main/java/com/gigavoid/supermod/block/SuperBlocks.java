package com.gigavoid.supermod.block;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.material.Material;

public class SuperBlocks {

    public static final EmeraldLogBlock emeraldLog = new EmeraldLogBlock(Material.wood);
    public static final SuperStoneBlock superStone = new SuperStoneBlock();

    public static void initializeBlocks(){
        GameRegistry.registerBlock(emeraldLog, "Emerald Log");
        GameRegistry.registerBlock(superStone, "Super Stone");
    }
}
