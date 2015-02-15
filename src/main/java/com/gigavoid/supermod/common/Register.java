package com.gigavoid.supermod.common;

import com.gigavoid.supermod.SuperMod;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
<<<<<<< HEAD:src/main/java/com/gigavoid/supermod/common/RegisterFunctions.java
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
=======
import net.minecraft.world.WorldProvider;
import net.minecraftforge.common.DimensionManager;
>>>>>>> e7039dfa0ff87fde8aa77118f5baa7444e20014e:src/main/java/com/gigavoid/supermod/common/Register.java
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;

public class Register {
    public static void registerBlock(Block block, String name) {
        block.setUnlocalizedName(name);
        GameRegistry.registerBlock(block, name);
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(block), 0, new ModelResourceLocation(SuperMod.MODID + ":" + name, "inventory"));
    }

    public static void registerItem(Item item, String name, FMLInitializationEvent event) {
        item.setUnlocalizedName(name);
        GameRegistry.registerItem(item, name);
        if(event.getSide() == Side.CLIENT) {
            Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(SuperMod.MODID + ":" + name, "inventory"));
        }
    }

    public static void registerDimension(int id, Class<? extends WorldProvider> provider, boolean keepLoaded){
        DimensionManager.registerProviderType(id, provider, keepLoaded);
        DimensionManager.registerDimension(id, id);
    }
}
