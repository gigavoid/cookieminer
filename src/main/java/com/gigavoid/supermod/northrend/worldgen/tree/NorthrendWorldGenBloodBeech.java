package com.gigavoid.supermod.northrend.worldgen.tree;

import com.gigavoid.supermod.northrend.block.NorthrendBlocks;
import net.minecraft.block.BlockLog;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

import java.util.Random;

public class NorthrendWorldGenBloodBeech extends WorldGenAbstractTree {
    public static final PropertyEnum AXIS_PROP = PropertyEnum.create("axis", BlockLog.EnumAxis.class);
    private int branches;

    public NorthrendWorldGenBloodBeech(boolean b, int branches){
        super(b);
        this.branches = branches;
    }

    @Override
    public boolean generate(World p_76484_1_, Random p_76484_2_, BlockPos p_76484_3) {
        BlockPos pos = p_76484_3.offset(EnumFacing.DOWN, 2);
        generateGround(p_76484_1_, pos);
        generateStem(p_76484_1_, p_76484_2_, pos);
        for (int i = 0; i < branches; i++){
            generateBranch(p_76484_1_, p_76484_2_, pos);
        }

        return true;
    }

    private void generateGround(World world, BlockPos pos){
        for (int y = 0; y > -6; y--){
            for (int x = -5; x < 6; x++){
                for (int z = -5; z < 6; z++){
                    if (y == 0 && x > -4 && x < 4 && z > -4 && z < 4){
                        if (x == 0 || z == 0){
                            if (world.getBlockState(pos.add(x, y + 1, z)) != Blocks.air.getDefaultState() &&
                                    world.getBlockState(pos.add(x, y, z)) == Blocks.snow.getDefaultState()) {
                                world.setBlockState(pos.add(x, y, z), NorthrendBlocks.northDirt.getDefaultState());
                            }
                        }
                        else if (x > -3 && x < 3 && z > -2 && z < 2){
                            if (world.getBlockState(pos.add(x, y + 1, z)) != Blocks.air.getDefaultState() &&
                                    world.getBlockState(pos.add(x, y, z)) == Blocks.snow.getDefaultState()) {
                                world.setBlockState(pos.add(x, y, z), NorthrendBlocks.northDirt.getDefaultState());
                            }
                        }
                        else if (x > -2 && x < 2 && z > -3 && z < 3){
                            if (world.getBlockState(pos.add(x, y + 1, z)) != Blocks.air.getDefaultState() &&
                                    world.getBlockState(pos.add(x, y, z)) == Blocks.snow.getDefaultState()) {
                                world.setBlockState(pos.add(x, y, z), NorthrendBlocks.northDirt.getDefaultState());
                            }                        }
                    }
                    else if (y == -1 && x > -5 && x < 5 && z > -5 && z < 5){
                        if (x > -2 && x < 2){
                            if (world.getBlockState(pos.add(x, y + 1, z)) != Blocks.air.getDefaultState() &&
                                    world.getBlockState(pos.add(x, y, z)) == Blocks.snow.getDefaultState()) {
                                world.setBlockState(pos.add(x, y, z), NorthrendBlocks.northDirt.getDefaultState());
                            }
                        }
                        else if (z > -2 && z < 2){
                            if (world.getBlockState(pos.add(x, y + 1, z)) != Blocks.air.getDefaultState() &&
                                    world.getBlockState(pos.add(x, y, z)) == Blocks.snow.getDefaultState()) {
                                world.setBlockState(pos.add(x, y, z), NorthrendBlocks.northDirt.getDefaultState());
                            }
                        }
                        else if (x > -4 && x < 4 && z > -3 && z < 3){
                            if (world.getBlockState(pos.add(x, y + 1, z)) != Blocks.air.getDefaultState() &&
                                    world.getBlockState(pos.add(x, y, z)) == Blocks.snow.getDefaultState()) {
                                world.setBlockState(pos.add(x, y, z), NorthrendBlocks.northDirt.getDefaultState());
                            }
                        }
                        else if (x > -3 && x < 3 && z > -4 && z < 4){
                            if (world.getBlockState(pos.add(x, y + 1, z)) != Blocks.air.getDefaultState() &&
                                    world.getBlockState(pos.add(x, y, z)) == Blocks.snow.getDefaultState()) {
                                world.setBlockState(pos.add(x, y, z), NorthrendBlocks.northDirt.getDefaultState());
                            }
                        }
                    }
                    else if (y < -1){
                        if (x > -2 && x < 2){
                            if (world.getBlockState(pos.add(x, y + 1, z)) != Blocks.air.getDefaultState() &&
                                    world.getBlockState(pos.add(x, y, z)) == Blocks.snow.getDefaultState()) {
                                world.setBlockState(pos.add(x, y, z), NorthrendBlocks.northDirt.getDefaultState());
                            }
                        }
                        else if (z > -2 && z < 2){
                            if (world.getBlockState(pos.add(x, y + 1, z)) != Blocks.air.getDefaultState() &&
                                    world.getBlockState(pos.add(x, y, z)) == Blocks.snow.getDefaultState()) {
                                world.setBlockState(pos.add(x, y, z), NorthrendBlocks.northDirt.getDefaultState());
                            }
                        }
                        else if (x > -5 && x < 5 && z > -4 && z < 4){
                            if (world.getBlockState(pos.add(x, y + 1, z)) != Blocks.air.getDefaultState() &&
                                    world.getBlockState(pos.add(x, y, z)) == Blocks.snow.getDefaultState()) {
                                world.setBlockState(pos.add(x, y, z), NorthrendBlocks.northDirt.getDefaultState());
                            }
                        }
                        else if (x > -4 && x < 4 && z > -5 && z < 5){
                            if (world.getBlockState(pos.add(x, y + 1, z)) != Blocks.air.getDefaultState() &&
                                    world.getBlockState(pos.add(x, y, z)) == Blocks.snow.getDefaultState()) {
                                world.setBlockState(pos.add(x, y, z), NorthrendBlocks.northDirt.getDefaultState());
                            }
                        }
                    }
                }
            }
        }
    }

    private void generateStem(World world, Random random, BlockPos pos){
        int height = random.nextInt(4) + 6;
        for (int y = -1; y < height; y++){
            for (int x = -1; x < 2; x++){
                for (int z = -1; z < 2; z++){
                    world.setBlockState(pos.add(x, y, z), NorthrendBlocks.northBloodBeechLog.getDefaultState().withProperty(AXIS_PROP, BlockLog.EnumAxis.func_176870_a(EnumFacing.Axis.Y)));
                }
            }
        }
    }

    private void generateBranch(World world, Random random, BlockPos pos){
        Vec3 from = new Vec3(random.nextInt(3) - 1, random.nextInt(2) + 6, random.nextInt(3) - 1);
        Vec3 to = new Vec3(from.xCoord * random.nextInt(3) + 2, from.yCoord + random.nextInt(2) + 1, from.zCoord * random.nextInt(3) + 2);
        int distance = (int)from.distanceTo(to);
        Vec3 line = new Vec3(to.xCoord - from.xCoord, to.yCoord - from.yCoord, to.zCoord - from.zCoord);
        line.normalize();
        for (int i = 0; i < distance; i++){
            line.add(line);
            BlockPos logPos = new BlockPos(line);
            logPos.add(0, 7, 0);
            world.setBlockState(pos.add(logPos), NorthrendBlocks.northBloodBeechLog.getDefaultState().withProperty(AXIS_PROP, BlockLog.EnumAxis.func_176870_a(EnumFacing.Axis.Y)));
        }
    }
}
