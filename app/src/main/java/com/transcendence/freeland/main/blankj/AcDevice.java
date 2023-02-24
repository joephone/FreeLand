package com.transcendence.freeland.main.blankj;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.annotation.Nullable;

import com.blankj.utilcode.util.DeviceUtils;
import com.transcendence.core.base.activity.BaseAc;
import com.transcendence.core.utils.log.LogUtils;
import com.transcendence.freeland.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author joephone
 * @date 2023/2/10
 * @desc
 */
public class AcDevice extends BaseAc {

    private ListView lv;
    private SimpleAdapter simpleAdapter;
    private List<Map<String,Object>> data = new ArrayList<>();

    public static void launch(Context context){
        Intent intent = new Intent(context, AcDevice.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lv);

        lv = findViewById(R.id.lv);
        //适配器
        simpleAdapter = new SimpleAdapter(this,initData(),android.R.layout.simple_list_item_2,new String[]{"names","note"},new int[]{android.R.id.text1,android.R.id.text2});
        lv.setAdapter(simpleAdapter);
    }

    private List<Map<String,Object>> initData(){
        LogUtils.d("initData");
        Map<String,Object> map = new HashMap<>();
        map.put("isRoot", DeviceUtils.isDeviceRooted());
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            map.put("isAdbEnabled", DeviceUtils.isAdbEnabled());
        }
        map.put("getSDKVersionName", DeviceUtils.getSDKVersionName());
        map.put("getSDKVersionCode", DeviceUtils.getSDKVersionCode());
        LogUtils.d("getSDKVersionCode----"+DeviceUtils.getSDKVersionCode());
        map.put("getAndroidID", DeviceUtils.getAndroidID());
        map.put("getMacAddress", DeviceUtils.getMacAddress());
        LogUtils.d("getMacAddress----"+DeviceUtils.getMacAddress());
        map.put("getManufacturer", DeviceUtils.getManufacturer());
        LogUtils.d("getManufacturer----"+DeviceUtils.getManufacturer());
        map.put("getModel", DeviceUtils.getModel());
        map.put("getABIs", Arrays.asList(DeviceUtils.getABIs()).toString());
        map.put("isTablet", DeviceUtils.isTablet());
        map.put("isEmulator", DeviceUtils.isEmulator());
        map.put("getUniqueDeviceId", DeviceUtils.getUniqueDeviceId("util"));
        map.put("isSameDevice", DeviceUtils.isSameDevice(DeviceUtils.getUniqueDeviceId()));
        data.add(map);
        LogUtils.d("data.size()----"+DeviceUtils.getAndroidID()+DeviceUtils.getSDKVersionName());
        return data;

    }
}
