package com.gigavoid.supermod.bettertools.block;

import com.gigavoid.supermod.common.Register;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

/**
 * Created by Lukas on 2015-02-18.
 */
public class BetterToolsBlocks {
    public static final BlockSaxeliumOre saxeliumOre = new BlockSaxeliumOre();

    public static void initializeBlocks(Register register) {
        register.registerBlock(saxeliumOre, "saxelium_ore");
    }
}
