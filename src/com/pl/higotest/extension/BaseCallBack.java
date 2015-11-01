package com.pl.higotest.extension;

import com.pl.higotest.R.string;
import com.pl.higotest.util.LogUtils;
import com.pl.higotest.util.ToastUtils;

public class BaseCallBack<T> implements CallBack<T> {

	@Override
	public boolean onStart() {
		// TODO Auto-generated method stub
		return true;
		
	}

	@Override
	public void onSuccess(T data) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFail(int code, String msg) {
		// TODO Auto-generated method stub
		ToastUtils.show(msg);
		LogUtils.d("onFail", code + ":" + msg);
	}

	@Override
	public void onError(int code, String msg) {
		// TODO Auto-generated method stub
		ToastUtils.show(MyApplication.getContext().getString(string.net_server_error));
	}

	@Override
	public void onComplete() {
		// TODO Auto-generated method stub
		
	}

}
