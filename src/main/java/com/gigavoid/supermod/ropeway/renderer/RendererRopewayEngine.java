package com.gigavoid.supermod.ropeway.renderer;

import com.gigavoid.supermod.ropeway.model.ModelRopewayEngine;
import com.gigavoid.supermod.ropeway.tileentity.TileEntityRopewayEngine;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class RendererRopewayEngine extends TileEntitySpecialRenderer {
    private final ModelRopewayEngine modelRopewayEngine;

    public RendererRopewayEngine() {
        this.modelRopewayEngine = new ModelRopewayEngine();
    }

    @Override
    public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float p_180535_8_, int p_180535_9_) {
        TileEntityRopewayEngine tileEntityRopewayEngine = (TileEntityRopewayEngine) tileEntity;

        GL11.glPushMatrix();
        GL11.glTranslated(x + .5, y + .5, z + .5);

        int direction = tileEntity.getBlockMetadata();

        float rotAngle = 0;

        if(direction == 2)
            rotAngle = -90f;
        else if(direction == 5)
            rotAngle = 180f;
        else if(direction == 3)
            rotAngle = 90f;

        GL11.glRotatef(rotAngle, 0f, 1f, 0f);

        ResourceLocation texture = new ResourceLocation("supermod:textures/blocks/ropeway_engine.png");
        Minecraft.getMinecraft().renderEngine.bindTexture(texture);

        modelRopewayEngine.render(tileEntityRopewayEngine);

        GL11.glPopMatrix();
    }
}
