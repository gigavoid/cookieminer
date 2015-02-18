package com.gigavoid.supermod.ropeway.entity;


import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityRopewayBasket extends Entity {


    public EntityRopewayBasket(World world) {
        this(world, 0, 0, 0);
        this.preventEntitySpawning = true;
    }

    @Override
    protected void entityInit() {

    }

    @Override
    protected void readEntityFromNBT(NBTTagCompound tagCompund) {

    }

    @Override
    protected void writeEntityToNBT(NBTTagCompound tagCompound) {

    }

    @Override
    public boolean canBeCollidedWith() {
        return true;
    }

    @Override
    public double getYOffset() {
        return -4;
    }


    @Override
    public boolean attackEntityFrom(DamageSource source, float amount) {
        this.setDead();
        return true;
    }

    @Override
    public boolean interactFirst(EntityPlayer playerIn)
    {
        if (this.riddenByEntity != null && this.riddenByEntity instanceof EntityPlayer && this.riddenByEntity != playerIn)
        {
            return true;
        }
        else if (this.riddenByEntity != null && this.riddenByEntity != playerIn)
        {
            return false;
        }
        else
        {
            if (!this.worldObj.isRemote)
            {
                playerIn.mountEntity(this);
                motionY = 500;
            }

            return true;
        }
    }

    @Override
    public AxisAlignedBB getCollisionBox(Entity entityIn)
    {
        return entityIn.getEntityBoundingBox();
    }


    public EntityRopewayBasket(World world, double x, double y, double z) {
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

}
