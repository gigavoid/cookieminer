package com.gigavoid.supermod.ropeway.entity;


import com.gigavoid.supermod.ropeway.block.RopewayBlocks;
import com.gigavoid.supermod.ropeway.item.RopewayItems;
import com.gigavoid.supermod.ropeway.tileentity.TileEntityRopewayEngine;
import net.minecraft.block.Block;
import net.minecraft.entity.DataWatcher;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

import java.util.List;
import java.util.Random;

public class EntityRopewayBasket extends Entity{

    public static final double SPEED = .1;
    /**
     * The block that the basket is moving towards.
     */
    private BlockPos target;
    private BlockPos prevTarget;
    private Random r = new Random();
    
    

    public EntityRopewayBasket(World world) {
        this(world, 0, 0, 0);
        this.preventEntitySpawning = true;
    }

    public void setTarget(BlockPos target) {
        this.target = target;

        if (!worldObj.isRemote) {
            dataWatcher.updateObject(20, target.getX());
            dataWatcher.updateObject(21, target.getY());
            dataWatcher.updateObject(22, target.getZ());
        }
    }

    @Override
    protected void entityInit() {
        DataWatcher dw = getDataWatcher();

        int x = 0, y = 0, z = 0;

        if (target != null) {
            x = target.getX();
            y = target.getY();
            z = target.getZ();
        }

        dw.addObject(20, x);
        dw.addObject(21, y);
        dw.addObject(22, z);
    }


    @Override
    protected void readEntityFromNBT(NBTTagCompound tagCompund) {
        int x = tagCompund.getInteger("targetX");
        int y = tagCompund.getInteger("targetY");
        int z = tagCompund.getInteger("targetZ");
        target = new BlockPos(x, y, z);

        x = tagCompund.getInteger("prevTargetX");
        y = tagCompund.getInteger("prevTargetY");
        z = tagCompund.getInteger("prevTargetZ");
        prevTarget = new BlockPos(x, y, z);
    }

    @Override
    protected void writeEntityToNBT(NBTTagCompound tagCompound) {
        if (target != null) {
            tagCompound.setInteger("targetX", target.getX());
            tagCompound.setInteger("targetY", target.getY());
            tagCompound.setInteger("targetZ", target.getZ());
        }

        if (prevTarget != null) {
            tagCompound.setInteger("prevTargetX", prevTarget.getX());
            tagCompound.setInteger("prevTargetY", prevTarget.getY());
            tagCompound.setInteger("prevTargetZ", prevTarget.getZ());
        }
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

        if (worldObj.isRemote) {
            int x = dataWatcher.getWatchableObjectInt(20);
            int y = dataWatcher.getWatchableObjectInt(21);
            int z = dataWatcher.getWatchableObjectInt(22);

            target = new BlockPos(x, y, z);
        }

        if (target != null) {
            if (worldObj.getBlockState(target).getBlock() != RopewayBlocks.engine) {
                // The engine the basket is moving towards has been destroyed
                worldObj.spawnEntityInWorld(new EntityItem(worldObj, posX, posY, posZ, new ItemStack(RopewayItems.basket)));
                kill();
                return;
            }

            double xDiff = target.getX() + .5f - posX;
            double yDiff = target.getY() - 1.1f - posY;
            double zDiff = target.getZ() + .5f - posZ;

            if (Math.abs(xDiff) + Math.abs(yDiff) + Math.abs(zDiff) < .3) {
                // The basket has (almost) reached its target
                posX = target.getX() + .5f;
                posY = target.getY() - 1.1f;
                posZ = target.getZ() + .5f;
                findNewTarget();
                return;
            }

            Vec3 diff = new Vec3(xDiff, yDiff, zDiff);
            diff = diff.normalize();


            posX += diff.xCoord * SPEED;
            posY += diff.yCoord * SPEED;
            posZ += diff.zCoord * SPEED;
        }
    }

    private void findNewTarget() {
        TileEntityRopewayEngine targetEntity = (TileEntityRopewayEngine) worldObj.getTileEntity(target);
        List<BlockPos> connectedRopes = targetEntity.getConnectedRopes();

        if (connectedRopes.size() == 0) {
            setTarget(null);
            return;
        }

        BlockPos foundRope;

        do {
            foundRope = connectedRopes.get(r.nextInt(connectedRopes.size()));
        } while (connectedRopes.size() != 1 && prevTarget != null && foundRope.equals(prevTarget));

        prevTarget = target;
        setTarget(foundRope);
    }

    public EntityRopewayBasket(World world, double x, double y, double z) {
        super(world);
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
