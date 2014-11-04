package com.gigavoid.supermod.item;


import com.gigavoid.supermod.item.material.*;
import com.gigavoid.supermod.item.misc.MagicEnderEyeItem;
import com.gigavoid.supermod.item.pickaxe.ProgressivePickaxeItem;
import com.gigavoid.supermod.item.pickaxe.VoidPickaxeItem;
import com.gigavoid.supermod.item.tool.RopewayWrench;
import cpw.mods.fml.common.IFuelHandler;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.ItemStack;

public class SuperItems {

    public static final ProgressivePickaxeItem progressivePickaxe = new ProgressivePickaxeItem();

    public static final VoidPickaxeItem voidPickaxe = new VoidPickaxeItem();
    public static final BedrockLumpItem bedLump = new BedrockLumpItem();
    public static final VoidStoneItem voidStone = new VoidStoneItem();
    public static final EmptyVoidStoneItem emptyVoidStone = new EmptyVoidStoneItem();
    public static final IronStickItem ironStick = new IronStickItem();
    public static final MagicPowderItem magicPowder = new MagicPowderItem();
    public static final MagicEnderEyeItem magicEnderEye = new MagicEnderEyeItem();
    public static final SaxeliumIngotItem saxeliumIngot = new SaxeliumIngotItem();
    public static final RopewayWrench ropewayWrench = new RopewayWrench();

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
        GameRegistry.registerItem(emptyVoidStone, "emptyVoidStone");
        GameRegistry.registerItem(magicPowder, "magicPowder");
        GameRegistry.registerItem(magicEnderEye, "magicEnderEye");
        GameRegistry.registerItem(saxeliumIngot, "saxeliumIngot");
        GameRegistry.registerItem(ropewayWrench, "ropewayWrench");

        GameRegistry.registerFuelHandler(fuelHandler);
    }
}
