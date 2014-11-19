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
        double xDiff = rope.posX - rope.targetX;
        double yDiff = rope.posY - rope.targetY;
        double zDiff = rope.posZ - rope.targetZ;

        double length = Math.sqrt(Math.pow(xDiff, 2) + Math.pow(yDiff, 2) + Math.pow(zDiff, 2));





        steltRep = new ModelRenderer(this, 0, 0);
        steltRep.addBox(0f, 0f, 0f, 1, (int)(16 * length), 1);
        steltRep.setRotationPoint(0, 0, 0);
        steltRep.setTextureSize(32, 64);


        //if(followAxisDiff < 0)
        //    rotation *= -1;


        steltRep.rotateAngleY = (float)Math.atan2(xDiff, zDiff) + (float)Math.PI;

        // Rotate on height axis
        steltRep.rotateAngleX = (float)Math.acos(yDiff / length);
    }

    public void render() {
        steltRep.render( 1 / 16f);
    }
}