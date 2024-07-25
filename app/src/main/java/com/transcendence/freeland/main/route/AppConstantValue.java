package com.transcendence.freeland.main.route;


import com.transcendence.freeland.basefun.alert.AlertAc;
import com.transcendence.freeland.basefun.bugly.BuglyKt;
import com.transcendence.freeland.basefun.countdownrestart.CountDownRestartKt;
import com.transcendence.freeland.basefun.directory.AndroidDirectoryKt;
import com.transcendence.freeland.basefun.nostart.NoStartA;
import com.transcendence.freeland.basefun.permission.PermissionIndexActivity;
import com.transcendence.freeland.ble.test.BleTest;
import com.transcendence.freeland.ble.test2.BleTest3;
import com.transcendence.freeland.ble.test2.NetTest;
import com.transcendence.freeland.main.index.BasefunIndexActivity;
import com.transcendence.freeland.main.index.BleIndexActivity;
import com.transcendence.freeland.main.index.RvIndexActivity;
import com.transcendence.freeland.main.index.SettingsIndexActivity;
import com.transcendence.freeland.main.index.UIIndexActivity;
import com.transcendence.freeland.ui.rv.linkpage.act.LinkPageMainActivity;
import com.transcendence.freeland.ui.rv.linkpage.act.LinkPageMainV2Activity;
import com.transcendence.freeland.ui.rv.mogu.act.MoguMainActivity;
import com.transcendence.freeland.ui.rv.mogu.act.MoguMainActivityV2;
import com.transcendence.freeland.ui.rv.staggerd.act.StaggerdMainActivity;
import com.transcendence.freeland.ui.rv.vp.act.RvVpMainActivity;
import com.transcendence.freeland.ui.seekbar.StepSeekBarMainActivity;

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
            NoStartA.class,
    };

    Class[] uiIndex = {
            RvIndexActivity.class,
            StepSeekBarMainActivity.class,
    };

    Class[] rvIndex = {
            RvVpMainActivity.class,
            MoguMainActivity.class,
            MoguMainActivityV2.class,
            StaggerdMainActivity.class,
            LinkPageMainActivity.class,
            LinkPageMainV2Activity.class,
    };

    Class[] bleIndex = {
            BleTest.class,
            BleTest3.class,
            NetTest.class
    };


}
