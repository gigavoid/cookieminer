package com.gigavoid.supermod.common;

import com.gigavoid.supermod.SuperMod;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.IWorldGenerator;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraft.world.WorldProvider;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;

public class Register {
    private int nextDimensionId = 2;

    public void registerBlock(Block block, String name) {
        registerBlock(block, name, name);
    }

    public void registerBlock(Block block, String name, String resourceName) {
        block.setUnlocalizedName(name);
        GameRegistry.registerBlock(block, name);
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(block), 0, new ModelResourceLocation(SuperMod.MODID + ":" + resourceName, "inventory"));
    }

    public void registerFluid(Fluid fluid, String name) {
        fluid.setUnlocalizedName(name);
        FluidRegistry.registerFluid(fluid);
    }

    public void registerItem(Item item, String name, FMLInitializationEvent event) {
        item.setUnlocalizedName(name);
        GameRegistry.registerItem(item, name);
        if(event.getSide() == Side.CLIENT) {
            Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(SuperMod.MODID + ":" + name, "inventory"));
        }
    }

    public int registerDimension(Class<? extends WorldProvider> provider, boolean keepLoaded){
        DimensionManager.registerProviderType(nextDimensionId, provider, keepLoaded);
        DimensionManager.registerDimension(nextDimensionId, nextDimensionId);
        return nextDimensionId++;
    }

    public void registerWorldGenerator(IWorldGenerator generator, int id){
        GameRegistry.registerWorldGenerator(generator, id);
    }
}
