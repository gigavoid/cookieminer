package com.gigavoid.supermod.northrend;

import com.gigavoid.supermod.common.module.Module;
import com.gigavoid.supermod.northrend.block.NorthrendBlocks;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

public class ModuleNorthrend extends Module {
    @Override
    public void init(FMLInitializationEvent e) {
        NorthrendBlocks.initializeBlocks();
    }
}
