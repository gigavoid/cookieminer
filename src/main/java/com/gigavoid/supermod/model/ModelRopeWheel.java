package com.gigavoid.supermod.model;

import com.gigavoid.supermod.tileentity.TileEntityRopeWheel;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * Created by ineentho on 2014-11-03.
 */
public class ModelRopeWheel extends ModelBase {
    private ModelRenderer base;
    private ModelRenderer gear;

    public ModelRopeWheel() {
        base = new ModelRenderer(this, 0, 0);
        base.addBox(-3, -1, -1, 11, 2, 2);
        base.setRotationPoint(0, 0, 0);
        base.setTextureSize(32, 64);

        gear = new ModelRenderer(this, 0, 0);
        gear.addBox(-2, -3, -3, 4, 6, 6);
        gear.setRotationPoint(0, 0, 0);
        gear.setTextureSize(32, 64);

    }

    public void render(TileEntityRopeWheel ropeWheel) {
        float scale = 1 / 16f;

        gear.rotateAngleX = System.nanoTime() / (float)Math.pow(10, 9) * 10;

        base.render(scale);
        gear.render(scale);
    }
}
