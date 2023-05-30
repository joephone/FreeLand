package com.transcendence.greenstar.demo.exportlog.zip;


import static com.transcendence.greenstar.demo.exportlog.zip.ExportLogUtils.betweenDays;
import static com.transcendence.greenstar.demo.exportlog.zip.ExportLogUtils.getCopyDir;
import static com.transcendence.greenstar.demo.exportlog.zip.ExportLogUtils.getLogDir;
import static com.transcendence.greenstar.demo.exportlog.zip.ExportLogUtils.getZipDir;
import static com.transcendence.greenstar.demo.exportlog.zip.FileUtil.deleteFolder;

import com.transcendence.core.utils.log.LogUtils;

import java.io.File;
import java.util.List;

public class ZipUtil {

    //压缩某一天的日志文件
    public static String zipOneDayLog(String date) {
        File file_copy = new File(getCopyDir());
        if (deleteFolder(getCopyDir())) {
            LogUtils.d("清空拷贝文件夹成功");
        } else {
            LogUtils.d("清空拷贝文件夹失败,路径为 : "+getCopyDir());
        }
        file_copy.mkdirs();
        File file_zip = new File(getZipDir());
        if (deleteFolder(getZipDir())) {
            LogUtils.d("清空压缩文件夹成功");
        } else {
            LogUtils.d("清空压缩文件夹失败,路径为 : "+getZipDir());
        }
        file_zip.mkdirs();
        String filePath = getLogDir() + date + ".log";
        String copyPath = getCopyDir();
        if (FileUtil.fileIsExists(filePath)) {
            LogUtils.d("文件：" + date + ".log" + "存在");
            boolean copyResult = FileUtil.copyFile(new File(filePath), copyPath, date + ".log");
            if (!copyResult) {
                LogUtils.d("拷贝日志文件失败！");
                return "拷贝日志文件失败！";
            } else {
                LogUtils.d("拷贝日志文件成功！");
            }
            boolean zipResult = FileUtil.ZipFolder(getCopyDir(), getZipDir() + "check_3_" + date + ".zip");
            if (!zipResult) {
                LogUtils.d("压缩日志文件失败！");
                return "压缩日志文件失败！";
            } else {
                LogUtils.d("压缩日志文件成功！");
            }
        } else {
            LogUtils.d("未找到文件：" + getLogDir() + date + ".log");
            return "日志文件未找到！";
        }
        return "";
    }

    //压缩几天的日志文件
    public static String zipSomeDaysLog(String beginDate, String endDate) {
        File file_copy = new File(getCopyDir());
        if (deleteFolder(getCopyDir())) {
            LogUtils.d("清空拷贝文件夹成功");
        } else {
            LogUtils.d("清空拷贝文件夹失败,路径为 : "+getCopyDir());
        }
        file_copy.mkdirs();
        File file_zip = new File(getZipDir());
        if (deleteFolder(getZipDir())) {
            LogUtils.d("清空压缩文件夹成功");
        } else {
            LogUtils.d("清空压缩文件夹失败,路径为 : "+getZipDir());
        }
        file_zip.mkdirs();
        if ("".equals(beginDate) || "".equals(endDate)) {
            LogUtils.d("起止日期格式异常！");
            return "起止日期格式异常！";
        }
        List<String> dates = betweenDays(beginDate, endDate);
        if (null == dates || 0 == dates.size()) {
            LogUtils.d("解析起止日期失败！");
            return "解析起止日期失败！";
        }
        int datesSize = dates.size();
        int emptyFileCount = 0;
        for (int i = 0; i < dates.size(); i++) {
            String filePath = getLogDir() + dates.get(i) + ".log";
            String copyPath = getCopyDir();
            if (FileUtil.fileIsExists(filePath)) {
                LogUtils.d("文件：" + dates.get(i) + ".log" + "存在");
                boolean copyResult = FileUtil.copyFile(new File(filePath), copyPath, dates.get(i) + ".log");
                if (!copyResult) {
                    LogUtils.d("拷贝日志文件失败！");
                    return "拷贝日志文件失败！";
                } else {
                    LogUtils.d("拷贝日志文件成功！");
                }
                boolean zipResult = FileUtil.ZipFolder(getCopyDir(), getZipDir() + "check_3_" + beginDate + "_" + endDate + ".zip");
                if (!zipResult) {
                    LogUtils.d("压缩日志文件失败！");
                    return "压缩日志文件失败！";
                } else {
                    LogUtils.d("压缩日志文件成功！");
                }
            } else {
                emptyFileCount++;
                LogUtils.d("未找到文件：" + getLogDir() + dates.get(i) + ".log");
            }
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (emptyFileCount == datesSize) {
            LogUtils.d("所选日期之间没有日志文件");
            return "所选日期之间没有日志文件！";
        } else {
            return "";
        }
    }
}
