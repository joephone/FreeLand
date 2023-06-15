package com.transcendence.greenstar.demo.exportlog.logcat;

import android.content.Context;

import com.transcendence.core.utils.log.LogUtils;
import com.transcendence.greenstar.demo.exportlog.export.zip.FileUtil;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author joephone
 * @date 2023/6/15
 * @desc 包括初始化文件目录、创建文件、抓取日志的指令等相关操作。
 */
public class LogcatUtil {

    private static final String TEMP_LOG = "tmclog-" + getFileName() + ".log";

    private static String filePath = "";

    private static File logFile = null;

    private static Process process = null;

    private static boolean running = false;

    public static String getFilePath() {
        return filePath;
    }

    public static void setFilePath(String path) {
        filePath = path;
    }

    public static Process getProcess() {
        return process;
    }

    public static File getLogFile() {
        return logFile;
    }

    /**
     * 初始化目录
     */
    public static void init(Context context) {
        try {
            File sdDir = context.getExternalFilesDir(null);
            filePath = sdDir.getAbsolutePath();
            LogUtils.d("创建文件成功！");
        } catch (Exception e) {
            e.printStackTrace();
            LogUtils.e("创建文件失败！");
        }
    }

    public static String getFileName() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String date = format.format(new Date(System.currentTimeMillis()));
        return date;
    }

    // 清除4天前保存的logcat日志
    public static void cleanHistory() {
        FileUtil.deleteFile(filePath);  //, 4 * 24 * 60 * 60 * 1000
    }

    public static boolean startCapture() {
        LogcatUtil.cleanHistory();
        if (running) {
            LogUtils.d( "Loggcat capture is already running");
            return true;
        }
        File path = new File(filePath);
        if (!path.exists()) {
            path.mkdirs();
        }
        logFile = new File(path, TEMP_LOG);
        try {
            process = Runtime.getRuntime().exec("logcat -c");
            process = Runtime.getRuntime().exec("logcat -f " + logFile);
        } catch (IOException e) {
            LogUtils.e( "Trye to capture app logcat failed. IO exception");
            e.printStackTrace();
            return false;
        }
        running = true;
        return true;
    }

    /**
     * 继续抓取日志，使用同样的文件
     *
     * @return
     */
    public static boolean resumeCapture() {
        if (logFile != null) {
            try {
                process = Runtime.getRuntime().exec("logcat -c");
                process = Runtime.getRuntime().exec("logcat -f " + logFile);
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }

        return true;
    }

    public static void stopCapture() {
        if (process != null) {
            process.destroy();
        }
        logFile = null;
        running = false;
    }
}

