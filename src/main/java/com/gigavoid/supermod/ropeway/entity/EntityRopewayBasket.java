package com.gigavoid.supermod.ropeway.entity;


import com.gigavoid.supermod.ropeway.block.RopewayBlocks;
import com.gigavoid.supermod.ropeway.item.RopewayItems;
import com.gigavoid.supermod.ropeway.tileentity.TileEntityRopewayEngine;
import net.minecraft.block.Block;
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
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;
import java.util.Random;

public class EntityRopewayBasket extends Entity {

    public static final double SPEED = .03;
    /**
     * The block that the basket is moving towards.
     */
    private BlockPos target;
    private Random r = new Random();
    
    private double velocityX;
    private double velocityY;
    private double velocityZ;

    public EntityRopewayBasket(World world) {
        this(world, 0, 0, 0);
        this.preventEntitySpawning = true;
    }

    public void setTarget(BlockPos target) {
        this.target = target;
    }

    @Override
    protected void entityInit() {

    }

    @Override
    protected void readEntityFromNBT(NBTTagCompound tagCompund) {
        int x = tagCompund.getInteger("targetX");
        int y = tagCompund.getInteger("targetY");
        int z = tagCompund.getInteger("targetZ");
        
        target = new BlockPos(x, y, z);
    }

    @Override
    protected void writeEntityToNBT(NBTTagCompound tagCompound) {
        tagCompound.setInteger("targetX", target.getX());
        tagCompound.setInteger("targetY", target.getY());
        tagCompound.setInteger("targetZ", target.getZ());
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
        
        if (worldObj.isRemote)
        {
            return;
        }
        
        System.out.println("asdf");
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
                findNewTarget();
                return;
            }

            Vec3 diff = new Vec3(xDiff, yDiff, zDiff);
            diff = diff.normalize();
            
            lastTickPosX = posX;
            lastTickPosY = posY;
            lastTickPosZ = posZ;

            posX += diff.xCoord * SPEED;
            posY += diff.yCoord * SPEED;
            posZ += diff.zCoord * SPEED;
        }
    }

    private void findNewTarget() {
        TileEntityRopewayEngine targetEntity = (TileEntityRopewayEngine) worldObj.getTileEntity(target);
        List<BlockPos> connectedRopes = targetEntity.getConnectedRopes();
        target = connectedRopes.get(r.nextInt(connectedRopes.size()));
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
