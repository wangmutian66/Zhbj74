package com.example.administrator.zhbj74;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.LinearLayout;

public class SplashActivity extends AppCompatActivity {

    private LinearLayout rl_root;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        rl_root = (LinearLayout) findViewById(R.id.rl_root);

        RotateAnimation animation= new RotateAnimation(0,360, Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f); // 旋转动画
        animation.setDuration(1000); //动画时间

    }
}
