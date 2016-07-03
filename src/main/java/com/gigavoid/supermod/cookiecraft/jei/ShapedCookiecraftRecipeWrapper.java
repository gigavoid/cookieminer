package com.gigavoid.supermod.cookiecraft.jei;

import com.gigavoid.supermod.cookiecraft.item.CookiecraftItems;
import com.gigavoid.supermod.cookiecraft.item.ItemCookiePouch;
import com.gigavoid.supermod.cookiecraft.item.ItemCookiePouchBase;
import com.gigavoid.supermod.cookiecraft.recipe.ShapedCookieRecipe;
import mezz.jei.api.recipe.wrapper.IShapedCraftingRecipeWrapper;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShapedCookiecraftRecipeWrapper implements IShapedCraftingRecipeWrapper {
    private final ShapedCookieRecipe recipe;

    public ShapedCookiecraftRecipeWrapper(ShapedCookieRecipe recipe) {
        this.recipe = recipe;
    }


    @Override
    public int getWidth() {
        return 3;
    }

    @Override
    public int getHeight() {
        return 3;
    }

    @Override
    public List getInputs() {
        List<Object> inputs = new ArrayList<Object>();

        for (ItemStack input : this.recipe.getRecipe()) {
            if (input == null) {
                inputs.add(null);
                continue;
            }
            ItemStack clonedStack = input.copy();
            if (input.getItem() instanceof ItemCookiePouchBase) {
                ItemCookiePouch pouch = (ItemCookiePouch) input.getItem();
                if (this.recipe.isConsumeCookieItem()) {
                    pouch.setCookies(clonedStack, this.recipe.getCookiesRequired());
                    inputs.add(clonedStack);
                } else {
                    List<ItemStack> inputArr = new ArrayList<ItemStack>();
                    for(ItemCookiePouch possiblePouch : CookiecraftItems.cookiePouches) {
                        if (possiblePouch.getStorage() >= this.recipe.getCookiesRequired()) {
                            ItemStack is = new ItemStack(possiblePouch);
                            possiblePouch.setCookies(is, this.recipe.getCookiesRequired());
                            inputArr.add(is);
                        }
                    }
                    inputs.add(inputArr);
                }
            } else {
                inputs.add(input);
            }
        }

        return inputs;
    }

    @Override
    public List<ItemStack> getOutputs() {
        return Collections.singletonList(this.recipe.getResult());
    }

    @Override
    public List<FluidStack> getFluidInputs() {
        return null;
    }

    @Override
    public List<FluidStack> getFluidOutputs() {
        return null;
    }

    @Override
    public void drawInfo(@Nonnull Minecraft minecraft, int recipeWidth, int recipeHeight) {

    }

    @Override
    public void drawAnimations(@Nonnull Minecraft minecraft, int recipeWidth, int recipeHeight) {

    }

    @Nullable
    @Override
    public List<String> getTooltipStrings(int mouseX, int mouseY) {
        return null;
    }
}
