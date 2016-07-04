package com.gigavoid.supermod.cookiecraft.model;

import com.gigavoid.supermod.cookiecraft.tileentity.TileEntitySlimeCompressor;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;

public class ModelCookieSlimeCompressor extends ModelBase {
    private ModelRenderer top;
    private ModelRenderer glass;
    private ModelRenderer bottom;
    private ModelRenderer slime;

    private boolean up = true;
    private long lastTime = System.nanoTime();

    public ModelCookieSlimeCompressor() {
        textureWidth = 128;
        textureHeight = 64;

        slime = new ModelRenderer(this, 0, 0).setTextureOffset(64, 0).addBox(-4, -5, -4, 8, 8, 8);

        top = new ModelRenderer(this, 0, 0).addBox(-8, 7, -8, 16, 1, 16);

        bottom = new ModelRenderer(this, 0, 0).addBox(-8, -8, -8, 16, 3, 16);

        glass = new ModelRenderer(this, 0, 0).setTextureOffset(0, 32).addBox(-7, -5, -7, 14, 12, 14);
    }

    public void render(TileEntitySlimeCompressor tileEntity) {
        float scale = 1 / 16f;

        long timeNow = System.nanoTime();
        double deltaTime = (timeNow - lastTime) / Math.pow(10, 9);

        //Retarded jump code
        if (slime.offsetY >= (4 / 16f)) {
            up = false;
        }
        else if (slime.offsetY <= (0)) {
            up = true;
        }
        slime.offsetY = up ? slime.offsetY + (float)(1 * deltaTime) : slime.offsetY - (float)(1 * deltaTime);

        slime.render(scale);
        top.render(scale);
        bottom.render(scale);
        glass.render(scale);

        lastTime = timeNow;
    }
}
