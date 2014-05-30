package com.whtd.tuiboxapp.util;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.StreamCorruptedException;
import java.net.SocketException;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import android.content.Entity;
import android.util.Log;

public class UtilHttp {

	private final static int MAX_CONNECT_RATE = 10;

	private static int serverRequest = 0;

	public static HttpEntity POST_HTTPCLIENT(String strUrl) {

		serverRequest++;

//		BufferedInputStream bufferedInputStream = null;
//		ObjectInputStream input = null;

		try {

			HttpPost httpRequest = new HttpPost(new URI(strUrl));
			httpRequest.setHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");

			HttpClient httpclient = new DefaultHttpClient();
			HttpResponse httpResponse = httpclient.execute(httpRequest);
			HttpEntity entity = null;
			if (httpResponse.getStatusLine().getStatusCode() == 200)
				entity = httpResponse.getEntity();
			else
				Log.d("Response", String.valueOf(httpResponse.getStatusLine() .getStatusCode()));
			
//			InputStream inputStream = httpResponse.getEntity().getContent();
//			bufferedInputStream = new BufferedInputStream(inputStream);
//			input = new ObjectInputStream(bufferedInputStream);
			return entity;
		} catch (SocketException e) {

			e.printStackTrace();
			// 重新连接
			if (serverRequest < MAX_CONNECT_RATE) {
				return POST_HTTPCLIENT(strUrl);
			}
		} catch (ConnectTimeoutException e) {
			Log.d("ConnectTimeout", "连接超时");
			e.printStackTrace();

		} catch (StreamCorruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
//		finally {
//			try {
//				if (input != null)
//					input.close();
//				if (bufferedInputStream != null)
//					bufferedInputStream.close();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
		return null;
	}

	public static String sendGet(String url) {
		Log.v("url", url);
		/*
		 * 测试的服务器不稳定，所以尝试3次请求
		 */
		for (int i = 0; i < 3; i++) {
			if (i != 0) {
				try {
					Thread.sleep(2 * 1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			HttpGet httpRequest = new HttpGet(url);
			try {
				// 发送请求并等待响应
				HttpResponse httpResponse = new DefaultHttpClient().execute(httpRequest);
				// 若状态码为200
				if (httpResponse.getStatusLine().getStatusCode() == 200) {
					return EntityUtils.toString(httpResponse.getEntity());
				}
			} catch (ClientProtocolException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}

			finally {
				httpRequest.abort();
			}

		}
		return "";
	}
}
