package com.gigavoid.supermod.ropeway;

import com.gigavoid.supermod.common.module.Module;
import com.gigavoid.supermod.ropeway.biome.RopewayBiomes;
import com.gigavoid.supermod.ropeway.entity.RopewayEntities;
import com.gigavoid.supermod.ropeway.item.RopewayItems;
import com.gigavoid.supermod.ropeway.renderer.RendererRopewayEngine;
import com.gigavoid.supermod.ropeway.block.RopewayBlocks;
import com.gigavoid.supermod.ropeway.tileentity.TileEntityRopewayEngine;
import com.gigavoid.supermod.ropeway.worldgen.RopewayWorldProvider;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModuleRopeway extends Module {
    public static int dimensionId;

    @Override
    public void preInit(FMLPreInitializationEvent e) {
        RopewayBiomes.registerBiomes(getRegister());

        dimensionId = getRegister().registerDimension(RopewayWorldProvider.class, false);
    }

    @Override
    public void init(FMLInitializationEvent e) {
        RopewayBlocks.initializeBlocks(getRegister());
        RopewayItems.initializeItems(getRegister(), e);
        RopewayEntities.registerEntities();

        GameRegistry.registerTileEntity(TileEntityRopewayEngine.class, "ropeway_engine");
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRopewayEngine.class, new RendererRopewayEngine());
    }
}
