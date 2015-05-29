package com.gigavoid.supermod.ropeway.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;

public class ModelRopewayBasket extends ModelBase {
    private ModelRenderer basket;


    ModelRenderer floor;
    ModelRenderer wall1;
    ModelRenderer wall2;
    ModelRenderer wall3;
    ModelRenderer wall4;
    ModelRenderer stick;

    public ModelRopewayBasket() {
        textureWidth = 64;
        textureHeight = 32;

        floor = new ModelRenderer(this, 0, 0);
        floor.addBox(0F, 0F, 0F, 16, 1, 16);
        floor.setRotationPoint(-8F, 0F, -8F);
        floor.setTextureSize(64, 32);
        wall1 = new ModelRenderer(this, 0, 0);
        wall1.addBox(0F, 0F, 0F, 16, 10, 1);
        wall1.setRotationPoint(-8F, -10F, -8F);
        wall1.setTextureSize(64, 32);
        wall2 = new ModelRenderer(this, 0, 0);
        wall2.addBox(0F, 0F, 0F, 16, 10, 1);
        wall2.setRotationPoint(-8F, -10F, 7F);
        wall2.setTextureSize(64, 32);
        wall4 = new ModelRenderer(this, 0, 0);
        wall4.addBox(0F, 0F, 0F, 1, 10, 14);
        wall4.setRotationPoint(7F, -10F, -7F);
        wall4.setTextureSize(64, 32);
        wall3 = new ModelRenderer(this, 0, 0);
        wall3.addBox(0F, 0F, 0F, 1, 10, 14);
        wall3.setRotationPoint(-8F, -10F, -7F);
        wall3.setTextureSize(64, 32);
        stick = new ModelRenderer(this, 0, 0);
        stick.addBox(0F, 0F, 0F, 1, 25, 1);
        stick.setRotationPoint(0F, -25F, 0F);
        stick.setTextureSize(64, 32);
    }

    public void render() {
        float scale = 1/16f;
        floor.render(scale);
        wall1.render(scale);
        wall2.render(scale);
        wall3.render(scale);
        wall4.render(scale);
        stick.render(scale);
    }
}
