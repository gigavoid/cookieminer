package com.gigavoid.supermod.northrend;

import com.gigavoid.supermod.common.module.Module;
import com.gigavoid.supermod.northrend.biome.NorthrendBiomes;
import com.gigavoid.supermod.northrend.block.NorthrendBlocks;
import com.gigavoid.supermod.northrend.entity.NorthrendEntities;
import com.gigavoid.supermod.northrend.event.NorthrendEventHandler;
import com.gigavoid.supermod.northrend.item.NorthrendItems;
import com.gigavoid.supermod.northrend.recipe.NorthrendRecipies;
import com.gigavoid.supermod.northrend.renderer.NorthrendRenderers;
import com.gigavoid.supermod.northrend.worldgen.custom.NorthrendWorldProvider;
import com.gigavoid.supermod.northrend.worldgen.gen.NorthrendMapGenFortress;
import com.gigavoid.supermod.northrend.worldgen.gen.NorthrendMapGenOres;
import com.gigavoid.supermod.northrend.worldgen.gen.NorthrendMapGenVillage;
import com.gigavoid.supermod.northrend.worldgen.structures.NorthrendStructureFortressPieces;
import com.gigavoid.supermod.northrend.worldgen.structures.NorthrendStructureMineshaftPieces;
import com.gigavoid.supermod.northrend.worldgen.structures.NorthrendStructureMineshaftStart;
import com.gigavoid.supermod.northrend.worldgen.structures.NorthrendStructureVillagePieces;
import net.minecraft.util.DamageSource;
import net.minecraft.world.gen.structure.MapGenStructureIO;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import scala.Console;

public class ModuleNorthrend extends Module {
    public static int dimensionId;
    public static final DamageSource freeze = (new DamageSource("freeze")).setDamageBypassesArmor();

    @Override
    public void preInit(FMLPreInitializationEvent e){
        NorthrendBlocks.initializeBlocks(getRegister(e.getSide()));
        NorthrendEntities.registerEntities(getRegister(e.getSide()));
        NorthrendBiomes.registerBiomes(getRegister(e.getSide()));

        dimensionId = getRegister(e.getSide()).registerDimension(NorthrendWorldProvider.class, false);
        getRegister(e.getSide()).registerWorldGenerator(new NorthrendMapGenOres(), 20);
    }

    @Override
    public void init(FMLInitializationEvent e){
        NorthrendBlocks.registerBlocks(getRegister(e.getSide()));
        NorthrendItems.registerItems(e, getRegister(e.getSide()));
        NorthrendRecipies.registerRecipies();
        NorthrendRenderers.registerRenderers();

        MapGenStructureIO.registerStructure(NorthrendMapGenFortress.Start.class, "Northrend Fortress");
        MapGenStructureIO.registerStructure(NorthrendMapGenVillage.Start.class, "Northrend Village");
        MapGenStructureIO.registerStructure(NorthrendStructureMineshaftStart.class, "Northrend Mineshaft");
        NorthrendStructureFortressPieces.registerNetherFortressPieces();
        NorthrendStructureVillagePieces.registerVillagePieces();
        NorthrendStructureMineshaftPieces.registerStructurePieces();

        NorthrendEventHandler northendEventHandler = new NorthrendEventHandler();
        FMLCommonHandler.instance().bus().register(northendEventHandler);
        MinecraftForge.EVENT_BUS.register(northendEventHandler);
    }
}
