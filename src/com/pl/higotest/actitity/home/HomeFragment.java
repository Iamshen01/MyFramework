package com.pl.higotest.actitity.home;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.pl.higotest.R;
import com.pl.higotest.R.string;
import com.pl.higotest.actitity.TitleFragment;
import com.pl.higotest.adapter.AdvertisePagerAdapter;
import com.pl.higotest.adapter.ShopListAdapter;
import com.pl.higotest.api.AdvertiseApi;
import com.pl.higotest.api.ShopApi;
import com.pl.higotest.extension.BaseFragment;
import com.pl.higotest.extension.LoadingCallBack;
import com.pl.higotest.model.AdvertiseInfo;
import com.pl.higotest.model.ShopInfo;
import com.pl.higotest.util.LogUtils;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.view.ViewGroup;

public class HomeFragment extends BaseFragment {
	
	public static final String TAG = "HomeFragment";
	
	private ViewPager vp_advertise;
	private PullToRefreshListView plv_shop;
	
	private ShopListAdapter shopListAdapter;
	
	private List<ImageView> mAdvertiseList = new ArrayList<ImageView>();
	private List<ShopInfo> mShopList = new ArrayList<ShopInfo>();
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_home, container, false);
		plv_shop = (PullToRefreshListView)view.findViewById(R.id.plv_shop);
		vp_advertise = (ViewPager)inflater.inflate(R.layout.viewpage_advertise, plv_shop.getRefreshableView(), false);		
		
		initAdvertise();
		
		FragmentManager manage= getFragmentManager();
		TitleFragment fragment_title = TitleFragment.newInstance(string.title_fragment_home, 0, R.drawable.selector_home_title_search);
		fragment_title.setOnRightClickLinstener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
		});
		FragmentTransaction transaction = manage.beginTransaction();
		transaction.add(R.id.fl_title_home, fragment_title);
		transaction.commit();
		return view;
	}
	
	protected void initAdvertise()
	{
		AdvertisePagerAdapter adapter = new AdvertisePagerAdapter(mAdvertiseList);
		vp_advertise.setAdapter(adapter);
		ListView lv_shop = plv_shop.getRefreshableView();
		lv_shop.addHeaderView(vp_advertise);
		initShop();
	}
	
	protected void initShop()
	{
		shopListAdapter = new ShopListAdapter(getActivity(), mShopList);
		plv_shop.setAdapter(shopListAdapter);
		plv_shop.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				// TODO Auto-generated method stub
				ShopInfo info = (ShopInfo)plv_shop.getRefreshableView().getAdapter().getItem(position);
				LogUtils.d(TAG, info.getShopID());
				Intent intent = new Intent(HomeFragment.this.getActivity());
				HomeFragment.this.getActivity().startActivity(intent);
			}
			
		});
		getShop();
	}
	
	protected void getShop()
	{
		ShopApi shopApi = new ShopApi();
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("latitude", 22.556217);
		param.put("longitude", 113.915842);
		param.put("currentLatitude", 22.556217);
		param.put("currentLongitude", 113.915842);
		
		shopApi.getShopList(param, new LoadingCallBack<List<ShopInfo>>(getBaseActivity().getProgressDialog()){
			@Override
			public void onSuccess(List<ShopInfo> list)
			{
				LogUtils.d("list", String.valueOf(list.size()));
				for (ShopInfo shopInfo : list) {
					LogUtils.d("ShopLogo", shopInfo.getShopLogo());
				}
				refeshShop(list);
				getAdvertise();
			}
		});
	}
	
	protected void refeshShop(List<ShopInfo> list)
	{
		shopListAdapter.setList(list);
		shopListAdapter.notifyDataSetChanged();
	}
	
	protected void getAdvertise()
	{
		AdvertiseApi advertiseApi = new AdvertiseApi();
		Map<String, Object> param = null;//new HashMap<String, Object>();
		advertiseApi.getAdvertiseList(param, new LoadingCallBack<List<AdvertiseInfo>>(getBaseActivity().getProgressDialog()){
			@Override
			public void onSuccess(List<AdvertiseInfo> list)
			{
				LogUtils.d("list", String.valueOf(list.size()));
				for (AdvertiseInfo advertiseInfo : list) {
					LogUtils.d("ImageUrl", advertiseInfo.getImageUrl());
				}
				refeshAdvertise(list);
			}
		});
	}
	
	protected void refeshAdvertise(List<AdvertiseInfo> list)
	{
		ImageLoader imageLoader = ImageLoader.getInstance();
		
		ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
		for (AdvertiseInfo advertiseInfo : list) {
			ImageView imageView = new ImageView(getActivity());
			imageView.setLayoutParams(params);
			mAdvertiseList.add(imageView);
			imageLoader.displayImage(advertiseInfo.getImageUrl(), imageView);
		}
		vp_advertise.getAdapter().notifyDataSetChanged();
	}
}
