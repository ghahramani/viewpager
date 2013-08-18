package com.navid.tabs;

import android.R;
import android.graphics.Color;

import java.lang.reflect.Field;

/**
 * Author: Navid Ghahramani
 * You can contact to me with ghahramani.navid@gmail.com
 */
public final class Utilities {
    public static Integer getColor(String color, int defaultValue) {
        int code;
        try {
            code = Color.parseColor(color);
        } catch (Exception e) {
            code = defaultValue;
        }
        return code;
    }

    public static Integer getResource(String res, int defaultValue) {
        try {
            for (Field field : R.color.class.getDeclaredFields()) {
                if (field.getName().equals(res)) {
                    field.setAccessible(true);
                    if (field.getType().equals(Integer.class)) {
                        return field.getInt(null);
                    } else {
                        return Integer.valueOf(String.valueOf(field.get(null)));
                    }
                }
            }
        } catch (Exception ignored) {
            ignored.printStackTrace();
        }
        return defaultValue;
    }
}
