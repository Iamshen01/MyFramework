package com.pl.higotest.api;

import java.util.List;
import java.util.Map;

import com.pl.higotest.extension.CallBack;
import com.pl.higotest.extension.MyListener;
import com.pl.higotest.extension.MyRequset;
import com.pl.higotest.model.CategoryInfo;

public class CategoryApi {
	public void getCategoryList(Map<String, Object> param, CallBack<List<CategoryInfo>> callBack) {

		MyRequset request = new MyRequset(Apis.SEARCH_CATEGORY, param, new MyListener<List<CategoryInfo>>(callBack){});
		request.Start();
}
}
