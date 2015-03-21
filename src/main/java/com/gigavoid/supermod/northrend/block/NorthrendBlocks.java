package com.gigavoid.supermod.northrend.block;

import com.gigavoid.supermod.common.Register;
import net.minecraft.block.material.Material;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;
import scala.reflect.internal.Trees;

public class NorthrendBlocks {
    //public static Fluid baseFluid;

    public static BlockGlacialIce glacialIce;
    public static BlockNorthDirt northDirt;
    public static BlockNorthStone northStone;
    public static BlockNorthLog northLog;
    public static BlockNorthLeaves northLeaves;
    public static BlockPortalNorthrend portalNorthrend;
    public static BlockNorthPlanks northPlanks;
    public static BlockNorthStairs northStairs;
    public static BlockNorthCobblestone northCobble;
    public static BlockNorthStoneStairs northCobbleStairs;
    public static BlockNorthFence northFence;
    public static BlockNorthFenceGate northFenceGate;
    public static BlockNorthGlaciemPlant northGlaciemPlant;
    public static BlockBlight blight;
    public static BlockSnowModded snowLayerMod;
    //public static BlockFluidClassic poison;
    public static BlockCoalOre coalOre;
    public static BlockDiamondOre diamondOre;
    public static BlockEmeraldOre emeraldOre;
    public static BlockFrostGemOre frostGemOre;
    public static BlockGoldOre goldOre;
    public static BlockIronOre ironOre;
    public static BlockLapisOre lapisOre;
    public static BlockMithrilOre mithrilOre;
    public static BlockRedstoneOre redstoneOre;
    public static BlockRedstoneOre lit_redstoneOre;
    public static BlockDragonBone dragonBone;
    public static BlockDragonHead dragonHead;

    public static void initializeBlocks(Register register) {
        //baseFluid = new Fluid("baseFluid");
        //register.registerFluid(baseFluid, "baseFluid");

        glacialIce = new BlockGlacialIce();
        northDirt = new BlockNorthDirt();
        northStone = new BlockNorthStone();
        northLog = new BlockNorthLog();
        northLeaves = new BlockNorthLeaves();
        portalNorthrend = new BlockPortalNorthrend();
        northPlanks = new BlockNorthPlanks();
        northStairs = new BlockNorthStairs(0);
        northCobble = new BlockNorthCobblestone();
        northCobbleStairs = new BlockNorthStoneStairs(0);
        northFence = new BlockNorthFence();
        northFenceGate = new BlockNorthFenceGate();
        northGlaciemPlant = new BlockNorthGlaciemPlant();
        blight = new BlockBlight();
        snowLayerMod = new BlockSnowModded();
        //poison = new BlockPoisonFluid(baseFluid, Material.water);
        coalOre = new BlockCoalOre();
        diamondOre = new BlockDiamondOre();
        emeraldOre = new BlockEmeraldOre();
        frostGemOre = new BlockFrostGemOre();
        goldOre = new BlockGoldOre();
        ironOre = new BlockIronOre();
        lapisOre = new BlockLapisOre();
        mithrilOre = new BlockMithrilOre();
        redstoneOre = new BlockRedstoneOre(false);
        lit_redstoneOre = new BlockRedstoneOre(true);
        dragonBone = new BlockDragonBone();
        dragonHead = new BlockDragonHead();
    }

    public static void registerBlocks(Register register){
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
        register.registerBlock(northGlaciemPlant, "glaciem_plant");
        register.registerBlock(blight, "north_blight");
        register.registerBlock(snowLayerMod, "snow_layer_mod");
        //register.registerBlock(poison, "poisonFluid");
        register.registerBlock(coalOre, "north_coal_ore");
        register.registerBlock(diamondOre, "north_diamond_ore");
        register.registerBlock(emeraldOre, "north_emerald_ore");
        register.registerBlock(frostGemOre, "north_frost_gem_ore");
        register.registerBlock(goldOre, "north_gold_ore");
        register.registerBlock(ironOre, "north_iron_ore");
        register.registerBlock(lapisOre, "north_lapis_ore");
        register.registerBlock(mithrilOre, "north_mithril_ore");
        register.registerBlock(redstoneOre, "north_red_stone_ore");
        register.registerBlock(lit_redstoneOre, "north_lit_red_stone_ore", "north_red_stone_ore");
        register.registerBlock(dragonBone, "north_dragon_bone");
        register.registerBlock(dragonHead, "north_dragonhead");
    }
}
