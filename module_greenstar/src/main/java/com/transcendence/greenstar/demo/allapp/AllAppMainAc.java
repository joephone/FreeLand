package com.transcendence.greenstar.demo.allapp;

import android.view.MenuItem;

import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;
import com.transcendence.core.base.activity.AppAc;
import com.transcendence.greenstar.R;

/**
 * @author joephone
 * @date 2023/2/27
 * @desc
 */
public class AllAppMainAc extends AppAc {

    NavigationView am_nav_view;
    DrawerLayout mDrawerLayout;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main_all_app;
    }

    @Override
    protected void initView() {
        // 初始化操作
//        initOperate();
        // 初始化事件
        initListeners();
    }

    private void initListeners() {
        am_nav_view = findViewById(R.id.am_nav_view);
        mDrawerLayout = findViewById(R.id.drawer_layout);
        // 设置Item 点击事件
        am_nav_view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener(){
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                if(item.getItemId() == R.id.nav_user_apps){
                    toggleFragment(0);
                    setTitle(R.string.user_apps);
                }else if(item.getItemId() == R.id.nav_system_apps){
                    toggleFragment(1);
                    setTitle(R.string.system_apps);
                }else if(item.getItemId() == R.id.nav_phone_info){
                    toggleFragment(2);
                    setTitle(R.string.phone_info);
                }else if(item.getItemId() == R.id.nav_screen_info){
                    toggleFragment(3);
                    setTitle(R.string.screen_info);
                }else if(item.getItemId() == R.id.nav_query_apk){
                    toggleFragment(4);
                    setTitle(R.string.query_apk);
                }else if(item.getItemId() == R.id.nav_setting){
                    toggleFragment(5);
                    setTitle(R.string.setting);
                }
                mDrawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });
    }

    /**
     * 切换 Fragment 处理
     * @param mPos
     */
    private void toggleFragment(int mPos) {
        // 判断是否想等
//        if (mPos != mFragmentPos){
//            // 初始化添加对应的布局
//            FragmentTransaction fragmentTransaction = fgManager.beginTransaction();
//            // 判断准备显示的 Fragment
//            BaseFragment fragment = mFragments.get(mPos);
//            // 如果默认未初始化, 则直接显示
//            if (mFragmentPos < 0){
//                fragmentTransaction.show(fragment).commit();
//            } else {
//                fragmentTransaction.hide(mFragments.get(mFragmentPos)).show(fragment).commit();
//            }
//            // 重新保存索引
//            mFragmentPos = mPos;
//            // 保存新的索引
//            mMenuPos = mPos;
//            // 切换改变处理
//            toggleChange();
//        }
    }
}
