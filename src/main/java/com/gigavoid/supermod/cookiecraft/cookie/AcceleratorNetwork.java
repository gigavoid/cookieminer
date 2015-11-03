package com.gigavoid.supermod.cookiecraft.cookie;

import com.gigavoid.supermod.cookiecraft.block.BlockCookieAcceleratorBase;
import com.gigavoid.supermod.cookiecraft.block.ICookieBlock;
import com.gigavoid.supermod.cookiecraft.util.CookieAcceleratorBlockPos;
import net.minecraft.block.Block;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;

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

    public static List<AcceleratorNetwork> getNeighborNetworks(World world, BlockPos pos) {
        List<AcceleratorNetwork> networkList = new ArrayList<AcceleratorNetwork>();
        for (EnumFacing dir : EnumFacing.VALUES) {
            BlockPos newPos = pos.offset(dir);
            if (acceleratorBlockTester.isConnected(world.getBlockState(newPos).getBlock())) {
                networkList.add(getNetwork(world, newPos));
            }
        }
        return networkList;
    }

    @Override
    public boolean isCore(CookieBlock block) {
        return block.isAcceleratorControl();
    }

    public void updateAcceleratorBlocks(boolean active) {
        System.out.println("Accelerator, " + active + " " + connectedBlocks.size());
        for (CookieBlock block : connectedBlocks) {
            if (block.isAcceleratorBlock())
                ((BlockCookieAcceleratorBase) block.getWorld().getBlockState(block.getPos()).getBlock()).setActive(block.getWorld(), block.getPos(), active);

        }
    }

    @Override
    protected void postUpdateNetwork(CookieBlock core) {
        if (core == null)
            updateAcceleratorBlocks(false);
        else
            updateAcceleratorBlocks(isAcceleratorBuilt(world, core.getPos()));
    }

    private boolean isAcceleratorBuilt(World world, BlockPos pos) {
        boolean north = world.getBlockState(pos.offset(EnumFacing.NORTH)).getBlock() instanceof BlockCookieAcceleratorBase;
        boolean east = world.getBlockState(pos.offset(EnumFacing.EAST)).getBlock() instanceof BlockCookieAcceleratorBase;

        int length = 0;
        while (length < 64) {
            if (north) {
                if (world.getBlockState(pos.offset(EnumFacing.NORTH, length)).getBlock() instanceof BlockCookieAcceleratorBase) {
                    length++;
                } else
                    break;
            } else if (world.getBlockState(pos.offset(EnumFacing.SOUTH, length)).getBlock() instanceof BlockCookieAcceleratorBase) {
                length++;
            } else
                break;
        }

        if (length < 8) {
            return false;
        }

        ArrayList<BlockPos> acceleratorBlocks = new ArrayList<BlockPos>();

        boolean outerConnected = true;
        for (int i = 0; i < length && outerConnected; i++) {
            outerConnected = checkBlocksAtLength(world, new CookieAcceleratorBlockPos(pos), i, length, north, east, acceleratorBlocks);
        }


        for (BlockPos p : acceleratorBlocks) {
            ((BlockCookieAcceleratorBase) world.getBlockState(p).getBlock()).setActive(world, p, outerConnected);
        }

        return outerConnected;
    }

    private boolean checkBlocksAtLength(IBlockAccess world, CookieAcceleratorBlockPos pos, int interval, int length, boolean north, boolean east, ArrayList<BlockPos> acceleratorBlocks) {
        if (world.getBlockState(pos.offsetNorthSouth(interval, north)).getBlock() instanceof BlockCookieAcceleratorBase) {
            acceleratorBlocks.add(pos.offsetNorthSouth(interval, north));
        } else
            return false;

        if (world.getBlockState(pos.offsetEastWest(interval, east)).getBlock() instanceof BlockCookieAcceleratorBase) {
            acceleratorBlocks.add(pos.offsetEastWest(interval, east));
        } else
            return false;

        if (world.getBlockState(pos.offsetNorthSouth(interval, north).offsetEastWest(length - 1, east)).getBlock() instanceof BlockCookieAcceleratorBase) {
            acceleratorBlocks.add(pos.offsetNorthSouth(interval, north).offsetEastWest(length - 1, east));
        } else
            return false;

        if (world.getBlockState(pos.offsetEastWest(interval, east).offsetNorthSouth(length - 1, north)).getBlock() instanceof BlockCookieAcceleratorBase) {
            acceleratorBlocks.add(pos.offsetEastWest(interval, east).offsetNorthSouth(length - 1, north));
        } else
            return false;

        return true;
    }
}

class AcceleratorBlockTester implements ConnectedBlockTester {
    @Override
    public boolean isConnected(Block block) {
        return block instanceof ICookieBlock;
    }
}
