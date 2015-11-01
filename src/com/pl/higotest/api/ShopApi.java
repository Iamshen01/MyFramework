package com.pl.higotest.api;

import java.util.List;
import java.util.Map;

import com.pl.higotest.extension.CallBack;
import com.pl.higotest.extension.MyListener;
import com.pl.higotest.extension.MyRequset;
import com.pl.higotest.model.ShopInfo;

public class ShopApi {
	public void getShopList(Map<String, Object> param, CallBack<List<ShopInfo>> callBack) {

			MyRequset request = new MyRequset(Apis.SEARCH_SHOP, param, new MyListener<List<ShopInfo>>(callBack){});
			request.Start();
	}
}
