package com.transcendence.greenstar.demo.exportlog.logcat

import android.widget.TextView
import com.transcendence.core.base.activity.AppAc
import com.transcendence.greenstar.R

/**
 * @author joephone
 * @date 2023/6/15
 * @desc 导出日志
 */
class LogcatKt :AppAc() {

    var mTvExport : TextView? =null
    /**
     * 获取布局 ID
     */
    override fun getLayoutId(): Int {
        return R.layout.activity_demo_exportlog_logcat
    }

    /**
     * 初始化数据
     */
    override fun initView() {
        LogModule.init(this)
        mTvExport = findViewById(R.id.btn_export)
        mTvExport?.setOnClickListener {
            LogModule.openCollectSystemLog(this)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        LogModule.closeCollectSystemLog(this)
    }
}