package com.pl.higotest.extension;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.pl.higotest.util.VolleyQueue;

import android.app.Application;
import android.content.Context;

public class MyApplication extends Application {
	
	private static MyApplication mMyApplication;
	
	public static Context getContext()
	{
		return mMyApplication.getApplicationContext();
	}
	
	public static MyApplication getInstance()
	{
		return mMyApplication;
	}
	
	@Override
    public void onCreate() {
        // TODO Auto-generated method stub
        super.onCreate();
        mMyApplication = this;
        VolleyQueue.setQueue(getApplicationContext());
        ImageLoaderConfiguration configuration = ImageLoaderConfiguration.createDefault(getApplicationContext());
        ImageLoader.getInstance().init(configuration);
    }
	
	
}
