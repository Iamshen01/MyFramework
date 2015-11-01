package com.pl.higotest.util;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import android.content.Context;

public class VolleyQueue {
	
	private static RequestQueue mQueue;
	
	public static void setQueue(Context context) {
		if(mQueue == null)
		{
			mQueue = Volley.newRequestQueue(context);
		}
	}
	
	public static RequestQueue getQueue() {
		return mQueue;
	}
}
