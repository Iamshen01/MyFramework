package com.pl.higotest.extension;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.internal.$Gson$Types;

public class MyListener<T> extends BaseListener<T>{
	
	private Type mType;
	
	public MyListener(CallBack<T> callBack)
	{
		super(callBack);
		mType = $Gson$Types.canonicalize(((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0]); 
	}

	@Override
	public T onParse(JSONObject json)
	{
		Gson gson = new Gson();
		return gson.fromJson(json.optJSONArray("result").toString(), mType);
	}
}
