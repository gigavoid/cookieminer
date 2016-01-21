package com.gigavoid.supermod.cookiecraft.block;

        import com.gigavoid.supermod.cookiecraft.creativetab.CookiecraftCreativeTabs;
        import com.gigavoid.supermod.cookiecraft.fluids.FluidChoco;
        import net.minecraft.block.material.Material;
        import net.minecraft.util.BlockPos;
        import net.minecraft.world.IBlockAccess;
        import net.minecraft.world.World;
        import net.minecraftforge.fluids.BlockFluidClassic;

public class BlockCookieChocoFluid extends BlockFluidClassic {
    public static final BlockCookieChocoFluid instance = new BlockCookieChocoFluid();
    public static final String name = "block_fluid_choco";

    private BlockCookieChocoFluid(){
        super(FluidChoco.instance, Material.water);
        setCreativeTab(CookiecraftCreativeTabs.tabCookiecraft);
    }

    @Override
    public boolean canDisplace(IBlockAccess world, BlockPos pos) {
        return !world.getBlockState(pos).getBlock().getMaterial().isLiquid() && super.canDisplace(world, pos);
    }

    @Override
    public boolean displaceIfPossible(World world, BlockPos pos) {
        return !world.getBlockState(pos).getBlock().getMaterial().isLiquid() && super.displaceIfPossible(world, pos);
    }

    @Override
    public int getRenderType() {
        return 3;
    }

    @Override
    protected void flowIntoBlock(World world, BlockPos pos, int meta)
    {
        if (meta < 0) return;
        if (displaceIfPossible(world, pos))
        {
            world.setBlockState(pos, this.getBlockState().getBaseState().withProperty(LEVEL, meta), 3);
        }
    }
}
