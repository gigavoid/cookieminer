package com.gigavoid.supermod.cookiecraft.item;

import com.gigavoid.supermod.cookiecraft.upgrade.MultiplicativeBoost;

import java.util.Map;

public interface IItemCookieUpgrade {
    double getFlatBoost();
    MultiplicativeBoost getMultiplicativeBoost();
}
