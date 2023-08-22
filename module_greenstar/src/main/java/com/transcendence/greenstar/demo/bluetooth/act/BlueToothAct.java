package com.transcendence.greenstar.demo.bluetooth.act;

import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.transcendence.core.base.common.activity.AppAc;
import com.transcendence.greenstar.R;
import com.transcendence.greenstar.demo.bluetooth.adapter.ViewPagerAdapter;
import com.transcendence.greenstar.demo.bluetooth.fragment.BlueToothFragment;
import com.transcendence.greenstar.demo.bluetooth.fragment.SettingFragment;

/**
 * @author joephone
 * @date 2023/8/7
 * @desc
 */
public class BlueToothAct extends AppAc {

    public static final int BLUE_TOOTH_DIALOG = 0x111;
    public static final int BLUE_TOOTH_TOAST = 0x123;
    public static final int BLUE_TOOTH_WRAITE = 0X222;
    public static final int BLUE_TOOTH_READ = 0X333;
    public static final int BLUE_TOOTH_WRAITE_FILE_NOW = 0X511;
    public static final int BLUE_TOOTH_READ_FILE_NOW = 0X996;
    public static final int BLUE_TOOTH_WRAITE_FILE = 0X555;
    public static final int BLUE_TOOTH_READ_FILE = 0X888;
    public static final int BLUE_TOOTH_SUCCESS = 0x444;

    private ViewPager viewPager;
    private MenuItem menuItem;
    private BottomNavigationView bottomNavigationView;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            if(item.getItemId()== R.id.navigation_home){
                viewPager.setCurrentItem(0);
            }else {
                viewPager.setCurrentItem(1);
            }
            return false;
        }
    };

    @Override
    protected int getLayoutId() {
        return R.layout.activity_demo_bluetooth;
    }

    @Override
    protected void initView() {
//        setTitle("蓝牙即时通讯");
        bottomNavigationView = findViewById(R.id.navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        viewPager = findViewById(R.id.viewpager);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                if (menuItem != null) {
                    menuItem.setChecked(false);
                } else {
                    bottomNavigationView.getMenu().getItem(0).setChecked(false);
                }
                menuItem = bottomNavigationView.getMenu().getItem(position);
                menuItem.setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
        setupViewPager(viewPager);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new BlueToothFragment());
        adapter.addFragment(new SettingFragment());
        viewPager.setAdapter(adapter);
    }
}
