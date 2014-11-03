package com.gigavoid.supermod.worldgen.trees;

/**
 * Created by Rasmus on 2014-11-03.
 */
public class SuperWorldGenNorthrendTree {
    private boolean northTreeHead[] = new boolean[5 * 5];

    private void setNorthTreeHead(){
        northTreeHead[1] = northTreeHead[23] = true;
        northTreeHead[2] = northTreeHead[22] = true;
        northTreeHead[3] = northTreeHead[21] = true;

        for(int i = 5; i < 20; i++){
            northTreeHead[i] = true;
        }
    }
}
