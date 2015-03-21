package com.gigavoid.supermod.cookiecraft.util;

import com.gigavoid.supermod.cookiecraft.block.ICookieBlock;
import com.gigavoid.supermod.cookiecraft.tileentity.TileEntityCookieCrafter;
import net.minecraft.block.Block;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CookieNetwork {
    private List<CookieBlock> cookieBlocks = new ArrayList<CookieBlock>();
    private CookieBlock crafter;
    private double cps;

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
        if (!checkDuplicateCrafter(worldIn, pos)) {
            // There was no duplicate crafter, continue storing it
            if (crafter != null) {
                ((TileEntityCookieCrafter)worldIn.getTileEntity(crafter.getPos())).setCPS(cps);
            }
        }
    }

    private Boolean checkDuplicateCrafter(World worldIn, BlockPos pos) {
        Boolean hasCrafter = false;
        for (CookieBlock cookieBlock : cookieBlocks) {
            cps += cookieBlock.getCPS();
            if (cookieBlock.isCrafter()) {
                crafter = cookieBlock;
                if (hasCrafter) {
                    // Multiple crafters, not a good idea.
                    if (cookieBlock.getPos().equals(pos)) {
                        // This block pos is the newly placed crafter, pop it!
                        worldIn.destroyBlock(pos, true);
                        return true;
                    }
                }
                hasCrafter = true;
            }
        }
        return false;
    }
}
