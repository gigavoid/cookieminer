package com.gigavoid.supermod.cookiecraft.block;

import com.gigavoid.supermod.cookiecraft.ModuleCookiecraft;
import com.gigavoid.supermod.cookiecraft.creativetab.CookiecraftCreativeTabs;
import com.gigavoid.supermod.cookiecraft.teleporter.Teleporter;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBreakable;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemMonsterPlacer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Random;

public class BlockCookiePortalCookiecraft extends BlockBreakable {
    public static final PropertyEnum AXIS = PropertyEnum.create("axis", EnumFacing.Axis.class, new EnumFacing.Axis[] {EnumFacing.Axis.X, EnumFacing.Axis.Z});

    public static final BlockCookiePortalCookiecraft instance = new BlockCookiePortalCookiecraft();

    private BlockCookiePortalCookiecraft() {
        super(Material.PORTAL, false);
        this.setCreativeTab(CookiecraftCreativeTabs.tabCookiecraft);
        this.setLightLevel(.75f);
        this.setHardness(-1);
        this.setTickRandomly(true);
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return Item.getItemFromBlock(this);
    }

    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
        super.updateTick(worldIn, pos, state, rand);

        if (worldIn.provider.isSurfaceWorld() && worldIn.getGameRules().getBoolean("doMobSpawning") && rand.nextInt(2000) < worldIn.getDifficulty().getDifficultyId()) {
            int i = pos.getY();
            BlockPos blockpos1;


            for (blockpos1 = pos; !World.doesBlockHaveSolidTopSurface(worldIn, blockpos1) && blockpos1.getY() > 0; blockpos1 = blockpos1.offset(EnumFacing.DOWN)) {
                ;
            }

            if (i > 0 && !worldIn.getBlockState(blockpos1.offset(EnumFacing.UP)).getBlock().isNormalCube(worldIn.getBlockState(pos))) {
                Entity entity = ItemMonsterPlacer.spawnCreature(worldIn, 57, (double) blockpos1.getX() + 0.5D, (double) blockpos1.getY() + 1.1D, (double) blockpos1.getZ() + 0.5D);

                if (entity != null) {
                    entity.timeUntilPortal = entity.getPortalCooldown();
                }
            }
        }
    }

    @Override
    public AxisAlignedBB getCollisionBoundingBox(World worldIn, BlockPos pos, IBlockState state) {
        return null;
    }

    public void setBlockBoundsBasedOnState(IBlockAccess access, BlockPos pos) {
        EnumFacing.Axis axis = (EnumFacing.Axis) access.getBlockState(pos).getValue(AXIS);
        float f = 0.125F;
        float f1 = 0.125F;

        if (axis == EnumFacing.Axis.X) {
            f = 0.5F;
        }

        if (axis == EnumFacing.Axis.Z) {
            f1 = 0.5F;
        }

        this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f1, 0.5F + f, 1.0F, 0.5F + f1);
    }

    public static int func_176549_a(EnumFacing.Axis p_176549_0_) {
        return p_176549_0_ == EnumFacing.Axis.X ? 1 : (p_176549_0_ == EnumFacing.Axis.Z ? 2 : 0);
    }

    public boolean isFullCube(IBlockState state) {
        return false;
    }

    public boolean func_176548_d(World worldIn, BlockPos p_176548_2_) {
        Size size = new Size(worldIn, p_176548_2_, EnumFacing.Axis.X);

        if (size.func_150860_b() && size.field_150864_e == 0) {
            size.func_150859_c();
            return true;
        } else {
            Size size1 = new Size(worldIn, p_176548_2_, EnumFacing.Axis.Z);

            if (size1.func_150860_b() && size1.field_150864_e == 0) {
                size1.func_150859_c();
                return true;
            } else {
                return false;
            }
        }
    }

    public void onNeighborBlockChange(World worldIn, BlockPos pos, IBlockState state, Block neighborBlock) {
        EnumFacing.Axis axis = (EnumFacing.Axis) state.getValue(AXIS);
        Size size;

        if (axis == EnumFacing.Axis.X) {
            size = new Size(worldIn, pos, EnumFacing.Axis.X);

            if (!size.func_150860_b() || size.field_150864_e < size.field_150868_h * size.field_150862_g) {
                worldIn.setBlockState(pos, Blocks.AIR.getDefaultState());
            }
        } else if (axis == EnumFacing.Axis.Z) {
            size = new Size(worldIn, pos, EnumFacing.Axis.Z);

            if (!size.func_150860_b() || size.field_150864_e < size.field_150868_h * size.field_150862_g) {
                worldIn.setBlockState(pos, Blocks.AIR.getDefaultState());
            }
        }
    }

    @SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(IBlockAccess worldIn, BlockPos pos, EnumFacing side) {
        EnumFacing.Axis axis = null;
        IBlockState iblockstate = worldIn.getBlockState(pos);

        if (worldIn.getBlockState(pos).getBlock() == this) {
            axis = (EnumFacing.Axis) iblockstate.getValue(AXIS);

            if (axis == null) {
                return false;
            }

            if (axis == EnumFacing.Axis.Z && side != EnumFacing.EAST && side != EnumFacing.WEST) {
                return false;
            }

            if (axis == EnumFacing.Axis.X && side != EnumFacing.SOUTH && side != EnumFacing.NORTH) {
                return false;
            }
        }

        boolean flag = worldIn.getBlockState(pos.offset(EnumFacing.WEST)).getBlock() == this && worldIn.getBlockState(pos.offset(EnumFacing.WEST, 2)).getBlock() != this;
        boolean flag1 = worldIn.getBlockState(pos.offset(EnumFacing.EAST)).getBlock() == this && worldIn.getBlockState(pos.offset(EnumFacing.EAST, 2)).getBlock() != this;
        boolean flag2 = worldIn.getBlockState(pos.offset(EnumFacing.NORTH)).getBlock() == this && worldIn.getBlockState(pos.offset(EnumFacing.NORTH, 2)).getBlock() != this;
        boolean flag3 = worldIn.getBlockState(pos.offset(EnumFacing.SOUTH)).getBlock() == this && worldIn.getBlockState(pos.offset(EnumFacing.SOUTH, 2)).getBlock() != this;
        boolean flag4 = flag || flag1 || axis == EnumFacing.Axis.X;
        boolean flag5 = flag2 || flag3 || axis == EnumFacing.Axis.Z;
        return flag4 && side == EnumFacing.WEST ? true : (flag4 && side == EnumFacing.EAST ? true : (flag5 && side == EnumFacing.NORTH ? true : flag5 && side == EnumFacing.SOUTH));
    }

    //Returns the quantity of items to drop on block destruction.
    public int quantityDropped(Random random) {
        return 0;
    }

    @Override
    public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn) {
       // public void onEntityCollidedWithBlock(World par1World, int par2, int par3, int par4, Entity par5Entity) {
            if ((entityIn.isRiding()) && (entityIn.isBeingRidden()) && ((entityIn instanceof EntityPlayerMP))) {
                EntityPlayerMP player = (EntityPlayerMP) entityIn;

                MinecraftServer mServer = MinecraftServer.getServer();

                if (player.timeUntilPortal > 0) {
                    player.timeUntilPortal = 10;
                } else if (player.dimension != ModuleCookiecraft.dimensionId) {
                    player.timeUntilPortal = 10;

                    player.mcServer.getConfigurationManager().transferPlayerToDimension(player, ModuleCookiecraft.dimensionId, new Teleporter(mServer.worldServerForDimension(ModuleCookiecraft.dimensionId)));
                } else {
                    player.timeUntilPortal = 10;
                    player.mcServer.getConfigurationManager().transferPlayerToDimension(player, 0, new Teleporter(mServer.worldServerForDimension(0)));
                }
            }
    }

    //Convert the given metadata into a BlockState for this Block
    public IBlockState getStateFromMeta(int meta) {
        return this.getDefaultState().withProperty(AXIS, (meta & 3) == 2 ? EnumFacing.Axis.Z : EnumFacing.Axis.X);
    }

    @SideOnly(Side.CLIENT)
    public EnumWorldBlockLayer getBlockLayer() {
        return EnumWorldBlockLayer.TRANSLUCENT;
    }

    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
        if (rand.nextInt(100) == 0) {
            worldIn.playSound((double) pos.getX() + 0.5D, (double) pos.getY() + 0.5D, (double) pos.getZ() + 0.5D, "portal.portal", 0.5F, rand.nextFloat() * 0.4F + 0.8F, false);
        }

        for (int i = 0; i < 4; ++i) {
            double d0 = (double) ((float) pos.getX() + rand.nextFloat());
            double d1 = (double) ((float) pos.getY() + rand.nextFloat());
            double d2 = (double) ((float) pos.getZ() + rand.nextFloat());
            double d3 = ((double) rand.nextFloat() - 0.5D) * 0.1D;
            double d4 = ((double) rand.nextFloat() - 0.5D) * 0.1D;
            double d5 = ((double) rand.nextFloat() - 0.5D) * 0.1D;
            int j = rand.nextInt(2) * 2 - 1;

            if (worldIn.getBlockState(pos.offset(EnumFacing.WEST)).getBlock() != this && worldIn.getBlockState(pos.offset(EnumFacing.EAST)).getBlock() != this) {
                d0 = (double) pos.getX() + 0.5D + 0.25D * (double) j;
            } else {
                d2 = (double) pos.getZ() + 0.5D + 0.25D * (double) j;
            }

            //worldIn.spawnParticle(EnumParticleTypes.SNOW_SHOVEL, d0, d1, d2, d3, d4, d5);
        }
    }

    //Convert the BlockState into the correct metadata value
    public int getMetaFromState(IBlockState state) {
        return func_176549_a((EnumFacing.Axis) state.getValue(AXIS));
    }

    @SideOnly(Side.CLIENT)
    public Item getItem(World worldIn, BlockPos pos) {
        return null;
    }

    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer (this, AXIS);
    }

    public static class Size {
        private final World field_150867_a;
        private final EnumFacing.Axis field_150865_b;
        private final EnumFacing field_150866_c;
        private final EnumFacing field_150863_d;
        private int field_150864_e = 0;
        private BlockPos field_150861_f;
        private int field_150862_g;
        private int field_150868_h;
        private static final String __OBFID = "CL_00000285";

        public Size(World worldIn, BlockPos p_i45694_2_, EnumFacing.Axis p_i45694_3_) {
            this.field_150867_a = worldIn;
            this.field_150865_b = p_i45694_3_;

            if (p_i45694_3_ == EnumFacing.Axis.X) {
                this.field_150863_d = EnumFacing.EAST;
                this.field_150866_c = EnumFacing.WEST;
            } else {
                this.field_150863_d = EnumFacing.NORTH;
                this.field_150866_c = EnumFacing.SOUTH;
            }

            for (BlockPos blockpos1 = p_i45694_2_; p_i45694_2_.getY() > blockpos1.getY() - 21 && p_i45694_2_.getY() > 0 && this.func_150857_a(worldIn.getBlockState(p_i45694_2_.offset(EnumFacing.DOWN)).getBlock()); p_i45694_2_ = p_i45694_2_.offset(EnumFacing.DOWN)) {
                ;
            }

            int i = this.func_180120_a(p_i45694_2_, this.field_150863_d) - 1;

            if (i >= 0) {
                this.field_150861_f = p_i45694_2_.offset(this.field_150863_d, i);
                this.field_150868_h = this.func_180120_a(this.field_150861_f, this.field_150866_c);

                if (this.field_150868_h < 2 || this.field_150868_h > 21) {
                    this.field_150861_f = null;
                    this.field_150868_h = 0;
                }
            }

            if (this.field_150861_f != null) {
                this.field_150862_g = this.func_150858_a();
            }
        }

        protected int func_180120_a(BlockPos p_180120_1_, EnumFacing p_180120_2_) {
            int i;

            for (i = 0; i < 22; ++i) {
                BlockPos blockpos1 = p_180120_1_.offset(p_180120_2_, i);

                if (!this.func_150857_a(this.field_150867_a.getBlockState(blockpos1).getBlock()) || this.field_150867_a.getBlockState(blockpos1.offset(EnumFacing.DOWN)).getBlock() != BlockCookieBlock.instance) {
                    break;
                }
            }

            Block block = this.field_150867_a.getBlockState(p_180120_1_.offset(p_180120_2_, i)).getBlock();
            return block == BlockCookieBlock.instance ? i : 0;
        }

        protected int func_150858_a() {
            int i;
            label56:

            for (this.field_150862_g = 0; this.field_150862_g < 21; ++this.field_150862_g) {
                for (i = 0; i < this.field_150868_h; ++i) {
                    BlockPos blockpos = this.field_150861_f.offset(this.field_150866_c, i).offset(EnumFacing.UP, this.field_150862_g);
                    Block block = this.field_150867_a.getBlockState(blockpos).getBlock();

                    if (!this.func_150857_a(block)) {
                        break label56;
                    }

                    if (block == instance) {
                        ++this.field_150864_e;
                    }

                    if (i == 0) {
                        block = this.field_150867_a.getBlockState(blockpos.offset(this.field_150863_d)).getBlock();

                        if (block != BlockCookieBlock.instance) {
                            break label56;
                        }
                    } else if (i == this.field_150868_h - 1) {
                        block = this.field_150867_a.getBlockState(blockpos.offset(this.field_150866_c)).getBlock();

                        if (block != BlockCookieBlock.instance) {
                            break label56;
                        }
                    }
                }
            }

            for (i = 0; i < this.field_150868_h; ++i) {
                if (this.field_150867_a.getBlockState(this.field_150861_f.offset(this.field_150866_c, i).offset(EnumFacing.UP, this.field_150862_g)).getBlock() != BlockCookieBlock.instance) {
                    this.field_150862_g = 0;
                    break;
                }
            }

            if (this.field_150862_g <= 21 && this.field_150862_g >= 3) {
                return this.field_150862_g;
            } else {
                this.field_150861_f = null;
                this.field_150868_h = 0;
                this.field_150862_g = 0;
                return 0;
            }
        }

        protected boolean func_150857_a(Block p_150857_1_) {
            Material material = p_150857_1_.getMaterial(p_150857_1_.getDefaultState());
            return material == Material.AIR || p_150857_1_ == instance;
        }

        public boolean func_150860_b() {
            return this.field_150861_f != null && this.field_150868_h >= 2 && this.field_150868_h <= 21 && this.field_150862_g >= 3 && this.field_150862_g <= 21;
        }

        public void func_150859_c() {
            for (int i = 0; i < this.field_150868_h; ++i) {
                BlockPos blockpos = this.field_150861_f.offset(this.field_150866_c, i);

                for (int j = 0; j < this.field_150862_g; ++j) {
                    this.field_150867_a.setBlockState(blockpos.offset(EnumFacing.UP, j), instance.getDefaultState().withProperty(BlockCookiePortalCookiecraft.AXIS, this.field_150865_b), 2);
                }
            }
        }
    }
}