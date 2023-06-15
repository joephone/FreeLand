package com.transcendence.greenstar.demo.exportlog.logcat;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import com.transcendence.core.utils.log.LogUtils;

import java.io.File;

/**
 * @author joephone
 * @date 2023/6/15
 * @desc
 */
public class LogcatService extends Service {

    private boolean stop = false;
    private int maxFileCount = 4;
    private long maxFileSize = 32*1024*1024;
    private static final String BACKUP_PREFIX = "log_backup_";

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        boolean success = LogcatUtil.startCapture();
        LogUtils.d("startCapture---"+success);
        if (!success) {
            LogUtils.e( "Error to start capture logcat!");
        } else {
            // 启动监听线程，因为子进程会被系统回收所以需要监听
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while(!stop) {
                        File logFile = LogcatUtil.getLogFile();
                        if (logFile.length() >= maxFileSize) {
                            LogUtils.d("Log file size exceed! Backup file");
                            LogcatUtil.stopCapture();
                            backupLogFile(logFile);
                            LogcatUtil.startCapture();
                        }
                        Process process = LogcatUtil.getProcess();
                        boolean isAlive = false;
                        try {
                            int exitValue = process.exitValue();
                            if (exitValue != 0) {
                                isAlive = false;
                            }
                        } catch (IllegalThreadStateException e) {
//                            e.printStackTrace();
                            isAlive = true;
                        }
                        if (!isAlive) {
                            LogUtils.e( "Logcat thread died!!!");
                            LogcatUtil.resumeCapture();
                        }

                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }
                    LogUtils.d( "Logcat thread normal stop!!!");
                }
            }).start();
        }
    }

    private void backupLogFile(File logFile) {
        String logPath = LogcatUtil.getFilePath();
        if (!new File(logPath).exists()) {
            LogUtils.e( "Error!! Log file path not exists");
            return;
        }
        for (int index =0;index<maxFileCount;index++) {
            String backupName = logPath + BACKUP_PREFIX + index + ".log";
            File file = new File(backupName);
            if (!file.exists()) {
                LogUtils.d( "Backup file " + logFile.getAbsolutePath() + "  to  " + backupName);
                logFile.renameTo(file);
                return;
            }
        }
        LogUtils.d( "Backup file is full. Delete first and rename current log file");
        String firstBackupName = logPath + BACKUP_PREFIX + "0.log";
        File firtFile = new File(firstBackupName);
        firtFile.delete();
        for (int index =1;index<maxFileCount;index++) {
            String backupName = logPath + BACKUP_PREFIX + index + ".log";
            File file = new File(backupName);
            file.renameTo(new File(logPath + BACKUP_PREFIX + (index-1) + ".log"));
        }
        // backup current file
        String currentBackupName = logPath + BACKUP_PREFIX + (maxFileCount-1) + ".log";
        logFile.renameTo(new File(currentBackupName));
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        stop = true;
        LogcatUtil.stopCapture();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

}
