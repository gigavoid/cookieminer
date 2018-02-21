package com.gigavoid.supermod.cookiecraft.item;

import com.gigavoid.supermod.common.RegistrationHandler;
import com.gigavoid.supermod.cookiecraft.ModuleCookiecraft;
import com.gigavoid.supermod.cookiecraft.block.BlockCookieChocoFluid;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.Arrays;
import java.util.List;

public class CookiecraftItems {
    public static final ItemMagicCookie magicCookie = new ItemMagicCookie("cookie_magic");
    public static final ItemCookieDough cookieDough = new ItemCookieDough("cookie_dough");
    public static final ItemCookieGemMixture cookieGemMixture = new ItemCookieGemMixture("cookie_gem_mixture");
    public static final ItemCookieGemMixtureIngot cookieGemMixtureIngot = new ItemCookieGemMixtureIngot("cookie_gem_mixture_ingot");
    public static final ItemCookieUraniumRod cookieUraniumRod = new ItemCookieUraniumRod("cookie_uranium_rod");
    // public static final ItemCookieBucket cookieChocoBucket = new ItemCookieBucket("cookie_bucket_choco", BlockCookieChocoFluid.instance);

    public static final ItemCookiePouch leatherCookiePouch = new ItemCookiePouch("cookie_pouch_leather", 32);
    public static final ItemCookiePouch woodenCookiePouch = new ItemCookiePouch("cookie_pouch_wood", 1024);
    public static final ItemCookiePouch stoneCookiePouch = new ItemCookiePouch("cookie_pouch_stone", 32768);
    public static final ItemCookiePouch ironCookiePouch = new ItemCookiePouch("cookie_pouch_iron", 1048576);
    public static final ItemCookiePouch goldenCookiePouch = new ItemCookiePouch("cookie_pouch_gold", 33554432);
    public static final ItemCookiePouch diamondCookiePouch = new ItemCookiePouch("cookie_pouch_diamond", 1073741824);
    public static final ItemCookiePouch emeraldCookiePouch = new ItemCookiePouch("cookie_pouch_emerald", 34359738368L);

    public static final ItemInfiniteCookiePouch infiniteCookiePouch = new ItemInfiniteCookiePouch("cookie_pouch_infinite");
    public static final ItemCookiePouchOverflow overflowCookiePouch = new ItemCookiePouchOverflow("cookie_pouch_overflow");

    public static final ItemFlatCPSUpgrade upgradeFlatCPS1 = new ItemFlatCPSUpgrade("cookie_upgrade_flat_1", 1/4d);
    public static final ItemFlatCPSUpgrade upgradeFlatCPS2 = new ItemFlatCPSUpgrade("cookie_upgrade_flat_2", 2);
    public static final ItemFlatCPSUpgrade upgradeFlatCPS3 = new ItemFlatCPSUpgrade("cookie_upgrade_flat_3", 256);
    public static final ItemFlatCPSUpgrade upgradeFlatCPS4 = new ItemFlatCPSUpgrade("cookie_upgrade_flat_4", 8096);

    public static final ItemMultiplicativeCPSUpgrade upgradeMultCPS1 = new ItemMultiplicativeCPSUpgrade("cookie_upgrade_mult_1", 1.2);
    public static final ItemMultiplicativeCPSUpgrade upgradeMultCPS2 = new ItemMultiplicativeCPSUpgrade("cookie_upgrade_mult_2", 1.5);
    public static final ItemMultiplicativeCPSUpgrade upgradeMultCPS3 = new ItemMultiplicativeCPSUpgrade("cookie_upgrade_mult_3", 2);
    public static final ItemMultiplicativeCPSUpgrade upgradeMultCPS4 = new ItemMultiplicativeCPSUpgrade("cookie_upgrade_mult_4", 3);

    public static final List<ItemCookiePouch> cookiePouches = Arrays.asList(leatherCookiePouch, woodenCookiePouch, stoneCookiePouch, ironCookiePouch, goldenCookiePouch, diamondCookiePouch, emeraldCookiePouch);

    public static void register(IForgeRegistry<Item> registry) {
        registry.registerAll(
                magicCookie,
                cookieDough,
                cookieGemMixture,
                cookieGemMixtureIngot,
                cookieUraniumRod,
                /*cookieChocoBucket,*/

                leatherCookiePouch,
                woodenCookiePouch,
                stoneCookiePouch,
                ironCookiePouch,
                goldenCookiePouch,
                diamondCookiePouch,
                emeraldCookiePouch,

                infiniteCookiePouch,
                overflowCookiePouch,

                upgradeFlatCPS1,
                upgradeFlatCPS2,
                upgradeFlatCPS3,
                upgradeFlatCPS4,

                upgradeMultCPS1,
                upgradeMultCPS2,
                upgradeMultCPS3,
                upgradeMultCPS4
        );
    }

    public static void registerModels() {
        magicCookie.registerItemModel();
        cookieDough.registerItemModel();
        cookieGemMixture.registerItemModel();
        cookieGemMixtureIngot.registerItemModel();
        cookieUraniumRod.registerItemModel();
        // cookieChocoBucket.registerItemModel();

        leatherCookiePouch.registerItemModel();
        woodenCookiePouch.registerItemModel();
        stoneCookiePouch.registerItemModel();
        ironCookiePouch.registerItemModel();
        goldenCookiePouch.registerItemModel();
        diamondCookiePouch.registerItemModel();
        emeraldCookiePouch.registerItemModel();

        infiniteCookiePouch.registerItemModel();
        overflowCookiePouch.registerItemModel();

        upgradeFlatCPS1.registerItemModel();
        upgradeFlatCPS2.registerItemModel();
        upgradeFlatCPS3.registerItemModel();
        upgradeFlatCPS4.registerItemModel();

        upgradeMultCPS1.registerItemModel();
        upgradeMultCPS2.registerItemModel();
        upgradeMultCPS3.registerItemModel();
        upgradeMultCPS4.registerItemModel();
    }
}
