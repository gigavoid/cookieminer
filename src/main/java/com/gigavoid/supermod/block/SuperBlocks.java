package com.gigavoid.supermod.block;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
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
        registerBlock(emeraldLog, "emeraldLog");
        registerBlock(emeraldLeaves, "emeraldLeaves");
        registerBlock(emeraldFlower, "emeraldFlower");
        registerBlock(saxeliumOre, "saxeliumOre");
        registerBlock(saxeliumBlock, "saxeliumBlock");
        registerBlock(pickaxeToolbench, "pickaxeToolbench");
        registerBlock(voidToolbench, "voidToolbench");
        registerBlock(glacialIce, "glacialIce");
        registerBlock(northDirt, "northDirt");
        registerBlock(northStone, "northStone");
        registerBlock(northLog, "northLog");
        registerBlock(northLeaves, "northLeaves");
        registerBlock(voidBlock, "voidBlock");
        registerBlock(pylon, "pylon");
        registerBlock(ropeWheel, "ropeWheel");
        registerBlock(portalNorthrend, "portalNorthrend");
        registerBlock(meat, "meat");
        registerBlock(bone, "block_bone");
        registerBlock(northPlanks, "northPlanks");
        registerBlock(northStairs, "northStairs");
        registerBlock(northCobble, "northCobblestone");
        registerBlock(northCobbleStairs, "northCobbleStairs");
        registerBlock(northFence, "northFence");
        registerBlock(northFenceGate, "northFenceGate");
        registerBlock(northGlaciemPlant, "northGlaciemPlant");
    }

    private static void registerBlock(Block block, String name) {
        block.setUnlocalizedName(name);
        GameRegistry.registerBlock(block, name);
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(block), 0, new ModelResourceLocation("supermod:" + name, "inventory"));

    }
}
