package com.transcendence.freeland.main.route;


import com.transcendence.freeland.basefun.alert.AlertAc;
import com.transcendence.freeland.basefun.bugly.BuglyKt;
import com.transcendence.freeland.basefun.countdownrestart.CountDownRestartKt;
import com.transcendence.freeland.basefun.directory.AndroidDirectoryKt;
import com.transcendence.freeland.basefun.permission.PermissionIndexActivity;
import com.transcendence.freeland.basefun.settings.SysSettingsAc;
import com.transcendence.freeland.ble.test.BleTest;
import com.transcendence.freeland.ble.test2.BleTest3;
import com.transcendence.freeland.ble.test2.NetTest;
import com.transcendence.freeland.main.index.BasefunIndexActivity;
import com.transcendence.freeland.main.index.BleIndexActivity;
import com.transcendence.freeland.main.index.SettingsIndexActivity;
import com.transcendence.freeland.main.index.UIIndexActivity;

import java.util.concurrent.CountDownLatch;

/**
 * @author joephone
 * @date 2023/5/29
 * @desc
 */
public interface AppConstantValue {

    Class[] appIndex = {
            BasefunIndexActivity.class,
            PermissionIndexActivity.class,
            SettingsIndexActivity.class,
            UIIndexActivity.class,
            BleIndexActivity.class,
    };

    Class[] baseFunIndex = {
            BuglyKt.class,
            CountDownRestartKt.class,
            AlertAc.class,
            AndroidDirectoryKt.class,
    };

    Class[] uiIndex = {

    };

    Class[] bleIndex = {
            BleTest.class,
            BleTest3.class,
            NetTest.class
    };


}
