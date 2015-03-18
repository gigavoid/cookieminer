package com.gigavoid.supermod.northrend.recipe;

import com.gigavoid.supermod.northrend.block.NorthrendBlocks;
import com.gigavoid.supermod.northrend.item.NorthrendItems;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class NorthrendRecipies {
    public static void registerRecipies(){
        dragonbonePickaxe();
        mithrilIngot();
    }

    private static void dragonbonePickaxe(){
        ItemStack dragonbone = new ItemStack(NorthrendItems.dragonbone);
        ItemStack stick = new ItemStack(Items.stick);

        GameRegistry.addRecipe(new ItemStack(NorthrendItems.dragonbonePickaxe),"bbb", " s ", " s ", 'b', dragonbone, 's', stick);
    }

    private static void mithrilIngot(){
        GameRegistry.addSmelting(NorthrendBlocks.mithrilOre, new ItemStack(NorthrendItems.mithrilIngot), 1);
    }
}
