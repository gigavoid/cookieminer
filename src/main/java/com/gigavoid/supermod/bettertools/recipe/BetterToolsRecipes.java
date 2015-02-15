package com.gigavoid.supermod.bettertools.recipe;

import com.gigavoid.supermod.bettertools.item.BetterToolsItems;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by Lukas on 2015-02-15.
 */
public class BetterToolsRecipes {
    public static void initializeRecipes(){
        obsidianPickaxAxe();
    }

    private static void obsidianPickaxAxe() {
        ItemStack obsidian = new ItemStack(Blocks.obsidian);
        ItemStack diamond = new ItemStack(Items.diamond);

        GameRegistry.addRecipe(new ItemStack(BetterToolsItems.obsidianPickaxeAxe), "ooo", " d ", " d ",
                'o', obsidian, 'd', diamond);
    }
}