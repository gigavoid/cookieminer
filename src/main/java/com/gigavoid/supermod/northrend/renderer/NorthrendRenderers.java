package com.gigavoid.supermod.northrend.renderer;

import com.gigavoid.supermod.northrend.entity.EntityNorthrendDragon;
import com.gigavoid.supermod.northrend.renderer.entity.RenderNorthrendDragon;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class NorthrendRenderers {
    public static void registerRenderers(){
        RenderingRegistry.registerEntityRenderingHandler(EntityNorthrendDragon.class,
                new RenderNorthrendDragon(Minecraft.getMinecraft().getRenderManager()));
    }
}
