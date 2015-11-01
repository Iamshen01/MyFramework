package com.pl.higotest.adapter;

import java.util.List;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.pl.higotest.R;
import com.pl.higotest.model.ShopInfo;

import android.content.Context;
import android.graphics.Bitmap.Config;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class ShopListAdapter extends BaseAdapter {
	
	private List<ShopInfo> mList;
	private Context mContext;
	private ImageLoader mImageLoader;
	private LayoutInflater mInflater;
	private DisplayImageOptions mImageOptions;

	public ShopListAdapter(Context context,List<ShopInfo> list)
	{
		mImageLoader = ImageLoader.getInstance();
		mImageOptions = new DisplayImageOptions.Builder()
				.bitmapConfig(Config.RGB_565)
				.cacheInMemory(true)
				.cacheOnDisk(true)
				.showImageOnLoading(R.drawable.goods_defult)
				.showImageForEmptyUri(R.drawable.goods_defult)
				.showImageOnFail(R.drawable.goods_defult)
				.build();
		mContext = context;
		mList = list;
		mInflater = LayoutInflater.from(mContext);
	}
	
	 public void setList(List<ShopInfo> list) {
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
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder viewHolder;
		if(convertView ==  null)
		{
			convertView = mInflater.inflate(R.layout.shop_item, parent, false);
			viewHolder = new ViewHolder();
			ImageView imageView = (ImageView)convertView.findViewById(R.id.iv_shop_icon);
			viewHolder.imageView = imageView;
			convertView.setTag(viewHolder);
		}
		else
        {
            viewHolder = (ViewHolder)convertView.getTag();
        }
		ShopInfo info = (ShopInfo)getItem(position);
		mImageLoader.displayImage(info.getShopLogo(), viewHolder.imageView, mImageOptions);
		return convertView;
	}
	
	private static class ViewHolder
	{
		ImageView imageView;
	}
	
	

}
