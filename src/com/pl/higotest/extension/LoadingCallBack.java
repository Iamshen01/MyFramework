package com.pl.higotest.extension;


import android.app.ProgressDialog;

public class LoadingCallBack<T> extends BaseCallBack<T> {
	
	private ProgressDialog mDialog;
	
	public LoadingCallBack(ProgressDialog dialog)
	{
		mDialog = dialog;
	}

	@Override
	public boolean onStart() {
		// TODO Auto-generated method stub
		boolean rt = super.onStart();
		if(rt)
		{
			mDialog.show();
		}
		return rt;
	}

	@Override
	public void onComplete() {
		// TODO Auto-generated method stub
		if(mDialog.isShowing())
		{
			mDialog.dismiss();
		}
		super.onComplete();
	}

}
