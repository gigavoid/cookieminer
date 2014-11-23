package com.gigavoid.supermod;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.init.Blocks;
import net.minecraftforge.event.terraingen.BiomeEvent;

/**
 * Created by ineentho on 2014-11-23.
 */
public class SuperVillageGenerator {

    @SubscribeEvent
    public void event(BiomeEvent.GetVillageBlockID event){
        event.replacement = Blocks.grass;
    }
}
