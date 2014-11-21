package com.gigavoid.supermod.renderer;

import com.gigavoid.supermod.entity.EntityRope;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

/**
 * Created by ineentho on 2014-11-03.
 */
public class RendererRope extends Render {

    public RendererRope() {
    }

    @Override
    public void doRender(Entity entity, double x, double y, double z, float p_76986_8_, float p_76986_9_) {
        EntityRope rope = (EntityRope) entity;
        GL11.glPushMatrix();
        GL11.glTranslatef((float) x + 0.5f, (float) y + .5f, (float) z + 0.5f);

        ResourceLocation textures = (new ResourceLocation("supermod:textures/blocks/ropeWheel.png"));
        Minecraft.getMinecraft().renderEngine.bindTexture(textures);

        GL11.glPushMatrix();

        rope.model.render();
        GL11.glPopMatrix();
        GL11.glPopMatrix();
    }

    @Override
    protected ResourceLocation getEntityTexture(Entity p_110775_1_) {
        return null;
    }
}
