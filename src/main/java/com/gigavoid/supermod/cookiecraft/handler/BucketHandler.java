package com.gigavoid.supermod.cookiecraft.handler;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.FillBucketEvent;
import net.minecraftforge.fml.common.eventhandler.Event;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.HashMap;
import java.util.Map;

public class BucketHandler {
    public static BucketHandler instance = new BucketHandler();
    public Map<Block, Item> buckets = new HashMap<Block, Item>();

    private BucketHandler(){}

    @SubscribeEvent
    public void onBucketFill(FillBucketEvent e) {
        ItemStack result = fillCustomBucket(e.getWorld(), e.getTarget());

        if (result == null)
            return;


        e.setFilledBucket(result);
        e.setResult(Event.Result.ALLOW);
    }

    private ItemStack fillCustomBucket(World world, RayTraceResult pos){
        Block block = world.getBlockState(pos.getBlockPos()).getBlock();

        Item bucket = buckets.get(block);
        if (bucket != null && world.getBlockState(pos.getBlockPos()).getBlock().getMetaFromState(world.getBlockState(pos.getBlockPos())) == 0){
            world.setBlockToAir(pos.getBlockPos());
            return new ItemStack(bucket);
        }
        return null;
    }
}
