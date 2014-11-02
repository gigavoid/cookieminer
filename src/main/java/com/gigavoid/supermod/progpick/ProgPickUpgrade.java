package com.gigavoid.supermod.progpick;

public class ProgPickUpgrade {
    public String name;
    public int reqLevel;
    public int maxLevel;

    public String getDisplayLevel(int level) {
        if(name == "Harvest Level") {
            switch(level){
                case 0:
                    return "Coal";
                case 1:
                    return "Iron";
                case 2:
                    return "Diamond";
                case 3:
                    return "Obidian";
                case 4:
                    return "Over Powered";
            }
        }

        return Integer.toString(level);
    }

    public ProgPickUpgrade(String name) {
        this(name, 1);
    }

    public ProgPickUpgrade(String name, int reqLevel) {
        this(name ,reqLevel, -1);
    }

    public ProgPickUpgrade(String name, int reqLevel, int maxLevel) {
        this.name = name;
        this.reqLevel = reqLevel;
        this.maxLevel = maxLevel;
    }
}
