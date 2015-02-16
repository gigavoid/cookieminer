package com.gigavoid.supermod.northrend;

import com.gigavoid.supermod.common.module.Module;
import com.gigavoid.supermod.northrend.biome.NorthrendBiomes;
import com.gigavoid.supermod.northrend.block.NorthrendBlocks;
import com.gigavoid.supermod.northrend.worldgen.custom.WorldProvider;
import com.gigavoid.supermod.northrend.worldgen.custom.WorldType;
import com.gigavoid.supermod.northrend.worldgen.gen.OreGen;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import static com.gigavoid.supermod.common.Register.*;

public class ModuleNorthrend extends Module {
    public static final int dimensionId = 2;
    public static final net.minecraft.world.WorldType northrend = new WorldType(7, "northrend");

    @Override
    public void preInit(FMLPreInitializationEvent e){
        NorthrendBiomes.registerBiomes();
        registerDimension(dimensionId, WorldProvider.class, false);
        registerWorldGenerator(new OreGen(), 25);
    }

    @Override
    public void init(FMLInitializationEvent e) {
        NorthrendBlocks.initializeBlocks();
    }
}
