package com.transcendence.greenstar.blankj;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;

import com.transcendence.core.base.activity.BaseAc;
import com.transcendence.greenstar.R;

import java.util.List;

/**
 * @author joephone
 * @date 2023/2/11
 * @desc
 */
public class AppActivity extends BaseAc implements AdapterView.OnItemClickListener {

    private ArrayAdapter<String> adapter;
    private ListView lvIndex;
    List<String> items;

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//        Intent intent = new Intent();
//        intent.setClass(mActivity, AppConstantValue.launchModeIndex[position]);
//        startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);
        lvIndex = findViewById(R.id.lvIndex);

//        List<String> items = StringUtils.getStringList(mActivity,R.array.launch_mode_index_item);
        adapter = new ArrayAdapter<>(mActivity,
                android.R.layout.simple_list_item_1, items);
        lvIndex.setAdapter(adapter);
        lvIndex.setOnItemClickListener(this);
    }

}
