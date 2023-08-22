package com.transcendence.greenstar.demo.appinfo.act;

import com.transcendence.core.base.common.activity.AppAc;
import com.transcendence.greenstar.R;
import com.transcendence.greenstar.demo.appinfo.bean.AppInfoItem;

/**
 * @author joephone
 * @date 2023/4/27
 * @desc
 */
public class AppInfoDetailsAc extends AppAc {

    // app 信息 Item
    private AppInfoItem appInfoItem;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_demo_appinfo_details;
    }

    @Override
    protected void initView() {
        initOperate();
        initListeners();
    }


    /** 初始化操作 */
    private void initOperate(){
//        try {
//            // 解析获取数据
//            appInfoItem = AppInfoItem.obtain(getIntent().getStringExtra(KeyConstants.KEY_PACKNAME));
//        } catch (Exception e){
//            LogUtils.e( "initOperate"+e );
//        }
//        if (appInfoItem == null){
//            // 提示获取失败
//            showMsg(R.string.get_appinfo_fail);
//            finish(); // 销毁页面
//            return;
//        }
//        // 刷新数据
//        refData();
//        // == 处理 ActionBar
//        // https://blog.csdn.net/andygo_520/article/details/51439688
//        // https://blog.csdn.net/zouchengxufei/article/details/51199922
//        setSupportActionBar(aad_toolbar);
//        ActionBar actionBar =  getSupportActionBar();
//        if(actionBar != null) {
//            // 给左上角图标的左边加上一个返回的图标
//            actionBar.setDisplayHomeAsUpEnabled(true);
//            // 对应ActionBar.DISPLAY_SHOW_TITLE
//            actionBar.setDisplayShowTitleEnabled(false);
//        }
    }

    /** 初始化事件 */
    private void initListeners(){
//        // 打开应用
//        aad_openapp_tv.setOnClickListener(this);
//        // 卸载应用
//        aad_uninstall_tv.setOnClickListener(this);
//        // 设置点击事件
//        aad_toolbar.setNavigationOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // 关闭页面
//                finish();
//            }
//        });
//        // 注册观察者模式
//        BaseApplication.sDevObservableNotify.registerObserver(this, new DevObserverNotify(this) {
//            @Override
//            public void onNotify(int nType, Object... args) {
//                switch (nType){
//                    case NotifyConstants.H_EXPORT_APP_MSG_NOTIFY:
//                        // 发送通知
//                        vHandler.sendEmptyMessage(nType);
//                        break;
//                    case NotifyConstants.H_EXPORT_APP_NOTIFY:
//                        // 发送通知
//                        vHandler.sendEmptyMessage(nType);
//                        break;
//                }
//            }
//        });
    }
}
