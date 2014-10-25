package com.gigavoid.supermod.item;


import com.gigavoid.supermod.item.material.BedrockLumpItem;
import com.gigavoid.supermod.item.material.IronStickItem;
import com.gigavoid.supermod.item.material.VoidStoneItem;
import com.gigavoid.supermod.item.pickaxe.VoidPickaxeItem;
import cpw.mods.fml.common.registry.GameRegistry;

public class SuperItems {

    public static final ProgressivePickaxeItem progressivePickaxe = new ProgressivePickaxeItem();

    public static final VoidPickaxeItem voidPickaxe = new VoidPickaxeItem();
    public static final BedrockLumpItem bedLump = new BedrockLumpItem();
    public static final VoidStoneItem voidStone = new VoidStoneItem();
    public static final IronStickItem ironStick = new IronStickItem();

    public static void initializeItems() {
        GameRegistry.registerItem(progressivePickaxe, "progressivePickaxe");

        GameRegistry.registerItem(voidPickaxe, "voidPickaxe");
        GameRegistry.registerItem(bedLump, "bedrockLump");
        GameRegistry.registerItem(ironStick, "ironStick");
        GameRegistry.registerItem(voidStone, "voidStone");
    }
}
