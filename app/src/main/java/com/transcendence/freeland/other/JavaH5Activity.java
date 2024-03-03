package com.transcendence.freeland.other;

import android.annotation.SuppressLint;
import android.os.Build;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import android.widget.TextView;

import com.transcendence.core.base.common.activity.AppAc;
import com.transcendence.core.utils.log.LogUtils;
import com.transcendence.freeland.R;


public class JavaH5Activity extends AppAc {

    private WebView mWebview;
    private TextView tv,tv1;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_web;
    }

    /**
     * 初始化布局
     */
    @Override
    protected void initView() {
        LogUtils.d("initView");
        mWebview = findViewById(R.id.web_view);  //h5demo2.html  h5demo3
//        tv = findViewById(R.id.tv);
//        tv1 = findViewById(R.id.title);
        String url = "file:///android_asset/callback.html";
        mWebview.loadUrl(url);
        //1，js调用安卓
        mWebview.getSettings().setJavaScriptEnabled(true);//这里必须开启
        //把当前JavaH5Activity对象作为androidObject别名传递给js
        //js通过window.androidObject.androidMethod()就可以直接调用安卓的androidMethod方法
        mWebview.addJavascriptInterface(JavaH5Activity.this, "androidObject");


//        mWebview.setWebViewClient(new WebViewClient() {
//            @Override
//            public boolean shouldOverrideUrlLoading(WebView view, String url) {
//                L.d("拦截到的url：" + url);
//                //url如果以qiushi开头，就是h5和我们定义的传值协议
//                if (url.startsWith("qiushi")) {
//                    Uri uriRequest = Uri.parse(url);
//                    String scheme = uriRequest.getScheme();
//                    String action = uriRequest.getHost();
//                    String query = uriRequest.getQuery();
//                    if ("qiushi".equals(scheme)) {
//                        if (!TextUtils.isEmpty(query)) {
//                            //把url携带的参数存到一个map里
//                            HashMap maps = new HashMap();
//                            Set<String> names = uriRequest.getQueryParameterNames();
//                            for (String name : names) {
//                                maps.put(name, uriRequest.getQueryParameter(name));
//                            }
//                            JSONObject jsonObject = new JSONObject(maps);
//                            if ("setH5Info".equals(action)) {
//                                if (jsonObject != null && jsonObject.has("params")) {
//                                    String h5InfoParams = jsonObject.optString("params");
//                                    L.d( "拦截到的参数：" + h5InfoParams);
//                                }
//                            }
//                        }
//                    }
//                } else {
//                    view.loadUrl(url);
//                }
//                return true;
//            }
//        });


//        tv.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String jsonParams = "123456";
//                //String url = "javascript:jsMethod()";//不拼接参数，直接调用js的jsMethod函数
//                String urlTemp = "javascript:jsMethod(" + jsonParams + ")";//拼接参数，就可以把数据传递给js
//                mWebview.loadUrl(urlTemp);
//            }
//        });
//
//        tv1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//                    String jsonParams = "123456";
//                    //String method = "jsMethod()";//不拼接参数，直接调用js的jsMethod函数
//                    String method = "jsMethod(" + jsonParams + ")";//拼接参数，就可以把数据传递给js
//                    mWebview.evaluateJavascript(method, new ValueCallback<String>() {
//                        @Override
//                        public void onReceiveValue(String value) {
//                            LogUtils.d("js返回的数据" + value);
//                        }
//                    });
//                }
//            }
//        });
    }


    //js调用安卓，必须加@JavascriptInterface注释的方法才可以被js调用
    @JavascriptInterface
    public String androidMethod() {
        LogUtils.d("js调用了安卓的方法");
        return "我是js调用安卓获取的数据";
    }
}
