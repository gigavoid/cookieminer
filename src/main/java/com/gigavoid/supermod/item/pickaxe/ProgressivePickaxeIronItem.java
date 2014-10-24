package com.gigavoid.supermod.item.pickaxe;

import com.gigavoid.supermod.item.SuperItems;
import net.minecraft.item.ItemStack;

/**
 * Created by ineentho on 2014-10-24.
 */
public class ProgressivePickaxeIronItem extends ProgressivePickaxeItem {
    public ProgressivePickaxeIronItem() {
        super(ToolMaterial.IRON);
        setUnlocalizedName("progessivePickaxeIron");
        setTextureName("progressivePickaxeIron");
        setMaxDamage(40);
    }

    @Override
    public ItemStack createNewPickaxe(ItemStack oldPick) {
        return new ItemStack(SuperItems.progressivePickaxeGold);
    }
}
