package com.gigavoid.supermod.model;

import com.gigavoid.supermod.entity.EntityRope;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;

public class ModelRope  extends ModelBase {
    private ModelRenderer rope;

    public ModelRope(EntityRope rope) {
        double dx = rope.posX - rope.targetX;
        double dy = rope.posY - rope.targetY;
        double dz = rope.posZ - rope.targetZ;

        double length = Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2) + Math.pow(dz, 2));

        this.rope = new ModelRenderer(this, 0, 0);
        this.rope.addBox(0f, 0f, 0f, 1, (int) (16 * length), 1);
        this.rope.setRotationPoint(0, 0, 0);
        this.rope.setTextureSize(32, 64);

        if(dz == 0)
            this.rope.rotateAngleZ = (float) (Math.atan2(dy, dx) + Math.PI / 2);
        else if(dx == 0)
            this.rope.rotateAngleX = (float) (Math.atan2(dz, dy) + Math.PI);
    }

    public void render() {
        rope.render(1 / 16f);
    }
}