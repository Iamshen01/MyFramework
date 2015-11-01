package com.pl.higotest.actitity;


import java.util.ArrayList;
import java.util.List;


import com.pl.higotest.R;
import com.pl.higotest.actitity.account.AccountFragment;
import com.pl.higotest.actitity.home.HomeFragment;
import com.pl.higotest.actitity.order.OrderFragment;
import com.pl.higotest.extension.BaseActivity;
import com.pl.higotest.view.MyViewPager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.widget.CompoundButton;
import android.widget.RadioButton;

public class MainActivity extends BaseActivity	 {
	
	private static final String TAG = "MainActivity";

	private MyViewPager myViewPager;
	private List<Fragment> fragments = new ArrayList<Fragment>();
    private int[] tab_ids = new int[]{ R.id.rb_tab_home, R.id.rb_tab_order, R.id.rb_tab_account };
    private List<RadioButton> tabList = new ArrayList<RadioButton>();


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		
		myViewPager = (MyViewPager)findViewById(R.id.mvp_tab);
		
		OnTabChangeListener listener = new OnTabChangeListener();
		for (int i : tab_ids) {
			RadioButton rb = (RadioButton)findViewById(i);
			rb.setOnCheckedChangeListener(listener);
			tabList.add(rb);
		}
		
		fragments.add(new HomeFragment());
		fragments.add(new OrderFragment());
		fragments.add(new AccountFragment());
		FragmentPagerAdapter adapter = new FragmentPagerAdapter(getSupportFragmentManager()){

			@Override
			public Fragment getItem(int arg0) {
				// TODO Auto-generated method stub
				return fragments.get(arg0);
			}

			@Override
			public int getCount() {
				// TODO Auto-generated method stub
				return fragments.size();
			}
			
		};
		myViewPager.setAdapter(adapter);
		myViewPager.addOnPageChangeListener(new OnPageChangeListener() {
			
			@Override
			public void onPageSelected(int arg0) {
				// TODO Auto-generated method stub
				tabList.get(arg0).setChecked(true);
			}
			
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub
			}
			
			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub
				
			};
		});
		
	}
	
	private class OnTabChangeListener implements CompoundButton.OnCheckedChangeListener
    {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (isChecked) {
                int position = tabList.indexOf(buttonView);
                myViewPager.setCurrentItem(position);
            }
        }
    }
}
