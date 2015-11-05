package com.gigavoid.supermod.cookiecraft;

import com.gigavoid.supermod.common.module.Module;
import com.gigavoid.supermod.cookiecraft.biome.CookieBiome;
import com.gigavoid.supermod.cookiecraft.block.BlockFluidChoco;
import com.gigavoid.supermod.cookiecraft.block.CookiecraftBlocks;
import com.gigavoid.supermod.cookiecraft.fluids.FluidChoco;
import com.gigavoid.supermod.cookiecraft.gui.CookiecraftGuis;
import com.gigavoid.supermod.cookiecraft.recipe.CookiecraftRecipes;
import com.gigavoid.supermod.cookiecraft.item.CookiecraftItems;
import com.gigavoid.supermod.cookiecraft.tileentity.CookiecraftTileEntities;
import com.gigavoid.supermod.cookiecraft.worldgen.CookiecraftWorldProvider;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModuleCookiecraft extends Module{
    private static ModelResourceLocation fluidLocation = new ModelResourceLocation("supermod:" + BlockFluidChoco.name, "fluid");
    public static int dimensionId;
    public static CookieBiome cookieBiome;

    @Override
    public void preInit(FMLPreInitializationEvent e) {
        FluidRegistry.registerFluid(FluidChoco.instance);
        GameRegistry.registerBlock(BlockFluidChoco.instance, BlockFluidChoco.name);
        Item fluid = Item.getItemFromBlock(BlockFluidChoco.instance);
        ModelBakery.addVariantName(fluid);

        ModelLoader.setCustomMeshDefinition(fluid, new ItemMeshDefinition() {
            public ModelResourceLocation getModelLocation(ItemStack stack) {
                return fluidLocation;
            }
        });
        ModelLoader.setCustomStateMapper(BlockFluidChoco.instance, new StateMapperBase()
        {
            protected ModelResourceLocation getModelResourceLocation(IBlockState state)
            {
                return fluidLocation;
            }
        });

        cookieBiome = new CookieBiome(getRegister(e.getSide()).getNextBiomeID(), 10);
        BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeManager.BiomeEntry(cookieBiome, 0));

        dimensionId = getRegister(e.getSide()).registerDimension(CookiecraftWorldProvider.class, false);
    }

    @Override
    public void init(FMLInitializationEvent e) {
        CookiecraftBlocks.initializeBlocks(getRegister(e.getSide()));
        CookiecraftItems.registerItems(getRegister(e.getSide()), e);
        CookiecraftTileEntities.registerTileEntities();
        CookiecraftGuis.initializeGuis();
        CookiecraftRecipes.initializeRecipes();
    }
}
