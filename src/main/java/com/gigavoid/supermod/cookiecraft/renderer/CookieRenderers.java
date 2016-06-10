package com.gigavoid.supermod.cookiecraft.renderer;

import com.gigavoid.supermod.cookiecraft.entity.EntityCookiecreeper;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class CookieRenderers {
    public static void registerRenderers(){
        RenderingRegistry.registerEntityRenderingHandler(EntityCookiecreeper.class, new RenderCookiecreeper(Minecraft.getMinecraft().getRenderManager()));
    }
}
