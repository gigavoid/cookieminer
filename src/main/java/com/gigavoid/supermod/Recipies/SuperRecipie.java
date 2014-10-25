package com.gigavoid.supermod.Recipies;


import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class SuperRecipie {


    public static void superFurnace(){
        ItemStack dirtStack = new ItemStack(Items.emerald);
        ItemStack gravelStack = new ItemStack(Items.diamond);

        GameRegistry.addRecipe(new ItemStack(Blocks.cobblestone), "xyx", "y y","xyx",
                'x', dirtStack, 'y', gravelStack);
    }
}