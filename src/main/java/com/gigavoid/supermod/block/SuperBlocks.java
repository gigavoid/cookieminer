package com.gigavoid.supermod.block;

import cpw.mods.fml.common.registry.GameRegistry;

public class SuperBlocks {

    public static final BlockEmeraldLog emeraldLog = new BlockEmeraldLog();
    public static final BlockEmeraldLeaves emeraldLeaves = new BlockEmeraldLeaves();
    public static final BlockEmeraldFlower emeraldFlower = new BlockEmeraldFlower();
    public static final BlockSaxeliumOre saxeliumOre = new BlockSaxeliumOre();
    public static final BlockSaxeliumBlock saxeliumBlock = new BlockSaxeliumBlock();
    public static final BlockPickaxeToolbench pickaxeToolbench = new BlockPickaxeToolbench();
    public static final BlockVoidToolbench voidToolbench = new BlockVoidToolbench();
    public static final BlockGlacialIce glacialIce = new BlockGlacialIce();
    public static final BlockNorthrendLog northLog = new BlockNorthrendLog();
    public static final BlockNorthLeaves northLeaves = new BlockNorthLeaves();
    public static final BlockVoidBlock voidBlock = new BlockVoidBlock();
    public static final BlockPortalNorthrend portalNorthrend = new BlockPortalNorthrend();

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
        GameRegistry.registerBlock(voidBlock, "voidBlock");
        GameRegistry.registerBlock(portalNorthrend, "portalNorthrend");
    }
}
