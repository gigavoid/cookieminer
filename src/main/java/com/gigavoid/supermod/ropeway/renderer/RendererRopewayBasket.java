package com.gigavoid.supermod.ropeway.renderer;

import com.gigavoid.supermod.ropeway.model.ModelRopewayBasket;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Vec3;
import org.lwjgl.opengl.GL11;

public class RendererRopewayBasket extends Render {
    public ModelRopewayBasket model = new ModelRopewayBasket();

    public RendererRopewayBasket(RenderManager p_i46179_1_) {
        super(p_i46179_1_);
    }

    @Override
    public void doRender(Entity entity, double x, double y, double z, float p_76986_8_, float tickProgress) {
        GL11.glPushMatrix();
        //GL11.glTranslatef((float) x + 0.5f, (float) y +.5f, (float) z + 0.5f);

        x += (entity.posX - entity.lastTickPosX) * (double)tickProgress;
        y += (entity.posY - entity.lastTickPosY) * (double)tickProgress;
        z += (entity.posZ - entity.lastTickPosZ) * (double)tickProgress;

        GL11.glTranslatef((float)x, (float)y, (float)z);

        ResourceLocation textures = (new ResourceLocation("supermod:textures/blocks/ropeway_engine.png"));
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
