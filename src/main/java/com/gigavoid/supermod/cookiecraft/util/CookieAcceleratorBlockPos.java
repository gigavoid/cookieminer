package com.gigavoid.supermod.cookiecraft.util;

import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;

public class CookieAcceleratorBlockPos extends BlockPos {
    public CookieAcceleratorBlockPos(BlockPos pos) {
        super(pos.getX(), pos.getY(), pos.getZ());
    }

    public CookieAcceleratorBlockPos offsetNorthSouth(boolean north){
        return this.offsetNorthSouth(1, north);
    }

    public CookieAcceleratorBlockPos offsetNorthSouth(int dist, boolean north){
        if (north)
            return new CookieAcceleratorBlockPos(this.offset(EnumFacing.NORTH, dist));
        else
            return new CookieAcceleratorBlockPos(this.offset(EnumFacing.SOUTH, dist));
    }

    public CookieAcceleratorBlockPos offsetEastWest(boolean north){
        return this.offsetEastWest(1, north);
    }

    public CookieAcceleratorBlockPos offsetEastWest(int dist, boolean east){
        if (east)
            return new CookieAcceleratorBlockPos(this.offset(EnumFacing.EAST, dist));
        else
            return new CookieAcceleratorBlockPos(this.offset(EnumFacing.WEST, dist));
    }
}
