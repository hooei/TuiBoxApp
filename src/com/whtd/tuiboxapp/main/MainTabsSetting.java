package com.whtd.tuiboxapp.main;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.whtd.tuiboxapp.R;

public class MainTabsSetting extends Fragment {
	
	private View view = null;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		if(view == null)
			view = inflater.inflate(R.layout.main_tabs_setting, container,false);
		
		ViewGroup group = (ViewGroup) view.getParent();
		if(group != null)
			group.removeView(view);
		
		return view;
	}

	
}
