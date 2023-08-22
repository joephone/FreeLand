package com.transcendence.greenstar.demo.bing;

import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.widget.AppCompatSpinner;

import com.transcendence.core.base.common.activity.AppAc;
import com.transcendence.greenstar.R;

public class BingActivity extends AppAc {

    private static String sBingUrl = "http://cn.bing.com/HPImageArchive.aspx?idx=0&n=1";
    private static final String BING = "http://cn.bing.com";
    private AppCompatSpinner mResolutionSpinner;
    private ImageView mImageView;



    @Override
    protected int getLayoutId() {
        return R.layout.activity_demo_bing;
    }

    protected void initView() {
        Button getPicBtn = findViewById(R.id.get_picture);
        Button getPicOkBtn = findViewById(R.id.get_picture_okhttp);
        mResolutionSpinner = findViewById(R.id.resolution_spinner);
        mImageView = findViewById(R.id.bing_picture);
        getPicBtn.setOnClickListener(v ->{
            //                HttpUtil.sendHttpRequest(sBingUrl, new HttpCallbackListener() {
//                    @Override
//                    public void finish(String response) {
//                        final StringBuilder picUrl = new StringBuilder();
//                        picUrl.append(BING);
//                        picUrl.append(XMLParseUtil.parseWithPull(response));
//                        picUrl.append(mResolutionSpinner.
//                                getSelectedItem().toString() + ".jpg");
//                        runOnUiThread(new Runnable() {
//                            @Override
//                            public void run() {
//                                Glide.with(MainActivity.this).
//                                        load(picUrl.toString()).into(mImageView);
//                            }
//                        });
//
//                    }
//
//                    @Override
//                    public void error(Exception e) {
//
//                    }
//                });
        });
        getPicOkBtn.setOnClickListener(v ->{
//            HttpUtil.sendOkHttpRequest(sBingUrl, new Callback() {
//                @Override
//                public void onFailure(Call call, IOException e) {
//
//                }
//
//                @Override
//                public void onResponse(Call call, Response response) throws IOException {
//                    String body = response.body().string();
//                    final StringBuilder picUrl = new StringBuilder();
//                    picUrl.append(BING);
//                    picUrl.append(XMLParseUtil.parseWithSax(body));
//                    picUrl.append(mResolutionSpinner.
//                            getSelectedItem().toString() + ".jpg");
//                    runOnUiThread(new Runnable() {
//                        @Override
//                        public void run() {
//                            Glide.with(MainActivity.this)
//                                    .load(picUrl.toString()).into(mImageView);
//                        }
//                    });
//                }
//            });
        });
    }


}
