package com.gigavoid.supermod.entity;

import com.gigavoid.supermod.model.ModelRope;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

/**
 * Created by ineentho on 2014-11-05.
 */
public class EntityRope extends Entity {
    public final ModelRope model;
    public double targetX, targetY, targetZ;


    public EntityRope(World world) {
        this(world, 0, 0, 0, 0, 0, 0);
    }

    @Override
    protected void entityInit() {  }

    @Override
    protected void readEntityFromNBT(NBTTagCompound p_70037_1_) { }

    @Override
    protected void writeEntityToNBT(NBTTagCompound p_70014_1_) { }

    public EntityRope(World world, double x0, double y0, double z0, double x1, double y1, double z1) {
        super(world);
        targetX = x1;
        targetY = y1;
        targetZ = z1;
        this.ignoreFrustumCheck = true;
        setPosition(x0, y0, z0);
        setSize(.1f ,.1f);
        model = new ModelRope(this);
    }

    @Override
    public void onUpdate() {

    }
}
