package com.gigavoid.supermod.item;


import com.gigavoid.supermod.item.material.BedrockLumpItem;
import com.gigavoid.supermod.item.material.IronStickItem;
import com.gigavoid.supermod.item.material.MagicPowderItem;
import com.gigavoid.supermod.item.material.VoidStoneItem;
import com.gigavoid.supermod.item.pickaxe.ProgressivePickaxeItem;
import com.gigavoid.supermod.item.pickaxe.VoidPickaxeItem;
import cpw.mods.fml.common.IFuelHandler;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.ItemStack;

public class SuperItems {

    public static final ProgressivePickaxeItem progressivePickaxe = new ProgressivePickaxeItem();

    public static final VoidPickaxeItem voidPickaxe = new VoidPickaxeItem();
    public static final BedrockLumpItem bedLump = new BedrockLumpItem();
    public static final VoidStoneItem voidStone = new VoidStoneItem();
    public static final IronStickItem ironStick = new IronStickItem();
    public static final MagicPowderItem magicPowder = new MagicPowderItem();

    public static final IFuelHandler fuelHandler = new IFuelHandler() {
        @Override
        public int getBurnTime(ItemStack fuel) {
            if (fuel.getItem() == magicPowder)
                return 3200;
            return 0;
        }
    };

    public static void initializeItems() {
        GameRegistry.registerItem(progressivePickaxe, "progressivePickaxe");

        GameRegistry.registerItem(voidPickaxe, "voidPickaxe");
        GameRegistry.registerItem(bedLump, "bedrockLump");
        GameRegistry.registerItem(ironStick, "ironStick");
        GameRegistry.registerItem(voidStone, "voidStone");
        GameRegistry.registerItem(magicPowder, "magicPowder");

        GameRegistry.registerFuelHandler(fuelHandler);
    }
}
