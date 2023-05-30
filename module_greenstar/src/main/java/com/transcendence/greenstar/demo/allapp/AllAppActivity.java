package com.transcendence.greenstar.demo.allapp;

import androidx.fragment.app.Fragment;

import com.transcendence.greenstar.R;
import com.transcendence.greenstar.demo.allapp.fragment.AllAppFragment;
import com.transcendence.greenstar.demo.allapp.fragment.SingleFragmentActivity;

/**
 * @author Joephone on 2019/8/27 17:13
 * @E-Mail Address：joephonechen@gmail.com
 * @Desc
 * @Edition 1.0
 * @EditionHistory
 */

public class AllAppActivity extends SingleFragmentActivity {


    @Override
    protected Fragment createFragment() {
        return AllAppFragment.newInstance();
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_demo_all_app_ac;
    }


    @Override
    protected int getLayoutId() {
        return R.layout.activity_demo_all_app_ac;
    }

    @Override
    protected void initView() {

    }
}
