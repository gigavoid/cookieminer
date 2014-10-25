package com.gigavoid.supermod.Recipies;


import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

public class SuperFurnaceRecipie {


    public static void superFurnace(){
        ItemStack dirtStack = new ItemStack(Blocks.dirt);
        ItemStack gravelStack = new ItemStack(Blocks.gravel);

        GameRegistry.addRecipe(new ItemStack(Blocks.cobblestone), "xxx", "x x","xxx",
                'x', dirtStack, 'y', gravelStack);
    }
}
