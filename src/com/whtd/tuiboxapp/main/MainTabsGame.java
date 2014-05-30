package com.whtd.tuiboxapp.main;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.List;

import org.apache.http.HttpEntity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.whtd.softplatform.client.project.bean.ProjectBean;
import com.whtd.tuiboxapp.R;
import com.whtd.tuiboxapp.util.Constants;
import com.whtd.tuiboxapp.util.UtilHttp;

public class MainTabsGame extends Fragment {

	private View view = null;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
			view = inflater.inflate(R.layout.main_tabs_game, container,false);
		
			getInfosFromServer();
		return view;
	}

	/**
	 * 获取服务器游戏列表信息
	 */
	private ProgressDialog progressDialog;
	
	private void getInfosFromServer(){
		
		progressDialog = ProgressDialog.show(getActivity(), "", "加载中，请稍后……");
		
		Thread thread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					String path = Constants.serverUrl+"/SoftPlatform"+"/getProject";
					HttpEntity entity = UtilHttp.POST_HTTPCLIENT(path);
					InputStream inputStream = entity.getContent();
					ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
					List<ProjectBean> infos = (List<ProjectBean>) objectInputStream.readObject();
					//获得信息 存到全局变量中
					if (infos != null)
					{														
						Constants.gamesList.clear();
						for(ProjectBean info : infos){
							Constants.gamesList.add(info);
						}									
					}	
//					Thread.sleep(5000);
					progressDialog.dismiss();
					Log.d("infoinfoinfo", infos.get(0).name);
				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
		});
		thread.start();
	}
}
