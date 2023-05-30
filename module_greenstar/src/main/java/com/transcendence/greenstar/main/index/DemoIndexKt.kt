package com.transcendence.greenstar.main.index

import android.widget.ListView
import com.transcendence.core.base.activity.AppAc
import com.transcendence.greenstar.R

/**
 * @author joephone
 * @date 2023/3/23
 * @desc
 */
class DemoIndexKt : AppAc() {

    private lateinit var lvList: ListView

    override fun getLayoutId(): Int {

        return R.layout.activity_index
    }

    override fun initView() {

    }
}