package com.gigavoid.supermod.ropeway.block;

import com.gigavoid.supermod.SuperMod;
import com.gigavoid.supermod.ropeway.creativetab.RopewayCreativeTabs;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;

/**
 * Created by Henrik on 2015-02-13.
 */
public class BlockRopewayPylon extends Block {
    protected BlockRopewayPylon() {
        super(Material.rock);
        this.setHardness(2.0f);
        this.setHarvestLevel("pickaxe", 0);
        this.setCreativeTab(RopewayCreativeTabs.tabBlock);
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return 2;
    }


}
