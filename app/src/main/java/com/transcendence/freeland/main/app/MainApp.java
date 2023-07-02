package com.transcendence.freeland.main.app;

import com.transcendence.core.base.app.CoreApp;
import com.transcendence.freeland.crash.CrashHandler;

/**
 * @author joephone
 * @date 2023/1/20
 * @desc
 */
public class MainApp extends CoreApp {

    @Override
    public void onCreate() {
        super.onCreate();

        CrashHandler.register(this);

    }
}
