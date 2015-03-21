package com.gigavoid.supermod.cookiecraft.block;

import com.gigavoid.supermod.cookiecraft.creativetab.CookiecraftCreativeTabs;
import net.minecraft.block.material.Material;

public class BlockCookieDoughCollector extends BlockCookieUpgradeBase implements ICookieUpgrade {
    protected BlockCookieDoughCollector() {
        super(Material.rock);
        setCreativeTab(CookiecraftCreativeTabs.tabCookiecraft);
    }

    @Override
    public double getCPS() {
        return 2;
    }
}
