package com.pl.higotest.model;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.google.gson.annotations.SerializedName;

public class ShopInfo {
	@SerializedName("shop_logo")
	private String shopLogo;
	
	@SerializedName("uid")
	private String shopID;

	public String getShopID() {
		return shopID;
	}

	public void setShopID(String shopID) {
		this.shopID = shopID;
	}

	public String getShopLogo() {
		return shopLogo;
	}

	public void setShopLogo(String shopLogo) {
		this.shopLogo = shopLogo;
	}
	
	public static List<ShopInfo> parseList(JSONArray json) {
		List<ShopInfo> list = new ArrayList<ShopInfo>();
		if(json != null)
		{
			for (int i=0,len = json.length(); i< len; i++) {
				JSONObject jsonItem = json.optJSONObject(i);
				ShopInfo info = parse(jsonItem);
				if(info != null)
				{
					list.add(info);
				}
			}
		}
		return list;
	}
	
	public static ShopInfo parse(JSONObject json) {
		if(json != null)
		{
			ShopInfo info = new ShopInfo();
			info.setShopLogo(json.optString("shop_logo"));
			return info;
		}
		return null;
	}
}
