package com.gigavoid.supermod.cookiecraft.block;

import com.gigavoid.supermod.cookiecraft.creativetab.CookiecraftCreativeTabs;
import net.minecraft.block.material.Material;

public class BlockCookiePortal extends BlockCookieUpgradeBase implements ICookieUpgrade {
    protected BlockCookiePortal() {
        super(Material.rock);
        setCreativeTab(CookiecraftCreativeTabs.tabCookiecraft);

    }

    @Override
    public double getCPS() {
        return 2;
    }
}
