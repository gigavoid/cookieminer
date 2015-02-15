package com.gigavoid.supermod.bettertools;

import com.gigavoid.supermod.bettertools.item.BetterToolsItems;
import com.gigavoid.supermod.bettertools.recipe.BetterToolsRecipes;
import com.gigavoid.supermod.common.module.Module;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

/**
 * Created by Lukas on 2015-02-14.
 */
public class ModuleBetterTools extends Module {
    @Override
    public void init(FMLInitializationEvent e) {
        BetterToolsItems.initializeItems(e);
        BetterToolsRecipes.initializeRecipes();
    }
}