package com.pl.higotest.model;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import android.text.InputFilter.LengthFilter;


public class AdvertiseInfo {
	public static List<AdvertiseInfo> parseList(JSONArray json) {
		List<AdvertiseInfo> list = new ArrayList<AdvertiseInfo>();
		if(json != null)
		{
			for (int i=0,len = json.length(); i< len; i++) {
				JSONObject jsonItem = json.optJSONObject(i);
				AdvertiseInfo info = parse(jsonItem);
				if(info != null)
				{
					list.add(info);
				}
			}
		}
		return list;
	}
	
	public static AdvertiseInfo parse(JSONObject json) {
		if(json != null)
		{
			AdvertiseInfo info = new AdvertiseInfo();
			info.setImageUrl(json.optString("imageUrl"));
			return info;
		}
		return null;
	}
	
	private String imageUrl;
	private int imageId;
	private int swipeType;
	private int shopId;
	private int typeId;
	private String loadUrl;
	private String shareTitle;
	private String shareLogo;
	private String msgContent;
	private String otherShareContent;
	private int imageDrawable;
	private String promotionDesc;
	//private GoodsInfo goodsInfo;
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public int getSwipeType() {
		return swipeType;
	}
	public void setSwipeType(int swipeType) {
		this.swipeType = swipeType;
	}
	public int getShopId() {
		return shopId;
	}
	public void setShopId(int shopId) {
		this.shopId = shopId;
	}
	public int getTypeId() {
		return typeId;
	}
	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}
	public String getLoadUrl() {
		return loadUrl;
	}
	public void setLoadUrl(String loadUrl) {
		this.loadUrl = loadUrl;
	}
	public int getImageId() {
		return imageId;
	}
	public void setImageId(int imageId) {
		this.imageId = imageId;
	}
	public int getImageDrawable() {
		return imageDrawable;
	}
	public void setImageDrawable(int imageDrawable) {
		this.imageDrawable = imageDrawable;
	}
	public String getShareTitle() {
		return shareTitle;
	}
	public void setShareTitle(String shareTitle) {
		this.shareTitle = shareTitle;
	}
	public String getShareLogo() {
		return shareLogo;
	}
	public void setShareLogo(String shareLogo) {
		this.shareLogo = shareLogo;
	}
	public String getMsgContent() {
		return msgContent;
	}
	public void setMsgContent(String msgContent) {
		this.msgContent = msgContent;
	}
	public String getOtherShareContent() {
		return otherShareContent;
	}
	public void setOtherShareContent(String otherShareContent) {
		this.otherShareContent = otherShareContent;
	}
//	public GoodsInfo getGoodsInfo() {
//		return goodsInfo;
//	}
//	public void setGoodsInfo(GoodsInfo goodsInfo) {
//		this.goodsInfo = goodsInfo;
//	}
	public String getPromotionDesc() {
		return promotionDesc;
	}
	public void setPromotionDesc(String promotionDesc) {
		this.promotionDesc = promotionDesc;
	}	
}
