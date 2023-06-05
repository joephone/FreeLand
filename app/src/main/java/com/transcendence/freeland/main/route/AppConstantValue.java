package com.transcendence.freeland.main.route;


import com.transcendence.freeland.basefun.bugly.BuglyKt;
import com.transcendence.freeland.basefun.settings.SysSettingsAc;
import com.transcendence.freeland.ble.test.BleTest;
import com.transcendence.freeland.ble.test2.BleTest3;
import com.transcendence.freeland.ble.test2.NetTest;
import com.transcendence.freeland.main.index.BleIndexActivity;
import com.transcendence.freeland.main.index.SettingsIndexActivity;
import com.transcendence.freeland.main.index.UIIndexActivity;

/**
 * @author joephone
 * @date 2023/5/29
 * @desc
 */
public interface AppConstantValue {

    Class[] appIndex = {
            SettingsIndexActivity.class,
            BuglyKt.class,
            UIIndexActivity.class,
            BleIndexActivity.class,
    };


    Class[] uiIndex = {

    };

    Class[] bleIndex = {
            BleTest.class,
            BleTest3.class,
            NetTest.class
    };


}
