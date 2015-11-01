package com.pl.higotest.util;

import android.util.Log;

public class LogUtils {
	
	public final static int LOG_LEVEL = 6;//����ģʽΪ6������ģʽΪ0
	public final static int RELEASE = 0 ;//����ģʽ
	public final static int ERROR = 1;
	public final static int WARN = 2;
	public final static int INFO = 3;
	public final static int DEBUG = 4;
	public final static int VERBOS = 5;
	
	public static boolean isDebug(){
		return LOG_LEVEL != RELEASE;		
	}

	public static void e(String tag, String msg) {
		if (LOG_LEVEL > ERROR)
			Log.e(tag, msg);
	}

	public static void w(String tag, String msg) {
		if (LOG_LEVEL > WARN)
			Log.w(tag, msg);
	}

	public static void i(String tag, String msg) {
		if (LOG_LEVEL > INFO)
			Log.i(tag, msg);
	}

	public static void d(String tag, String msg) {
		if (LOG_LEVEL > DEBUG)
			Log.d(tag, msg);
	}
	
	public static void d(String tag, Integer msg) {
		d(tag, String.valueOf(msg));
	}
	
	public static void d(String tag, Boolean msg) {
		d(tag, String.valueOf(msg));
	}

	public static void v(String tag, String msg) {
		if (LOG_LEVEL > VERBOS)
			Log.v(tag, msg);
	}
}
