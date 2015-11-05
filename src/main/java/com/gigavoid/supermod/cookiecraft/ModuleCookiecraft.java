package com.gigavoid.supermod.cookiecraft;

import com.gigavoid.supermod.common.Register;
import com.gigavoid.supermod.common.module.Module;
import com.gigavoid.supermod.cookiecraft.biome.CookieBiome;
import com.gigavoid.supermod.cookiecraft.block.BlockCookieChocoFluid;
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
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModuleCookiecraft extends Module{
    @SidedProxy(serverSide = "com.gigavoid.supermod.cookiecraft.ModuleCookiecraft$CommonProxy", clientSide = "com.gigavoid.supermod.cookiecraft.ModuleCookiecraft$ClientProxy")
    public static CommonProxy proxy;

    public static int dimensionId;
    public static CookieBiome cookieBiome;

    public void preInit(FMLPreInitializationEvent event) { proxy.preInit(event, getRegister(event.getSide())); }

    public static class CommonProxy
    {
        public void preInit(FMLPreInitializationEvent event, Register register)
        {
            FluidRegistry.registerFluid(FluidChoco.instance);
            GameRegistry.registerBlock(BlockCookieChocoFluid.instance, BlockCookieChocoFluid.name);


            cookieBiome = new CookieBiome(register.getNextBiomeID(), 10);
            BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeManager.BiomeEntry(cookieBiome, 0));

            dimensionId = register.registerDimension(CookiecraftWorldProvider.class, false);
        }
    }

    public static class ClientProxy extends CommonProxy {
        private static ModelResourceLocation fluidLocation = new ModelResourceLocation("supermod:" + BlockCookieChocoFluid.name, "fluid");

        @Override
        public void preInit(FMLPreInitializationEvent event, Register register) {
            super.preInit(event, register);
            Item fluid = Item.getItemFromBlock(BlockCookieChocoFluid.instance);
            ModelBakery.addVariantName(fluid);

            ModelLoader.setCustomMeshDefinition(fluid, new ItemMeshDefinition() {
                public ModelResourceLocation getModelLocation(ItemStack stack) {
                    return fluidLocation;
                }
            });
            ModelLoader.setCustomStateMapper(BlockCookieChocoFluid.instance, new StateMapperBase() {
                protected ModelResourceLocation getModelResourceLocation(IBlockState state) {
                    return fluidLocation;
                }
            });
        }
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
