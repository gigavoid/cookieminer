package com.gigavoid.supermod.northrend.block;

import com.gigavoid.supermod.common.Register;

public class NorthrendBlocks {
    public static final BlockGlacialIce glacialIce = new BlockGlacialIce();
    public static final BlockNorthDirt northDirt = new BlockNorthDirt();
    public static final BlockNorthStone northStone = new BlockNorthStone();
    public static final BlockNorthLog northLog = new BlockNorthLog();
    public static final BlockNorthLeaves northLeaves = new BlockNorthLeaves();
    public static final BlockPortalNorthrend portalNorthrend = new BlockPortalNorthrend();
    public static final BlockNorthPlanks northPlanks = new BlockNorthPlanks();
    public static final BlockNorthStairs northStairs = new BlockNorthStairs(0);
    public static final BlockNorthCobblestone northCobble = new BlockNorthCobblestone();
    public static final BlockNorthStoneStairs northCobbleStairs = new BlockNorthStoneStairs(0);
    public static final BlockNorthFence northFence = new BlockNorthFence();
    public static final BlockNorthFenceGate northFenceGate = new BlockNorthFenceGate();
    public static final BlockNorthGlaciemPlant northGlaciemPlant = new BlockNorthGlaciemPlant();
    public static final BlockBlight blight = new BlockBlight();

    public static void initializeBlocks(Register register){
        register.registerBlock(glacialIce, "north_ice");
        register.registerBlock(northDirt, "north_dirt");
        register.registerBlock(northStone, "north_stone");
        register.registerBlock(northLog, "north_log");
        register.registerBlock(northLeaves, "north_leaves");
        register.registerBlock(portalNorthrend, "north_portal");
        register.registerBlock(northPlanks, "north_planks");
        register.registerBlock(northStairs, "north_stairs");
        register.registerBlock(northCobble, "north_cobblestone");
        register.registerBlock(northCobbleStairs, "north_cobble_stairs");
        register.registerBlock(northFence, "north_fence");
        register.registerBlock(northFenceGate, "north_fence_gate");
        //register.registerBlock(northGlaciemPlant, "glaciem_plant");
        register.registerBlock(blight, "north_blight");
    }
}
