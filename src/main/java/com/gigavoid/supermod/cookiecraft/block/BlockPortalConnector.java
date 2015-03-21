package com.gigavoid.supermod.cookiecraft.block;

import com.gigavoid.supermod.cookiecraft.creativetab.CookiecraftCreativeTabs;
import net.minecraft.block.material.Material;

public class BlockPortalConnector extends BlockCookieUpgradeBase implements ICookieUpgrade {
    public BlockPortalConnector(){
        super(Material.rock);
        setCreativeTab(CookiecraftCreativeTabs.tabCookiecraft);
    }

    @Override
    public double getCPS() {
        return 1000d;
    }
}
