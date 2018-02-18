package com.gigavoid.supermod.cookiecraft.cookie;

import com.gigavoid.supermod.cookiecraft.block.ICookieBlock;
import com.gigavoid.supermod.cookiecraft.tileentity.TileEntityCookieCrafter;
import net.minecraft.block.Block;
import net.minecraft.util.BlockPos;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.ArrayList;

public class CookieNetwork extends BlockNetwork {
    private static CookieBlockTester cookieBlockTester = new CookieBlockTester();

    private CookieNetwork(World world, BlockPos startPos) {
        super(world, startPos);
    }

    @Override
    public boolean isCore(CookieBlock block) {
        return block.isCrafter();
    }

    public static CookieNetwork getNetwork(World world, BlockPos pos) {
        CookieNetwork network = new CookieNetwork(world, pos);

        ArrayList<BlockPos> blocks = ConnectedBlockSearcher.findConnected(world, pos, cookieBlockTester);

        for (BlockPos block : blocks) {
            network.addBlock(world, block);
        }


        return network;
    }

    @Override
    protected void postUpdateNetwork(CookieBlock core) {
        if (core == null) return;

        ((TileEntityCookieCrafter) world.getTileEntity(core.getPos())).setCPS(calculateCps());
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
        for (CookieBlock block : connectedBlocks) {
            if (block.isStorage() && !block.isFullStorage()) {
                return block;
            }
        }
        return null;
    }

    private double calculateCps() {
        double cps = 0;
        for (CookieBlock block : connectedBlocks) {
            if (block.isCpsUpgrade())
                cps += block.getCPS();
        }

        return cps;
    }
}

class CookieBlockTester implements ConnectedBlockTester {
    @Override
    public boolean isConnected(Block block) {
        return block instanceof ICookieBlock;
    }
}
