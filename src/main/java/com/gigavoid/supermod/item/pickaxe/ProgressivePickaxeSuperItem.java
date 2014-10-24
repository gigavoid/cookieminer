package com.gigavoid.supermod.item.pickaxe;

import com.gigavoid.supermod.item.SuperItems;
import net.minecraft.item.ItemStack;

/**
 * Created by ineentho on 2014-10-24.
 */
public class ProgressivePickaxeSuperItem extends ProgressivePickaxeItem {
    public ProgressivePickaxeSuperItem() {
        super(ToolMaterial.EMERALD);
        setUnlocalizedName("progessivePickaxeSuper");
        setTextureName("progressivePickaxeSuper");
        setMaxDamage(160);
    }

    @Override
    public ItemStack createNewPickaxe() {
        return new ItemStack(SuperItems.progressivePickaxeSuper);
    }
}
