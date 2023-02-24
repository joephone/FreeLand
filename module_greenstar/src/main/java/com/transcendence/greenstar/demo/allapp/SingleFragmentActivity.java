package com.transcendence.greenstar.demo.allapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.transcendence.core.base.activity.BaseAc;
import com.transcendence.greenstar.R;

/**
 * @author Joephone on 2019/8/27 17:04
 * @E-Mail Address：joephonechen@gmail.com
 * @Desc
 * @Edition 1.0
 * @EditionHistory
 */

public abstract class SingleFragmentActivity extends BaseAc {
    //子类返回对应的Fragment对象
    protected abstract Fragment createFragment();

    //允许子类使用自己的布局来覆盖父类布局
//    @LayoutRes//该注解表示任何时候，该实 现方法都应该返回有效的布局资源ID
    protected abstract int getLayoutResId();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResId());

        FragmentManager fm=getSupportFragmentManager();

        Fragment fragment=fm.findFragmentById(R.id.frameContainer);
        if(fragment==null){
            fragment=createFragment();
            fm.beginTransaction().add(R.id.frameContainer,fragment).commit();
        }
    }
}
