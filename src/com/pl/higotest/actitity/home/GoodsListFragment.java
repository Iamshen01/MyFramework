package com.pl.higotest.actitity.home;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import com.pl.higotest.R;
import com.pl.higotest.adapter.CategoryListAdapter;
import com.pl.higotest.extension.BaseFragment;
import com.pl.higotest.model.CategoryInfo;

public class GoodsListFragment extends BaseFragment {
	
	
	ListView lv_category_list;
	List<CategoryInfo> mCategoryList = new ArrayList<CategoryInfo>();
	CategoryListAdapter mCategoryListAdapter;

	public static GoodsListFragment newInstance() {
		GoodsListFragment fragment = new GoodsListFragment();
		return fragment;
	}
	
	


	@Override
	public void onAttach(Activity activity) {
		// TODO Auto-generated method stub
		super.onAttach(activity);
		mCategoryListAdapter = new CategoryListAdapter(activity, mCategoryList);
		CategoryInfo info1 = new CategoryInfo();
		info1.setCategoryName("Ë®¹û");
		CategoryInfo info2 = new CategoryInfo();
		info2.setCategoryName("Êß²Ë");
		mCategoryList.add(info1);
		mCategoryList.add(info2);
	}




	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		ListView lv_category_list = (ListView)inflater.inflate(R.layout.fragment_category_list, container, false);
		lv_category_list.setAdapter(mCategoryListAdapter);
		return new TextView(getActivity());
	}
}
