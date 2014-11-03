package com.gigavoid.supermod.block;

import cpw.mods.fml.common.registry.GameRegistry;

public class SuperBlocks {

    public static final EmeraldLogBlock emeraldLog = new EmeraldLogBlock();
    public static final EmeraldLeavesBlock emeraldLeaves = new EmeraldLeavesBlock();
    public static final EmeraldFlowerBlock emeraldFlower = new EmeraldFlowerBlock();
    public static final SaxeliumOreBlock saxeliumOre = new SaxeliumOreBlock();
    public static final SaxeliumBlockBlock saxeliumBlock = new SaxeliumBlockBlock();
    public static final PickaxeToolbenchBlock pickaxeToolbench = new PickaxeToolbenchBlock();
    public static final VoidToolbenchBlock voidToolbench = new VoidToolbenchBlock();
    public static final GlacialIceBlock glacialIce = new GlacialIceBlock();
    public static final NorthrendLogBlock northLog = new NorthrendLogBlock();
    public static final NorthLeavesBlock northLeaves = new NorthLeavesBlock();

    public static void initializeBlocks(){
        GameRegistry.registerBlock(emeraldLog, "emeraldLog");
        GameRegistry.registerBlock(emeraldLeaves, "emeraldLeaves");
        GameRegistry.registerBlock(emeraldFlower, "emeraldFlower");
        GameRegistry.registerBlock(saxeliumOre, "saxeliumOre");
        GameRegistry.registerBlock(saxeliumBlock, "saxeliumBlock");
        GameRegistry.registerBlock(pickaxeToolbench, "pickaxeToolbench");
        GameRegistry.registerBlock(voidToolbench, "voidToolbench");
        GameRegistry.registerBlock(glacialIce, "glacialIce");
        GameRegistry.registerBlock(northLog, "northLog");
        GameRegistry.registerBlock(northLeaves, "northLeaves");
    }
}
