package com.transcendence.greenstar.main;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.transcendence.core.base.activity.BaseAc;
import com.transcendence.core.base.route.RoutePath;
import com.transcendence.greenstar.R;


public class GreenStarMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_green_star);
    }
}