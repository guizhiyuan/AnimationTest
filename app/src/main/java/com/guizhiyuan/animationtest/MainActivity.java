package com.guizhiyuan.animationtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mScaleAnimation;
    private Button mAlphaAnimation;
    private Button mRotateAnimation;
    private Button mTranslateAnimation;
    private Button mAnimationSet;
    private Button mAnimationLis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        mScaleAnimation = (Button) findViewById(R.id.mScaleAnimation);
        mScaleAnimation.setOnClickListener(this);
        mAlphaAnimation = (Button) findViewById(R.id.mAlphaAnimation);
        mAlphaAnimation.setOnClickListener(this);
        mRotateAnimation = (Button) findViewById(R.id.mRotateAnimation);
        mRotateAnimation.setOnClickListener(this);
        mTranslateAnimation = (Button) findViewById(R.id.mTranslateAnimation);
        mTranslateAnimation.setOnClickListener(this);
        mAnimationSet = (Button) findViewById(R.id.mAnimationSet);
        mAnimationSet.setOnClickListener(this);
        mAnimationLis = (Button) findViewById(R.id.mAnimationLis);
        mAnimationLis.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.mScaleAnimation:
                ScaleAnimation sa = new ScaleAnimation(0, 1, 0, 1);
                sa.setDuration(2000);
                mScaleAnimation.startAnimation(sa);
                break;
            case R.id.mAlphaAnimation:
                AlphaAnimation aa = new AlphaAnimation(0, 5);
                aa.setDuration(3000);
                mAlphaAnimation.startAnimation(aa);
                break;
            case R.id.mRotateAnimation:
                RotateAnimation ra = new RotateAnimation(0, 360, 100, 50);
                ra.setDuration(3000);
                mRotateAnimation.startAnimation(ra);
                break;
            case R.id.mTranslateAnimation:
                TranslateAnimation ta = new TranslateAnimation(0, 0, 60, 300);
                ta.setDuration(3000);
                mTranslateAnimation.startAnimation(ta);
                break;
            case R.id.mAnimationSet:
                AnimationSet as = new AnimationSet(true);
                RotateAnimation ra1 = new RotateAnimation(0, 360, 100, 50);
                ra1.setDuration(3000);
                as.addAnimation(ra1);
                TranslateAnimation ta1 = new TranslateAnimation(0, 0, 60, 300);
                ta1.setDuration(3000);
                as.addAnimation(ta1);
                mAnimationSet.startAnimation(as);
                break;
            case R.id.mAnimationLis:
                TranslateAnimation ta2 = new TranslateAnimation(0, 0, 50, 100);
                ta2.setDuration(3000);
                mAnimationLis.startAnimation(ta2);
                ta2.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        Toast.makeText(MainActivity.this, "Animation is listened!", Toast.LENGTH_LONG).show();

                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
        }
    }
}
