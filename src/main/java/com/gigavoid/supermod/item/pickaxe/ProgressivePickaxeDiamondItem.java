package com.gigavoid.supermod.item.pickaxe;

import com.gigavoid.supermod.item.SuperItems;
import net.minecraft.item.ItemStack;

/**
 * Created by ineentho on 2014-10-24.
 */
public class ProgressivePickaxeDiamondItem extends ProgressivePickaxeItem {
    public ProgressivePickaxeDiamondItem() {
        super(ToolMaterial.EMERALD);
        setUnlocalizedName("progessivePickaxeDiamond");
        setTextureName("progressivePickaxeDiamond");
        setMaxDamage(160);
    }

    @Override
    public ItemStack createNewPickaxe(ItemStack oldPick) {
        return new ItemStack(SuperItems.progressivePickaxeSuper);
    }
}
