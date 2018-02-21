package com.gigavoid.supermod.cookiecraft.item;

import com.gigavoid.supermod.cookiecraft.creativetab.CookiecraftCreativeTabs;
import com.gigavoid.supermod.cookiecraft.upgrade.MultiplicativeBoost;
import net.minecraft.item.Item;

public class ItemMultiplicativeCPSUpgrade extends CookieItemBase implements IItemCookieUpgrade{
    private final double boost;
    public final static String MULT_BOOST_SIMPLE = "multBoostSimple";


    public ItemMultiplicativeCPSUpgrade(String name, double boost) {
        super(name);
        this.boost = boost;
        setCreativeTab(CookiecraftCreativeTabs.tabCookiecraft);
    }

    @Override
    public double getFlatBoost() {
        return 0;
    }

    @Override
    public MultiplicativeBoost getMultiplicativeBoost() {
        return new MultiplicativeBoost(MULT_BOOST_SIMPLE, this.boost);
    }
}
