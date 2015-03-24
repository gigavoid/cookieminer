package com.gigavoid.supermod.cookiecraft;

import com.gigavoid.supermod.common.module.Module;
import com.gigavoid.supermod.cookiecraft.biome.CookieBiome;
import com.gigavoid.supermod.cookiecraft.block.CookiecraftBlocks;
import com.gigavoid.supermod.cookiecraft.gui.CookiecraftGuis;
import com.gigavoid.supermod.cookiecraft.recipe.CookiecraftRecipes;
import com.gigavoid.supermod.cookiecraft.item.CookiecraftItems;
import com.gigavoid.supermod.cookiecraft.tileentity.CookiecraftTileEntities;
import com.gigavoid.supermod.cookiecraft.worldgen.CookiecraftWorldProvider;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ModuleCookiecraft extends Module{
    public static int dimensionId;
    public static CookieBiome cookieBiome;

    @Override
    public void preInit(FMLPreInitializationEvent e) {
        cookieBiome = new CookieBiome(getRegister(e.getSide()).getNextBiomeID(), 10);
        BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeManager.BiomeEntry(cookieBiome, 0));

        dimensionId = getRegister(e.getSide()).registerDimension(CookiecraftWorldProvider.class, false);
    }

    @Override
    public void init(FMLInitializationEvent e) {
        CookiecraftBlocks.initializeBlocks(getRegister(e.getSide()));
        CookiecraftItems.registerItems(getRegister(e.getSide()), e);
        CookiecraftTileEntities.registerTileEntities();
        CookiecraftGuis.initializeGuis();
        CookiecraftRecipes.initializeRecipes();
    }
}
