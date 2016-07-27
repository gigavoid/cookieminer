package com.gigavoid.supermod.cookiecraft.tileentity;


import com.gigavoid.supermod.cookiecraft.cookie.CookieBlock;
import com.gigavoid.supermod.cookiecraft.cookie.CookieNetwork;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.util.BlockPos;
import com.google.common.base.Predicate;

import java.util.List;

public class TileEntityBakingTable extends TileEntityCookieGenerator{
	public static final String NBT_ACTIVE = "Active";
    private boolean active = false;

	public TileEntityBakingTable() {
	}

	Predicate<EntityVillager> checkRange(BlockPos pos){
		return entityVillager -> Math.abs(entityVillager.getPosition().getX() - pos.getX()) <= 1 && Math.abs(entityVillager.getPosition().getZ() - pos.getZ()) <= 1;
	}

	public boolean isAVillagerInRange(){
		List entities = this.worldObj.getEntities(EntityVillager.class, checkRange(this.pos));
		boolean result = !entities.isEmpty();
        boolean update = active != result;
		setActive(result);
        if (update)
            updateCookieNetwork();
		return result;
	}

    public void updateCookieNetwork(){
        CookieNetwork.getNetwork(getWorld(), getPos()).updateNetwork();
    }

	@Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);
        setActive(compound.getBoolean(NBT_ACTIVE));
    }

    @Override
    public void writeToNBT(NBTTagCompound compound) {
        compound.setBoolean(NBT_ACTIVE, active);
        super.writeToNBT(compound);
    }

	public boolean getActive(){
		return active;
	}

    public void setActive(boolean active) {
		this.active = active;
    }

    @Override
    public Packet getDescriptionPacket() {
        NBTTagCompound compound = new NBTTagCompound();
        compound.setBoolean(NBT_ACTIVE, active);
        return new S35PacketUpdateTileEntity(pos, 1, compound);
    }

    @Override
    public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt) {
        NBTTagCompound compound = pkt.getNbtCompound();
        setActive(compound.getBoolean(NBT_ACTIVE));
    }
}
