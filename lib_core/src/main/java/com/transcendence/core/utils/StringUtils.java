package com.transcendence.core.utils;

import android.content.Context;

import com.transcendence.core.base.app.MainApp;

import java.util.ArrayList;
import java.util.List;

/**
 * @author joephone
 * @date 2023/2/27
 * @desc
 */
public class StringUtils {

    /**
     * 根据id 得到字符串
     */
    public static String getString(int id) {
        try {
            return MainApp.getInstance().getApplicationContext().getString(id);
        } catch (Exception e) {
            // TODO: handle exception
        }
        return "";
    }

    public static List<String> getStringList(Context context, int name) {
        List<String> list = new ArrayList<>();
        String[] array = context.getResources().getStringArray(name);
        for (int i = 0; i < array.length; i++) {
            list.add(array[i]);
        }
        return list;
    }


    public static String[] getStringArray(Context context, int name) {
        String[] array = context.getResources().getStringArray(name);
        return array;
    }
}
