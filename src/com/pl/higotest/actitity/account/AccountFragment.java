package com.pl.higotest.actitity.account;


import com.pl.higotest.R;
import com.pl.higotest.R.string;
import com.pl.higotest.actitity.TitleFragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class AccountFragment extends Fragment {
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_account, container, false);
		FragmentManager manage= getFragmentManager();
		Fragment fragment_title = TitleFragment.newInstance(string.title_fragment_account);
		FragmentTransaction transaction = manage.beginTransaction();
		transaction.add(R.id.fl_title_account, fragment_title);
		transaction.commit();
		return view;
	}
}
