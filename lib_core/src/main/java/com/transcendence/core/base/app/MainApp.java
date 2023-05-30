package com.transcendence.core.base.app;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;
import com.tencent.mmkv.MMKV;
import com.transcendence.core.BuildConfig;

/**
 * @author joephone
 * @date 2023/1/23
 * @desc
 */
public class MainApp extends Application {
    private static MainApp instance;

    @Override
    public void onCreate() {
        super.onCreate();
        //mmkv初始化
        MMKV.initialize(this);
        //路由初始化
        initARouter();
    }

    private void initARouter() {
        if (BuildConfig.DEBUG) {
            ARouter.openLog();
            ARouter.openDebug();
        }
        ARouter.init(this);
    }

    /**
     * 获得当前app运行的Application
     */
    public static MainApp getInstance() {
        if (instance == null) {
            throw new NullPointerException(
                    "please inherit BaseApplication or call setApplication.");
        }
        return instance;
    }
}
