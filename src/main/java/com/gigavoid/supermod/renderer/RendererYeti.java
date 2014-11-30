package com.gigavoid.supermod.renderer;

import com.gigavoid.supermod.entity.EntityYeti;
import com.gigavoid.supermod.model.ModelYeti;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.util.ResourceLocation;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

@SideOnly(Side.CLIENT)
public class RendererYeti extends RenderLiving {
    private static final ResourceLocation yetiTextures = new ResourceLocation("supermod:textures/entities/YetiTexture.png");
    /**
     * Iron Golem's Model.
     */
    private final ModelYeti yetiModel;
    private static final String __OBFID = "CL_00001031";

    public RendererYeti() {
        super(Minecraft.getMinecraft().getRenderManager(), new ModelYeti(), 0.5f);
        this.yetiModel = (ModelYeti) this.mainModel;
    }

    public void doRender(EntityLivingBase par1Entity, double par2, double par4, double par6, float par8, float par9) {
        this.doRender((EntityYeti) par1Entity, par2, par4, par6, par8, par9);
    }

    protected ResourceLocation getEntityTexture(Entity par1Entity) {
        return yetiTextures;
    }

    protected void rotateCorpse(EntityYeti par1EntityYeti, float par2, float par3, float par4) {
        super.rotateCorpse(par1EntityYeti, par2, par3, par4);

        if ((double) par1EntityYeti.limbSwingAmount >= 0.01D) {
            float f3 = 13.0F;
            float f4 = par1EntityYeti.limbSwing
                    - par1EntityYeti.limbSwingAmount * (1.0F - par4)
                    + 6.0F;
            float f5 = (Math.abs(f4 % f3 - f3 * 0.5F) - f3 * 0.25F)
                    / (f3 * 0.25F);
            GL11.glRotatef(6.5F * f5, 0.0F, 0.0F, 1.0F);
        }
    }

    protected void rotateCorpse(EntityLivingBase par1EntityLivingBase, float par2, float par3, float par4) {
        this.rotateCorpse((EntityYeti) par1EntityLivingBase, par2, par3, par4);
    }
}
