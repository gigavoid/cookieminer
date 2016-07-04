package com.gigavoid.supermod.cookiecraft.container;

import com.gigavoid.supermod.cookiecraft.block.BlockCookieGeneratorBase;
import com.gigavoid.supermod.cookiecraft.block.BlockCookieNetworkBlockBase;
import com.gigavoid.supermod.cookiecraft.tileentity.TileEntityCookieGenerator;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotCookieUpgrade extends Slot {
    private final TileEntityCookieGenerator tileEntity;

    public SlotCookieUpgrade(TileEntityCookieGenerator tileEntity, int index, int x, int y) {
        super(tileEntity, index, x, y);
        this.tileEntity = tileEntity;
    }

    @Override
    public boolean isItemValid(ItemStack stack) {
        return ((BlockCookieGeneratorBase) tileEntity.getBlockType()).canAcceptUpgrade(stack);
    }
}
