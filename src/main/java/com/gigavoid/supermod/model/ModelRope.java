package com.gigavoid.supermod.model;

import com.gigavoid.supermod.tileentity.TileEntityRopeWheel;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;

/**
 * Created by ineentho on 2014-11-03.
 */
public class ModelRope  extends ModelBase {
    private ModelRenderer steltRep;

    public ModelRope(int[] pointB, int[] pointA) {

        Boolean zAxis = pointA[0] - pointB[0] == 0;
        int yDiff = pointA[1] - pointB[1];
        int axis = zAxis ? 2 : 0;
        int followAxisDiff = pointA[axis] - pointB[axis];

        double length = Math.sqrt(Math.pow(yDiff, 2) + Math.pow(followAxisDiff, 2));



        steltRep = new ModelRenderer(this, 0, 0);
        steltRep.addBox(0f, 0f, 0f, 1, (int)(16 * length), 1);
        steltRep.setRotationPoint(0, 0, 0);
        steltRep.setTextureSize(32, 64);


        float rotation = (float)Math.acos(yDiff / length);


        if(followAxisDiff < 0)
            rotation *= -1;

        if(zAxis)
            steltRep.rotateAngleX = rotation;
        else
            steltRep.rotateAngleZ = rotation;
    }

    public void render() {
        steltRep.render( 1 / 16f);
    }
}