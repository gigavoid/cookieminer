package com.gigavoid.supermod.cookiecraft;

import net.minecraftforge.common.config.ConfigCategory;
import net.minecraftforge.common.config.Configuration;

import java.io.File;

public class CookieConfiguration {
    private final Configuration config;


    public long costDoughCollector, costCookieFarm, costCactusMasher, costCookieStreamer,
        costSapGatherer, costCookieCircuit, costIceMelter, costMoonlightReflector, costSlimeCompressor,
        costLavaConverter, costBakingTable, costNuclearBaker, costPortalConnector, costVacuumOven,
        costIonChanneler, costCookieAccelerator;

    public double outputDoughCollector, outputCookieFarm, outputCactusMasher, outputCookieStreamer,
            outputSapGatherer, outputCookieCircuit, outputIceMelter, outputMoonlightReflector, outputSlimeCompressor,
            outputLavaConverter, outputBakingTable, outputNuclearBaker, outputPortalConnector, outputVacuumOven,
            outputIonChanneler, outputCookieAccelerator;

    public long pouchSizeLeather, pouchSizeWood, pouchSizeStone, pouchSizeIron, pouchSizeGold, pouchSizeDiamond, pouchSizeEmerald;


    public CookieConfiguration(File file) {
        this.config = new Configuration(file);
    }

    public void load() {
        config.load();

        ConfigCategory cat = config.getCategory("production cookie costs");
        cat.setComment("Sets the cost in cookies for cookie production");

        costCookieFarm = getLong(cat, "T02_CookieFarm", 8);
        costCactusMasher = getLong(cat, "T03_CactusMasher", 64);
        costCookieStreamer = getLong(cat, "T04_CookieStreamer", 512);
        costSapGatherer = getLong(cat, "T05_SapGatherer", 4096);
        costCookieCircuit = getLong(cat, "T06_CookieCicuit", 32768);
        costIceMelter = getLong(cat, "T07_IceMelter", 262144);
        costMoonlightReflector = getLong(cat, "T08_MoonlightReflector", 2097152);
        costSlimeCompressor = getLong(cat, "T09_SlimeCompressor", 16777216);
        costLavaConverter = getLong(cat, "T10_LavaConverter", 134217728);
        costBakingTable = getLong(cat, "T11_BakingTable", 1073741824);
        costNuclearBaker = getLong(cat, "T12_NuclearBaker", 8589934592L);
        costPortalConnector = getLong(cat, "T13_PortalConnector", 68719476736L);
        costVacuumOven = getLong(cat, "T14_VacuumOven", 549755813888L);
        costIonChanneler = getLong(cat, "T15_IonChanneler", 4398046511104L);
        costCookieAccelerator = getLong(cat, "T16_CookieAccelerator", 35184372088832L);



        cat = config.getCategory("production cookie outputs");
        cat.setComment("Sets the cookies per seconds for each production block");

        outputDoughCollector = getDouble(cat, "T01_DoughCollector", 1/16D * Math.pow(4, 0));
        outputCookieFarm = getDouble(cat, "T02_CookieFarm", 1/16D * Math.pow(4, 1));
        outputCactusMasher = getDouble(cat, "T03_CactusMasher", 1/16D * Math.pow(4, 2));
        outputCookieStreamer = getDouble(cat, "T04_CookieStreamer", 1/16D * Math.pow(4, 3));
        outputSapGatherer = getDouble(cat, "T05_SapGatherer", 1/16D * Math.pow(4, 4));
        outputCookieCircuit = getDouble(cat, "T06_CookieCicuit", 1/16D * Math.pow(4, 5));
        outputIceMelter = getDouble(cat, "T07_IceMelter", 1/16D * Math.pow(4, 6));
        outputMoonlightReflector = getDouble(cat, "T08_MoonlightReflector", 1/16D * Math.pow(4, 7));
        outputSlimeCompressor = getDouble(cat, "T09_SlimeCompressor", 1/16D * Math.pow(4, 8));
        outputLavaConverter = getDouble(cat, "T10_LavaConverter", 1/16D * Math.pow(4, 9));
        outputBakingTable = getDouble(cat, "T11_BakingTable", 1/16D * Math.pow(4, 10));
        outputNuclearBaker = getDouble(cat, "T12_NuclearBaker", 1/16D * Math.pow(4, 11));
        outputPortalConnector = getDouble(cat, "T13_PortalConnector", 1/16D * Math.pow(4, 12));
        outputVacuumOven = getDouble(cat, "T14_VacuumOven", 1/16D * Math.pow(4, 13));
        outputIonChanneler = getDouble(cat, "T15_IonChanneler", 1/16D * Math.pow(4, 14));
        outputCookieAccelerator = getDouble(cat, "T16_CookieAccelerator", 1/16D * Math.pow(4, 15));



        cat = config.getCategory("pouch sizes");
        cat.setComment("Sets the size of cookie pouches");

        pouchSizeLeather = getLong(cat, "T01_LeatherPouch", 32);
        pouchSizeWood = getLong(cat, "T02_WoodenPouch", 1024);
        pouchSizeStone = getLong(cat, "T03_StonePouch", 32768);
        pouchSizeIron = getLong(cat, "T04_IronPouch", 1048576);
        pouchSizeGold = getLong(cat, "T05_GoldenPouch", 33554432);
        pouchSizeDiamond = getLong(cat, "T06_DiamondPouch", 1073741824);
        pouchSizeEmerald = getLong(cat, "T07_EmeraldPouch", 34359738368L);

        config.save();
    }



    private long getLong(ConfigCategory cat, String key, long def) {
        return Long.parseLong(config.get(cat.getName(), key, String.valueOf(def)).getString());
    }

    private double getDouble(ConfigCategory cat, String key, double def) {
        return config.get(cat.getName(), key, def).getDouble();
    }
}
