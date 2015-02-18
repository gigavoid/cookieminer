package com.gigavoid.supermod.ropeway.entity;


import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class EntityBasket extends Entity {


    public EntityBasket(World world) {
        this(world, 0, 0, 0);
        this.preventEntitySpawning = true;
    }



    public EntityBasket(World world, double x, double y, double z) {
        super(world);
        //this.setSize(0.98F, 5F);
        //noClip = true;
        //yOffset = 2.2f;
        this.preventEntitySpawning = true;
        this.motionX = 0.0D;
        this.motionY = 0.0D;
        this.motionZ = 0.0D;
        noClip = false;
        setSize(1, .7f);

        if(!(x == 0 && y == 0 && z == 0)) {
            this.setPosition(x, y, z);
            this.prevPosX = x;
            this.prevPosY = y;
            this.prevPosZ = z;
        }
    }



    @Override
    protected void entityInit() {

    }

    @Override
    protected void readEntityFromNBT(NBTTagCompound p_70037_1_) {

    }

    @Override
    protected void writeEntityToNBT(NBTTagCompound p_70014_1_) {

    }
}
