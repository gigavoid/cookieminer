package com.gigavoid.supermod.cookiecraft.block;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.registries.IForgeRegistry;

public class CookiecraftBlocks {
    public static final BlockCookieBlock cookieBlock = new BlockCookieBlock("cookie_block");
    public static final BlockCookieBurntCookieBlock burntCookieBlock = new BlockCookieBurntCookieBlock("cookie_burnt_block");
    public static final BlockCookieOreUranium oreUranium = new BlockCookieOreUranium("cookie_ore_uranium");

    //public static final BlockCookiePortalCookiecraft portal = new BlockCookiePortalCookiecraft("cookie_portal");
    public static final BlockCookieCrafter cookieCrafter = new BlockCookieCrafter("cookie_crafter");
    public static final BlockCookieTrashBaker trashBaker = new BlockCookieTrashBaker("cookie_trash_baker");
    public static final BlockCookiePipe pipe = new BlockCookiePipe("cookie_pipe");

    public static final BlockCookieDoughCollector doughCollector = new BlockCookieDoughCollector("cookie_dough_collector");
    public static final BlockCookieFarm cookieFarm = new BlockCookieFarm("cookie_farm");
    public static final BlockCookieCactusMasher cactusMasher = new BlockCookieCactusMasher("cookie_cactus_masher");
    public static final BlockCookieSteamer cookieSteamer = new BlockCookieSteamer("cookie_steamer");
    public static final BlockCookieSapGatherer sapGatherer = new BlockCookieSapGatherer("cookie_sap_gatherer");
    public static final BlockCookieCocoaCircuit cocoaCircuit = new BlockCookieCocoaCircuit("cookie_cocoa_circuit");
    public static final BlockCookieIceMelter iceMelter = new BlockCookieIceMelter("cookie_ice_melter");
    public static final BlockCookieMoonlightReflector moonlightReflector = new BlockCookieMoonlightReflector("cookie_moonlight_reflector");
    public static final BlockCookieSlimeCompressor slimeCompressor = new BlockCookieSlimeCompressor("cookie_slime_compressor");
    public static final BlockCookieLavaConverter lavaConverter = new BlockCookieLavaConverter("cookie_lava_converter");
    public static final BlockCookieBakingTable bakingTable = new BlockCookieBakingTable("cookie_baking_table");
    public static final BlockCookieNuclearBaker nuclearBaker = new BlockCookieNuclearBaker("cookie_nuclear_baker");
    public static final BlockCookiePortalConnector portalConnector = new BlockCookiePortalConnector("cookie_portal_connector");
    public static final BlockCookieVacuumOven vacuumOven = new BlockCookieVacuumOven("cookie_vacuum_oven");
    public static final BlockCookieIonChanneler ionChanneler = new BlockCookieIonChanneler("cookie_ion_channeler");
    public static final BlockCookieAcceleratorControl acceleratorControl = new BlockCookieAcceleratorControl("cookie_accelerator_control");
    public static final BlockCookieAcceleratorPart acceleratorPart = new BlockCookieAcceleratorPart("cookie_accelerator_part");

    public static final BlockCookieStorage woodenCookieStorage = new BlockCookieStorage("cookie_storage_wood", 256, 1);
    public static final BlockCookieStorage ironCookieStorage = new BlockCookieStorage("cookie_storage_iron", 16384, 64);
    public static final BlockCookieStorage goldenCookieStorage = new BlockCookieStorage("cookie_storage_gold", 262144, 4096);
    public static final BlockCookieStorage diamondCookieStorage = new BlockCookieStorage("cookie_storage_diamond", 268435456, 262144);
    public static final BlockCookieStorage endCookieStorage = new BlockCookieStorage("cookie_storage_ender", 274877906944L, 268435456);

    public static void register(IForgeRegistry<Block> registry) {
        registry.registerAll(
                cookieBlock,
                burntCookieBlock,
                oreUranium,

                /*portal,*/
                cookieCrafter,
                trashBaker,
                pipe,

                doughCollector,
                cookieFarm,
                cactusMasher,
                cookieSteamer,
                sapGatherer,
                cocoaCircuit,
                iceMelter,
                moonlightReflector,
                slimeCompressor,
                lavaConverter,
                bakingTable,
                nuclearBaker,
                portalConnector,
                vacuumOven,
                acceleratorControl,
                acceleratorPart,

                woodenCookieStorage,
                ironCookieStorage,
                goldenCookieStorage,
                diamondCookieStorage,
                endCookieStorage
        );
    }

