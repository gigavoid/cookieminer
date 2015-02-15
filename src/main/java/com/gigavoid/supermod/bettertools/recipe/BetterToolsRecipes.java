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
        ironStick();
    }

    private static void ironStick() {
        ItemStack iron = new ItemStack(Items.iron_ingot);

        GameRegistry.addRecipe(new ItemStack(BetterToolsItems.ironStick, 4), "   ", " i ", " i ",
                'i', iron);
    }

    private static void obsidianPickaxAxe() {
        ItemStack obsidian = new ItemStack(Blocks.obsidian);
        ItemStack ironStick = new ItemStack(BetterToolsItems.ironStick);

        GameRegistry.addRecipe(new ItemStack(BetterToolsItems.obsidianPickaxeAxe), "ooo", " i ", " i ",
                'o', obsidian, 'i', ironStick);
    }
}