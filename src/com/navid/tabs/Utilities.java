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

    public static int getResourceIdByName(String packageName, String className, String name) {
        Class r = null;
        int id = 0;
        try {
            r = Class.forName(packageName + ".R");

            Class[] classes = r.getClasses();
            Class desireClass = null;

            for (Class aClass : classes) {
                if (aClass.getName().split("\\$")[1].equals(className)) {
                    desireClass = aClass;

                    break;
                }
            }

            if (desireClass != null)
                id = desireClass.getField(name).getInt(desireClass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        return id;
    }
}
