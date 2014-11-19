package com.gigavoid.supermod.renderer;

import com.gigavoid.supermod.model.ModelRope;
import com.gigavoid.supermod.model.ModelRopeWheel;
import com.gigavoid.supermod.tileentity.TileEntityRopeWheel;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

/**
 * Created by ineentho on 2014-11-03.
 */
public class RendererRopeWheel extends TileEntitySpecialRenderer {

    private final ModelRopeWheel modelRopeWheel;

    public RendererRopeWheel() {
        this.modelRopeWheel = new ModelRopeWheel();
    }

    @Override
    public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float scale) {
        TileEntityRopeWheel ropeWheel = (TileEntityRopeWheel) tileEntity;
        ropeWheel.frame();

        GL11.glPushMatrix();
        GL11.glTranslatef((float) x + 0.5f, (float) y + .5f, (float) z + 0.5f);

        ResourceLocation textures = (new ResourceLocation("supermod:textures/blocks/ropeWheel.png"));
        Minecraft.getMinecraft().renderEngine.bindTexture(textures);

        //This rotation part is very important! Without it, your modelRopeWheel will render upside-down! And for some reason you DO need PushMatrix again!
        GL11.glPushMatrix();

        float rotAngle = 0f;
        if(ropeWheel.direction == 0)
            rotAngle = -90f;
        if(ropeWheel.direction == 1)
            rotAngle = 180f;
        if(ropeWheel.direction == 2)
            rotAngle = 90f;

        GL11.glRotatef(rotAngle, 0f, 1f, 0f);

        modelRopeWheel.render(ropeWheel);

        int[] myPos = {ropeWheel.xCoord, ropeWheel.yCoord, ropeWheel.zCoord};

        //for(int[] point : ropeWheel.ropePoints)
        //    new ModelRope(myPos, point, ropeWheel).render();
        //Tell it to stop rendering for both the PushMatrix's
        GL11.glPopMatrix();
        GL11.glPopMatrix();
    }
}
