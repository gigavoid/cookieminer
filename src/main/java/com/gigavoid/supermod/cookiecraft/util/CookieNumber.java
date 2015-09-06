package com.gigavoid.supermod.cookiecraft.util;

import java.util.HashMap;
import java.util.Map;

public class CookieNumber {

    private static Map<Integer, String> notations;

    static {
        notations = new HashMap<Integer, String>();
        notations.put(1, "");
        notations.put(3, "k");
        notations.put(6, "M");
        notations.put(9, "G");
        notations.put(12, "T");
        notations.put(15, "P");
        notations.put(18, "E");
        notations.put(21, "Z");
        notations.put(24, "Y");
    }

    public static String doubleToString(double number) {
        int factor = Math.max(1, ((int) Math.log10(number) / 3) * 3);
        return String.format("%.3f%s", (number / Math.pow(10, factor - 1)), notations.get(factor));
    }
}
