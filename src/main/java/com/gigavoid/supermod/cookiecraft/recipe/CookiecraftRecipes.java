package com.gigavoid.supermod.cookiecraft.recipe;

import com.gigavoid.supermod.cookiecraft.ModuleCookiecraft;
import com.gigavoid.supermod.cookiecraft.block.*;
import com.gigavoid.supermod.cookiecraft.item.CookiecraftItems;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.init.Items;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.lang.reflect.GenericArrayType;

public class CookiecraftRecipes {
    public static void initializeRecipes() {
        /**
         * Item stack definitions
         */

        // Vanilla items
        ItemStack ironIngot = new ItemStack(Items.IRON_INGOT);
        ItemStack goldIngot = new ItemStack(Items.GOLD_INGOT);
        ItemStack wood = new ItemStack(Blocks.PLANKS);
        ItemStack stone = new ItemStack(Blocks.STONE);
        ItemStack cstone = new ItemStack(Blocks.COBBLESTONE);
        ItemStack diamond = new ItemStack(Items.DIAMOND);
        ItemStack emerald = new ItemStack(Items.EMERALD);
        ItemStack cookie = new ItemStack(Items.COOKIE);
        ItemStack cookies = new ItemStack(Items.COOKIE, 9);
        ItemStack wheat = new ItemStack(Items.WHEAT);
        ItemStack cocoaBean = new ItemStack(Items.DYE, 1, 0x3);
        ItemStack milk = new ItemStack(Items.MILK_BUCKET);
        ItemStack lava = new ItemStack(Items.LAVA_BUCKET);
        ItemStack string = new ItemStack(Items.STRING);
        ItemStack leather = new ItemStack(Items.LEATHER);
        ItemStack seed = new ItemStack(Items.WHEAT_SEEDS);
        ItemStack dirt = new ItemStack(Blocks.DIRT);
        ItemStack piston = new ItemStack(Blocks.PISTON);
        ItemStack cactus = new ItemStack(Blocks.CACTUS);
        ItemStack redstone = new ItemStack(Items.REDSTONE);
        ItemStack enderPearl = new ItemStack(Items.ENDER_PEARL);
        ItemStack glass = new ItemStack(Blocks.GLASS);
        ItemStack enchantedBook = new ItemStack(Items.ENCHANTED_BOOK);
        ItemStack obsidian = new ItemStack(Blocks.OBSIDIAN);

        // Cookie network blocks
        ItemStack cookieCrafter = new ItemStack(BlockCookieCrafter.instance);
        ItemStack doughCollector = new ItemStack(BlockCookieDoughCollector.instance);
        ItemStack trashBaker = new ItemStack(BlockCookieTrashBaker.instance);
        ItemStack cookieFarm = new ItemStack(BlockCookieFarm.instance);
        ItemStack cactusMasher = new ItemStack(BlockCookieCactusMasher.instance);
        ItemStack cookieSteamer = new ItemStack(BlockCookieSteamer.instance);
        ItemStack cookieCircuit = new ItemStack(BlockCookieCocoaCircuit.instance);
        ItemStack moonlightReflector = new ItemStack(BlockCookieMoonlightReflector.instance);
        ItemStack lavaConverter = new ItemStack(BlockCookieLavaConverter.instance);
        ItemStack portalConnector = new ItemStack(BlockCookiePortalConnector.instance);
        ItemStack vacuumOven = new ItemStack(BlockCookieVacuumOven.instance);
        ItemStack ionChanneler = new ItemStack(BlockCookieIonChanneler.instance);
        ItemStack pipe = new ItemStack(BlockCookiePipe.instance, 8);
        ItemStack cookieBlock = new ItemStack(BlockCookieBlock.instance);
        ItemStack cookieAcceleratorPart = new ItemStack(BlockCookieAcceleratorPart.instance);
        ItemStack cookieAcceleratorControl = new ItemStack(BlockCookieAcceleratorControl.instance);
        ItemStack nuclearBaker = new ItemStack(BlockCookieNuclearBaker.instance);

        ItemStack cookieStorageWood = new ItemStack(BlockCookieStorage.instances.get("wood"));
        ItemStack cookieStorageIron = new ItemStack(BlockCookieStorage.instances.get("iron"));
        ItemStack cookieStorageGold = new ItemStack(BlockCookieStorage.instances.get("gold"));
        ItemStack cookieStorageDiamond = new ItemStack(BlockCookieStorage.instances.get("diamond"));
        ItemStack cookieStorageEnder = new ItemStack(BlockCookieStorage.instances.get("ender"));


        // Cookiepouchese
        ItemStack leatherCookiePouch = new ItemStack(CookiecraftItems.leatherCookiePouch);
        ItemStack woodenCookiePouch = new ItemStack(CookiecraftItems.woodenCookiePouch);
        ItemStack stoneCookiePouch = new ItemStack(CookiecraftItems.stoneCookiePouch);
        ItemStack ironCookiePouch = new ItemStack(CookiecraftItems.ironCookiePouch);
        ItemStack goldenCookiePouch = new ItemStack(CookiecraftItems.goldenCookiePouch);
        ItemStack diamondCookiePouch = new ItemStack(CookiecraftItems.diamondCookiePouch);
        ItemStack emeraldCookiePouch = new ItemStack(CookiecraftItems.emeraldCookiePouch);

        // General Cookiecraft items
        ItemStack cookieDough = new ItemStack(CookiecraftItems.cookieDough);
        ItemStack magicCookie = new ItemStack(CookiecraftItems.magicCookie);
        ItemStack gemMixture = new ItemStack(CookiecraftItems.cookieGemMixture, 3);
        ItemStack gemMixtureIngot = new ItemStack(CookiecraftItems.cookieGemMixtureIngot);
        ItemStack uraniumRod = new ItemStack(CookiecraftItems.cookieUraniumRod);
        ItemStack uraniumOre = new ItemStack(BlockCookieOreUranium.instance);


        /**
         * Recipes
         */

        // Network blocks

        GameRegistry.addRecipe(pipe, "i  ", "c  ", "i  ",
                'i', ironIngot, 'c', cookie);
        GameRegistry.addRecipe(pipe, " i ", " c ", " i ",
                'i', ironIngot, 'c', cookie);
        GameRegistry.addRecipe(pipe, "  i", "  c", "  i",
                'i', ironIngot, 'c', cookie);

        GameRegistry.addRecipe(cookieBlock, "ccc", "ccc", "ccc",
                'c', cookie);

        GameRegistry.addRecipe(cookieCrafter, "iii", "ici", "iii",
                'i', ironIngot, 'c', cookie);

        GameRegistry.addRecipe(doughCollector, "iii","idi","iii",
                'i', ironIngot, 'd', cookieDough);

        GameRegistry.addRecipe(trashBaker,  "i i", "idi", "iii",
                'i', ironIngot, 'd', cookieDough);

        GameRegistry.addRecipe(cookieStorageWood, "www", "wcw", "www",
                'w', wood, 'c', cookie);

        GameRegistry.addRecipe(new ShapedCookieRecipe(cookieStorageIron, 1024, false, "iii", "ici", "iii",
                'i', ironIngot, 'c', emeraldCookiePouch));

        GameRegistry.addRecipe(new ShapedCookieRecipe(cookieStorageGold, 32768, false, "iii", "ici", "iii",
                'i', goldIngot, 'c', emeraldCookiePouch));

        GameRegistry.addRecipe(new ShapedCookieRecipe(cookieStorageDiamond, 1048576, false, "iii", "ici", "iii",
                'i', diamond, 'c', emeraldCookiePouch));

        GameRegistry.addRecipe(new ShapedCookieRecipe(cookieStorageEnder, 1073741824, false, "iii", "ici", "iii",
                'i', enderPearl, 'c', emeraldCookiePouch));


        GameRegistry.addRecipe(new ShapedCookieRecipe(cookieFarm, ModuleCookiecraft.config.costCookieFarm, false, "isi", "sps", "idi",
                'i', ironIngot, 's', seed, 'd', dirt, 'p', emeraldCookiePouch));

        GameRegistry.addRecipe(new ShapedCookieRecipe(cactusMasher, ModuleCookiecraft.config.costCactusMasher, false, "isi", "cpc", "iii",
                'i', ironIngot, 's', piston, 'c', cactus, 'p', emeraldCookiePouch));

        GameRegistry.addRecipe(new ShapedCookieRecipe(cookieSteamer, ModuleCookiecraft.config.costCookieStreamer, false, "iri", "gpg", "i i",
                'i', ironIngot, 'r', redstone, 'g', goldIngot, 'p', emeraldCookiePouch));

        GameRegistry.addRecipe(new ShapedCookieRecipe(cookieCircuit, ModuleCookiecraft.config.costCookieCircuit, false, "gcg", "rpr", "gcg",
                'c', cocoaBean, 'r', redstone, 'g', goldIngot, 'p', emeraldCookiePouch));

        GameRegistry.addRecipe(new ShapedCookieRecipe(moonlightReflector, ModuleCookiecraft.config.costMoonlightReflector, false, "ege", "ipi", "iii",
                'e', enderPearl, 'i', ironIngot, 'g', glass, 'p', emeraldCookiePouch));

        GameRegistry.addRecipe(new ShapedCookieRecipe(lavaConverter, ModuleCookiecraft.config.costLavaConverter, false, "ili", "gpg", "ili",
                'l', lava, 'i', ironIngot, 'g', glass, 'p', emeraldCookiePouch));

        GameRegistry.addRecipe(new ShapedCookieRecipe(nuclearBaker, ModuleCookiecraft.config.costNuclearBaker, false, "iui", "upu", "iui",
                'i', ironIngot, 'u', uraniumRod, 'p', emeraldCookiePouch));

        GameRegistry.addRecipe(new ShapedCookieRecipe(portalConnector, ModuleCookiecraft.config.costPortalConnector, false, "idi", "mpm", "ioi",
                'i', ironIngot, 'd', diamond, 'm', magicCookie, 'o', obsidian, 'p', emeraldCookiePouch));

        GameRegistry.addRecipe(new ShapedCookieRecipe(vacuumOven, ModuleCookiecraft.config.costVacuumOven, false, "eoe", "opo", "eoe",
                'e', emerald, 'o', obsidian, 'p', emeraldCookiePouch));

        GameRegistry.addRecipe(new ShapedCookieRecipe(ionChanneler, ModuleCookiecraft.config.costIonChanneler, false, "ded", "dpd", "ded",
                'e', enderPearl, 'd', diamond, 'p', emeraldCookiePouch));

        GameRegistry.addRecipe(new ShapedCookieRecipe(cookieAcceleratorPart, ModuleCookiecraft.config.costCookieAccelerator, false, "mmm", " p ", "mmm",
                'm', gemMixtureIngot, 'p', emeraldCookiePouch));

        GameRegistry.addRecipe(new ShapedCookieRecipe(cookieAcceleratorControl, ModuleCookiecraft.config.costCookieAccelerator, false, "mgm", " p ", "mim",
                'm', gemMixtureIngot, 'p', emeraldCookiePouch, 'g', glass, 'i', ironIngot));


        // Cookiepouchese

        GameRegistry.addRecipe(leatherCookiePouch, " s ", "lcl", " l ",
                's', string, 'c', cookie, 'l', leather);

        GameRegistry.addRecipe(new ShapedCookieRecipe(woodenCookiePouch, CookiecraftItems.leatherCookiePouch.getStorage(), true, " s ", "wpw", " w ",
                's', string, 'w', wood, 'p', leatherCookiePouch));

        GameRegistry.addRecipe(new ShapedCookieRecipe(stoneCookiePouch, CookiecraftItems.woodenCookiePouch.getStorage(), true, " s ", "wpw", " w ",
                's', string, 'w', stone, 'p', woodenCookiePouch));

        GameRegistry.addRecipe(new ShapedCookieRecipe(ironCookiePouch, CookiecraftItems.stoneCookiePouch.getStorage(), true, " s ", "wpw", " w ",
                's', string, 'w', ironIngot, 'p', stoneCookiePouch));

        GameRegistry.addRecipe(new ShapedCookieRecipe(goldenCookiePouch, CookiecraftItems.ironCookiePouch.getStorage(), true, " s ", "wpw", " w ",
                's', string, 'w', goldIngot, 'p', ironCookiePouch));

        GameRegistry.addRecipe(new ShapedCookieRecipe(diamondCookiePouch, CookiecraftItems.goldenCookiePouch.getStorage(), true, " s ", "wpw", " w ",
                's', string, 'w', diamond, 'p', goldenCookiePouch));

        GameRegistry.addRecipe(new ShapedCookieRecipe(emeraldCookiePouch, CookiecraftItems.diamondCookiePouch.getStorage(), true, " s ", "wpw", " w ",
                's', string, 'w', emerald, 'p', diamondCookiePouch));


        // General Cookiecraft blocks

        GameRegistry.addShapelessRecipe(cookieDough, wheat, cocoaBean, milk);

        GameRegistry.addShapelessRecipe(cookies, cookieBlock);

        GameRegistry.addRecipe(magicCookie, "bbb", "bcb", "bbb",
                'b', enchantedBook, 'c', cookie);

        GameRegistry.addShapelessRecipe(gemMixture, diamond, emerald);

        GameRegistry.addSmelting(gemMixture, gemMixtureIngot, 6.0F);

        GameRegistry.addSmelting(uraniumOre, uraniumRod, 6.0F);
    }
}
