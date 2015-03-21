package com.gigavoid.supermod.northrend.block;

import com.gigavoid.supermod.northrend.creativetab.NorthrendCreativeTabs;
import net.minecraft.block.BlockFence;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.world.World;

/**
 * Created by Rasmus on 2014-11-23.
 */
public class BlockNorthFence extends BlockFence {
    public BlockNorthFence(){
        super(Material.wood);
        this.setCreativeTab(NorthrendCreativeTabs.tabNorthrend);
    }
}
