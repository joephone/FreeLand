package com.transcendence.greenstar.demo.permissionx

import android.os.Bundle
import android.view.View
import com.transcendence.core.base.activity.BasePermissionsActivity
import com.transcendence.core.utils.log.LogUtils
import com.transcendence.greenstar.R

/**
 * @author joephone
 * @date 2023/6/13
 * @desc
 */
class PermissionxKt : BasePermissionsActivity() {

    /**
     * 获取布局 ID
     */
    override fun getLayoutId(): Int {
        return R.layout.activity_demo_permissionx
    }

    /**
     * 初始化数据
     */
    override fun initView() {
        findViewById<View>(R.id.tv_checkCallPermission).setOnClickListener {
            callPhone(
                "123456789"
            )
        }

        findViewById<View>(R.id.tv_checkStorePermission).setOnClickListener {
            applyCameraOrExternalStorage { isGranted ->
                if(isGranted) {
                    LogUtils.d("已授权")
                } else {
                    LogUtils.d("拐子呃，您家授权啊")
                }
            }
        }

        findViewById<View>(R.id.tv_checkInstallPermission).setOnClickListener {
            applyInstallPermissions { isGranted ->
                if(isGranted) {
                    LogUtils.d("已授权")
                } else {
                    LogUtils.d("拐子呃，您家授权啊")
                }
            }
        }

        findViewById<View>(R.id.tv_checkLocationPermission).setOnClickListener {
            applyLocationPermissions { isGranted ->
                if(isGranted) {
                    LogUtils.d("已授权")
                } else {
                    LogUtils.d("拐子呃，您家授权啊")
                }
            }
        }
    }


//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_demo_permissionx)
//
//
//
//    }


}