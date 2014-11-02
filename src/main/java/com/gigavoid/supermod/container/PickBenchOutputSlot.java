package com.gigavoid.supermod.container;

import com.gigavoid.supermod.tileentity.PickBenchTileEntity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.SlotFurnace;

/**
 * Created by ineentho on 2014-10-26.
 */
public class PickBenchOutputSlot extends SlotFurnace{

    private PickBenchTileEntity tileEntity;

    public PickBenchOutputSlot(EntityPlayer player, PickBenchTileEntity tileEntity, int id, int x, int y) {
        super(player, tileEntity, id, x, y);
        this.tileEntity = tileEntity;
    }


    @Override
    public boolean canTakeStack(EntityPlayer p_82869_1_) {
        return tileEntity.canUpgrade();
    }

}
