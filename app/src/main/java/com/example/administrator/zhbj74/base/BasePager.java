package com.example.administrator.zhbj74.base;

import android.app.Activity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.administrator.zhbj74.R;

/**
 * Created by Administrator on 2018/1/3.
 */

public class BasePager {

    public Activity activity;

    public TextView tvTitle;
    public ImageButton btnMenu;
    public FrameLayout flContent;
    public View mrootView;

    public BasePager(Activity activity){
        this.activity=activity;
        mrootView=initView();
    }

    //初始化我们的布局
    public View initView(){

        View view=View.inflate(activity,R.layout.base_pager,null);
        tvTitle=view.findViewById(R.id.tv_title);
        btnMenu=view.findViewById(R.id.btn_menu);
        flContent=view.findViewById(R.id.fl_content);


        return view;
    }

    //初始化数据
    public void initData(){

    }



}
