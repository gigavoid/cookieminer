package com.gigavoid.supermod.item.pickaxe;

import com.gigavoid.supermod.item.SuperItems;
import net.minecraft.item.ItemStack;

/**
 * Created by ineentho on 2014-10-24.
 */
public class ProgressivePickaxeStoneItem extends ProgressivePickaxeItem {
    public ProgressivePickaxeStoneItem() {
        super(ToolMaterial.STONE);
        setUnlocalizedName("progessivePickaxeStone");
        setTextureName("progressivePickaxeStone");
        setMaxDamage(20);
    }

    @Override
    public ItemStack createNewPickaxe(ItemStack oldPick) {
        return  new ItemStack(SuperItems.progressivePickaxeGold);
    }
}
