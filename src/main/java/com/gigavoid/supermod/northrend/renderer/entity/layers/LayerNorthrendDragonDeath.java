package com.gigavoid.supermod.northrend.renderer.entity.layers;

import com.gigavoid.supermod.northrend.entity.EntityNorthrendDragon;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.entity.EntityLivingBase;

import java.util.Random;

public class LayerNorthrendDragonDeath implements LayerRenderer {
    public void func_177213_a(EntityNorthrendDragon p_177213_1_, float p_177213_2_, float p_177213_3_, float p_177213_4_, float p_177213_5_, float p_177213_6_, float p_177213_7_, float p_177213_8_)
    {
        if (p_177213_1_.deathTicks > 0)
        {
            Tessellator tessellator = Tessellator.getInstance();
            WorldRenderer worldrenderer = tessellator.getWorldRenderer();
            RenderHelper.disableStandardItemLighting();
            float f7 = ((float)p_177213_1_.deathTicks + p_177213_4_) / 200.0F;
            float f8 = 0.0F;

            if (f7 > 0.8F)
            {
                f8 = (f7 - 0.8F) / 0.2F;
            }

            Random random = new Random(432L);
            GlStateManager.func_179090_x();
            GlStateManager.shadeModel(7425);
            GlStateManager.enableBlend();
            GlStateManager.blendFunc(770, 1);
            GlStateManager.disableAlpha();
            GlStateManager.enableCull();
            GlStateManager.depthMask(false);
            GlStateManager.pushMatrix();
            GlStateManager.translate(0.0F, -1.0F, -2.0F);

            for (int i = 0; (float)i < (f7 + f7 * f7) / 2.0F * 60.0F; ++i)
            {
                GlStateManager.rotate(random.nextFloat() * 360.0F, 1.0F, 0.0F, 0.0F);
                GlStateManager.rotate(random.nextFloat() * 360.0F, 0.0F, 1.0F, 0.0F);
                GlStateManager.rotate(random.nextFloat() * 360.0F, 0.0F, 0.0F, 1.0F);
                GlStateManager.rotate(random.nextFloat() * 360.0F, 1.0F, 0.0F, 0.0F);
                GlStateManager.rotate(random.nextFloat() * 360.0F, 0.0F, 1.0F, 0.0F);
                GlStateManager.rotate(random.nextFloat() * 360.0F + f7 * 90.0F, 0.0F, 0.0F, 1.0F);
                worldrenderer.startDrawing(6);
                float f9 = random.nextFloat() * 20.0F + 5.0F + f8 * 10.0F;
                float f10 = random.nextFloat() * 2.0F + 1.0F + f8 * 2.0F;
                worldrenderer.func_178974_a(16777215, (int)(255.0F * (1.0F - f8)));
                worldrenderer.addVertex(0.0D, 0.0D, 0.0D);
                worldrenderer.func_178974_a(16711935, 0);
                worldrenderer.addVertex(-0.866D * (double)f10, (double)f9, (double)(-0.5F * f10));
                worldrenderer.addVertex(0.866D * (double)f10, (double)f9, (double)(-0.5F * f10));
                worldrenderer.addVertex(0.0D, (double)f9, (double)(1.0F * f10));
                worldrenderer.addVertex(-0.866D * (double)f10, (double)f9, (double)(-0.5F * f10));
                tessellator.draw();
            }

            GlStateManager.popMatrix();
            GlStateManager.depthMask(true);
            GlStateManager.disableCull();
            GlStateManager.disableBlend();
            GlStateManager.shadeModel(7424);
            GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
            GlStateManager.func_179098_w();
            GlStateManager.enableAlpha();
            RenderHelper.enableStandardItemLighting();
        }
    }

    public boolean shouldCombineTextures()
    {
        return false;
    }

    public void doRenderLayer(EntityLivingBase p_177141_1_, float p_177141_2_, float p_177141_3_, float p_177141_4_, float p_177141_5_, float p_177141_6_, float p_177141_7_, float p_177141_8_)
    {
        this.func_177213_a((EntityNorthrendDragon)p_177141_1_, p_177141_2_, p_177141_3_, p_177141_4_, p_177141_5_, p_177141_6_, p_177141_7_, p_177141_8_);
    }
}
