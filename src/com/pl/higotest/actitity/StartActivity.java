package com.pl.higotest.actitity;

import com.pl.higotest.R;
import com.pl.higotest.extension.BaseActivity;

import android.os.Bundle;
import android.os.Handler;

public class StartActivity extends BaseActivity {

	Thread mThread;
	Handler mHandler = new Handler();
	Runnable mCallback = new Runnable()
	{
		@Override
		public void run()
		{
			startActivity(MainActivity.class);
			finish();
		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_start);
		
		mThread = new Thread()
		{
			@Override
			public void run ()
			{
				mHandler.postDelayed(mCallback, 2000);
			}
			 
		};
		mThread.start();
	}
}

