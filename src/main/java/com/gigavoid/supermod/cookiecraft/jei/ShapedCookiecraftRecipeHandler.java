package com.gigavoid.supermod.cookiecraft.jei;

import com.gigavoid.supermod.cookiecraft.recipe.ShapedCookieRecipe;
import mezz.jei.api.recipe.IRecipeHandler;
import mezz.jei.api.recipe.IRecipeWrapper;
import mezz.jei.api.recipe.VanillaRecipeCategoryUid;
import mezz.jei.plugins.vanilla.crafting.ShapedOreRecipeWrapper;

import javax.annotation.Nonnull;

public class ShapedCookiecraftRecipeHandler implements IRecipeHandler<ShapedCookieRecipe> {
    @Nonnull
    @Override
    public Class<ShapedCookieRecipe> getRecipeClass() {
        return ShapedCookieRecipe.class;
    }

    @Nonnull
    @Override
    public String getRecipeCategoryUid() {
        return VanillaRecipeCategoryUid.CRAFTING;
    }

    @Nonnull
    @Override
    public IRecipeWrapper getRecipeWrapper(@Nonnull ShapedCookieRecipe recipe) {
        return new ShapedCookiecraftRecipeWrapper(recipe);
    }

    @Override
    public boolean isRecipeValid(@Nonnull ShapedCookieRecipe recipe) {
        return true;
    }
}
