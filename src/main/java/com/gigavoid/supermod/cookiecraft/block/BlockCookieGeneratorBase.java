package com.gigavoid.supermod.cookiecraft.block;

import com.gigavoid.supermod.cookiecraft.tileentity.TileEntityCookieGenerator;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public abstract class BlockCookieGeneratorBase extends BlockCookieNetworkBlockBase {

    public BlockCookieGeneratorBase(Material material) {
        super(material);
    }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileEntityCookieGenerator();
    }


    public TileEntityCookieGenerator getTileEntity(World world, BlockPos pos) {
        return (TileEntityCookieGenerator) world.getTileEntity(pos);
    }
}
