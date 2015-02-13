package com.gigavoid.supermod.ropeway;

import com.gigavoid.supermod.common.module.Module;
import com.gigavoid.supermod.ropeway.block.RopewayBlocks;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

/**
 * Created by Henrik on 2015-02-13.
 */
public class ModuleRopeway extends Module {
    @Override
    public void init(FMLInitializationEvent e) {
        RopewayBlocks.initializeBlocks();
    }
}
