package com.gigavoid.supermod.ropeway.entity;

import com.gigavoid.supermod.SuperMod;
import com.gigavoid.supermod.ropeway.renderer.RendererRopewayBasket;
import com.gigavoid.supermod.ropeway.renderer.RendererRope;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class RopewayEntities {
    public static void registerEntities(Side side){

		registerEntity(EntityRope.class, "entity_rope", 64, -1, 5);
        registerEntity(EntityRopewayBasket.class, "entity_basket", 64, 1, 6);

		if (side == Side.CLIENT)
			registerRenderers();
    }

	@SideOnly(Side.CLIENT)
	private static void registerRenderers() {
		registerRenderer(EntityRope.class, new RendererRope(Minecraft.getMinecraft().getRenderManager()));
		registerRenderer(EntityRopewayBasket.class, new RendererRopewayBasket(Minecraft.getMinecraft().getRenderManager()));
	}

	@SideOnly(Side.CLIENT)
	private static void registerRenderer(Class<? extends Entity> clazz, Render renderer) {
		RenderingRegistry.registerEntityRenderingHandler(clazz, renderer);
	}

	private static void registerEntity(Class clazz, String name, int range, int freq, int id) {
        EntityRegistry.registerModEntity(clazz, name, id, SuperMod.instance, range, freq, true);
        EntityRegistry.registerGlobalEntityID(clazz, name, id);
    }
}
