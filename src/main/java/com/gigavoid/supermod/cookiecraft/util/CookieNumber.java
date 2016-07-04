package com.gigavoid.supermod.cookiecraft.util;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class CookieNumber {

    private static Map<Integer, String> notations;

    static {
        notations = new HashMap<Integer, String>();
        notations.put(0, "");
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
        int factor = Math.max(0, ((int) Math.log10(number) / 3) * 3);
        int nDecimals = 2;

        if (number < 1000 && Math.floor(number) == number) {
            nDecimals = 0;
        }

        return String.format(Locale.US, "%." + nDecimals +"f%s", (number / Math.pow(10, factor)), notations.get(factor));
    }
}
