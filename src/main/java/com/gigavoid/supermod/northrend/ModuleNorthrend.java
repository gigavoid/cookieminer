package com.gigavoid.supermod.northrend;

import com.gigavoid.supermod.common.module.Module;
import com.gigavoid.supermod.northrend.biome.NorthrendBiomes;
import com.gigavoid.supermod.northrend.block.NorthrendBlocks;
import com.gigavoid.supermod.northrend.worldgen.custom.WorldProvider;
import com.gigavoid.supermod.northrend.worldgen.gen.MapGenOres;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ModuleNorthrend extends Module {
    public static int dimensionId;

    @Override
    public void preInit(FMLPreInitializationEvent e){
        NorthrendBlocks.initializeBlocks(getRegister());
        NorthrendBiomes.registerBiomes();
        dimensionId = getRegister().registerDimension(WorldProvider.class, false);
        getRegister().registerWorldGenerator(new MapGenOres(), 20);
    }

    @Override
    public void  init(FMLInitializationEvent e){
        NorthrendBlocks.registerBlocks(getRegister());}
}
