package com.gigavoid.supermod.cookiecraft.cookie;

import com.gigavoid.supermod.cookiecraft.block.*;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
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

    public World getWorld() {
        return world; }

    public boolean isCrafter() {
        return block == BlockCookieCrafter.instance;
    }

    public boolean isAcceleratorControl() {
        return block == BlockCookieAcceleratorControl.instance;
    }

    public boolean isAcceleratorBlock() {return block instanceof BlockCookieAcceleratorBase; }

    public double getCPS() {
        IBlockState blockState = world.getBlockState(pos);
        if (!(blockState.getBlock() instanceof ICookieGenerator))
            return 0;

        return ((ICookieGenerator) blockState.getBlock()).getModifiedCPS(world, pos, blockState);
    }

    public boolean isStorage() {
        return world.getBlockState(pos).getBlock() instanceof ICookieStorageBlock;
    }

    public boolean isCpsUpgrade() {
        return world.getBlockState(pos).getBlock() instanceof ICookieGenerator;
    }

    public long getCurrentStorage() {
        IBlockState blockState = world.getBlockState(pos);

        if (!(blockState.getBlock() instanceof ICookieStorageBlock)) {
            return 0;
        }

        return ((ICookieStorageBlock) blockState.getBlock()).getCurrentStorage(world, pos);
    }

    public long getStorageCap() {
        IBlockState blockState = world.getBlockState(pos);
        if (!(blockState.getBlock() instanceof ICookieStorageBlock)) {
            return 0;
        }

        return ((ICookieStorageBlock) blockState.getBlock()).getStorageCap();
    }

    public boolean isFullStorage() {
        return isStorage() && getStorageCap() - getCurrentStorage() <= 0;
    }

    /**
     * @return Leftover cookies that could not be stored
     */
    public long storeAsManyCookiesAsPossible(long numCookies) {
        ICookieStorageBlock cookieStorage = (ICookieStorageBlock) world.getBlockState(pos).getBlock();

        long storageLeft = getStorageCap() - getCurrentStorage();

        if (storageLeft >= numCookies) {
            // There's space to store all cookies
            cookieStorage.addCookies(world, pos, numCookies);
            return 0; // no cookies left
        }

        // Store until the storage is full
        cookieStorage.addCookies(world, pos, storageLeft);
        return numCookies - storageLeft; // some cookies left to store elsewhere
    }
}
