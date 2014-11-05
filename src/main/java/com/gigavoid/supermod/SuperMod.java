package com.gigavoid.supermod;

import com.gigavoid.supermod.entity.EntityYeti;
import com.gigavoid.supermod.entity.SuperEntities;
import com.gigavoid.supermod.recepies.SuperRecipie;
import com.gigavoid.supermod.recepies.SuperSmeltingRecipie;
import com.gigavoid.supermod.biome.SuperBiomes;
import com.gigavoid.supermod.block.SuperBlocks;
import com.gigavoid.supermod.gui.SuperGuiHandler;
import com.gigavoid.supermod.item.SuperItems;
import com.gigavoid.supermod.keybinding.SuperKeyBinds;
import com.gigavoid.supermod.renderer.RendererYeti;
import com.gigavoid.supermod.worldgen.SuperWorldGens;
import com.gigavoid.supermod.worldgen.WorldProviderNorthrend;
import com.gigavoid.supermod.worldgen.WorldTypeNorthrend;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.world.WorldType;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.DimensionManager;

@Mod(modid = SuperMod.MODID, version = SuperMod.VERSION)
public class SuperMod
{
    @Mod.Instance("supermod")
    public static SuperMod instance;

    public static final String MODID = "supermod";
    public static final String VERSION = "1.0";

    public static final int northrendDimID = 2;
    public static final WorldType northrend  = new WorldTypeNorthrend(7, "northrend");

    @EventHandler
    public void preInit(FMLPreInitializationEvent event){
        SuperBlocks.initializeBlocks();
        SuperItems.initializeItems();
        SuperBiomes.registerBiomes();

        DimensionManager.registerProviderType(northrendDimID, WorldProviderNorthrend.class, false);
        DimensionManager.registerDimension(northrendDimID, northrendDimID);
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        SuperWorldGens.initializeWorldGens();
        SuperKeyBinds.registerKeybinds();
        SuperGuiHandler.initializeGuis();
        SuperRecipie.initializeRecipes();
        SuperSmeltingRecipie.InitializeSmektingRecipes();
        SuperEntities.registerEntities();
    }
}
