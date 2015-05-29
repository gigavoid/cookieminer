package com.gigavoid.supermod.ropeway.entity;

import com.gigavoid.supermod.ropeway.model.ModelRope;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public class EntityRope extends Entity {
    public final ModelRope model;
    public BlockPos target;


    public EntityRope(World world) {
        this(world, null, null);
    }

    @Override
    protected void entityInit() {  }

    @Override
    protected void readEntityFromNBT(NBTTagCompound p_70037_1_) { }

    @Override
    protected void writeEntityToNBT(NBTTagCompound p_70014_1_) { }

    public EntityRope(World world, BlockPos a, BlockPos b) {
        super(world);
        target = b;
        this.ignoreFrustumCheck = true;
        setPosition(a.getX(), a.getY(), a.getZ());
        //setSize(.1f ,.1f);
        model = new ModelRope(this);
    }

    @Override
    public void onUpdate() {

    }
}
