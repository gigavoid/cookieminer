package com.gigavoid.supermod.northrend;

import com.gigavoid.supermod.common.module.Module;
import com.gigavoid.supermod.northrend.biome.NorthrendBiomes;
import com.gigavoid.supermod.northrend.block.NorthrendBlocks;
import com.gigavoid.supermod.northrend.event.NorthrendEventHandler;
import com.gigavoid.supermod.northrend.item.NorthrendItems;
import com.gigavoid.supermod.northrend.recipe.NorthrendRecipies;
import com.gigavoid.supermod.northrend.worldgen.custom.NorthrendWorldProvider;
import com.gigavoid.supermod.northrend.worldgen.gen.NorthrendMapGenOres;
import net.minecraft.util.DamageSource;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ModuleNorthrend extends Module {
    public static int dimensionId;
    public static final DamageSource freeze = (new DamageSource("freeze")).setDamageBypassesArmor().setDamageIsAbsolute();

    @Override
    public void preInit(FMLPreInitializationEvent e){
        NorthrendBlocks.initializeBlocks(getRegister());
        NorthrendBiomes.registerBiomes();
        dimensionId = getRegister().registerDimension(NorthrendWorldProvider.class, false);
        getRegister().registerWorldGenerator(new NorthrendMapGenOres(), 20);

    }

    @Override
    public void init(FMLInitializationEvent e){
        NorthrendBlocks.registerBlocks(getRegister());
        NorthrendItems.registerItems(e, getRegister());
        NorthrendRecipies.registerRecipies();

        NorthrendEventHandler northendEventHandler = new NorthrendEventHandler();
        FMLCommonHandler.instance().bus().register(northendEventHandler);
        MinecraftForge.EVENT_BUS.register(northendEventHandler);
    }
}
