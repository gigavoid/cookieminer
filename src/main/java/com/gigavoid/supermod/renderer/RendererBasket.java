package com.gigavoid.supermod.renderer;

import com.gigavoid.supermod.entity.ModelBasket;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

/**
 * Created by ineentho on 2014-11-22.
 */
public class RendererBasket extends Render {

    public ModelBasket model = new ModelBasket();

    public RendererBasket(RenderManager p_i46179_1_) {
        super(p_i46179_1_);
    }

    @Override
    public void doRender(Entity entity, double x, double y, double z, float p_76986_8_, float p_76986_9_) {
        GL11.glPushMatrix();
        //GL11.glTranslatef((float) x + 0.5f, (float) y +.5f, (float) z + 0.5f);
        GL11.glTranslatef((float)x, (float)y, (float)z);

        ResourceLocation textures = (new ResourceLocation("supermod:textures/blocks/ropeWheel.png"));
        Minecraft.getMinecraft().renderEngine.bindTexture(textures);


        GL11.glPushMatrix();
        GL11.glRotatef(180, 1, 0,0);
        model.render();
        GL11.glPopMatrix();
        GL11.glPopMatrix();
    }

    @Override
    protected ResourceLocation getEntityTexture(Entity p_110775_1_) {
        return null;
    }
}
