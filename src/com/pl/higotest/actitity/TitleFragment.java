package com.pl.higotest.actitity;


import com.pl.higotest.R;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

public class TitleFragment extends Fragment {
	
	public static final String TAG = "TitleFragment";
	
	private TextView tv_title;
	private ImageButton ibtn_right;
	private ImageButton ibtn_left;
	private OnClickListener mRightListener;
	private OnClickListener mLeftListener;
	private OnClickListener listener = new OnClickListener() {		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
			case R.id.ibtn_right:
				if(mRightListener != null) mRightListener.onClick(v);
				break;
			case R.id.ibtn_left:
				if(mLeftListener != null) mLeftListener.onClick(v);
				break;
			}
		}
	};

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		
		
		View fragment_view = inflater.inflate(R.layout.fragment_title, container, false);
		
		tv_title = (TextView)fragment_view.findViewById(R.id.tv_title);
		ibtn_right = (ImageButton)fragment_view.findViewById(R.id.ibtn_right);
		ibtn_left = (ImageButton)fragment_view.findViewById(R.id.ibtn_left);
		
		ibtn_right.setOnClickListener(listener);
		ibtn_left.setOnClickListener(listener);
		
		Bundle args = getArguments();
		int titleResId = args.getInt("titleResId",0);
		if(titleResId > 0)
		{
			tv_title.setText(titleResId);
		}
		else 
		{
			String title = args.getString("title");
			if(title == null)
			{
				title = "";
			}
			tv_title.setText(title);
		}
		int rightResId = args.getInt("rightResId",0);
		int leftResId = args.getInt("leftResId", 0);
		if(rightResId > 0)
		{
			ibtn_right.setImageResource(rightResId);
		}
		if(leftResId > 0)
		{
			ibtn_left.setImageResource(leftResId);
		}
		return fragment_view;
	}
	
	public void setOnRightClickLinstener(OnClickListener listener)
	{
		mRightListener = listener;
	}
	public void setOnLeftClickLinstener(OnClickListener listener)
	{
		mLeftListener = listener;
	}
	
	public static TitleFragment newInstance()
	{
		return new TitleFragment();
	}
	
	public static TitleFragment newInstance(String title)
	{
		TitleFragment fragment = new TitleFragment();
		Bundle bundle = new Bundle();
		bundle.putString("title", title);
		fragment.setArguments(bundle);
		return fragment;
	}
	
	public static TitleFragment newInstance(int titleResId)
	{
		TitleFragment fragment = new TitleFragment();
		Bundle bundle = new Bundle();
		bundle.putInt("titleResId", titleResId);
		fragment.setArguments(bundle);
		return fragment;
	}
	
	public static TitleFragment newInstance(int leftResId, int rightResId)
	{
		TitleFragment fragment = new TitleFragment();
		Bundle bundle = new Bundle();
		bundle.putInt("leftResId", leftResId);
		bundle.putInt("rightResId", rightResId);
		fragment.setArguments(bundle);
		return fragment;
	}
	
	public static TitleFragment newInstance(String title, int leftResId, int rightResId)
	{
		TitleFragment fragment = new TitleFragment();
		Bundle bundle = new Bundle();
		bundle.putString("title", title);
		bundle.putInt("leftResId", leftResId);
		bundle.putInt("rightResId", rightResId);
		fragment.setArguments(bundle);
		return fragment;
	}
	
	public static TitleFragment newInstance(int titleResId, int leftResId, int rightResId)
	{
		TitleFragment fragment = new TitleFragment();
		Bundle bundle = new Bundle();
		bundle.putInt("titleResId", titleResId);
		bundle.putInt("leftResId", leftResId);
		bundle.putInt("rightResId", rightResId);
		fragment.setArguments(bundle);
		return fragment;
	}
}
