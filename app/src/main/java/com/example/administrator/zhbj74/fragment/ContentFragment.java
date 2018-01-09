package com.example.administrator.zhbj74.fragment;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.zhbj74.R;
import com.example.administrator.zhbj74.base.BasePager;
import com.example.administrator.zhbj74.base.impl.GovAffairsPager;
import com.example.administrator.zhbj74.base.impl.HomePager;
import com.example.administrator.zhbj74.base.impl.NewsCenterPager;
import com.example.administrator.zhbj74.base.impl.SettingPager;
import com.example.administrator.zhbj74.base.impl.SmartServicePager;

import java.util.ArrayList;

/**
 * Created by Administrator on 2018/1/2.
 */

public class ContentFragment extends BaseFragment {
    private ArrayList<BasePager> basePagers;
    private ViewPager vp_content;
    @Override
    public View initView() {


        View view=View.inflate(mActivity,R.layout.fragment_content,null);
        vp_content = view.findViewById(R.id.vp_content);

        return view;
    }

    @Override
    public void initData() {
        basePagers=new ArrayList<BasePager>();
        basePagers.add(new HomePager(mActivity));
        basePagers.add(new NewsCenterPager(mActivity));
        basePagers.add(new SmartServicePager(mActivity));
        basePagers.add(new GovAffairsPager(mActivity));
        basePagers.add(new SettingPager(mActivity));


        vp_content.setAdapter(new ContentAdatar());
    }

    class ContentAdatar extends PagerAdapter{

        @Override
        public int getCount() {
            return basePagers.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            BasePager mpager = basePagers.get(position);
            View view = mpager.mrootView;
            container.addView(view);
            return view;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            super.destroyItem(container, position, object);
            container.removeView((View) object);
        }
    }

}
