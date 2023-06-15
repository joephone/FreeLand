package com.transcendence.greenstar.demo.exportlog.logcat;

import android.content.Context;
import android.content.Intent;

/**
 * @author joephone
 * @date 2023/6/15
 * @desc 调用类
 */
public class LogModule {
    public static void init(Context context) {
        LogcatUtil.init(context);
    }

    /**
     * 应用启动抓取系统全日志
     *
     * @param context
     */
    public static void openCollectSystemLog(Context context) {
        Intent intent = new Intent(context, LogcatService.class);
        context.startService(intent);
    }

    /**
     * 停止日志收集
     *
     * @param context
     */
    public static void closeCollectSystemLog(Context context) {
        Intent intent = new Intent(context, LogcatService.class);
        context.stopService(intent);
    }
}

