package com.gigavoid.supermod.decorator;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;

import java.util.Random;

/**
 * Created by Rasmus on 2014-11-19.
 */
public class CityDecorator extends SuperDecorator {
    public Block wall, corner, lamp, window, commonTreasure, uncommonTreasure;

    @Override
    public void genDecorations(World p_76728_1_, Random p_76728_2_, int p_76728_3_, int p_76728_4_) {
        clean(p_76728_1_, p_76728_3_, p_76728_4_);
        genTower(p_76728_1_, p_76728_2_, p_76728_3_, p_76728_4_);
        genRoads(p_76728_1_, p_76728_3_, p_76728_4_);
    }

    public void genTower(World p_76728_1_, Random p_76728_2_, int p_76728_3_, int p_76728_4_){
        boolean towerDone = false;
        int height = 40 + p_76728_2_.nextInt(3) * 4;
        for (int i = 70 + height + 4; !towerDone; i--) {
            towerDone = true;
            for (int j = 0; j < 8; j++) {
                for (int k = 0; k < 8; k++) {
                    if (p_76728_1_.getBlock(p_76728_3_ + 4 + j, i, p_76728_4_ + 4 + k) != Blocks.stone) {
                        if ((j == 0 && k == 0) || (j == 0 && k == 7) || (j == 7 && k == 0) || (j == 7 && k == 7)) {
                            if (i < 70 + height + 4)
                                p_76728_1_.setBlock(p_76728_3_ + 4 + j, i, p_76728_4_ + 4 + k, corner);
                            else
                                p_76728_1_.setBlock(p_76728_3_ + 4 + j, i, p_76728_4_ + 4 + k, lamp);
                        }
                        else if ((i - 70) % 4 != 0 && (j == 0 || j == 7 || k == 0 || k == 7)) {
                            if (i < 70 + height) {
                                if (i > 74 && ((k == 0 && (j == 3 || j == 4)) || (k == 7 && (j == 3 || j == 4)) || (j == 0 && (k == 3 || k == 4)) || (j == 7 && (k == 3 || k == 4))))
                                    p_76728_1_.setBlock(p_76728_3_ + 4 + j, i, p_76728_4_ + 4 + k, window);
                                else if (i > 70 && ((k == 0 && (j == 3 || j == 4)) || (k == 7 && (j == 3 || j == 4)) || (j == 0 && (k == 3 || k == 4)) || (j == 7 && (k == 3 || k == 4))))
                                    p_76728_1_.setBlock(p_76728_3_ + 4 + j, i, p_76728_4_ + 4 + k, Blocks.air);
                                else
                                    p_76728_1_.setBlock(p_76728_3_ + 4 + j, i, p_76728_4_ + 4 + k, wall);
                            }
                            else{
                                if (i - 70 - height == 1){
                                    if ((k < 3 || k > 4) && k != 0 && k != 7)
                                        p_76728_1_.setBlock(p_76728_3_ + 4 + j, i, p_76728_4_ + 4 + k, wall);
                                    else if ((j < 3 || j > 4) && j != 0 && j != 7)
                                        p_76728_1_.setBlock(p_76728_3_ + 4 + j, i, p_76728_4_ + 4 + k, wall);
                                }
                                else if (i - 70 - height == 2){
                                    if ((k < 2 || k > 5) && k != 0 && k != 7)
                                        p_76728_1_.setBlock(p_76728_3_ + 4 + j, i, p_76728_4_ + 4 + k, wall);
                                    else if ((j < 2 || j > 5) && j != 0 && j != 7)
                                        p_76728_1_.setBlock(p_76728_3_ + 4 + j, i, p_76728_4_ + 4 + k, wall);
                                }
                            }
                        }
                        else if ((i - 70) % 4 == 0 && i < 70 + height + 4 && i > 66) {
                            if (((j == 5 && k == 6) || (j == 6 && k == 6) || (j == 6 && k == 5)) && i > 70 && i < 70 + height)
                                p_76728_1_.setBlock(p_76728_3_ + 4 + j, i, p_76728_4_ + 4 + k, Blocks.air);
                            else if (j > 2 && j < 5 && k > 2 && k < 5)
                                p_76728_1_.setBlock(p_76728_3_ + 4 + j, i, p_76728_4_ + 4 + k, lamp);
                            else
                                p_76728_1_.setBlock(p_76728_3_ + 4 + j, i, p_76728_4_ + 4 + k, wall);
                        }
                        else if (i > 66 && i < 66 + height - 4) {
                            if ((i - 70) % 4 == 1 && (j == 5 && k == 6))
                                p_76728_1_.setBlock(p_76728_3_ + 4 + j, i, p_76728_4_ + 4 + k, wall);
                            else if ((i - 70) % 4 == 2 && (j == 6 && k == 6))
                                p_76728_1_.setBlock(p_76728_3_ + 4 + j, i, p_76728_4_ + 4 + k, wall);
                            else if ((i - 70) % 4 == 3 && (j == 6 && k == 5))
                                p_76728_1_.setBlock(p_76728_3_ + 4 + j, i, p_76728_4_ + 4 + k, wall);
                            /*else if ((j == 1 && k == 1) || (j == 2 && k == 1) || (j == 1 && k == 2))
                                p_76728_1_.setBlock(p_76728_3_ + 4 + j, i, p_76728_4_ + 4 + k, Blocks.bookshelf);
                            else if ((i - 70) % 4 == 1 && ((j == 6 && k == 1) || (j == 5 && k == 1) || (j == 6 && k == 2)))
                                p_76728_1_.setBlock(p_76728_3_ + 4 + j, i, p_76728_4_ + 4 + k, Blocks.oak_stairs);
                            else if ((i - 70) % 4 == 1 && j == 5 && k == 5) {
                                p_76728_1_.setBlock(p_76728_3_ + 4 + j, i, p_76728_4_ + 4 + k, Blocks.fence);
                                p_76728_1_.setBlock(p_76728_3_ + 4 + j, i + 1, p_76728_4_ + 4 + k, Blocks.wooden_pressure_plate);
                            }
                            else if ((i - 70) % 4 == 1 && (j == 2 && k == 5)) {
                                p_76728_1_.setBlock(p_76728_3_ + 4 + j, i, p_76728_4_ + 4 + k, Blocks.bed, 0, 2);
                                p_76728_1_.setBlock(p_76728_3_ + 4 + j, i, p_76728_4_ + 5 + k, Blocks.bed, 1, 2);
                            }*/
                        }
                        else if (i <= 70) {
                            if (i < 70 && i > 66 && j > 2 && j < 5 && k > 2 && k < 5){
                                if (p_76728_2_.nextInt(75) == 1)
                                    p_76728_1_.setBlock(p_76728_3_ + 4 + j, i, p_76728_4_ + 4 + k, uncommonTreasure);
                                else
                                    p_76728_1_.setBlock(p_76728_3_ + 4 + j, i, p_76728_4_ + 4 + k, commonTreasure);
                            }
                            else
                                p_76728_1_.setBlock(p_76728_3_ + 4 + j, i, p_76728_4_ + 4 + k, wall);
                        }
                        else
                            p_76728_1_.setBlock(p_76728_3_ + 4 + j, i, p_76728_4_ + 4 + k, Blocks.air);
                        towerDone = false;
                    }
                }
            }
        }
    }

