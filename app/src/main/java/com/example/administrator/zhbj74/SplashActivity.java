package com.example.administrator.zhbj74;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.content.SharedPreferencesCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.LinearLayout;

import com.example.administrator.zhbj74.utils.PrefUtils;

public class SplashActivity extends AppCompatActivity {

    private LinearLayout rl_root;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        rl_root = (LinearLayout) findViewById(R.id.rl_root);

        //旋转动画
        RotateAnimation animation= new RotateAnimation(0,360, Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f); // 旋转动画
        animation.setDuration(1000); //动画时间
        animation.setFillAfter(true);

        //缩放动画
        ScaleAnimation animScale=new ScaleAnimation(0,1,0,1, Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        animScale.setDuration(1000);
        animScale.setFillAfter(true);

        //渐变
        AlphaAnimation animAlpha=new AlphaAnimation(0,1);
        animAlpha.setDuration(2000);
        animAlpha.setFillAfter(true);

        //动画结合
        AnimationSet set=new AnimationSet(true);
        set.addAnimation(animation);
        set.addAnimation(animScale);
        set.addAnimation(animAlpha);
        //启动动画
        rl_root.startAnimation(set);


        set.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                //动画结束
                //如果是第一次进入，跳新手引导
                //否则跳主页面
                //SharedPreferences sp=getSharedPreferences("config",MODE_PRIVATE); sp.getBoolean("is_first_enter",true);
                boolean isFirst= PrefUtils.getBoolean(SplashActivity.this,"is_first_enter",true);
                Intent intent;
                if(isFirst){
                    //新手引导
                    intent=new Intent(getApplicationContext(),GuaideActivity.class);

                }else{
                    //主界面
                    intent=new Intent(getApplicationContext(),MainActivity.class);
                }

                startActivity(intent);
                finish();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

    }
}
