package com.gigavoid.supermod.block;

import net.minecraft.block.BlockOldLeaf;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.IIcon;

public class EmeraldLeavesBlock extends BlockOldLeaf {
    public EmeraldLeavesBlock(){
        super();
        this.setHardness(1.0f);
        this.setBlockTextureName("leaves_jungle");
        this.setCreativeTab(CreativeTabs.tabBlock);
        this.setBlockName("emeraldLeaves");
        this.setStepSound(soundTypeGrass);
    }

    @Override
    public IIcon getIcon(int p_149691_1_, int p_149691_2_) {
        return super.getIcon(p_149691_1_, 3);
    }

    @Override
    public String[] func_150125_e() {
        return new String[] {"Emerald"};
    }

    @Override
    public boolean isOpaqueCube()
    {
        return true;
    }
}
