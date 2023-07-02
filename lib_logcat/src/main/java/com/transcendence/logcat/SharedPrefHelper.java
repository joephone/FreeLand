/*
 * Copyright (C) 2015. The Android Open Source Project.
 *
 *         yinglovezhuzhu@gmail.com
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package com.transcendence.logcat;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.Map;
import java.util.Set;

/**
 * 配置文件工具类
 * Create by yinglovezhuzhu@gmail.com in 2014年12月20日
 */
public class SharedPrefHelper {

    private SharedPreferences mSharePref;

    public SharedPrefHelper(Context context, String name) {
        mSharePref = context.getSharedPreferences(name, Context.MODE_APPEND);
    }

    /**
     * 获取但实例对象，创建单实例对象的时候会初始化的配置文件
     * @param context
     * @return
     */
    public static SharedPrefHelper newInstance(Context context, String name) {
        return new SharedPrefHelper(context, name);
    }


    /**
     * 清除配置文件的所有数据
     *
     */
    public boolean clearAll() {
        return mSharePref.edit().clear().commit();
    }

    /**
     * 保存一个字符数据到配置文件中
     * @param key
     * @param value
     * @return
     */
    public boolean saveString(String key, String value) {
        return mSharePref.edit().putString(key, value).commit();
    }


    /**
     * 保存一个整型数据到配置文件中
     * @param key
     * @param value
     * @return
     */
    public boolean saveInt(String key, int value) {
        return mSharePref.edit().putInt(key, value).commit();
    }

    /**
     * 保存一个浮点型数据到配置文件中
     * @param key
     * @param value
     * @return
     */
    public boolean saveFloat(String key, float value) {
        return mSharePref.edit().putFloat(key, value).commit();
    }

    /**
     * 保存一个长整型数据到配置文件中
     * @param key
     * @param value
     * @return
     */
    public boolean saveLong(String key, long value) {
        return mSharePref.edit().putLong(key, value).commit();
    }


    /**
     * 保存一个布尔型数据到配置文件中
     * @param key
     * @param value
     * @return
     */
    public boolean saveBoolean(String key, boolean value) {
        return mSharePref.edit().putBoolean(key, value).commit();
    }

    /**
     * 保存一个String的Map
     * @param map
     * @return
     */
    public boolean saveStringMap(Map<String, String> map) {
        if(null == map || map.isEmpty()) {
            return true;
        }
        Set<String> keys = map.keySet();
        SharedPreferences.Editor editor = mSharePref.edit();
        for (String key : keys) {
            editor.putString(key, map.get(key));
        }
        return editor.commit();
    }

    /**
     * 保存一个Long的Map
     * @param map
     * @return
     */
    public boolean saveLongMap(Map<String, Long> map) {
        if(null == map || map.isEmpty()) {
            return true;
        }
        Set<String> keys = map.keySet();
        SharedPreferences.Editor editor = mSharePref.edit();
        for (String key : keys) {
            editor.putLong(key, map.get(key));
        }
        return editor.commit();
    }

    /**
     * 从配置文件中删除某个字段的数据
     * @param key
     * @return
     */
    public boolean remove(String key) {
        return mSharePref.edit().remove(key).commit();
    }


    /**
     * 配置文件中是否包含某个字段数据
     * @param key
     * @return
     */
    public boolean contains(String key) {
        return mSharePref.contains(key);
    }

    /**
     * 获取配置文件中的所有字段，包含key和value
     * @return
     */
    public Map<String, ?> getAll() {
        return mSharePref.getAll();
    }

    /**
     * 从配置文件中读取一个字符数据
     * @param key
     * @param defValue
     * @return
     */
    public String getString(String key, String defValue) {
        return mSharePref.getString(key, defValue);
    }

    /**
     * 从配置文件中读取一个整型数据
     * @param key
     * @param defValue
     * @return
     */
    public int getInt(String key, int defValue) {
        return mSharePref.getInt(key, defValue);
    }


    /**
     * 从配置文件中读取一个浮点型数据
     * @param key
     * @param defValue
     * @return
     */
    public float getFloat(String key, float defValue) {
        return mSharePref.getFloat(key, defValue);
    }


    /**
     * 从配置文件中读取一个长整型数据
     * @param key
     * @param defValue
     * @return
     */
    public long getLong(String key, long defValue) {
        return mSharePref.getLong(key, defValue);
    }


    /**
     * 从配置文件中读取一个布尔型数据
     * @param key
     * @param defValue
     * @return
     */
    public boolean getBoolean(String key, boolean defValue) {
        return mSharePref.getBoolean(key, defValue);
    }

}