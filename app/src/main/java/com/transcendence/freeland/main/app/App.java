package com.transcendence.freeland.main.app;

import android.app.Application;

import com.transcendence.core.base.app.MainApp;
import com.transcendence.freeland.crash.CrashHandler;

/**
 * @author joephone
 * @date 2023/1/20
 * @desc
 */
public class App extends MainApp {

    @Override
    public void onCreate() {
        super.onCreate();

        CrashHandler.register(this);
    }
}
