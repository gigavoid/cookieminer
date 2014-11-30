package com.gigavoid.supermod.tileentity;

import com.gigavoid.supermod.renderer.RendererRopeWheel;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by ineentho on 2014-11-22.
 */
public class SuperTileEntities {
    public static void initializeEntities() {
        GameRegistry.registerTileEntity(PickBenchTileEntity.class, "pickBench");
        GameRegistry.registerTileEntity(VoidBenchTileEntity.class, "voidBench");
        GameRegistry.registerTileEntity(TileEntityRopeWheel.class, "ropeWheel");
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRopeWheel.class, new RendererRopeWheel());
    }
}
