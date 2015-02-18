package com.gigavoid.supermod.jaadu;

import com.gigavoid.supermod.common.module.Module;
import com.gigavoid.supermod.jaadu.biome.JaaduBiomes;
import com.gigavoid.supermod.jaadu.block.JaaduBlocks;
import com.gigavoid.supermod.jaadu.worldgen.custom.WorldProvider;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ModuleJaadu extends Module {
    public static int dimensionId;

    @Override
    public void preInit(FMLPreInitializationEvent e){
        JaaduBlocks.initializeBlocks(getRegister());
        JaaduBiomes.registerBiomes();
        dimensionId = getRegister().registerDimension(WorldProvider.class, false);
    }

    //@Override
    public void  init(FMLInitializationEvent e){
        JaaduBlocks.registerBlocks(getRegister());
    }
}
