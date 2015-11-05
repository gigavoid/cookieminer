package com.gigavoid.supermod.common;

import com.gigavoid.supermod.SuperMod;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.IFluidBlock;
import net.minecraftforge.fml.common.IWorldGenerator;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraft.world.WorldProvider;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;

public class Register {
    private int nextDimensionId = 2;
    private int nextBiomeId = 40;
	private Side side;

	public void registerBlock(Block block, String name) {
        registerBlock(block, name, name);
    }

    public void registerBlock(Block block, String name, String resourceName) {
        block.setUnlocalizedName(name);
        GameRegistry.registerBlock(block, name);
		if (side == Side.CLIENT)
        	Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(block), 0, new ModelResourceLocation(SuperMod.MODID + ":" + resourceName, "inventory"));
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

    public void registerEntity(Class<? extends net.minecraft.entity.Entity> entity, String name, int color, int spotColor){
        int id = EntityRegistry.findGlobalUniqueEntityId();
        EntityRegistry.registerGlobalEntityID(entity, name, id, color, spotColor);
    }

    // If entity shall have no egg.
    public void registerEntity(Class<? extends net.minecraft.entity.Entity> entity, String name){
        int id = EntityRegistry.findGlobalUniqueEntityId();
        EntityRegistry.registerGlobalEntityID(entity, name, id);
    }

    public int getNextBiomeID(){
        return nextBiomeId++;
    }

    public void registerWorldGenerator(IWorldGenerator generator, int id){
        GameRegistry.registerWorldGenerator(generator, id);
    }

    public void registerFluidModel(IFluidBlock fluidBlock) {
        Item item = Item.getItemFromBlock((Block) fluidBlock);

        ModelBakery.addVariantName(item);

        final ModelResourceLocation modelResourceLocation = new ModelResourceLocation("supermod:choco_fluid", fluidBlock.getFluid().getName());

        ModelLoader.setCustomMeshDefinition(item, new ItemMeshDefinition() {
            @Override
            public ModelResourceLocation getModelLocation(ItemStack stack) {
                return modelResourceLocation;
            }
        });

        ModelLoader.setCustomStateMapper((Block) fluidBlock, new StateMapperBase() {
            @Override
            protected ModelResourceLocation getModelResourceLocation(IBlockState p_178132_1_) {
                return modelResourceLocation;
            }
        });
    }

	public void setSide(Side side) {
		this.side = side;
	}
}
