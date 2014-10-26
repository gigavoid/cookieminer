package com.gigavoid.supermod.recepies;

import com.gigavoid.supermod.block.SuperBlocks;
import com.gigavoid.supermod.item.SuperItems;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.ItemStack;

public class SuperSmeltingRecipie {
    public static void InitializeSmektingRecipes(){
        GameRegistry.addSmelting(SuperBlocks.emeraldFlower, new ItemStack(SuperItems.magicPowder, 2), 10);
    }
}
