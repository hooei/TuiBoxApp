package com.whtd.tuiboxapp.main;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

import com.whtd.tuiboxapp.R;

public class MainActivity extends FragmentActivity implements OnCheckedChangeListener {

	
	private RadioGroup radioGroup ;
	
	private MainTabsGame TabsGame;
	private MainTabsSetting TabsSetting;
	private Fragment tabsInstance[] ={TabsGame,TabsSetting};
	private Class tabsClass[] = {MainTabsGame.class,MainTabsSetting.class};
	
	private FragmentTransaction transaction;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_activity_tabs);
		
		initView();
	}

	private void initView(){
		
		radioGroup = (RadioGroup) this.findViewById(R.id.main_tabs);
		radioGroup.setOnCheckedChangeListener(this);
		
		radioGroup.check(R.id.main_tabs_game);
	}

	@Override
	public void onCheckedChanged(RadioGroup group, int index) {
		
		switch (index) {
		case R.id.main_tabs_game:
			ShowFragment(MainTabsGame.class);
			break;

		case  R.id.main_tabs_set:
			
			ShowFragment(MainTabsSetting.class);
			break;
		}
	}
	
	/**
	 * 显示隐藏Fragment
	 * @param mClass Fragment
	 */
	private void ShowFragment(Class mClass)
	{
		try {
			transaction = getSupportFragmentManager().beginTransaction();
			
			for (int i = 0; i < tabsInstance.length; i++) {
				if (tabsClass[i].equals(mClass)) {
					if (tabsInstance[i] == null) {
						tabsInstance[i] = (Fragment) mClass.newInstance();
						transaction.add(R.id.main_realtabcontent, tabsInstance[i]);
					}else{
						transaction.show(tabsInstance[i]);
					}
				} else if (tabsInstance[i] != null) {
					transaction.hide(tabsInstance[i]);
				}
			}

			transaction.commit();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
