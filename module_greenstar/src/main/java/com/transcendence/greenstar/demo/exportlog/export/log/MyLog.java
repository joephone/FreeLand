package com.transcendence.greenstar.demo.exportlog.export.log;


import android.text.TextUtils;

import com.transcendence.core.global.Global;
import com.transcendence.core.utils.log.LogUtils;
import com.transcendence.greenstar.demo.exportlog.export.zip.ExportLogUtils;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import de.mindpipe.android.logging.log4j.LogConfigurator;

public class MyLog {
    public static final boolean SWITCH_LOG = true;
    private static boolean isConfigured = false;

    public static void configure() {
        final LogConfigurator logConfigurator = new LogConfigurator();
        try {
            String logDir = ExportLogUtils.getLogDir();
            String logFileName = ExportLogUtils.getLogFileName();
            logConfigurator.setFileName(logDir + logFileName + ".log");
            LogUtils.e( "setFileName--"+logDir + logFileName + ".log");
            //以下设置是按指定大小来生成新的文件
            logConfigurator.setMaxBackupSize(50);
            logConfigurator.setMaxFileSize(1024 * 1024 * 10);
            logConfigurator.setUseFileAppender(true);
            //以下为通用配置
            logConfigurator.setImmediateFlush(true);
            logConfigurator.setRootLevel(Level.DEBUG);
            logConfigurator.setFilePattern("%d\t%p/%c:\t%m%n");
            logConfigurator.configure();
            LogUtils.e( "Log4j config finish");
        } catch (Throwable throwable) {
            logConfigurator.setResetConfiguration(true);
            LogUtils.e( "Log4j config error, use default config. Error:" + throwable);
        }
    }

    private static String getSurffix() {
        try {
            StackTraceElement[] stack = Thread.currentThread().getStackTrace();
            String file = stack[4].getFileName();
            int line = stack[4].getLineNumber();
            String method = stack[4].getMethodName();
            return String.format("  - %s, line: %d, method: %s", file, line, method);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public static void d(String message) {
        if (SWITCH_LOG) {
            Logger LOGGER = getLogger(Global.TAG);
            LOGGER.debug(message + getSurffix());
        }
    }

    public static void d(String tag, String message) {
        if (SWITCH_LOG) {
            Logger LOGGER = getLogger(Global.TAG);
            LOGGER.debug(message + getSurffix());
        }
    }

    public static void d(String tag, String message, Throwable exception) {
        if (SWITCH_LOG) {
            Logger LOGGER = getLogger(Global.TAG);
            LOGGER.debug(message + getSurffix(), exception);
        }
    }

    public static void i(String message) {
        if (SWITCH_LOG) {
            Logger LOGGER = getLogger(Global.TAG);
            if (message == null)
                LOGGER.info("");
            else
                LOGGER.info(message + getSurffix());
        }
    }

    public static void i(String tag, String message) {
        if (SWITCH_LOG) {
            Logger LOGGER = getLogger(Global.TAG);
            LOGGER.info(message + getSurffix());
        }
    }

    public static void i(String tag, String message, Throwable exception) {
        if (SWITCH_LOG) {
            Logger LOGGER = getLogger(Global.TAG);
            LOGGER.info(message + getSurffix(), exception);
        }
    }

    public static void w(String message) {
        if (SWITCH_LOG) {
            Logger LOGGER = getLogger(Global.TAG);
            LOGGER.warn(message + getSurffix());
        }
    }

    public static void w(String tag, String message) {
        if (SWITCH_LOG) {
            Logger LOGGER = getLogger(Global.TAG);
            LOGGER.warn(message + getSurffix());
        }
    }

    public static void w(String tag, String message, Throwable exception) {
        if (SWITCH_LOG) {
            Logger LOGGER = getLogger(Global.TAG);
            LOGGER.warn(message + getSurffix(), exception);
        }
    }

    public static void e(String message) {
        if (SWITCH_LOG) {
            Logger LOGGER = getLogger(Global.TAG);
            LOGGER.error(message + getSurffix());
        }
    }

    public static void e(String tag, String message) {
        if (SWITCH_LOG) {
            Logger LOGGER = getLogger(Global.TAG);
            LOGGER.error(message + getSurffix());
        }
    }

    public static void e(String tag, String message, Throwable exception) {
        if (SWITCH_LOG) {
            Logger LOGGER = getLogger(Global.TAG);
            LOGGER.error(message + getSurffix(), exception);
        }
    }

    private static Logger getLogger(String tag) {
        if (!isConfigured) {
            isConfigured = true;
            configure();
        }
        Logger logger;
        if (TextUtils.isEmpty(tag)) {
            logger = Logger.getRootLogger();
        } else {
            logger = Logger.getLogger(tag);
        }
        return logger;
    }
}