package com.gigavoid.supermod.ropeway.block;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by Henrik on 2015-02-13.
 */
public class RopewayBlocks {

    public static final BlockRopewayPylon ropewayPylon = new BlockRopewayPylon();

    public static void initializeBlocks() {
        registerBlock(ropewayPylon, "pylon");
    }

    private static void registerBlock(Block block, String name) {
        block.setUnlocalizedName(name);
        GameRegistry.registerBlock(block, name);
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(block), 0, new ModelResourceLocation("supermod:" + name, "inventory"));

    }
}
