package com.transcendence.greenstar.main;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.transcendence.core.base.activity.BaseAc;
import com.transcendence.core.base.route.RoutePath;
import com.transcendence.greenstar.R;

@Route(path = RoutePath.GreenStar.PAGER_MAIN)
public class GreenStarMainActivity extends BaseAc {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_green_star);
    }
}