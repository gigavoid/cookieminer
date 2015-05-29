package com.gigavoid.supermod.cookiecraft.recipe;

import com.gigavoid.supermod.cookiecraft.block.CookiecraftBlocks;
import com.gigavoid.supermod.cookiecraft.cookie.CookieStorageItem;
import com.gigavoid.supermod.cookiecraft.item.CookiecraftItems;
import com.gigavoid.supermod.cookiecraft.item.ICookieStorageItem;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.init.Items;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CookiecraftRecipes {
    public static void initializeRecipes() {
        cookieCrafter();
        cookieDoughCollector();
        cookieDough();
		lavaConverter();
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

	private static void lavaConverter() {
		GameRegistry.addRecipe(new IRecipe() {
			@Override
			public boolean matches(InventoryCrafting ic, World worldIn) {
				return isItem(0, ic, Item.getItemFromBlock(Blocks.stone)) &&
						ic.getStackInSlot(1) == null &&
						isItem(2, ic, Item.getItemFromBlock(Blocks.stone)) &&
						ic.getStackInSlot(3) == null &&
						isCookieStorage(100, ic.getStackInSlot(4)) &&
						ic.getStackInSlot(5) == null &&
						isItem(6, ic, Item.getItemFromBlock(Blocks.stone)) &&
						ic.getStackInSlot(7) == null &&
						isItem(8, ic, Item.getItemFromBlock(Blocks.stone));
			}

			private boolean isItem(int slot, InventoryCrafting ic, Item item) {
				return ic.getStackInSlot(slot) != null && ic.getStackInSlot(slot).getItem() == item;
			}

			private boolean isCookieStorage(int numCookies, ItemStack stackInSlot) {
				if (stackInSlot != null && stackInSlot.getItem() instanceof  ICookieStorageItem) {
					CookieStorageItem storage = new CookieStorageItem(stackInSlot);
					return storage.getCookies() >= numCookies;
				}
				return false;
			}

			@Override
			public ItemStack getCraftingResult(InventoryCrafting ic) {
				return new ItemStack(CookiecraftBlocks.lavaConverter );
			}

			@Override
			public int getRecipeSize() {
				return 9;
			}

			@Override
			public ItemStack getRecipeOutput() {
				return null;
			}

			@Override
			public ItemStack[] func_179532_b(InventoryCrafting inv) {
				ItemStack stackInSlot = inv.getStackInSlot(4);
				CookieStorageItem storage = new CookieStorageItem(stackInSlot);
				storage.takeCookies(100);
				ItemStack[] ret = new ItemStack[inv.getSizeInventory()];
				for (int i = 0; i < ret.length; i++)
				{
					ret[i] = null;
				}
				ret[4] = stackInSlot;
				return ret;
			}
		});
	}
}
