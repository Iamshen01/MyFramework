package com.pl.higotest.extension;

import org.json.JSONObject;

import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;

public interface CombineListener extends  Listener<JSONObject>, ErrorListener {
	boolean onStart();
}
