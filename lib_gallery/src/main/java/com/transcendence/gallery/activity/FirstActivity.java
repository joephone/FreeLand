package com.transcendence.gallery.activity;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.viewpager.widget.ViewPager;

import com.transcendence.core.base.activity.AppAc;
import com.transcendence.gallery.R;
import com.transcendence.gallery.animations.EnterScreenAnimations;
import com.transcendence.gallery.animations.ExitScreenAnimations;
import com.transcendence.gallery.lib.GalleryImageView;

public class FirstActivity extends AppAc {

    private GalleryImageView scrollGalleryView;
    private ImageView mTransitionImage;
    private EnterScreenAnimations mEnterScreenAnimations;
    private ExitScreenAnimations mExitScreenAnimations;
    private TextView tag;


    @SuppressLint("SetTextI18n")
    private void initThis(){
        tag.setText(1+  "/" + 16);
        scrollGalleryView
                //设置viewPager底部缩略图大小尺寸
                .setThumbnailSize(200)
                //设置是否支持缩放
                .setZoom(true)
                //设置缩放的倍数
                .setZoomSize(3)
                //设置是否隐藏底部缩略图
                .hideThumbnails(false)
                //设置FragmentManager
                .setFragmentManager(getSupportFragmentManager())
                //添加滑动事件，也可以不用添加
                .addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                    @Override
                    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                    }

                    @SuppressLint("SetTextI18n")
                    @Override
                    public void onPageSelected(int position) {
                        scrollGalleryView.setCurrentItem(position);
                        tag.setText((position + 1) + "/" + 16);
                    }

                    @Override
                    public void onPageScrollStateChanged(int state) {

                    }
                })
                //添加单张图片
                .addBitmap(toBitmap(R.drawable.image1))
                .addBitmap(toBitmap(R.drawable.image1))
                .addBitmap(toBitmap(R.drawable.image1))
                .addBitmap(toBitmap(R.drawable.image1))
                .addBitmap(toBitmap(R.drawable.image1))
                .addBitmap(toBitmap(R.drawable.image1))
                .addBitmap(toBitmap(R.drawable.image1))
                .addBitmap(toBitmap(R.drawable.beauty01))
                .addBitmap(toBitmap(R.drawable.beauty02))
                .addBitmap(toBitmap(R.drawable.beauty03))
                .addBitmap(toBitmap(R.drawable.beauty04))
                .addBitmap(toBitmap(R.drawable.beauty05))
                .addBitmap(toBitmap(R.drawable.beauty06))
                .addBitmap(toBitmap(R.drawable.beauty07))
                .addBitmap(toBitmap(R.drawable.beauty08))
                .addBitmap(toBitmap(R.drawable.beauty09));
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_first;
    }

    @Override
    protected void initView() {
        scrollGalleryView = findViewById(R.id.scroll_gallery_view);
        final RelativeLayout mainContainer = findViewById(R.id.main_container);
        tag = findViewById(R.id.tag);
        FrameLayout androidContent = getWindow().getDecorView().findViewById(android.R.id.content);
        mTransitionImage = new ImageView(this);
        androidContent.addView(mTransitionImage);

        mEnterScreenAnimations = new EnterScreenAnimations(mTransitionImage, scrollGalleryView, mainContainer);
        mExitScreenAnimations = new ExitScreenAnimations(mTransitionImage, scrollGalleryView, mainContainer);


        final int[] finalLocationOnTheScreen = new int[2];
        scrollGalleryView.getLocationOnScreen(finalLocationOnTheScreen);
        initThis();
        mEnterScreenAnimations.playEnteringAnimation(
                finalLocationOnTheScreen[0], // left
                finalLocationOnTheScreen[1], // top
                scrollGalleryView.getWidth(),
                scrollGalleryView.getHeight());
    }

    private Bitmap toBitmap(int image) {
        return ((BitmapDrawable) getResources().getDrawable(image)).getBitmap();
    }
}
