package com.gigavoid.supermod.block;

import net.minecraftforge.fml.common.registry.GameRegistry;

public class SuperBlocks {

    public static final BlockEmeraldLog emeraldLog = new BlockEmeraldLog();
    public static final BlockEmeraldLeaves emeraldLeaves = new BlockEmeraldLeaves();
    public static final BlockEmeraldFlower emeraldFlower = new BlockEmeraldFlower();
    public static final BlockSaxeliumOre saxeliumOre = new BlockSaxeliumOre();
    public static final BlockSaxeliumBlock saxeliumBlock = new BlockSaxeliumBlock();
    public static final BlockPickaxeToolbench pickaxeToolbench = new BlockPickaxeToolbench();
    public static final BlockVoidToolbench voidToolbench = new BlockVoidToolbench();
    public static final BlockGlacialIce glacialIce = new BlockGlacialIce();
    public static final BlockNorthDirt northDirt = new BlockNorthDirt();
    public static final BlockNorthStone northStone = new BlockNorthStone();
    public static final BlockNorthrendLog northLog = new BlockNorthrendLog();
    public static final BlockNorthLeaves northLeaves = new BlockNorthLeaves();
    public static final BlockVoidBlock voidBlock = new BlockVoidBlock();
    public static final BlockPylon pylon = new BlockPylon();
    public static final BlockRopeWheel ropeWheel = new BlockRopeWheel();
    public static final BlockPortalNorthrend portalNorthrend = new BlockPortalNorthrend();
    public static final BlockMeat meat = new BlockMeat();
    public static final BlockBone bone = new BlockBone();
    public static final BlockNorthPlanks northPlanks = new BlockNorthPlanks();
    public static final BlockNorthStairs northStairs = new BlockNorthStairs(0);
    public static final BlockNorthCobblestone northCobble = new BlockNorthCobblestone();
    public static final BlockNorthStoneStairs northCobbleStairs = new BlockNorthStoneStairs(0);
    public static final BlockNorthFence northFence = new BlockNorthFence();
    public static final BlockNorthFenceGate northFenceGate = new BlockNorthFenceGate();
    public static final BlockNorthGlaciemPlant northGlaciemPlant = new BlockNorthGlaciemPlant();

    public static void initializeBlocks(){
        GameRegistry.registerBlock(emeraldLog, "emeraldLog");
        GameRegistry.registerBlock(emeraldLeaves, "emeraldLeaves");
        GameRegistry.registerBlock(emeraldFlower, "emeraldFlower");
        GameRegistry.registerBlock(saxeliumOre, "saxeliumOre");
        GameRegistry.registerBlock(saxeliumBlock, "saxeliumBlock");
        GameRegistry.registerBlock(pickaxeToolbench, "pickaxeToolbench");
        GameRegistry.registerBlock(voidToolbench, "voidToolbench");
        GameRegistry.registerBlock(glacialIce, "glacialIce");
        GameRegistry.registerBlock(northDirt, "northDirt");
        GameRegistry.registerBlock(northStone, "northStone");
        GameRegistry.registerBlock(northLog, "northLog");
        GameRegistry.registerBlock(northLeaves, "northLeaves");
        GameRegistry.registerBlock(voidBlock, "voidBlock");
        GameRegistry.registerBlock(pylon, "pylon");
        GameRegistry.registerBlock(ropeWheel, "ropeWheel");
        GameRegistry.registerBlock(portalNorthrend, "portalNorthrend");
        GameRegistry.registerBlock(meat, "meat");
        GameRegistry.registerBlock(bone, "bone");
        GameRegistry.registerBlock(northPlanks, "northPlanks");
        GameRegistry.registerBlock(northStairs, "northStairs");
        GameRegistry.registerBlock(northCobble, "northCobblestone");
        GameRegistry.registerBlock(northCobbleStairs, "northCobbleStairs");
        GameRegistry.registerBlock(northFence, "northFence");
        GameRegistry.registerBlock(northFenceGate, "northFenceGate");
        GameRegistry.registerBlock(northGlaciemPlant, "northGlaciemPlant");
    }
}
