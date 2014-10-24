package com.gigavoid.supermod.item.pickaxe;

import com.gigavoid.supermod.item.SuperItems;
import net.minecraft.item.ItemStack;

/**
 * Created by ineentho on 2014-10-24.
 */
public class ProgressivePickaxeWoodItem extends ProgressivePickaxeItem {
    public ProgressivePickaxeWoodItem() {
        super(ToolMaterial.WOOD);
        setUnlocalizedName("progessivePickaxeWood");
        setTextureName("progressivePickaxeWood");
        setMaxDamage(10);
    }

    @Override
    public ItemStack createNewPickaxe() {
        return  new ItemStack(SuperItems.progressivePickaxeStone);
    }
}
