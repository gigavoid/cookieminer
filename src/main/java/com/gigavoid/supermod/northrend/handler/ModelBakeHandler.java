package com.gigavoid.supermod.northrend.handler;

import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.ArrayList;
import java.util.List;

public class ModelBakeHandler
{
    public static List<String> fluidsToTextureStitch = new ArrayList<String>();

    @SubscribeEvent
    public void onTextureStitch(TextureStitchEvent.Pre event)
    {
        TextureMap map = event.map;

        for (String name : fluidsToTextureStitch)
        {
            Fluid fluid = FluidRegistry.getFluid(name);
            if (fluid == null)
            {
                System.out.println("No fluid found with name " + name);
            }
            else
            {
                fluid.setIcons(map.getAtlasSprite("supermod:blocks/" + name + "_still"), map.getAtlasSprite("supermod:blocks/" + name + "_flow"));
            }
        }
    }

    @SubscribeEvent
    public void onTextureStitch(TextureStitchEvent.Post event)
    {
        TextureMap map = event.map;
    }
}