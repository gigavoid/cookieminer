package com.gigavoid.supermod.cookiecraft;

import com.gigavoid.supermod.common.module.Module;
import com.gigavoid.supermod.cookiecraft.biome.CookieBiome;
import com.gigavoid.supermod.cookiecraft.block.CookiecraftBlocks;
import com.gigavoid.supermod.cookiecraft.tileentity.CookiecraftTileEntities;
import com.gigavoid.supermod.cookiecraft.worldgen.CookiecraftWorldProvider;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModuleCookiecraft extends Module{
    public static int dimensionId;
    public static CookieBiome cookieBiome;

    @Override
    public void preInit(FMLPreInitializationEvent e) {
        cookieBiome = new CookieBiome(getRegister().getNextBiomeID(), 10);
        BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeManager.BiomeEntry(cookieBiome, 0));

        dimensionId = getRegister().registerDimension(CookiecraftWorldProvider.class, false);
    }

    @Override
    public void init(FMLInitializationEvent e) {
        CookiecraftBlocks.initializeBlocks(getRegister());
        CookiecraftTileEntities.registerTileEntities();
    }
}
