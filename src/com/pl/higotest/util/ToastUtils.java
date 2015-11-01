package com.pl.higotest.util;

import com.pl.higotest.extension.MyApplication;

import android.widget.Toast;

public class ToastUtils {
	public static void show(String text)
	{
		Toast toast = Toast.makeText(MyApplication.getContext(), text, Toast.LENGTH_SHORT);
		toast.show();
	}
}
