package com.transcendence.freeland.main;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.transcendence.core.base.activity.BaseAc;
import com.transcendence.freeland.R;

public class MainActivity extends BaseAc {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}