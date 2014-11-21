package com.gigavoid.supermod.model;

import com.gigavoid.supermod.entity.EntityRope;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;

public class ModelRope  extends ModelBase {
    private ModelRenderer steltRep;

    public ModelRope(EntityRope rope) {
        double dx = rope.posX - rope.targetX;
        double dy = rope.posY - rope.targetY;
        double dz = rope.posZ - rope.targetZ;

      //  if(rope.targetX == 0 && rope.targetY == 0 && rope.targetZ == 0)
       //     return;

        double length = Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2) + Math.pow(dz, 2));
        double length2D = Math.sqrt(Math.pow(dx, 2) + Math.pow(dz, 2));
        //double length2DZ = Math.sqrt(Math.pow(dz, 2) + Math.pow(dz, 2));

/*
        float rotX = dx != 0 ? (float)Math.asin(length2D/dx) : .0f;
        float rotY = (float)Math.acos(length / length2D);
        float rotZ = dz != 0 ? (float)Math.asin(length2D/dz) : .0f;
*/

        float rotX = (float)Math.atan2( dy, dz );
        float rotY = (float)Math.atan2( dx * Math.cos(rotX), dz );
        float rotZ = (float)Math.atan2( Math.cos(rotX), Math.sin(rotX) * Math.sin(rotX) );

        steltRep = new ModelRenderer(this, 0, 0);
        steltRep.addBox(0f, 0f, 0f, 1, (int)(16 * length), 1);
        steltRep.setRotationPoint(0, 0, 0);
        steltRep.setTextureSize(32, 64);

        float timed = (float)(System.currentTimeMillis() - 1.41652525E12) / 1000f;

        steltRep.rotateAngleX = 0;//rotY; //+ //(float)(System.currentTimeMillis() - 1.41652525E12) / 1000f;
        steltRep.rotateAngleY = 0;//rotX; //(float)(Math.PI * 1.5) //(float)(System.currentTimeMillis() - 1.41652525E12) / 1000f;;
        steltRep.rotateAngleZ = timed;
    }

    public void render() {
        //if(steltRep != null)
            steltRep.render( 1 / 16f);
    }
}