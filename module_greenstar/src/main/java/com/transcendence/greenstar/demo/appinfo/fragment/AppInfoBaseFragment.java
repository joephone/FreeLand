package com.transcendence.greenstar.demo.appinfo.fragment;

import android.view.View;

/**
 * @author joephone
 * @date 2023/4/26
 * @desc
 */
public abstract class AppInfoBaseFragment extends IBaseFragment implements View.OnClickListener{

    // ==== 其他对象 ====

    @Override
    public void initValues() {
        super.initValues();
    }

    @Override
    public void onClick(View v) {
    }

    /** 滑动到顶部 */
    public void onScrollTop(){
    }

}
