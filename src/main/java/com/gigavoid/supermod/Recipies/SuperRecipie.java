package com.gigavoid.supermod.Recipies;


import com.gigavoid.supermod.item.SuperItems;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class SuperRecipie {
    public static void initializeRecipes(){
        superFurnace();
        voidPickaxe();
        ironStick();
    }


    public static void superFurnace(){
        ItemStack dirtStack = new ItemStack(Items.emerald);
        ItemStack gravelStack = new ItemStack(Items.diamond);

        GameRegistry.addRecipe(new ItemStack(Blocks.cobblestone), "xyx", "y y","xyx",
                'x', dirtStack, 'y', gravelStack);
    }

    public static void voidPickaxe(){
        ItemStack voidStoneStack = new ItemStack(SuperItems.voidStone);
        ItemStack ironStickStack = new ItemStack(SuperItems.ironStick);
        GameRegistry.addRecipe(new ItemStack(SuperItems.voidPickaxe), "xxx", " y ", " y ",
                'x', voidStoneStack, 'y', ironStickStack);
    }

    public static void ironStick(){
        ItemStack ironIgnotStack = new ItemStack(Items.iron_ingot);
        GameRegistry.addRecipe(new ItemStack(SuperItems.ironStick, 4), "x  ", "x  ", " x ", 'x', ironIgnotStack);
    }
}
