package com.whtd.tuiboxapp.main;

import com.whtd.tuiboxapp.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MainTabsGame extends Fragment {

	private View view = null;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		if(view == null)
			view = inflater.inflate(R.layout.main_tabs_game, container,false);
		
		ViewGroup group = (ViewGroup) view.getParent();
		if(group != null)
			group.removeView(view);
		
		return view;
	}

	
}
