package com.gigavoid.supermod.ropeway.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;

public class ModelRopewayBasket extends ModelBase {
    private ModelRenderer basket;


    ModelRenderer floor;
    ModelRenderer wall1;
    ModelRenderer wall2;
    ModelRenderer Shape1;
    ModelRenderer Shape3;
    ModelRenderer Shape2;

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
        Shape3 = new ModelRenderer(this, 0, 0);
        Shape3.addBox(0F, 0F, 0F, 1, 10, 14);
        Shape3.setRotationPoint(7F, -10F, -7F);
        Shape3.setTextureSize(64, 32);
        Shape1 = new ModelRenderer(this, 0, 0);
        Shape1.addBox(0F, 0F, 0F, 1, 10, 14);
        Shape1.setRotationPoint(-8F, -10F, -7F);
        Shape1.setTextureSize(64, 32);
        Shape2 = new ModelRenderer(this, 0, 0);
        Shape2.addBox(0F, 0F, 0F, 1, 25, 1);
        Shape2.setRotationPoint(0F, -25F, 0F);
        Shape2.setTextureSize(64, 32);
    }

    public void render() {
        float scale = 1/16f;
        floor.render(scale);
        wall1.render(scale);
        wall2.render(scale);
        Shape1.render(scale);
        Shape3.render(scale);
        Shape2.render(scale);
    }
}
