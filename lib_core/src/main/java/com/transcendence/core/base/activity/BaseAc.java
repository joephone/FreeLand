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
        NativeStatusBarUtils.with(mActivity).init();

        init();
    }

    protected void init() {
        initLayout();
        initView();
    }


    /**
     * 初始化布局
     */
    protected void initLayout() {
        if (getLayoutId() > 0) {
            setContentView(getLayoutId());
        }
    }

    /**
     * 获取布局 ID
     */
    protected abstract int getLayoutId();

    /**
     * 初始化数据
     */
    protected abstract void initView();




}
