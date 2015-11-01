package com.pl.higotest.api;

import java.util.List;
import java.util.Map;

import com.pl.higotest.extension.CallBack;
import com.pl.higotest.extension.MyListener;
import com.pl.higotest.extension.MyRequset;
import com.pl.higotest.model.AdvertiseInfo;



public class AdvertiseApi {
	
	public void getAdvertiseList(Map<String, Object> param, CallBack<List<AdvertiseInfo>> callBack) {
		MyRequset request = new MyRequset(Apis.SEARCH_ADVERTISE_IMAGE, param, new MyListener<List<AdvertiseInfo>>(callBack){});
		request.Start();
	}
}
