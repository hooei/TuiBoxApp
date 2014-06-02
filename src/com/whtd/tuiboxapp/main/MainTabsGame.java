package com.whtd.tuiboxapp.main;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.List;

import org.apache.http.HttpEntity;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.whtd.softplatform.client.project.bean.ProjectBean;
import com.whtd.tuiboxapp.R;
import com.whtd.tuiboxapp.game.custom.CustomGameItem;
import com.whtd.tuiboxapp.util.Constants;
import com.whtd.tuiboxapp.util.UtilHttp;

public class MainTabsGame extends Fragment implements OnTouchListener{
//	Handler mhandler = new Handler() {  
//		@Override  
//		public void handleMessage(Message msg) {// handler接收到消息后就会执行此方法  
//			View view = LinearLayout.inflate(getActivity(), R.layout.game_item_view, null);
//			
//			t = (TextView) view.findViewById(R.id.custom_item_txt_name);
//			Log.d("t", t.toString());
//			t.setText("123123123");
//		}
//	};
	
	private View page = null;
	private LinearLayout games_view;
	private Activity mActivity;
	
	private ScrollView scrollView;
	@Override
	public void onAttach(Activity activity) {
		// TODO Auto-generated method stub
		super.onAttach(activity);
		mActivity = activity;
	}
	LayoutInflater minflater;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		page = inflater.inflate(R.layout.main_tabs_game, container, false);
		scrollView = (ScrollView) page.findViewById(R.id.games_scroll);
		scrollView.setOnTouchListener(this);
		games_view = (LinearLayout)page.findViewById(R.id.games_view);
//		getInfosFromServer();
		minflater = inflater;
		mActivity.runOnUiThread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				CustomGameItem v = new CustomGameItem(getActivity());
				v.setName("成功");
				v.setApk_size("1W");
				games_view.addView(v);
				
				CustomGameItem v2 = new CustomGameItem(getActivity());
				v2.setName("成功");
				v2.setApk_size("1W");
				games_view.addView(v2);
				
				CustomGameItem v22 = new CustomGameItem(getActivity());
				v22.setName("成功");
				v22.setApk_size("1W");
				games_view.addView(v22);
				
				CustomGameItem v222 = new CustomGameItem(getActivity());
				v222.setName("成功");
				v222.setApk_size("1W");
				games_view.addView(v222);
				
				CustomGameItem v21 = new CustomGameItem(getActivity());
				v21.setName("成功");
				v21.setApk_size("1W");
				games_view.addView(v21);
			}
		});
		return page;
	}

	/**
	 * 获取服务器游戏列表信息
	 */
	private ProgressDialog progressDialog;
	private CustomGameItem item ;
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
							
							final View view = LayoutInflater.from(getActivity()).inflate(R.layout.game_item_view, null);
							final LinearLayout l = (LinearLayout) getActivity().findViewById(R.id.games_view);
							item = (CustomGameItem) view.findViewById(R.id.iii);
							
							mActivity.runOnUiThread(new Runnable() {
								
								@Override
								public void run() {
									// TODO Auto-generated method stub
									l.addView(view);
									
								}
							});
							break;
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
	
	@Override
	public boolean onTouch(View view, MotionEvent event) {
		// TODO Auto-generated method stub
		 
        switch (event.getAction()) {
        case MotionEvent.ACTION_DOWN:

            break;
        case MotionEvent.ACTION_MOVE:
             int scrollY=view.getScrollY();
             int height=view.getHeight();
             int scrollViewMeasuredHeight=scrollView.getChildAt(0).getMeasuredHeight();
             if(scrollY==0){
            	 Toast.makeText( getActivity() ,  "Touch==0" , Toast.LENGTH_SHORT).show();
                }
             if((scrollY+height)==scrollViewMeasuredHeight){
            	 Toast.makeText( getActivity() ,  "Touch Touch" , Toast.LENGTH_SHORT).show();
             }
            break;

        default:
            break;
        }
		return false;
	};	
}
