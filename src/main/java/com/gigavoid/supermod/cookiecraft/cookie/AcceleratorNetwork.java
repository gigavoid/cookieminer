package com.gigavoid.supermod.cookiecraft.cookie;

import com.gigavoid.supermod.cookiecraft.block.BlockCookieAcceleratorBase;
import com.gigavoid.supermod.cookiecraft.block.ICookieBlock;
import net.minecraft.block.Block;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

import java.util.ArrayList;

public class AcceleratorNetwork extends BlockNetwork {
    private static AcceleratorBlockTester acceleratorBlockTester = new AcceleratorBlockTester();

    public AcceleratorNetwork(World world, BlockPos startPos) {
        super(world, startPos);
    }

    public static AcceleratorNetwork getNetwork(World world, BlockPos pos) {
        AcceleratorNetwork network = new AcceleratorNetwork(world, pos);

        ArrayList<BlockPos> blocks = ConnectedBlockSearcher.findConnected(world, pos, acceleratorBlockTester);

        for (BlockPos block : blocks) {
            network.addBlock(world, block);
        }


        return network;
    }

    @Override
    protected void postUpdateNetwork(CookieBlock core) {

    }

    @Override
    public boolean isCore(CookieBlock block) {
        return block.isAcceleratorControl();
    }

    public CookieBlock findAcceleratorControl() {
        for (CookieBlock block : connectedBlocks) {
            if (block.isAcceleratorControl())
                return block;
        }
        return null;
    }

    public void updateAcceleratorBlocks(boolean active) {
        for (CookieBlock block : connectedBlocks) {
            if (block.isAcceleratorBlock())
                ((BlockCookieAcceleratorBase) block.getWorld().getBlockState(block.getPos()).getBlock()).setActive(block.getWorld(), block.getPos(), active);
        }
    }
}

class AcceleratorBlockTester implements ConnectedBlockTester {
    @Override
    public boolean isConnected(Block block) {
        return block instanceof ICookieBlock;
    }
}
