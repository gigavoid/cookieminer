package com.gigavoid.supermod.northrend;

import com.gigavoid.supermod.common.module.Module;
import com.gigavoid.supermod.northrend.biome.NorthrendBiomes;
import com.gigavoid.supermod.northrend.block.NorthrendBlocks;
import com.gigavoid.supermod.northrend.event.NorthrendEventHandler;
import com.gigavoid.supermod.northrend.item.NorthrendItems;
import com.gigavoid.supermod.northrend.recipe.NorthrendRecipies;
import com.gigavoid.supermod.northrend.worldgen.custom.NorthrendWorldProvider;
import com.gigavoid.supermod.northrend.worldgen.gen.NorthrendMapGenFortress;
import com.gigavoid.supermod.northrend.worldgen.gen.NorthrendMapGenOres;
import com.gigavoid.supermod.northrend.worldgen.gen.NorthrendMapGenVillage;
import com.gigavoid.supermod.northrend.worldgen.structures.NorthrendStructureFortressPieces;
import com.gigavoid.supermod.northrend.worldgen.structures.NorthrendStructureVillagePieces;
import net.minecraft.util.DamageSource;
import net.minecraft.world.gen.structure.MapGenStructureIO;
import net.minecraft.world.gen.structure.MapGenVillage;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ModuleNorthrend extends Module {
    public static int dimensionId;
    public static final DamageSource freeze = (new DamageSource("freeze")).setDamageBypassesArmor().setDamageIsAbsolute();

    @Override
    public void preInit(FMLPreInitializationEvent e){
        NorthrendBlocks.initializeBlocks(getRegister());
        NorthrendBiomes.registerBiomes();

        dimensionId = getRegister().registerDimension(NorthrendWorldProvider.class, false);
        getRegister().registerWorldGenerator(new NorthrendMapGenOres(), 20);

        List villageSpawnBiomes = new ArrayList(MapGenVillage.villageSpawnBiomes);
        villageSpawnBiomes.addAll(Arrays.asList(NorthrendBiomes.northHighlands, NorthrendBiomes.northPlains));
        MapGenVillage.villageSpawnBiomes = villageSpawnBiomes;
    }

    @Override
    public void init(FMLInitializationEvent e){
        NorthrendBlocks.registerBlocks(getRegister());
        NorthrendItems.registerItems(e, getRegister());
        NorthrendRecipies.registerRecipies();

        MapGenStructureIO.registerStructure(NorthrendMapGenFortress.Start.class, "Northrend Fortress");
        MapGenStructureIO.registerStructure(NorthrendMapGenVillage.Start.class, "Northrend Village");
        NorthrendStructureFortressPieces.registerNetherFortressPieces();
        NorthrendStructureVillagePieces.registerVillagePieces();

        NorthrendEventHandler northendEventHandler = new NorthrendEventHandler();
        FMLCommonHandler.instance().bus().register(northendEventHandler);
        MinecraftForge.EVENT_BUS.register(northendEventHandler);
        //MinecraftForge.TERRAIN_GEN_BUS.register(northendEventHandler);
    }
}
