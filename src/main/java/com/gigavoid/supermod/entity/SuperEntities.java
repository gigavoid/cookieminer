package com.gigavoid.supermod.entity;

import com.gigavoid.supermod.SuperMod;
import com.gigavoid.supermod.renderer.RendererBasket;
import com.gigavoid.supermod.renderer.RendererRope;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.EntityList;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;

/**
 * Created by Rasmus on 2014-11-05.
 */
public class SuperEntities {
    public static void registerEntities(){
        EntityList.addMapping(EntityYeti.class, "entityYeti", 67, 0xFFFFFF, 0x666666);

        registerWithRenderer(EntityRope.class, new RendererRope(Minecraft.getMinecraft().getRenderManager()), "entityRope", 64, -1, 5);
        registerWithRenderer(EntityBasket.class, new RendererBasket(Minecraft.getMinecraft().getRenderManager()), "entityBasket", 64, 1, 6);

    }

    private static void registerWithRenderer(Class clazz, Render renderer, String name, int range, int freq, int id) {
        EntityRegistry.registerModEntity(clazz, name, id, SuperMod.instance, range, freq, true);
        EntityRegistry.registerGlobalEntityID(clazz, name, id);
        RenderingRegistry.registerEntityRenderingHandler(clazz, renderer);
    }
}
