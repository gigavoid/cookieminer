package com.gigavoid.supermod.northrend.renderer.entity;

import com.gigavoid.supermod.northrend.entity.EntityIzrr;
import net.minecraft.client.model.ModelBlaze;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderIzrr extends RenderLiving
{
    private static final ResourceLocation blazeTextures = new ResourceLocation("supermod:textures/entity/izrr.png");

    public RenderIzrr(RenderManager p_i46191_1_)
    {
        super(p_i46191_1_, new ModelBlaze(), 0.5F);
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(EntityIzrr p_110775_1_)
    {
        return blazeTextures;
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(Entity p_110775_1_)
    {
        return this.getEntityTexture((EntityIzrr)p_110775_1_);
    }
}
