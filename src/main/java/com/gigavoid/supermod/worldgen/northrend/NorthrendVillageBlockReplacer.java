package com.gigavoid.supermod.worldgen.northrend;

import com.gigavoid.supermod.block.SuperBlocks;
import cpw.mods.fml.common.eventhandler.Event;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.init.Blocks;
import net.minecraftforge.event.terraingen.BiomeEvent;

public class NorthrendVillageBlockReplacer {

    @SubscribeEvent
    public void event(BiomeEvent.GetVillageBlockID event){
        if (WorldChunkManagerNorthrend.allowedBiomes.indexOf(event.biome) != -1){
            event.setResult(Event.Result.DENY);
            if (event.original == Blocks.log || event.original == Blocks.log2) {
                event.replacement = SuperBlocks.northLog;
            }
            else if (event.original == Blocks.cobblestone) {
                event.replacement = SuperBlocks.northCobble;
            }
            else if (event.original == Blocks.planks) {
                event.replacement = SuperBlocks.northPlanks;
            }
            else if (event.original == Blocks.oak_stairs) {
                event.replacement = SuperBlocks.northStairs;
            }
            else if (event.original == Blocks.stone_stairs) {
                event.replacement = SuperBlocks.northCobbleStairs;
            }
            else if (event.original == Blocks.water) {
                event.replacement = Blocks.ice;
            }
            else if (event.original == Blocks.fence) {
                event.replacement = SuperBlocks.northFence;
            }
            else if (event.original == Blocks.gravel || event.original == Blocks.farmland) {
                event.replacement = SuperBlocks.northDirt;
            }
            else if (event.original == Blocks.dirt || event.original == Blocks.sand){
                event.replacement = Blocks.snow;
            }
            else if (event.original == Blocks.wheat || event.original == Blocks.potatoes || event.original == Blocks.carrots){
                event.replacement = SuperBlocks.northGlaciemPlant;
            }
            else
                event.setResult(Event.Result.ALLOW);
        }
    }
}
