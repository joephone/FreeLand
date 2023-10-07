package com.transcendence.greenstar.base.route;

import com.transcendence.greenstar.demo.allapp.AllAppActivity;
import com.transcendence.greenstar.demo.appinfo.act.AppInfoMainAc;
import com.transcendence.greenstar.demo.auth.AuthOneAct;
import com.transcendence.greenstar.demo.bing.BingActivity;
import com.transcendence.greenstar.demo.biometric.BiometricActivity;
import com.transcendence.greenstar.demo.bluetooth.act.BlueToothAct;
import com.transcendence.greenstar.demo.dbnote.act.DBNoteActivity;
import com.transcendence.greenstar.demo.encryption.act.EncryptionMainAc;
import com.transcendence.greenstar.demo.exportlog.logcat.LogcatKt;
import com.transcendence.greenstar.demo.load.LoadAcKt;
import com.transcendence.greenstar.demo.luckypanel.LuckyPanelAc;
import com.transcendence.greenstar.demo.pdf.act.FileDisplayActivity;
import com.transcendence.greenstar.demo.permissionx.PermissionxKt;
import com.transcendence.greenstar.demo.record.example.RecordExampleActivity;
import com.transcendence.greenstar.demo.shoppingcart.ShoppingCartActivity;
import com.transcendence.greenstar.demo.showPermissions.ShowPermissionAc;
import com.transcendence.greenstar.demo.splash.SplashActivity;
//import com.transcendence.greenstar.demo.wearecord.WeaRecordMainKt;
import com.transcendence.greenstar.demo.wuwei.WuweiActivity;
import com.transcendence.greenstar.demo.zxing.ZxingMain;

/**
 * @author joephone
 * @date 2023/2/27
 * @desc
 */
public interface GreenStarConstantValue {

    Class[] demoIndex = {
            AppInfoMainAc.class,
            LuckyPanelAc.class,
            EncryptionMainAc.class,
            BingActivity.class,
      //      WeaRecordMainKt.class,//RecordMainActivity.class,
            RecordExampleActivity.class,
            DBNoteActivity.class,
            BiometricActivity.class,
            LogcatKt.class,
            AuthOneAct.class,
            ShoppingCartActivity.class,
            SplashActivity.class,
            ShowPermissionAc.class,
            PermissionxKt.class,
            AllAppActivity.class,
            WuweiActivity.class,
            LoadAcKt.class,
            ZxingMain.class,
            FileDisplayActivity.class,
            BlueToothAct.class
    };

}
