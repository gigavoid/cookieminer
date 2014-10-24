package com.gigavoid.supermod.block;

import net.minecraft.block.BlockFlower;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.world.World;

import java.util.Random;

public class EmeraldFlowerBlock extends BlockFlower {
    public EmeraldFlowerBlock() {
        super(0);
        this.setLightLevel(1.0f);
        this.setCreativeTab(CreativeTabs.tabDecorations);
        this.setBlockName("emeraldFlower");
        this.setTickRandomly(true);
    }

    @Override
    public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random) {
        super.updateTick(par1World, par2, par3, par4, par5Random);
        par1World.spawnParticle("largeexplode", par2, par3, par4, 0.0D, 1.0D, 0.0D);
    }
}
