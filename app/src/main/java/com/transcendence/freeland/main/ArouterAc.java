package com.transcendence.freeland.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;

import com.transcendence.core.base.activity.AppAc;
import com.transcendence.core.base.activity.BaseAc;
import com.transcendence.core.base.route.RoutePath;
import com.transcendence.core.base.route.RouteUtils;
import com.transcendence.core.widget.menugroup.CircleMenuAdapter;
import com.transcendence.core.widget.menugroup.CircleMenuItem;
import com.transcendence.freeland.R;
import com.transcendence.freeland.databinding.ActivityArouterBinding;
import com.transcendence.freeland.main.image.SaveImageActivity;


import java.util.ArrayList;
import java.util.List;

/**
 * @author joephone
 * @date 2023/1/19
 * @desc
 */
public class ArouterAc extends AppAc {

    ActivityArouterBinding activityBinding;

    private List<CircleMenuItem> mMenuItems = new ArrayList<>();
    private String[] mItemTexts = new String[] { "App ", "GreenStar", "Music" };
    private int[] mItemImgs = new int[] { R.mipmap.ic_app_ten,
            R.mipmap.ic_app_green_star, R.mipmap.ic_app_music };


    @Override
    protected int getLayoutId() {
        return 0;
    }

    protected void initView() {
        mIsBackVisible = false;
        activityBinding = DataBindingUtil.setContentView(this, R.layout.activity_arouter);
        initData(mItemTexts, mItemImgs);
        //中心视图
        View centerView = LayoutInflater.from(this).inflate(R.layout.circle_menu_item_center,null,false);

        centerView.setOnClickListener(v ->  {
            SaveImageActivity.launch(this);
//            startAc(SaveZfPicAc.class);


        });

        activityBinding.circleMenuGroup.setAdapter(new CircleMenuAdapter(mMenuItems));
        activityBinding.circleMenuGroup.setCenterView(centerView);
        activityBinding.circleMenuGroup.setOnMenuItemClickListener((view, pos) ->  {
//            showToast(mItemTexts[pos]);
            switch (pos){
                case 1:
                    RouteUtils.navigationActivity(RoutePath.GreenStar.PAGER_MAIN);
                    break;
                case 2:
                    RouteUtils.navigationActivity(RoutePath.Gallery.PAGER_MAIN);
//                    RouteUtils.navigationActivity(RoutePath.Music.PAGER_MAIN);
                    break;
            }
        });
        activityBinding.circleMenuGroup.autoCycle();
    }

    private void initData(String[] mItemTexts, int[] mItemImgs) {
        if (mItemImgs==null && mItemTexts==null){
            throw new IllegalArgumentException("Text or Image not allow be null");
        }
        int count = mItemImgs==null ? mItemTexts.length: mItemImgs.length;
        if (mItemImgs!=null && mItemTexts!=null){
            count = Math.min(mItemImgs.length,mItemTexts.length);
        }

        for (int i=0;i<count;i++){
            mMenuItems.add(new CircleMenuItem(mItemImgs[i],mItemTexts[i]));
        }
    }
}
