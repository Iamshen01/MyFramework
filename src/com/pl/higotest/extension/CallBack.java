package com.pl.higotest.extension;

public interface CallBack<T> {
	
	boolean onStart();
	
	void onSuccess(T data);
	
	void onFail(int code, String msg);
	
	void onError(int code, String msg);
	
	void onComplete();
}
