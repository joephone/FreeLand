package com.transcendence.freeland.ble.test2;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.provider.Settings;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import com.transcendence.core.base.activity.AppAc;
import com.transcendence.core.utils.log.LogUtils;
import com.transcendence.freeland.R;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author joephone
 * @date 2023/6/4
 * @desc
 */
public class BleTest3 extends AppAc {

    TextView tv2;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_ble_firsttest;
    }

    @Override
    protected void initView() {
        TextView tv = findViewById(R.id.tv);
        tv2 = findViewById(R.id.tv_2);
        tv.setOnClickListener(v ->{
            change(BleTest3.this);
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        isConnected(BleTest3.this);
    }

    private void isConnected(Context context){
        ConnectivityManager connMgr = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        // 获取当前活动的网络信息
        NetworkInfo activeNetworkInfo = connMgr.getActiveNetworkInfo();

        // 判断应用是否拥有WLAN权限
        boolean hasWifiPermission = isAppWiFiEnabled(context);//checkCallingOrSelfPermission(Manifest.permission.ACCESS_WIFI_STATE) == PackageManager.PERMISSION_GRANTED;

        // 判断应用是否拥有移动数据权限
        boolean hasMobileDataPermission = isAppMobileDataEnabled(context);//checkCallingOrSelfPermission(Manifest.permission.ACCESS_NETWORK_STATE) == PackageManager.PERMISSION_GRANTED;

        // 判断网络是否可用
        boolean isNetworkAvailable = activeNetworkInfo != null && activeNetworkInfo.isConnected();

        tv2.setText("判断应用是否拥有WLAN权限"+hasWifiPermission+"判断应用是否拥有移动数据权限"+hasMobileDataPermission+"isNetworkAvailable--"+isNetworkAvailable);
        LogUtils.d("判断应用是否拥有WLAN权限"+hasWifiPermission);
//        LogUtils.d("判断应用是否拥有WIFI权限"+isWifiAvailable(context));
        LogUtils.d("判断应用是否拥有移动数据权限"+hasMobileDataPermission);
        LogUtils.d("isNetworkAvailable--"+isNetworkAvailable);
    }




    public void change(Context context){
        LogUtils.d("LCBPermissionModule pushSystemPage");
        Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setData(Uri.parse("package:" + context.getPackageName()));
        context.startActivity(intent);
    }


    // 检查应用内 WLAN 是否可用
    public static boolean isAppWiFiEnabled(Context context) {
        ConnectivityManager cm =
                (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (cm != null) {
            NetworkCapabilities nc = null;
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
                nc = cm.getNetworkCapabilities(cm.getActiveNetwork());
            }
            if (nc != null) {
                return nc.hasTransport(NetworkCapabilities.TRANSPORT_WIFI);
            }
        }
        return false;
    }

    // 检查应用内移动数据是否可用
    public static boolean isAppMobileDataEnabled(Context context) {
        ConnectivityManager cm =
                (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (cm != null) {
            NetworkCapabilities nc = null;
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
                nc = cm.getNetworkCapabilities(cm.getActiveNetwork());
            }
            if (nc != null) {
                return nc.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR);
            }
        }
        return false;
    }
}
