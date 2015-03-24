package com.gigavoid.supermod.northrend.recipe;

import com.gigavoid.supermod.northrend.block.NorthrendBlocks;
import com.gigavoid.supermod.northrend.item.NorthrendItems;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class NorthrendRecipies {
    public static void registerRecipies(){
        dragonbonePickaxe();
        mithrilTools();
        mithrilIngot();
        northPearl();
    }

    private static void dragonbonePickaxe(){
        ItemStack dragonbone = new ItemStack(NorthrendItems.dragonbone);
        ItemStack stick = new ItemStack(Items.stick);

        GameRegistry.addRecipe(new ItemStack(NorthrendItems.dragonbonePickaxe),"aaa", " b ", " b ", 'a', dragonbone, 'b', stick);
    }

    private static void mithrilTools(){

        ItemStack mithrilIngot = new ItemStack(NorthrendItems.mithrilIngot);
        ItemStack stick = new ItemStack(Items.stick);

        GameRegistry.addRecipe(new ItemStack(NorthrendItems.mithrilPickaxe),"aaa", " b ", " b ", 'a', mithrilIngot, 'b', stick);

        GameRegistry.addRecipe(new ItemStack(NorthrendItems.mithrilSword)," a ", " a ", " b ", 'a', mithrilIngot, 'b', stick);
        GameRegistry.addRecipe(new ItemStack(NorthrendItems.mithrilSword),"a  ", "a  ", "b  ", 'a', mithrilIngot, 'b', stick);
        GameRegistry.addRecipe(new ItemStack(NorthrendItems.mithrilSword),"  a", "  a", "  b", 'a', mithrilIngot, 'b', stick);

        GameRegistry.addRecipe(new ItemStack(NorthrendItems.mithrilAxe),"aa ", "ab ", " b ", 'a', mithrilIngot, 'b', stick);
        GameRegistry.addRecipe(new ItemStack(NorthrendItems.mithrilAxe)," aa", " ba", " b ", 'a', mithrilIngot, 'b', stick);

        GameRegistry.addRecipe(new ItemStack(NorthrendItems.mithrilShovel)," a ", " b ", " b ", 'a', mithrilIngot, 'b', stick);
        GameRegistry.addRecipe(new ItemStack(NorthrendItems.mithrilShovel),"a  ", "b  ", "b  ", 'a', mithrilIngot, 'b', stick);
        GameRegistry.addRecipe(new ItemStack(NorthrendItems.mithrilShovel),"  a", "  b", "  b", 'a', mithrilIngot, 'b', stick);

        GameRegistry.addRecipe(new ItemStack(NorthrendItems.mithrilHoe),"aa ", " b ", " b ", 'a', mithrilIngot, 'b', stick);
        GameRegistry.addRecipe(new ItemStack(NorthrendItems.mithrilHoe)," aa", " b ", " b ", 'a', mithrilIngot, 'b', stick);
    }

    private static void mithrilIngot(){
        GameRegistry.addSmelting(NorthrendBlocks.mithrilOre, new ItemStack(NorthrendItems.mithrilIngot), 1);
    }

    private static void northPearl(){
        ItemStack enerPearl = new ItemStack(Items.ender_pearl);
        ItemStack ice = new ItemStack(Blocks.ice);

        GameRegistry.addShapelessRecipe(new ItemStack(NorthrendItems.northPearl), enerPearl, ice);
    }
}
