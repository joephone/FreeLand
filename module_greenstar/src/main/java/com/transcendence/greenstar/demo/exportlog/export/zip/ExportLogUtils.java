package com.transcendence.greenstar.demo.exportlog.export.zip;

import android.os.Environment;


import com.transcendence.core.base.global.Global;
import com.transcendence.core.utils.AppUtils;
import com.transcendence.core.utils.log.LogUtils;
import com.transcendence.greenstar.BuildConfig;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ExportLogUtils {
    public static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
    //日志保存路径
    public static final String LOG_DIR = "/"+Global.TAG+ "/logs/";
    //日志拷贝路径
    public static final String COPY_DIR = "/"+Global.TAG+"/copy/";
    //日志压缩路径
    public static final String ZIP_DIR = "/"+Global.TAG+"/upload/";
//    private static final String packageName = "com.hjly.exportlogdemo";

    private static boolean isSdcardMounted() {
        return Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState());
    }

    public static String getLogDir() {
        if (isSdcardMounted()) {
            return Environment.getExternalStorageDirectory() + LOG_DIR;
        } else {
            return "/data/data/" + AppUtils.getPackageName() + LOG_DIR;
        }
    }

    public static String getCopyDir() {
        if (isSdcardMounted()) {
            return Environment.getExternalStorageDirectory() + COPY_DIR;
        } else {
            return "/data/data/" + AppUtils.getPackageName() + COPY_DIR;
        }
    }

    public static String getZipDir() {
        if (isSdcardMounted()) {
            return Environment.getExternalStorageDirectory() + ZIP_DIR;
        } else {
            return "/data/data/" + AppUtils.getPackageName() + ZIP_DIR;
        }
    }

    public static String getLogFileName() {
        return simpleDateFormat.format(new Date());
    }

    /**
     * 计算两个日期之间的日期
     *
     * @param startTime
     * @param endTime
     */
    public static List<String> betweenDays(String startTime, String endTime) {
        List<String> result = new ArrayList<>();
        Date date_start = null;
        Date date_end = null;
        try {
            date_start = simpleDateFormat.parse(startTime);
            date_end = simpleDateFormat.parse(endTime);
        } catch (Exception e) {
            e.printStackTrace();
            return result;
        }
        //计算日期从开始时间于结束时间的0时计算
        Calendar fromCalendar = Calendar.getInstance();
        fromCalendar.setTime(date_start);
        fromCalendar.set(Calendar.HOUR_OF_DAY, 0);
        fromCalendar.set(Calendar.MINUTE, 0);
        fromCalendar.set(Calendar.SECOND, 0);
        fromCalendar.set(Calendar.MILLISECOND, 0);
        Calendar toCalendar = Calendar.getInstance();
        toCalendar.setTime(date_end);
        toCalendar.set(Calendar.HOUR_OF_DAY, 0);
        toCalendar.set(Calendar.MINUTE, 0);
        toCalendar.set(Calendar.SECOND, 0);
        toCalendar.set(Calendar.MILLISECOND, 0);
        int s = (int) ((toCalendar.getTimeInMillis() - fromCalendar.getTimeInMillis()) / (86400000));
        if (s != 0) {
            //多天
            for (int i = 0; i <= s; i++) {
                long todayDate = fromCalendar.getTimeInMillis() + i * 86400000;
                LogUtils.d("起止日期之间的日期包括：" + simpleDateFormat.format(todayDate));
                result.add(simpleDateFormat.format(todayDate));
            }
        } else {
            //此时在同一天之内
            LogUtils.d("起止日期之间的日期包括：" + startTime);
            result.add(startTime);
        }
        return result;
    }

}
