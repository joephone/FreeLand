package com.transcendence.greenstar.demo.auth;

import com.transcendence.core.base.common.activity.AppAc;
import com.transcendence.greenstar.R;

/**
 * @author joephone
 * @date 2018/6/4 16:12
 * @desc 新 认证第一步
 */
public class AuthOneAct extends AppAc {


    @Override
    protected int getLayoutId() {
        return R.layout.activity_demo_auth_step_one;
    }

    @Override
    protected void initView() {
        setTitle("身份认证");
    }
}
