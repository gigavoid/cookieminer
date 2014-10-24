package com.gigavoid.supermod.item.pickaxe;

import com.gigavoid.supermod.item.SuperItems;
import net.minecraft.item.ItemStack;

/**
 * Created by ineentho on 2014-10-24.
 */
public class ProgressivePickaxeGoldItem extends ProgressivePickaxeItem {
    public ProgressivePickaxeGoldItem() {
        super(ToolMaterial.GOLD);
        setUnlocalizedName("progessivePickaxeGold");
        setTextureName("progressivePickaxeGold");
        setMaxDamage(80);
    }

    @Override
    public ItemStack createNewPickaxe() {
        return new ItemStack(SuperItems.progressivePickaxeDiamond);
    }
}
