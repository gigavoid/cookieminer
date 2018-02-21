package com.gigavoid.supermod.common;

import com.gigavoid.supermod.cookiecraft.block.CookiecraftBlocks;
import com.gigavoid.supermod.cookiecraft.item.CookiecraftItems;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber
public class RegistrationHandler {
    private int nextDimensionId = 2;
    private int nextBiomeId = 40;
	private Side side;

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        CookiecraftItems.register(event.getRegistry());
        CookiecraftBlocks.registerItemBlocks(event.getRegistry());
    }

    @SubscribeEvent
    public static void registerItems(ModelRegistryEvent event) {
        CookiecraftItems.registerModels();
        CookiecraftBlocks.registerModels();
    }

    @SubscribeEvent
    public void registerBlocks(RegistryEvent.Register<Block> event) {
        CookiecraftBlocks.register(event.getRegistry());
    }

    // Old bullshit
    /* public int registerDimension(Class<? extends WorldProvider> provider, boolean keepLoaded){
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

	public void setSide(Side side) {
		this.side = side;
	}*/
}
