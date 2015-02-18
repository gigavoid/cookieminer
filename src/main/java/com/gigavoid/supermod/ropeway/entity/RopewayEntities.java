package com.gigavoid.supermod.ropeway.entity;

import com.gigavoid.supermod.SuperMod;
import com.gigavoid.supermod.ropeway.renderer.RendererRopewayBasket;
import com.gigavoid.supermod.ropeway.renderer.RendererRope;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.Render;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class RopewayEntities {
    public static void registerEntities(){
        registerWithRenderer(EntityRope.class, new RendererRope(Minecraft.getMinecraft().getRenderManager()), "entity_rope", 64, -1, 5);
        registerWithRenderer(EntityRopewayBasket.class, new RendererRopewayBasket(Minecraft.getMinecraft().getRenderManager()), "entity_basket", 64, 1, 6);

    }

    private static void registerWithRenderer(Class clazz, Render renderer, String name, int range, int freq, int id) {
        EntityRegistry.registerModEntity(clazz, name, id, SuperMod.instance, range, freq, true);
        EntityRegistry.registerGlobalEntityID(clazz, name, id);
        RenderingRegistry.registerEntityRenderingHandler(clazz, renderer);
    }
}
