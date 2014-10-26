package com.gigavoid.supermod.progpick;

public class ProgPickUpgrade {

    public String name;
    public int reqLevel;

    public ProgPickUpgrade(String name) {
        this(name, 1);
    }

    public ProgPickUpgrade(String name, int reqLevel) {
        this.name = name;

        this.reqLevel = reqLevel;
    }
}
