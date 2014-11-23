package com.gigavoid.supermod.util;

import java.lang.reflect.Field;

/**
 * Created by ineentho on 2014-11-22.
 */
public class SuperReflection {
    public static Object getFieldValue(String fieldName, Class clazz, Object instance) {
        Field field = getField(clazz, fieldName);
        field.setAccessible(true);

        try {
            return field.get(instance);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return null;
    }


    public static Field getField(Class clazz, String fieldName) {
        try {
            return clazz.getDeclaredField(fieldName);
        } catch (NoSuchFieldException e) {
            Class superClass = clazz.getSuperclass();
            if (superClass == null) {
                e.printStackTrace();
            } else {
                return getField(superClass, fieldName);
            }
        }

        return null;
    }
}
