package com.gigavoid.supermod.northrend.recipe;

import com.gigavoid.supermod.northrend.item.NorthrendItems;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class NorthrendRecipies {
    public static void registerRecipies(){
        dragonbonePickaxe();
    }

    private static void dragonbonePickaxe(){
        ItemStack dragonbone = new ItemStack(NorthrendItems.dragonbone);
        ItemStack stick = new ItemStack(Items.stick);

        GameRegistry.addRecipe(new ItemStack(NorthrendItems.dragonbonePickaxe),"bbb", " s ", " s ", 'b', dragonbone, 's', stick);
    }
}
