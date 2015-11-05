package com.gigavoid.supermod.cookiecraft.cookie;

import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;

public abstract class BlockNetwork  {
    protected List<CookieBlock> connectedBlocks = new ArrayList<CookieBlock>();
    protected World world;
    protected BlockPos startPos;

    public BlockNetwork(World world, BlockPos startPos) {

        this.world = world;
        this.startPos = startPos;
    }

    public void addBlock(World world, BlockPos pos) {
        connectedBlocks.add(new CookieBlock(world, pos, world.getBlockState(pos).getBlock()));
    }


    public boolean hasMultipleCores() {
        Boolean foundOne = false;
        for (CookieBlock cookieBlock : connectedBlocks) {
            if (isCore(cookieBlock)) {
                if (foundOne) {
                    return true;
                }
                foundOne = true;
            }
        }
        return false;

    }


    public void updateNetwork() {
        if (hasMultipleCores()) {
            // Destroy the newly placed block, preventing multiple crafters
            world.destroyBlock(startPos, true);
        } else {
            // There was no duplicate core, continue storing it
            CookieBlock core = findCore();
            postUpdateNetwork(core);
        }
    }

    protected abstract void postUpdateNetwork(CookieBlock core);

    public int getSizeOfNetwork(){
        return this.connectedBlocks.size();
    }

    public CookieBlock findCore() {
        for (CookieBlock block : connectedBlocks) {
            if (isCore(block))
                return block;
        }
        return null;
    }

    public abstract boolean isCore(CookieBlock block);

}
