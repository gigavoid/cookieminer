package com.gigavoid.supermod.ropeway.entity;


import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

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
    public double getMountedYOffset() {
        return -.2;
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
                addVelocity(5, 5, 5);
            }

            return true;
        }
    }

    @Override
    public void func_180426_a(double p_180426_1_, double p_180426_3_, double p_180426_5_, float p_180426_7_, float p_180426_8_, int p_180426_9_, boolean p_180426_10_) {
        this.setPosition(p_180426_1_, p_180426_3_, p_180426_5_);
        this.setRotation(p_180426_7_, p_180426_8_);
    }

    @Override
    public AxisAlignedBB getCollisionBox(Entity entityIn)
    {
        return entityIn.getEntityBoundingBox();
    }


    @Override
    public void onEntityUpdate() {
        super.onEntityUpdate();
        addVelocity(50, 50, 50);
        motionY += 15;
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
        noClip = true;
        setSize(1, .7f);

        if(!(x == 0 && y == 0 && z == 0)) {
            this.setPosition(x, y, z);
            this.prevPosX = x;
            this.prevPosY = y;
            this.prevPosZ = z;
        }
    }

}
