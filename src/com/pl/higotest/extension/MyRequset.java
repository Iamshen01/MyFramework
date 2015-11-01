package com.pl.higotest.extension;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;
import com.google.gson.Gson;
import com.pl.higotest.api.Apis;
import com.pl.higotest.util.LogUtils;
import com.pl.higotest.util.VolleyQueue;

public class MyRequset extends Request<JSONObject> {
	
	/** Default charset for JSON request. */
    protected static final String PROTOCOL_CHARSET = "utf-8";
    
    protected static final String TAG = "MyRequset";
    protected static final String APITAG = "ApiParams";
	
	private CombineListener mListener;
	private Map<String, Object> mParam;
	private String mApiName;

	public MyRequset(int method, String apiName, Map<String, Object> param, CombineListener listener) {
		super(method, Apis.ApiUrl, listener);
		mApiName = apiName;
		mParam = param;
		mListener = listener;
	}
	
	public MyRequset(String apiName, Map<String, Object> data, CombineListener listener) {
		this(Method.POST, apiName, data, listener);
	}
	
	public MyRequset(String apiName, CombineListener listener) {
		this(apiName, null, listener);
	}

	@Override
	protected Map<String, String> getParams() throws AuthFailureError {
		Map<String, String> data = new HashMap<String, String>();
		Map<String, Object> param = Apis.getFullParam(mApiName, mParam);
		Gson gson = new Gson();
		String json = gson.toJson(param);
		LogUtils.d(APITAG, json);
		data.put("data", json);
		return data;
	}

	@Override
	protected void deliverResponse(JSONObject response) {
		mListener.onResponse(response);
	}

	@Override
	protected Response<JSONObject> parseNetworkResponse(NetworkResponse response) {
		String jsonString = " ";
		try {
            jsonString = new String(response.data,
                    HttpHeaderParser.parseCharset(response.headers, PROTOCOL_CHARSET));
            return Response.success(new JSONObject(jsonString),
                    HttpHeaderParser.parseCacheHeaders(response));
        } catch (UnsupportedEncodingException e) {
            return Response.error(new ParseError(e));
        } catch (JSONException je) {
        	LogUtils.d(TAG, jsonString);
            return Response.error(new ParseError(je));
        }
	}
	
	public void Start()
	{
		if(mListener.onStart())
		{
			VolleyQueue.getQueue().add(this);
		}
	}
}
