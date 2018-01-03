package com.example.administrator.zhbj74.base.impl;

import android.app.Activity;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.example.administrator.zhbj74.R;
import com.example.administrator.zhbj74.base.BasePager;

/**
 * 首页
 * Created by Administrator on 2018/1/3.
 */

public class HomePager extends BasePager {

    public HomePager(Activity activity) {
        super(activity);
    }


    @Override
    public void initData() {
//        TextView view=new TextView(activity);
//        view.setText("首页");
//        view.setTextColor(Color.RED);
//        view.setTextSize(22);
//        view.setGravity(Gravity.CENTER);
//        flContent.addView(view);

        View view=View.inflate(activity, R.layout.activity_home,null);
        flContent.addView(view);


    }
}
