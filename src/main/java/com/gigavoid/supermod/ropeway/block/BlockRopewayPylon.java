package com.gigavoid.supermod.ropeway.block;

import com.gigavoid.supermod.SuperMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

/**
 * Created by Henrik on 2015-02-13.
 */
public class BlockRopewayPylon extends Block {
    protected BlockRopewayPylon() {
        super(Material.rock);
        this.setHardness(2.0f);
        this.setHarvestLevel("pickaxe", 0);
        this.setCreativeTab(RopewayBlocks.ropewayCreativeTab);
    }
}
