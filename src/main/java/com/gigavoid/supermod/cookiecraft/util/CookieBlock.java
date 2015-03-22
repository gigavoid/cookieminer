package com.gigavoid.supermod.cookiecraft.util;

import com.gigavoid.supermod.cookiecraft.block.CookiecraftBlocks;
import com.gigavoid.supermod.cookiecraft.block.ICookieStorage;
import com.gigavoid.supermod.cookiecraft.block.ICookieUpgrade;
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

    public boolean isCrafter() {
        return block == CookiecraftBlocks.cookieCrafter;
    }

    public double getCPS() {
        IBlockState blockState = world.getBlockState(pos);
        if (!(blockState.getBlock() instanceof ICookieUpgrade))
            return 0;

        return ((ICookieUpgrade) blockState.getBlock()).getCPS(world, pos, blockState);
    }

    public boolean isStorage() {
        return world.getBlockState(pos).getBlock() instanceof ICookieStorage;
    }

    public boolean isCpsUpgrade() {
        return world.getBlockState(pos).getBlock() instanceof ICookieUpgrade;
    }

    public long getCurrentStorage() {
        IBlockState blockState = world.getBlockState(pos);

        if (!(blockState.getBlock() instanceof ICookieStorage)) {
            return 0;
        }

        return ((ICookieStorage) blockState.getBlock()).getCurrentStorage(world, pos);
    }

    public long getStorageCap() {
        IBlockState blockState = world.getBlockState(pos);
        if (!(blockState.getBlock() instanceof ICookieStorage)) {
            return 0;
        }

        return ((ICookieStorage) blockState.getBlock()).getStorageCap();
    }

    public boolean isFullStorage() {
        return isStorage() && getStorageCap() - getCurrentStorage() <= 0;
    }

    /**
     * @return Leftover cookies that could not be stored
     */
    public long storeAsManyCookiesAsPossible(long numCookies) {
        ICookieStorage cookieStorage = (ICookieStorage) world.getBlockState(pos).getBlock();

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
