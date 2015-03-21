package com.gigavoid.supermod.cookiecraft.block;

import com.gigavoid.supermod.cookiecraft.creativetab.CookiecraftCreativeTabs;
import net.minecraft.block.material.Material;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public class BlockPortalConnector extends BlockCookieUpgradeBase implements ICookieUpgrade {
    public BlockPortalConnector(){
        super(Material.rock);
        setCreativeTab(CookiecraftCreativeTabs.tabCookiecraft);
    }

    @Override
    public double getCPS(World world, BlockPos pos) {
        if (isNextToPortal(world, pos.offsetNorth()) ||
                isNextToPortal(world, pos.offsetEast()) ||
                isNextToPortal(world, pos.offsetSouth()) ||
                isNextToPortal(world, pos.offsetWest())) {
            return 1000d;
        }
        return 0;
    }

    private boolean isNextToPortal(World world, BlockPos blockPos) {
        return world.getBlockState(blockPos).getBlock() == CookiecraftBlocks.portalCookiecraft;
    }
}
