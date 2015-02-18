package com.gigavoid.supermod.ropeway.item;

import com.gigavoid.supermod.common.Register;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

public class RopewayItems {
    public static final ItemRopewayWrench wrench = new ItemRopewayWrench();
    public static final ItemRopewayBasket basket = new ItemRopewayBasket();

    public static void initializeItems(Register register, FMLInitializationEvent event) {
        register.registerItem(wrench, "ropeway_wrench", event);
        register.registerItem(basket, "ropeway_basket", event);
    }
}
