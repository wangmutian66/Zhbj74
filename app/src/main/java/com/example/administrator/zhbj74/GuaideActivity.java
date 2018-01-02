package com.example.administrator.zhbj74;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.administrator.zhbj74.utils.PrefUtils;

import java.util.ArrayList;

/**
 * 新手引导页面
 * Created by Administrator on 2018/1/2.
 */

public class GuaideActivity extends Activity {

    private ViewPager mViewPager;
    private ArrayList<ImageView> mimageViewList;
    private int[] mImageId=new int[]{R.drawable.guide_1,R.drawable.guide_2,R.drawable.guide_3};
    private LinearLayout ll_container;
    private ImageView redpoint;
    //小红点移动距离
    private int mPointDis;
    private int dis;
    private Button btnStart;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_guaide);
        mViewPager=(ViewPager)findViewById(R.id.vp_guaide);
        ll_container=(LinearLayout)findViewById(R.id.ll_container);
        redpoint=findViewById(R.id.redpoint);
        btnStart=findViewById(R.id.btn_start);


        initData(); //先初始化
        mViewPager.setAdapter(new GuaideAdapter()); //在设置数据
        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                //position 当前位置  positionOffset 移动偏移的百分比
                //页面滑动中的回调
                dis= (int) (mPointDis*positionOffset) + position*mPointDis;
                RelativeLayout.LayoutParams params= (RelativeLayout.LayoutParams) redpoint.getLayoutParams();
                params.leftMargin=dis;
                redpoint.setLayoutParams(params);

            }

            @Override
            public void onPageSelected(int position) {
                //某个页面被选中
                if(position == (mimageViewList.size() - 1)){
                    btnStart.setVisibility(View.VISIBLE);
                }else{
                    btnStart.setVisibility(View.INVISIBLE);
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {


            }
        });


        //视图树
        redpoint.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                redpoint.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                //layout 方法执行结束的回调

                mPointDis=ll_container.getChildAt(1).getLeft()-ll_container.getChildAt(0).getLeft();
                System.out.println("小圆点："+mPointDis);
            }
        });


        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //更新sp
                PrefUtils.setBoolean(GuaideActivity.this,"is_first_enter",false);


                Intent i=new Intent(GuaideActivity.this,MainActivity.class);
                startActivity(i);
                finish();
            }
        });

    }

    //初始化数据
    private void initData(){
        mimageViewList=new  ArrayList<ImageView>();
        for(int i=0;i<mImageId.length;i++){
            ImageView view = new ImageView(this);
            view.setBackgroundResource(mImageId[i]);
            mimageViewList.add(view);

            ImageView dian = new ImageView(this);
            dian.setImageResource(R.drawable.shape_point_gray);
            //布局参数初始化，宽高包裹内容，父控件是谁 就是谁声明的布局参数
            LinearLayout.LayoutParams param=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            // 设置左边距
            if(i > 0){
                param.leftMargin=10;
            }
            dian.setLayoutParams(param); //设置布局参数
            ll_container.addView(dian);

        }
    }

    class GuaideAdapter extends PagerAdapter{

        @Override
        public int getCount() {
            return mimageViewList.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {

            return view==object;
        }


        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            ImageView image=mimageViewList.get(position);
            container.addView(image);

            return image;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }


}
