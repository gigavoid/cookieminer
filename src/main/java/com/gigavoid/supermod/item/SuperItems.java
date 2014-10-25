package com.gigavoid.supermod.item;

import com.gigavoid.supermod.item.material.BedrockLumpItem;
import com.gigavoid.supermod.item.pickaxe.*;
import cpw.mods.fml.common.registry.GameRegistry;

public class SuperItems {

    public static final ProgressivePickaxeWoodItem progressivePickaxeWood = new ProgressivePickaxeWoodItem();
    public static final ProgressivePickaxeStoneItem progressivePickaxeStone = new ProgressivePickaxeStoneItem();
    public static final ProgressivePickaxeIronItem progressivePickaxeIron = new ProgressivePickaxeIronItem();
    public static final ProgressivePickaxeGoldItem progressivePickaxeGold = new ProgressivePickaxeGoldItem();
    public static final ProgressivePickaxeDiamondItem progressivePickaxeDiamond = new ProgressivePickaxeDiamondItem();
    public static final ProgressivePickaxeSuperItem progressivePickaxeSuper = new ProgressivePickaxeSuperItem();

    public static final VoidPickaxeItem voidPickaxe = new VoidPickaxeItem();
    public static final BedrockLumpItem bedLump = new BedrockLumpItem();

    public static void initializeItems() {
        GameRegistry.registerItem(progressivePickaxeWood, "progressivePickaxeWood");
        GameRegistry.registerItem(progressivePickaxeStone, "progressivePickaxeStone");
        GameRegistry.registerItem(progressivePickaxeIron, "progressivePickaxeIron");
        GameRegistry.registerItem(progressivePickaxeGold, "progressivePickaxeGold");
        GameRegistry.registerItem(progressivePickaxeDiamond, "progressivePickaxeDiamond");
        GameRegistry.registerItem(progressivePickaxeSuper, "progressivePickaxeSuper");

        GameRegistry.registerItem(voidPickaxe, "voidPickaxe");
        GameRegistry.registerItem(bedLump, "bedrockLump");
    }
}
