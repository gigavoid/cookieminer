package com.gigavoid.supermod.cookiecraft.tileentity;

import com.gigavoid.supermod.cookiecraft.cookie.CookieNetwork;
import com.google.common.base.Predicate;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.util.math.BlockPos;

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
		List entities = this.world.getEntities(EntityVillager.class, checkRange(this.pos));
		boolean result = !entities.isEmpty();
		setActive(result);
        if (result != active)
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
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        compound.setBoolean(NBT_ACTIVE, active);
        super.writeToNBT(compound);
        return compound;
    }

	public boolean getActive(){
		return active;
	}

    public void setActive(boolean active) {
		this.active = active;
    }

    @Override
    public NBTTagCompound getUpdateTag() {
        NBTTagCompound tag = super.getUpdateTag();
        tag.setBoolean(NBT_ACTIVE, active);
        return tag;
    }

    @Override
    public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity pkt) {
        NBTTagCompound compound = pkt.getNbtCompound();
        setActive(compound.getBoolean(NBT_ACTIVE));
    }
}
