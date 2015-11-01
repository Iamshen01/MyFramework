package com.pl.higotest.actitity.home;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.pl.higotest.R;
import com.pl.higotest.adapter.CategoryListAdapter;
import com.pl.higotest.api.CategoryApi;
import com.pl.higotest.extension.BaseFragment;
import com.pl.higotest.extension.LoadingCallBack;
import com.pl.higotest.model.CategoryInfo;
import com.pl.higotest.util.LogUtils;

public class CategoryListFragment extends BaseFragment {
	
	
	ListView lv_category_list;
	List<CategoryInfo> mCategoryList = new ArrayList<CategoryInfo>();
	CategoryListAdapter mCategoryListAdapter;
	int mShopID;

	public static CategoryListFragment newInstance(int ShopID) {
		CategoryListFragment fragment = new CategoryListFragment();
		Bundle bundle = new Bundle();
		bundle.putInt("ShopID", ShopID);
		fragment.setArguments(bundle);
		return fragment;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		ListView lv_category_list = (ListView)inflater.inflate(R.layout.fragment_category_list, container, false);
		mCategoryListAdapter = new CategoryListAdapter(getActivity(), mCategoryList);
		lv_category_list.setAdapter(mCategoryListAdapter);
		Bundle args = getArguments();
		mShopID = args.getInt("ShopID");
		return lv_category_list;
	}
	
	protected void getCategory()
	{
		CategoryApi shopApi = new CategoryApi();
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("shopId", mShopID);
		
		shopApi.getCategoryList(param, new LoadingCallBack<List<CategoryInfo>>(getBaseActivity().getProgressDialog()){
			@Override
			public void onSuccess(List<CategoryInfo> list)
			{
				LogUtils.d("list", String.valueOf(list.size()));
				for (CategoryInfo categoryInfo : list) {
					LogUtils.d("CategoryName", categoryInfo.getCategoryName());
				}
				mCategoryListAdapter.setList(list);
				mCategoryListAdapter.notifyDataSetChanged();
			}
		});
	}
}
