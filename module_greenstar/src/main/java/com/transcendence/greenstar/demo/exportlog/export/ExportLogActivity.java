package com.transcendence.greenstar.demo.exportlog.export;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat;

import com.transcendence.core.base.activity.AppAc;
import com.transcendence.core.utils.log.LogUtils;
import com.transcendence.greenstar.R;
import com.transcendence.greenstar.demo.exportlog.export.zip.ZipUtil;


public class ExportLogActivity extends AppAc {


    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static String[] PERMISSIONS_STORAGE = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };
    private AlertDialog dialog;
    private boolean havePermission = false;



    @Override
    protected int getLayoutId() {
        return R.layout.activity_demo_exportlog_main;
    }

    @Override
    protected void initView() {

        Button btnZipTodayLog = findViewById(R.id.btn_zip_today_log);
        btnZipTodayLog.setOnClickListener(view -> {
            if (!havePermission) {
                LogUtils.d("当前设备无存储权限");
                Toast.makeText(this, "当前设备无存储权限", Toast.LENGTH_SHORT).show();
                return;
            }
            String result = ZipUtil.zipOneDayLog("20230331");
            if (!"".equals(result)) {
                Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "压缩日志文件成功", Toast.LENGTH_SHORT).show();
            }
        });

        Button btnZipLogsInThePastThreeDays = findViewById(R.id.btn_zip_logs_in_the_past_three_days);
        btnZipLogsInThePastThreeDays.setOnClickListener(view -> {
            if (!havePermission) {
                LogUtils.d("当前设备无存储权限");
                Toast.makeText(this, "当前设备无存储权限", Toast.LENGTH_SHORT).show();
                return;
            }
            String result = ZipUtil.zipSomeDaysLog("20230329", "20230331");
            if (!"".equals(result)) {
                Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "压缩日志文件成功", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        checkPermission();
    }

    private void checkPermission() {
//        if (Build.VERSION.SDK_INT >= 30) {
//            if (!Environment.isExternalStorageManager()) {
//                if (dialog != null) {
//                    dialog.dismiss();
//                    dialog = null;
//                }
//                dialog = new AlertDialog.Builder(this)
//                        .setTitle("提示")//设置标题
//                        .setMessage("请开启文件访问权限，否则无法正常使用本应用！")
//                        .setNegativeButton("取消", (dialog, i) -> dialog.dismiss())
//                        .setPositiveButton("确定", (dialog, which) -> {
//                            dialog.dismiss();
//                            Intent intent = new Intent(Settings.ACTION_MANAGE_ALL_FILES_ACCESS_PERMISSION);
//                            startActivity(intent);
//                        }).create();
//                dialog.show();
//            } else {
//                havePermission = true;
//                LogUtils.d("Android 11以上，当前已有权限");
//            }
//        } else {
            if (Build.VERSION.SDK_INT > Build.VERSION_CODES.M) {
                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                    //申请权限
                    if (dialog != null) {
                        dialog.dismiss();
                        dialog = null;
                    }
                    dialog = new AlertDialog.Builder(this)
                            .setTitle("提示")//设置标题
                            .setMessage("请开启文件访问权限，否则无法正常使用本应用！")
                            .setPositiveButton("确定", (dialog, which) -> {
                                dialog.dismiss();
                                ActivityCompat.requestPermissions(ExportLogActivity.this, PERMISSIONS_STORAGE, REQUEST_EXTERNAL_STORAGE);
                            }).create();
                    dialog.show();
                } else {
                    havePermission = true;
                    LogUtils.d("Android 6.0以上，11以下，当前已有权限");
                }
            } else {
                havePermission = true;
                LogUtils.d("Android 6.0以下，已获取权限");
            }
//        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case REQUEST_EXTERNAL_STORAGE: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    havePermission = true;
                    Toast.makeText(this, "授权成功！", Toast.LENGTH_SHORT).show();
                } else {
                    havePermission = false;
                    Toast.makeText(this, "授权被拒绝！", Toast.LENGTH_SHORT).show();
                }
                return;
            }
        }
    }

}