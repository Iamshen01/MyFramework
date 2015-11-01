package com.pl.higotest.extension;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.ViewGroup;

public class BaseActivity extends FragmentActivity {
	
	private ProgressDialog mDialog;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mDialog = new ProgressDialog(this);
	}


	public ProgressDialog getProgressDialog()
	{
		return mDialog;
	}
	
	public MyApplication getMyApplication()
	{
		return (MyApplication)getApplication();
	}
	
	public void startActivity(Class<?> cls)
	{
		Intent intent = new Intent(this, cls);
		startActivity(intent);
	}
	
	public <T> T $(int viewID) {
	    return (T) findViewById(viewID);
	}
	
	public <T> T $(int viewID, ViewGroup view) {
	    return (T) view.findViewById(viewID);
	}

}
