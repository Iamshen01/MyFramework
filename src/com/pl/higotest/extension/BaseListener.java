package com.pl.higotest.extension;

import org.json.JSONObject;

import com.android.volley.VolleyError;
import com.pl.higotest.util.LogUtils;

public abstract class BaseListener<T> implements CombineListener{
		
	public static final String DATA_TAG = "ServerData";
	public static final String ERROR_TAG = "ServerError";
	
	private CallBack<T> mCallBack;
	
	public BaseListener(CallBack<T> callBack)
	{
		mCallBack = callBack;
	}


	@Override
	public void onResponse(JSONObject json) {
		LogUtils.d(DATA_TAG, json.toString());
		int status = json.optInt("status");
		if (status == 0) {
			T t = onParse(json);
			mCallBack.onSuccess(t);
		} else {
			String msg = json.optString("msg");
			mCallBack.onFail(status, msg);
		}
		mCallBack.onComplete();
	}
	
	@Override
	public void onErrorResponse(VolleyError error) {
		LogUtils.e(ERROR_TAG, error.getMessage());
		mCallBack.onError(2, error.getMessage());
		mCallBack.onComplete();
	}

	@Override
	public boolean onStart() {
		return mCallBack.onStart();
	}


	public abstract T onParse(JSONObject json);
}
