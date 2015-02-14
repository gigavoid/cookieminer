package com.gigavoid.supermod.common;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by Rasmus on 2/13/2015.
 */
public class RegisterFunctions {
    public static void registerBlock(Block block, String name) {
        block.setUnlocalizedName(name);
        GameRegistry.registerBlock(block, name);
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(block), 0, new ModelResourceLocation("supermod:" + name, "inventory"));
    }
}
