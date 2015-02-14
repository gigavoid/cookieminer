package com.gigavoid.supermod.northrend.block;

import static com.gigavoid.supermod.common.RegisterFunctions.registerBlock;

public class NorthrendBlocks {
    public static final BlockGlacialIce glacialIce = new BlockGlacialIce();
    public static final BlockNorthDirt northDirt = new BlockNorthDirt();
    public static final BlockNorthStone northStone = new BlockNorthStone();
    public static final BlockNorthrendLog northLog = new BlockNorthrendLog();
    public static final BlockNorthLeaves northLeaves = new BlockNorthLeaves();
    //public static final BlockPortalNorthrend portalNorthrend = new BlockPortalNorthrend();
    public static final BlockNorthPlanks northPlanks = new BlockNorthPlanks();
    public static final BlockNorthStairs northStairs = new BlockNorthStairs(0);
    public static final BlockNorthCobblestone northCobble = new BlockNorthCobblestone();
    public static final BlockNorthStoneStairs northCobbleStairs = new BlockNorthStoneStairs(0);
    public static final BlockNorthFence northFence = new BlockNorthFence();
    public static final BlockNorthFenceGate northFenceGate = new BlockNorthFenceGate();
    public static final BlockNorthGlaciemPlant northGlaciemPlant = new BlockNorthGlaciemPlant();

    public static void initializeBlocks(){
        registerBlock(glacialIce, "north_ice");
        registerBlock(northDirt, "north_dirt");
        registerBlock(northStone, "north_stone");
        registerBlock(northLog, "north_log");
        registerBlock(northLeaves, "north_leaves");
        //registerBlock(portalNorthrend, "north_portal");
        registerBlock(northPlanks, "north_planks");
        registerBlock(northStairs, "north_stairs");
        registerBlock(northCobble, "north_cobblestone");
        registerBlock(northCobbleStairs, "north_cobble_stairs");
        registerBlock(northFence, "north_fence");
        registerBlock(northFenceGate, "north_fence_gate");
        registerBlock(northGlaciemPlant, "glaciem_plant");
    }
}
