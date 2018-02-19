package com.gigavoid.supermod.cookiecraft.worldgen;

import com.gigavoid.supermod.cookiecraft.ModuleCookiecraft;
import net.minecraft.world.DimensionType;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;

public class CookiecraftWorldProvider extends WorldProvider {
    @Override
    public DimensionType getDimensionType() {
        return ModDimensions.cookieverseDimensionType;
    }

    @Override
    public IChunkGenerator createChunkGenerator() {
        return new CookieverseChunkGenerator(world);
    }
}
