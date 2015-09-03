package com.gigavoid.supermod.cookiecraft.recipe;

import com.gigavoid.supermod.cookiecraft.block.CookiecraftBlocks;
import com.gigavoid.supermod.cookiecraft.item.CookiecraftItems;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.init.Items;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CookiecraftRecipes {
    public static void initializeRecipes() {
        cookieCrafter();
        cookieDoughCollector();
        cookieDough();
		cookieFarm();
    }

    private static void cookieCrafter(){
        ItemStack ironIngot = new ItemStack(Items.iron_ingot);
        ItemStack cookie = new ItemStack(Items.cookie);

        GameRegistry.addRecipe(new ItemStack(CookiecraftBlocks.cookieCrafter), "iii", "ici", "iii",
                'i', ironIngot, 'c', cookie);
    }

    private static void cookieDoughCollector(){
        ItemStack ironIngot = new ItemStack(Items.iron_ingot);
        ItemStack cookieDough = new ItemStack(CookiecraftItems.cookieDough);

        GameRegistry.addRecipe(new ItemStack(CookiecraftBlocks.cookieDoughCollector),"iii","ici","iii",
                'i',ironIngot,'c',cookieDough);
    }

    private static void cookieDough(){
        ItemStack wheat = new ItemStack(Items.wheat);

        ItemStack cocoaBeans = new ItemStack(Items.dye , 1,3);

        ItemStack milk = new ItemStack(Items.milk_bucket);

        GameRegistry.addRecipe(new ItemStack(CookiecraftItems.cookieDough), "w w", "wcw", "wmw",
                'w', wheat, 'c', cocoaBeans, 'm', milk);
    }

	private static void cookieFarm() {
		ItemStack iron = new ItemStack(Items.iron_ingot);
		ItemStack seed = new ItemStack(Items.wheat_seeds);
		ItemStack cookieBox = new ItemStack(CookiecraftItems.emeraldCookiePouch);
		ItemStack dirt = new ItemStack(Item.getItemFromBlock(Blocks.dirt));


		GameRegistry.addRecipe(new ShapedCookieRecepie(8, "isi", "scs", "idi",
				'i', iron, 's', seed, 'c', cookieBox, 'd', dirt));
	}

}
