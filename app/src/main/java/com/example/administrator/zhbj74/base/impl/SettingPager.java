package com.example.administrator.zhbj74.base.impl;

import android.app.Activity;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.TextView;

import com.example.administrator.zhbj74.base.BasePager;

/**
 * 首页
 * Created by Administrator on 2018/1/3.
 */

public class SettingPager extends BasePager {

    public SettingPager(Activity activity) {
        super(activity);
    }


    @Override
    public void initData() {
        TextView view=new TextView(activity);
        view.setText("设置");
        view.setTextColor(Color.RED);
        view.setTextSize(22);
        view.setGravity(Gravity.CENTER);
        flContent.addView(view);
    }
}
