package com.transcendence.core.base.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.transcendence.core.utils.CommonUtils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.transcendence.core.R;
import com.transcendence.core.utils.statusbar.NativeStatusBarUtils;
import com.transcendence.core.utils.statusbarview.StatusBarUtil;


/**
 * @author joephone
 * @date 2023/1/19
 * @desc
 */
public abstract class BaseAc extends AppCompatActivity {

    protected BaseAc mActivity;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = this;

//        initStatusBar();
        NativeStatusBarUtils.with(mActivity).init();
    }


    public void showToast(@NonNull String msg){
        Toast.makeText(BaseAc.this,msg,Toast.LENGTH_SHORT).show();
    }


    public void startAc(Class<?> cls) {
        Intent intent = new Intent(this, cls);
        startActivity(intent);
    }

    public void startAc(Class<?> cls, Bundle bundle) {
        Intent intent = new Intent(this, cls);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void startAcForResult(Class<?> cls, int requestCode) {
        Intent intent = new Intent(this, cls);
        startActivityForResult(intent, requestCode);
    }
}
