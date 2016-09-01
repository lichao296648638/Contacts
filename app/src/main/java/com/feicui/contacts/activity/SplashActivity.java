package com.feicui.contacts.activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;

import com.feicui.contacts.R;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

/**
 * @author Neal 2016-08-25
 * @description 开屏页
 */
public class SplashActivity extends BaseActivity {
    //开屏页图片
    ImageView iv_splash;
    //淡入动画
    AlphaAnimation alphaAnim;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected int setContent() {

        return R.layout.activity_splash;
    }

    @Override
    protected void initView() {
        iv_splash = (ImageView) findViewById(R.id.iv_splash);
    }

    @Override
    protected void setListener() {

    }

    /**
     * @description 加载动画
     */
    private void initAnimation() {
        //淡入动画
        alphaAnim = new AlphaAnimation(0f, 1f);
        //设置动画时间
        alphaAnim.setDuration(3000);
        //设置动画播放结束后的监听
        alphaAnim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                //跳转到主页
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                //关闭开屏页
                finish();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        //开启动画
        iv_splash.startAnimation(alphaAnim);
    }

    /**
     * 当前页是否已获得焦点
     *
     * @param hasFocus true代表获得焦点，false相反
     */
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            initAnimation();
        }
    }



}