    public static void registerItemBlocks(IForgeRegistry<Item> registry) {
        registry.registerAll(
                cookieBlock.createItemBlock(),
                burntCookieBlock.createItemBlock(),
                oreUranium.createItemBlock(),

                /*portal.cre,*/
                cookieCrafter.createItemBlock(),
                trashBaker.createItemBlock(),
                pipe.createItemBlock(),

                doughCollector.createItemBlock(),
                cookieFarm.createItemBlock(),
                cactusMasher.createItemBlock(),
                cookieSteamer.createItemBlock(),
                sapGatherer.createItemBlock(),
                cocoaCircuit.createItemBlock(),
                iceMelter.createItemBlock(),
                moonlightReflector.createItemBlock(),
                slimeCompressor.createItemBlock(),
                lavaConverter.createItemBlock(),
                bakingTable.createItemBlock(),
                nuclearBaker.createItemBlock(),
                portalConnector.createItemBlock(),
                vacuumOven.createItemBlock(),
                acceleratorControl.createItemBlock(),
                acceleratorPart.createItemBlock(),

                woodenCookieStorage.createItemBlock(),
                ironCookieStorage.createItemBlock(),
                goldenCookieStorage.createItemBlock(),
                diamondCookieStorage.createItemBlock(),
                endCookieStorage.createItemBlock()
        );
    }

    public static void registerModels() {
        cookieBlock.registerItemModel(Item.getItemFromBlock(cookieBlock));
        burntCookieBlock.registerItemModel(Item.getItemFromBlock(burntCookieBlock));
        oreUranium.registerItemModel(Item.getItemFromBlock(oreUranium));

        // portal.registerItemModel(Item.getItemFromBlock(portal));
        cookieCrafter.registerItemModel(Item.getItemFromBlock(cookieCrafter));
        trashBaker.registerItemModel(Item.getItemFromBlock(trashBaker));
        pipe.registerItemModel(Item.getItemFromBlock(pipe));

        doughCollector.registerItemModel(Item.getItemFromBlock(doughCollector));
        cookieFarm.registerItemModel(Item.getItemFromBlock(cookieFarm));
        cactusMasher.registerItemModel(Item.getItemFromBlock(cactusMasher));
        cookieSteamer.registerItemModel(Item.getItemFromBlock(cookieSteamer));
        sapGatherer.registerItemModel(Item.getItemFromBlock(sapGatherer));
        cocoaCircuit.registerItemModel(Item.getItemFromBlock(cocoaCircuit));
        iceMelter.registerItemModel(Item.getItemFromBlock(iceMelter));
        moonlightReflector.registerItemModel(Item.getItemFromBlock(moonlightReflector));
        slimeCompressor.registerItemModel(Item.getItemFromBlock(slimeCompressor));
        lavaConverter.registerItemModel(Item.getItemFromBlock(lavaConverter));
        bakingTable.registerItemModel(Item.getItemFromBlock(bakingTable));
        nuclearBaker.registerItemModel(Item.getItemFromBlock(nuclearBaker));
        portalConnector.registerItemModel(Item.getItemFromBlock(portalConnector));
        vacuumOven.registerItemModel(Item.getItemFromBlock(vacuumOven));
        ionChanneler.registerItemModel(Item.getItemFromBlock(ionChanneler));
        acceleratorControl.registerItemModel(Item.getItemFromBlock(acceleratorControl));
        acceleratorPart.registerItemModel(Item.getItemFromBlock(acceleratorPart));

        woodenCookieStorage.registerItemModel(Item.getItemFromBlock(woodenCookieStorage));
        ironCookieStorage.registerItemModel(Item.getItemFromBlock(ironCookieStorage));
        goldenCookieStorage.registerItemModel(Item.getItemFromBlock(goldenCookieStorage));
        diamondCookieStorage.registerItemModel(Item.getItemFromBlock(diamondCookieStorage));
        endCookieStorage.registerItemModel(Item.getItemFromBlock(endCookieStorage));
    }
}
