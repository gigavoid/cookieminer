package com.gigavoid.supermod.cookiecraft.cookie;

import com.gigavoid.supermod.cookiecraft.block.ICookieBlock;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by ineentho on 11/3/15.
 */
public class ConnectedBlockSearcher {

    public static ArrayList<BlockPos> findConnected(World world, BlockPos pos, ConnectedBlockTester tester) {
        ArrayList<BlockPos> blocks = new ArrayList<BlockPos>();
        List<BlockPos> searched = new ArrayList<BlockPos>();
        Stack<BlockPos> toSearch = new Stack<BlockPos>();
        toSearch.push(pos);
        searched.add(pos);


        while (!toSearch.empty()) {
            BlockPos blockPos = toSearch.pop();
            if (tester.isConnected(world.getBlockState(blockPos).getBlock())) {
                blocks.add(blockPos);

                for (EnumFacing dir : EnumFacing.VALUES) {
                    searchNext(searched, toSearch, blockPos.offset(dir));
                }
            }
        }


        return blocks;
    }

    private static void searchNext(List<BlockPos> searched, Stack<BlockPos> toSearch, BlockPos blockPos) {
        if (!hasSearched(searched, blockPos)) {
            toSearch.add(blockPos);
            searched.add(blockPos);
        }
    }

    private static boolean hasSearched(List<BlockPos> searched, BlockPos blockPos) {
        for (BlockPos pos : searched) {
            if (pos.equals(blockPos))
                return true;
        }
        return false;
    }
}
