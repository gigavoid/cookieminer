package com.gigavoid.supermod.bonus;

import com.gigavoid.supermod.bonus.block.BonusBlocks;
import com.gigavoid.supermod.common.module.Module;
import com.gigavoid.supermod.ropeway.block.RopewayBlocks;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

/**
 * Created by SnuRRaN on 2015-02-14.
 */

public class ModuleBonus extends Module {
    @Override
    public void init(FMLInitializationEvent e) {
        BonusBlocks.initializeBlocks();
    }
}
