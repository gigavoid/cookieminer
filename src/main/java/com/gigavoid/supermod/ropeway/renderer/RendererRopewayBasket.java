package com.gigavoid.supermod.ropeway.renderer;

import com.gigavoid.supermod.ropeway.entity.EntityRopewayBasket;
import com.gigavoid.supermod.ropeway.model.ModelRopewayBasket;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Vec3;
import org.lwjgl.opengl.GL11;

public class RendererRopewayBasket extends Render {
    public ModelRopewayBasket model = new ModelRopewayBasket();

	private double renderPosX;
	private double renderPosY;
	private double renderPosZ;

    public RendererRopewayBasket(RenderManager p_i46179_1_) {
        super(p_i46179_1_);
    }

	private void calcRenderPos(Entity p_147936_1_, float smth, double posX, double posY, double posZ)
	{
		if (p_147936_1_.ticksExisted == 0)
		{
			p_147936_1_.lastTickPosX = p_147936_1_.posX;
			p_147936_1_.lastTickPosY = p_147936_1_.posY;
			p_147936_1_.lastTickPosZ = p_147936_1_.posZ;
		}

		double d0 = p_147936_1_.lastTickPosX + (p_147936_1_.posX - p_147936_1_.lastTickPosX) * (double)smth;
		double d1 = p_147936_1_.lastTickPosY + (p_147936_1_.posY - p_147936_1_.lastTickPosY) * (double)smth;
		double d2 = p_147936_1_.lastTickPosZ + (p_147936_1_.posZ - p_147936_1_.lastTickPosZ) * (double)smth;
		float f1 = p_147936_1_.prevRotationYaw + (p_147936_1_.rotationYaw - p_147936_1_.prevRotationYaw) * smth;
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);


		renderPosX = (posX - d0) * -1;
		renderPosY = (posY - d1) * -1;
		renderPosZ = (posZ - d2) * -1;
	}

	public void calcPos(EntityRopewayBasket entity, float tickProgress)
	{
		if (entity.ticksExisted == 0)
		{
			entity.lastSmoothX = entity.smoothX;
			entity.lastSmoothY = entity.smoothY;
			entity.lastSmoothZ = entity.smoothZ;
		}

		double d0 = entity.lastSmoothX + (entity.smoothX - entity.lastSmoothX) * (double)tickProgress;
		double d1 = entity.lastSmoothY + (entity.smoothY - entity.lastSmoothY) * (double)tickProgress;
		double d2 = entity.lastSmoothZ + (entity.smoothZ - entity.lastSmoothZ) * (double)tickProgress;
		float f1 = entity.prevRotationYaw + (entity.rotationYaw - entity.prevRotationYaw) * tickProgress;
		int i = entity.getBrightnessForRender(tickProgress);

		if (entity.isBurning())
		{
			i = 15728880;
		}

		int j = i % 65536;
		int k = i / 65536;
		OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float) j / 1.0F, (float) k / 1.0F);
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		this.realRender(entity, d0 - this.renderPosX, d1 - this.renderPosY, d2 - this.renderPosZ, f1, tickProgress);
	}

	private void realRender(EntityRopewayBasket ropeway, double x, double y, double z, float f1, float tickProgress) {
//		x += (ropeway.smoothX - ropeway.lastSmoothX) * tickProgress;
//		y += (ropeway.smoothY - ropeway.lastSmoothY) * tickProgress;
//		z += (ropeway.smoothZ - ropeway.lastSmoothZ) * tickProgress;

		GL11.glTranslated((float)x, (float)y, (float)z);

		ResourceLocation textures = (new ResourceLocation("supermod:textures/blocks/ropeway_engine.png"));
		Minecraft.getMinecraft().renderEngine.bindTexture(textures);


		GL11.glPushMatrix();
		GL11.glRotated(180, 1, 0,0);
		model.render();
		GL11.glPopMatrix();
		GL11.glPopMatrix();
	}


	@Override
    public void doRender(Entity entity, double x, double y, double z, float smth, float tickProgress) {
		GL11.glPushMatrix();

		EntityRopewayBasket ropeway = (EntityRopewayBasket) entity;
		calcRenderPos(ropeway, smth, x, y, z);
		calcPos(ropeway, tickProgress);
	}
    @Override
    protected ResourceLocation getEntityTexture(Entity p_110775_1_) {
        return null;
    }
}
