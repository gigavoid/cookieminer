package com.gigavoid.supermod.cookiecraft.jei;

import mezz.jei.api.*;

@JEIPlugin
public class JEICookieminerPlugin implements IModPlugin {
    @Override
    public void onJeiHelpersAvailable(IJeiHelpers jeiHelpers) {

    }

    @Override
    public void onItemRegistryAvailable(IItemRegistry itemRegistry) {

    }

    @Override
    public void register(IModRegistry registry) {
        registry.addRecipeHandlers(
                new ShapedCookiecraftRecipeHandler()
        );

    }

    @Override
    public void onRecipeRegistryAvailable(IRecipeRegistry recipeRegistry) {

    }
}
