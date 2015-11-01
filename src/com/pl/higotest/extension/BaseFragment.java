package com.pl.higotest.extension;

import android.support.v4.app.Fragment;

public class BaseFragment extends Fragment {
	public BaseActivity getBaseActivity()
	{
		return (BaseActivity)getActivity();
	}
}
