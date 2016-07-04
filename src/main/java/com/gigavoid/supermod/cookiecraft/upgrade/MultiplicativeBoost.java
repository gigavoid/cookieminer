package com.gigavoid.supermod.cookiecraft.upgrade;

public class MultiplicativeBoost {
    private String key;
    private double boost;

    public MultiplicativeBoost(String key, double boost) {
        this.key = key;
        this.boost = boost;
    }

    public String getKey() {
        return key;
    }

    public double getBoost() {
        return boost;
    }
}
