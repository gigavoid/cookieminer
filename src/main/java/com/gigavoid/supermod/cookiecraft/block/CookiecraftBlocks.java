package com.gigavoid.supermod.cookiecraft.block;

import com.gigavoid.supermod.common.Register;

public class CookiecraftBlocks {
    public static void initializeBlocks(Register register) {
        register.registerBlock(BlockCookieCrafter.instance, "cookie_crafter");
        register.registerBlock(BlockCookiePortalCookiecraft.instance, "cookie_portal");
        register.registerBlock(BlockCookieBlock.instance, "cookie_block");
        register.registerBlock(BlockCookieDoughCollector.instance, "cookie_dough_collector");
        register.registerBlock(BlockCookieBurntCookieBlock.instance, "cookie_burnt_block");
        register.registerBlock(BlockCookiePortalConnector.instance, "cookie_portal_connector");
        register.registerBlock(BlockCookieLavaConverter.instance, "cookie_lava_converter");
        register.registerBlock(BlockCookieMoonlightReflector.instance, "cookie_moonlight_reflector");
        register.registerBlock(BlockCookiePipe.instance, "cookie_pipe");
        register.registerBlock(BlockCookieCactusMasher.instance, "cookie_cactus_masher");
        register.registerBlock(BlockCookieCocoaCircuit.instance, "cookie_cocoa_circuit");
        register.registerBlock(BlockCookieFarm.instance, "cookie_farm");
        register.registerBlock(BlockCookieSteamer.instance, "cookie_steamer");
        register.registerBlock(BlockCookieVacuumOven.instance, "cookie_vacuum_oven");
        register.registerBlock(BlockCookieIonChanneler.instance, "cookie_ion_channeler");
        register.registerBlock(BlockCookieTrashBaker.instance, "cookie_trash_baker");
        register.registerBlock(BlockCookieAcceleratorControl.instance, "cookie_accelerator_control");
        register.registerBlock(BlockCookieAcceleratorPart.instance, "cookie_accelerator_part");
        register.registerBlock(BlockCookieNuclearBaker.instance, "cookie_nuclear_baker");
        register.registerBlock(BlockCookieOreUranium.instance, "cookie_ore_uranium");
        register.registerBlock(BlockCookieSlimeCompressor.instance, "cookie_slime_compressor");
        register.registerBlock(BlockCookieSapGatherer.instance, "cookie_sap_gatherer");
        register.registerBlock(BlockCookieIceMelter.instance, "cookie_ice_melter");
        register.registerBlock(BlockCookieBakingTable.instance, "cookie_baking_table");

        for (String key : BlockCookieStorage.instances.keySet()){
            register.registerBlock(BlockCookieStorage.instances.get(key), "cookie_storage_" + key);
        }
    }
}
