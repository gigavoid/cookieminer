package com.gigavoid.supermod.northrend.block;

import com.gigavoid.supermod.common.Register;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;
import scala.Console;

import java.lang.reflect.Constructor;

public class NorthrendBlocks {
    public static Fluid baseFluid;

    public static BlockNorthGlacialIce glacialIce;
    public static BlockNorthDirt northDirt;
    public static BlockNorthStone northStone;
    public static BlockNorthLog northLog;
    public static BlockNorthLeaves northLeaves;
    public static BlockNorthPortal portalNorthrend;
    public static BlockNorthPlanks northPlanks;
    public static BlockNorthStairs northStairs;
    public static BlockNorthCobblestone northCobble;
    public static BlockNorthStoneStairs northCobbleStairs;
    public static BlockNorthFence northFence;
    public static BlockNorthFenceGate northFenceGate;
    public static BlockNorthGlaciemPlant northGlaciemPlant;
    public static BlockNorthBlight blight;
    public static BlockNorthSnowModded snowLayerMod;
    public static BlockFluidClassic poison;
    public static BlockNorthCoalOre coalOre;
    public static BlockNorthDiamondOre diamondOre;
    public static BlockNorthEmeraldOre emeraldOre;
    public static BlockNorthFrostGemOre frostGemOre;
    public static BlockNorthGoldOre goldOre;
    public static BlockNorthIronOre ironOre;
    public static BlockNorthLapisOre lapisOre;
    public static BlockNorthMithrilOre mithrilOre;
    public static BlockNorthRedstoneOre redstoneOre;
    public static BlockNorthRedstoneOre lit_redstoneOre;
    public static BlockNorthDragonBone dragonBone;
    public static BlockNorthDragonHead dragonHead;
    public static BlockNorthSapling northPineSapling;
    public static BlockNorthSapling northFirSapling;
    public static BlockNorthSapling northBirchSapling;
    public static BlockNorthBloodBeechLog northBloodBeechLog;
    public static BlockNorthBloodBeechLeaves northBloodBeechLeaves;

    public static void initializeBlocks(Register register){ // throws Exception
        /**Constructor<TextureAtlasSprite> TASConstructor = TextureAtlasSprite.class.getDeclaredConstructor();
        TASConstructor.setAccessible(true);

        TextureAtlasSprite still = TASConstructor.newInstance("supermod:blocks/poison_fluid_sill");
        TextureAtlasSprite flowing = TASConstructor.newInstance("supermod:blocks/poison_fluid_flowing");
*/
        baseFluid = new Fluid("base_fluid");
        register.registerFluid(baseFluid, "base_fluid");

        glacialIce = new BlockNorthGlacialIce();
        northDirt = new BlockNorthDirt();
        northStone = new BlockNorthStone();
        northLog = new BlockNorthLog();
        northLeaves = new BlockNorthLeaves();
        portalNorthrend = new BlockNorthPortal();
        northPlanks = new BlockNorthPlanks();
        northStairs = new BlockNorthStairs(0);
        northCobble = new BlockNorthCobblestone();
        northCobbleStairs = new BlockNorthStoneStairs(0);
        northFence = new BlockNorthFence();
        northFenceGate = new BlockNorthFenceGate();
        northGlaciemPlant = new BlockNorthGlaciemPlant();
        blight = new BlockNorthBlight();
        snowLayerMod = new BlockNorthSnowModded();
        poison = new BlockNorthPoisonFluid(baseFluid, Material.water);
        coalOre = new BlockNorthCoalOre();
        diamondOre = new BlockNorthDiamondOre();
        emeraldOre = new BlockNorthEmeraldOre();
        frostGemOre = new BlockNorthFrostGemOre();
        goldOre = new BlockNorthGoldOre();
        ironOre = new BlockNorthIronOre();
        lapisOre = new BlockNorthLapisOre();
        mithrilOre = new BlockNorthMithrilOre();
        redstoneOre = new BlockNorthRedstoneOre(false);
        lit_redstoneOre = new BlockNorthRedstoneOre(true);
        dragonBone = new BlockNorthDragonBone();
        dragonHead = new BlockNorthDragonHead();
        northPineSapling = new BlockNorthSapling(BlockNorthSapling.EnumType.PINE);
        northFirSapling = new BlockNorthSapling(BlockNorthSapling.EnumType.FIR);
        northBirchSapling = new BlockNorthSapling(BlockNorthSapling.EnumType.BIRCH);
        northBloodBeechLog = new BlockNorthBloodBeechLog();
        northBloodBeechLeaves = new BlockNorthBloodBeechLeaves();
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
        register.registerBlock(northGlaciemPlant, "north_glaciem_plant");
        register.registerBlock(blight, "north_blight");
        register.registerBlock(snowLayerMod, "north_snow_layer_mod");
        register.registerBlock(poison, "poison_fluid");
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
        register.registerBlock(northPineSapling, "north_pine_sapling");
        register.registerBlock(northFirSapling, "north_fir_sapling");
        register.registerBlock(northBirchSapling, "north_birch_sapling");
        register.registerBlock(northBloodBeechLog, "north_blood_beech_log");
        register.registerBlock(northBloodBeechLeaves, "north_blood_beech_leaves");
    }
}
