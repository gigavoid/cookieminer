package com.gigavoid.supermod.entity;

import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

/**
 * Created by ineentho on 2014-11-05.
 */
public class EntityRope extends Entity {
    public double targetX, targetY, targetZ;


    public EntityRope(World world) {
        super(world);
        this.ignoreFrustumCheck = true;
        System.out.println("vanliga som inte används");
    }

    public EntityRope(World world, double x0, double y0, double z0, double x1, double y1, double z1) {
        super(world);
        targetX = x1;
        targetY = y1;
        targetZ = z1;
        this.ignoreFrustumCheck = true;
        setPosition(x0, y0, z0);
        System.out.println("rigkitagas");
    }

    @Override
    protected void entityInit() {


    }

    @Override
    protected void readEntityFromNBT(NBTTagCompound tags) {
        targetX = tags.getDouble("targetX");
        targetY = tags.getDouble("targetY");
        targetZ = tags.getDouble("targetZ");
    }

    @Override
    protected void writeEntityToNBT(NBTTagCompound tags) {
        tags.setDouble("targetX", targetX);
        tags.setDouble("targetY", targetY);
        tags.setDouble("targetZ", targetZ);
    }
}
