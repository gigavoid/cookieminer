package com.gigavoid.supermod.bettertools;

import com.gigavoid.supermod.bettertools.block.BetterToolsBlocks;
import com.gigavoid.supermod.bettertools.item.BetterToolsItems;
import com.gigavoid.supermod.bettertools.recipe.BetterToolsRecipes;
import com.gigavoid.supermod.bettertools.worldgen.BetterToolsWorldGens;
import com.gigavoid.supermod.common.module.Module;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

public class ModuleBetterTools extends Module {
    @Override
    public void init(FMLInitializationEvent e) {
        BetterToolsWorldGens.initializeWorldGens(getRegister(e.getSide()));
        BetterToolsItems.initializeItems(e, getRegister(e.getSide()));
        BetterToolsBlocks.initializeBlocks(getRegister(e.getSide()));
        BetterToolsRecipes.initializeRecipes();
    }
}