    public void genRoads(World p_76728_1_, int p_76728_2_, int p_76728_3_){
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 16; j++) {
                if (i == 1 || i == 2 || i == 14 || i == 13 || j == 1 || j == 2 || j == 14 || j == 13)
                    p_76728_1_.setBlock(p_76728_2_ + i, 70, p_76728_3_ + j, wall);
                else if (i == 7 || i == 8 || j == 7 || j == 8)
                    p_76728_1_.setBlock(p_76728_2_ + i, 70, p_76728_3_ + j, wall);
                if (i == 5 || i == 10 || j == 5 || j == 10)
                    p_76728_1_.setBlock(p_76728_2_ + i, 69, p_76728_3_ + j, wall);
            }
        }
    }

    public void clean(World p_76728_1_, int p_76728_2_, int p_76728_3_){
        boolean cleaningDone = false;
        for (int i = 71; !cleaningDone; i++){
            cleaningDone = true;
            for (int j = 0; j < 16; j++){
                for (int k = 0; k < 16; k++) {
                    if (p_76728_1_.getBlock(p_76728_2_ + j, i, p_76728_3_ + k) != Blocks.air){
                        p_76728_1_.setBlock(p_76728_2_ + j, i, p_76728_3_ + k, Blocks.air);
                        cleaningDone = false;
                    }
                }
            }
        }
    }
}
