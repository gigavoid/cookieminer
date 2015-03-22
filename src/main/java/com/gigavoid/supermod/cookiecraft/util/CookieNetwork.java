package com.gigavoid.supermod.cookiecraft.util;

import com.gigavoid.supermod.cookiecraft.block.ICookieBlock;
import com.gigavoid.supermod.cookiecraft.tileentity.TileEntityCookieCrafter;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CookieNetwork {
    private List<CookieBlock> cookieBlocks = new ArrayList<CookieBlock>();

    public static CookieNetwork getNetwork(World world, BlockPos pos) {
        CookieNetwork network = new CookieNetwork();

        List<BlockPos> searched = new ArrayList<BlockPos>();
        Stack<BlockPos> toSearch = new Stack<BlockPos>();
        toSearch.push(pos);
        searched.add(pos);


        while (!toSearch.empty()) {
            BlockPos blockPos = toSearch.pop();
            if (world.getBlockState(blockPos).getBlock() instanceof ICookieBlock) {
                network.addBlock(world, blockPos);

                searchNext(searched, toSearch, blockPos.offsetNorth());
                searchNext(searched, toSearch, blockPos.offsetEast());
                searchNext(searched, toSearch, blockPos.offsetSouth());
                searchNext(searched, toSearch, blockPos.offsetWest());
                searchNext(searched, toSearch, blockPos.offsetUp());
                searchNext(searched, toSearch, blockPos.offsetDown());
            }
        }


        return network;
    }

    private static void searchNext(List<BlockPos> searched, Stack<BlockPos> toSearch, BlockPos blockPos) {
        if (!hasSearched(searched, blockPos)) {
            toSearch.add(blockPos);
            searched.add(blockPos);
        }
    }

    private static boolean hasSearched(List<BlockPos> searched, BlockPos blockPos) {
        for(BlockPos pos : searched) {
            if (pos.equals(blockPos))
                return true;
        }
        return false;
    }

    private void addBlock(World world, BlockPos pos) {
        cookieBlocks.add(new CookieBlock(world, pos, world.getBlockState(pos).getBlock()));
    }

    public void updateNetwork(World worldIn, BlockPos pos) {
        if (hasMultipleCrafters()) {
            // Destroy the newly placed block, preventing multiple crafters
            worldIn.destroyBlock(pos, true);
        }
        else {
            // There was no duplicate crafter, continue storing it
            CookieBlock crafter = findCrafter();
            if (crafter != null) {
                ((TileEntityCookieCrafter)worldIn.getTileEntity(crafter.getPos())).setCPS(calculateCps());
            }
        }
    }

    /**
     * @return Leftover cookies that could not be stored
     */
    public long storeCookies(long numCookies) {
        while (true) {
            CookieBlock block = findNextStorageBlock();
            if (block == null)
                return numCookies;

            numCookies = block.storeAsManyCookiesAsPossible(numCookies);

            if (numCookies == 0)
                return 0;
        }
    }

    private CookieBlock findNextStorageBlock() {
        for (CookieBlock block : cookieBlocks) {
            if (block.isStorage() && !block.isFullStorage()) {
                return block;
            }
        }
        return null;
    }

    private double calculateCps() {
        double cps = 0;
        for (CookieBlock block : cookieBlocks) {
            if (block.isCpsUpgrade())
                cps += block.getCPS();
        }

        return cps;
    }

    private CookieBlock findCrafter() {
        for (CookieBlock block : cookieBlocks) {
            if (block.isCrafter())
                return block;
        }
        return null;
    }

    private boolean hasMultipleCrafters() {
        Boolean foundOneCrafter = false;
        for (CookieBlock cookieBlock : cookieBlocks) {
            if (cookieBlock.isCrafter()) {
                if (foundOneCrafter) {
                    return true;
                }
                foundOneCrafter = true;
            }
        }
        return false;
    }
}
