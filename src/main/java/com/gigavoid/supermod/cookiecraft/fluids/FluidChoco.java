package com.gigavoid.supermod.cookiecraft.fluids;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;

public class FluidChoco extends Fluid {

    public static final String name = "choco_fluid";
    public static final FluidChoco instance = new FluidChoco();

    private FluidChoco()
    {
        super(name, new ResourceLocation("supermod:blocks/choco_fluid_still"), new ResourceLocation("supermod:blocks/choco_fluid_flow"));
    }
}

