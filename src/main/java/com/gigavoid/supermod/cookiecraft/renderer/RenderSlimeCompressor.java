package com.gigavoid.supermod.cookiecraft.renderer;

import com.gigavoid.supermod.cookiecraft.model.ModelCookieSlimeCompressor;
import com.gigavoid.supermod.cookiecraft.tileentity.TileEntitySlimeCompressor;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class RenderSlimeCompressor extends TileEntitySpecialRenderer {
    private final ModelCookieSlimeCompressor modelSlimeCompressor;

    public RenderSlimeCompressor() {
        this.modelSlimeCompressor = new ModelCookieSlimeCompressor();
    }

    @Override
    public void render(TileEntity te, double x, double y, double z, float partialTicks, int destroyStage, float alpha) {
        TileEntitySlimeCompressor tileEntitySlimeCompressor = (TileEntitySlimeCompressor) te;

        GL11.glPushMatrix();
        GL11.glTranslated(x + .5, y + .5, z + .5);
        GL11.glRotatef(0f, 0f, 1f, 0f);

        ResourceLocation texture = new ResourceLocation("supermod:textures/blocks/cookie_slime_compressor2.png");
        Minecraft.getMinecraft().renderEngine.bindTexture(texture);

        modelSlimeCompressor.render(tileEntitySlimeCompressor);

        GL11.glPopMatrix();
    }
}
