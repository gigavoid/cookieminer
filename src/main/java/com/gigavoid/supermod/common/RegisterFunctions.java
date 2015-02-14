package com.gigavoid.supermod.common;

import com.gigavoid.supermod.SuperMod;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class RegisterFunctions {
    public static void registerBlock(Block block, String name) {
        block.setUnlocalizedName(name);
        GameRegistry.registerBlock(block, name);
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(block), 0, new ModelResourceLocation(SuperMod.MODID + ":" + name, "inventory"));
    }

    public static void registerItem(Item item, String name) {
        item.setUnlocalizedName(name);
        GameRegistry.registerItem(item, name);
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(SuperMod.MODID + ":" + name, "inventory"));
    }
}
