package com.pl.higotest.adapter;

import java.util.List;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.pl.higotest.R;
import com.pl.higotest.model.CategoryInfo;
import com.pl.higotest.model.ShopInfo;

import android.content.Context;
import android.graphics.Bitmap.Config;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CategoryListAdapter extends BaseAdapter {
	
	private List<CategoryInfo> mList;
	private Context mContext;
	private LayoutInflater mInflater;

	public CategoryListAdapter(Context context,List<CategoryInfo> list)
	{
		mContext = context;
		mList = list;
		mInflater = LayoutInflater.from(mContext);
	}
	
	 public void setList(List<CategoryInfo> list) {
		mList = list;
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mList.size();
		
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return mList.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		CategoryInfo info = (CategoryInfo)getItem(position);
		return info.getCategoryID();
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder viewHolder;
		if(convertView ==  null)
		{
			convertView = mInflater.inflate(R.layout.category_item, parent, false);
			viewHolder = new ViewHolder();
			TextView textView = (TextView)convertView.findViewById(R.id.tv_category);
			viewHolder.textView = textView;
			convertView.setTag(viewHolder);
		}
		else
        {
            viewHolder = (ViewHolder)convertView.getTag();
        }
		CategoryInfo info = (CategoryInfo)getItem(position);
		viewHolder.textView.setText(info.getCategoryName());
		return convertView;
	}
	
	private static class ViewHolder
	{
		TextView textView;
	}
	
	

}
