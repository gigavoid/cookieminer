package com.gigavoid.supermod.renderer;

import com.gigavoid.supermod.entity.EntityYeti;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

/**
 * Created by Rasmus on 2014-11-05.
 */
public class SuperRenderer {
    public static void registerRenderers(){
        RenderingRegistry.registerEntityRenderingHandler(EntityYeti.class, new RendererYeti());
    }
}
