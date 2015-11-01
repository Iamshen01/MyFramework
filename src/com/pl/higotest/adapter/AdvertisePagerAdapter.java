package com.pl.higotest.adapter;

import java.util.List;


import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;

public class AdvertisePagerAdapter extends PagerAdapter {
	
	private List<ImageView> imgList;
	
	public AdvertisePagerAdapter(List<ImageView> list)
	{
		imgList = list;
	}
	
	@Override
    public int getCount() {
        return imgList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object ;
    }

    @Override
    public void destroyItem(View arg0, int arg1, Object arg2) {
        ((ViewPager) arg0).removeView((View)arg2);
    }

    @Override
    public Object instantiateItem(View arg0, int arg1) {
        View imgView = imgList.get(arg1);
        ((ViewPager) arg0).addView(imgView);
        return imgView;
    }

}
