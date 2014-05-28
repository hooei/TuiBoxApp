package com.whtd.tuiboxapp.main;

import org.w3c.dom.Text;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;

import com.whtd.tuiboxapp.R;

public class MainActivity extends FragmentActivity {

	public View GameView;
	public View SetView;
	
	private Class tabFragments[] = {MainTabsGame.class,MainTabsSetting.class};
	private String tabIndex[] = {"game","setting"};
	private String tabText[] = {"游戏","设置"};
	private int tabImage[] = {R.drawable.main_tab_item_game, R.drawable.main_tab_item_set};
	private FragmentTabHost tabHost ;
	
	private LayoutInflater layoutInflater ;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_activity_tabs);
		
		initView();
	}

	private void initView(){
//		tabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
//		tabHost.setup(this, getSupportFragmentManager(),R.id.main_realtabcontent);
//		
//		TabSpec tabSpec = null;
//		for (int i = 0; i < tabFragments.length; i++) {
//			tabSpec = tabHost.newTabSpec(tabIndex[i]).setIndicator(getMainTabView(i));
//			tabHost.addTab(tabSpec,tabFragments[i],null);
//		}
	}
	
//	private View getMainTabView(int index){
//		
//		layoutInflater = LayoutInflater.from(this); 
//		View view = layoutInflater.inflate(R.layout.main_tab_item_view, null);
//		
//		ImageView img = (ImageView) view.findViewById(R.id.main_tab_img);
//		img.setImageResource(tabImage[index]);
//		
//		TextView txt = (TextView) view.findViewById(R.id.main_tab_txt);
//		txt.setText(tabText[index]);
//		
//		return view;
//	}


}
