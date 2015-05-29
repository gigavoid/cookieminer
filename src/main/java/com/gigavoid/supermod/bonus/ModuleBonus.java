package com.gigavoid.supermod.bonus;

import com.gigavoid.supermod.bonus.block.BonusBlocks;
import com.gigavoid.supermod.common.module.Module;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

public class ModuleBonus extends Module {
    @Override
    public void init(FMLInitializationEvent e) {
        BonusBlocks.initializeBlocks(getRegister(e.getSide()));
    }
}
