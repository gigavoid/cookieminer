package com.gigavoid.supermod.cookiecraft;

import com.gigavoid.supermod.common.RegistrationHandler;
import com.gigavoid.supermod.common.module.Module;
import com.gigavoid.supermod.cookiecraft.biome.CookieBiome;
import com.gigavoid.supermod.cookiecraft.block.BlockCookieChocoFluid;
import com.gigavoid.supermod.cookiecraft.block.CookiecraftBlocks;
import com.gigavoid.supermod.cookiecraft.entity.CookieEntities;
import com.gigavoid.supermod.cookiecraft.fluids.FluidChoco;
import com.gigavoid.supermod.cookiecraft.gui.CookiecraftGuis;
import com.gigavoid.supermod.cookiecraft.handler.BucketHandler;
import com.gigavoid.supermod.cookiecraft.recipe.CookiecraftRecipes;
import com.gigavoid.supermod.cookiecraft.item.CookiecraftItems;
import com.gigavoid.supermod.cookiecraft.renderer.CookieRenderers;
import com.gigavoid.supermod.cookiecraft.renderer.RenderSlimeCompressor;
import com.gigavoid.supermod.cookiecraft.tileentity.CookiecraftTileEntities;
import com.gigavoid.supermod.cookiecraft.tileentity.TileEntitySlimeCompressor;
import com.gigavoid.supermod.cookiecraft.worldgen.CookiecraftWorldGenOre;
import com.gigavoid.supermod.cookiecraft.worldgen.CookiecraftWorldGens;
import com.gigavoid.supermod.cookiecraft.worldgen.CookiecraftWorldProvider;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModuleCookiecraft extends Module{
    @SidedProxy(serverSide = "com.gigavoid.supermod.cookiecraft.ModuleCookiecraft$CommonProxy", clientSide = "com.gigavoid.supermod.cookiecraft.ModuleCookiecraft$ClientProxy")
    public static CommonProxy proxy;

    public static int dimensionId;
    public static CookieBiome cookieBiome;
    public static CookieConfiguration config;

    public void preInit(FMLPreInitializationEvent event) {
        //proxy.preInit(event, getRegister(event.getSide()));
    }

    public static class CommonProxy
    {
        public void registerItemRenderer(Item item, int meta, String id) { }

        public void preInit(FMLPreInitializationEvent event, RegistrationHandler register)
        {
            MinecraftForge.EVENT_BUS.register(BucketHandler.instance);

            FluidRegistry.registerFluid(FluidChoco.instance);
            //GameRegistry.registerBlock(BlockCookieChocoFluid.instance, BlockCookieChocoFluid.name);
            CookieEntities.registerEntities(register);

            //cookieBiome = new CookieBiome(register.getNextBiomeID(), 10);
            //BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeManager.BiomeEntry(cookieBiome, 0)); // Probabli inheritence of cookiebiome

            //dimensionId = register.registerDimension(CookiecraftWorldProvider.class, false);

            config = new CookieConfiguration(event.getSuggestedConfigurationFile());
            config.load();
        }
    }

    public static class ClientProxy extends CommonProxy {
        private static ModelResourceLocation fluidLocation = new ModelResourceLocation("supermod:" + BlockCookieChocoFluid.name, "fluid");

        @Override
        public void registerItemRenderer(Item item, int meta, String id) {
            ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(id));
        }

        @Override
        public void preInit(FMLPreInitializationEvent event, RegistrationHandler register) {
            super.preInit(event, register);
            GameRegistry.registerWorldGenerator(new CookiecraftWorldGenOre(), 3);

            Item fluid = Item.getItemFromBlock(BlockCookieChocoFluid.instance);
            ModelBakery.registerItemVariants(fluid);

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
        CookiecraftTileEntities.registerTileEntities();
        CookiecraftGuis.initializeGuis();
        CookiecraftRecipes.initializeRecipes();
        //CookiecraftWorldGens.initializeWorldGens(getRegister(e.getSide()));

        if (FMLCommonHandler.instance().getSide() == Side.CLIENT) {
            CookieRenderers.registerRenderers();
        }

        // BucketHandler.instance.buckets.put(BlockCookieChocoFluid.instance, CookiecraftItems.cookieChocoBucket);
        // FluidContainerRegistry.registerFluidContainer(FluidChoco.instance, new ItemStack(CookiecraftItems.cookieChocoBucket), new ItemStack(Items.bucket));
        FluidRegistry.addBucketForFluid(FluidChoco.instance);

        if (e.getSide() == Side.CLIENT){
            registerTileEntity();
        }
    }

    @SideOnly(Side.CLIENT)
    private void registerTileEntity() {
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySlimeCompressor.class, new RenderSlimeCompressor());
    }
}
