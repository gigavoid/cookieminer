package com.gigavoid.supermod.cookiecraft.util;

import com.gigavoid.supermod.cookiecraft.block.CookiecraftBlocks;
import com.gigavoid.supermod.cookiecraft.block.ICookieUpgrade;
import net.minecraft.block.Block;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public class CookieBlock {
    private final World world;
    private final BlockPos pos;
    private final Block block;

    public CookieBlock(World world, BlockPos pos, Block block) {
        this.world = world;
        this.pos = pos;
        this.block = block;
    }

    public BlockPos getPos() {
        return pos;
    }

    public boolean isCrafter() {
        return block == CookiecraftBlocks.cookieCrafter;
    }

    public double getCPS() {
        return ((ICookieUpgrade)world.getBlockState(pos).getBlock()).getCPS(world, pos);
    }
}
