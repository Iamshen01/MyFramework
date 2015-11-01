package com.pl.higotest.api;

import java.util.HashMap;
import java.util.Map;

public class Apis {
    public static final String ApiUrl = "http://192.168.1.68/hilife/api/index.php";
    
    public static final String SEARCH_ADVERTISE_IMAGE="users_advertizeImage";//主界面请求广告     
	public final static String SEARCH_SHOP = "users_searchSeller";//搜索商铺
	public final static String SEARCH_CATEGORY = "storegoods_selectgoodstypes";//搜索商铺
    
    public static Map<String, Object> getFullParam(String apiName, Map<String, Object> param)
    {
    	Map<String, Object> data = new HashMap<String, Object>();
    	data.put("action", apiName);
    	data.put("appver", "1.0");
    	data.put("os", "Android");
    	data.put("osver", "4.4.2");
    	data.put("deviceid", "11111");
    	if(param != null)
    	{
    		data.put("params", param);
    	}
    	return data;
    }
}
