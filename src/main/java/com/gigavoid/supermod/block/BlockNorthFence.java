package com.gigavoid.supermod.block;

import net.minecraft.block.BlockFence;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.world.World;

/**
 * Created by Rasmus on 2014-11-23.
 */
public class BlockNorthFence extends BlockFence {
    public BlockNorthFence(){
        super("supermod:planks_north", Material.wood);
        this.setCreativeTab(CreativeTabs.tabDecorations);
    }

    @Override
    public boolean canPlaceTorchOnTop(World world, int x, int y, int z) {
        return true;
    }
}
