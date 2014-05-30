package com.whtd.tuiboxapp.main;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.whtd.tuiboxapp.R;

public class MainTabsSetting extends Fragment {
	
	private View view = null;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
			view = inflater.inflate(R.layout.main_tabs_setting, container,false);
		
			EditText e = (EditText) getActivity().findViewById(R.id.test);
			e.setText("123");
		return view;
	}

	
}
