package com.gigavoid.supermod.model;

import com.gigavoid.supermod.entity.EntityRope;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;

/**
 * Created by ineentho on 2014-11-03.
 */
public class ModelRope  extends ModelBase {
    private ModelRenderer steltRep;

    public ModelRope(EntityRope rope) {
        double dx = rope.posX - rope.targetX;
        double dy = rope.posY - rope.targetY;
        double dz = rope.posZ - rope.targetZ;

        double length = Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2) + Math.pow(dz, 2));
        double length2D = Math.sqrt(Math.pow(dx, 2) + Math.pow(dz, 2));


        float rotX = dx != 0 ? (float)Math.asin(length2D/dx) : .0f;
        float rotY = (float)Math.acos(length/length2D);


        steltRep = new ModelRenderer(this, 0, 0);
        steltRep.addBox(0f, 0f, 0f, 1, (int)(16 * length), 1);
        steltRep.setRotationPoint(0, 0, 0);
        steltRep.setTextureSize(32, 64);

        steltRep.rotateAngleX = rotX;
        steltRep.rotateAngleY = rotY;
        steltRep.rotateAngleZ = 0;
    }

    public void render() {
        steltRep.render( 1 / 16f);
    }
}