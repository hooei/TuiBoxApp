package com.whtd.tuiboxapp.game.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v4.app.FragmentActivity;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;

import com.whtd.tuiboxapp.R;
import com.whtd.tuiboxapp.tools.imgview.SmartImageView;

public class CustomGameItem extends LinearLayout {

	private SmartImageView icon;
	private TextView name;
	private RatingBar star;
	private TextView download_count;
	private TextView apk_size;
	private ProgressBar download_progress;
	private TextView download_txt;
	private TextView summary;	
	
	private Drawable attr_icon;
	private String attr_name;
	private String attr_count;
	private String attr_apkSize;
	private String attr_summary;
	
	
	
	public CustomGameItem(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		
		View view = LayoutInflater.from(context).inflate(R.layout.game_item_view_custom, this, true);
		icon = (SmartImageView) view.findViewById(R.id.custom_item_img_icon);
		name = (TextView) view.findViewById(R.id.custom_item_txt_name);
		star = (RatingBar) view.findViewById(R.id.custom_item_rat_star);
		download_count = (TextView) view.findViewById(R.id.custom_item_download_count);
		apk_size = (TextView) view.findViewById(R.id.custom_item_apk_size);
		download_progress = (ProgressBar) view.findViewById(R.id.custom_item_progress_download);
		download_txt = (TextView) view.findViewById(R.id.custom_item_download_txt);
		summary = (TextView) view.findViewById(R.id.custom_item_summary);
	}


	public CustomGameItem(Context context, AttributeSet attrs) {
		super(context, attrs);
		
		TypedArray array = context.obtainStyledAttributes(attrs,R.styleable.custom_item_view_attrs);
		
//		attr_name = array.get
		attr_name = array.getString(R.styleable.custom_item_view_attrs_itemname);
		attr_count = array.getString(R.styleable.custom_item_view_attrs_itemcount);
		attr_apkSize = array.getString(R.styleable.custom_item_view_attrs_itemapksize);
		attr_summary = array.getString(R.styleable.custom_item_view_attrs_itemsummary);
		
		array.recycle();
		
		
		View view = LayoutInflater.from(context).inflate(R.layout.game_item_view_custom, this, true);
		icon = (SmartImageView) view.findViewById(R.id.custom_item_img_icon);
		name = (TextView) view.findViewById(R.id.custom_item_txt_name);
		star = (RatingBar) view.findViewById(R.id.custom_item_rat_star);
		download_count = (TextView) view.findViewById(R.id.custom_item_download_count);
		apk_size = (TextView) view.findViewById(R.id.custom_item_apk_size);
		download_progress = (ProgressBar) view.findViewById(R.id.custom_item_progress_download);
		download_txt = (TextView) view.findViewById(R.id.custom_item_download_txt);
		summary = (TextView) view.findViewById(R.id.custom_item_summary);
		
		name.setText(attr_name);
		download_count.setText(attr_count);
		apk_size.setText(attr_apkSize);
		summary.setText(attr_summary);
	}


	public void setIcon(String url) {
		this.icon.setImageUrl(url);
	}

	public void setName(String name) {
		this.name.setText(name);
	}

	public void setStar(RatingBar star) {
		this.star = star;
	}

	public void setDownload_count(String download_count) {
		this.download_count.setText(download_count);
	}

	public void setApk_size(String apk_size) {
		this.apk_size.setText(apk_size);
	}

	public void setSummary(String summary) {
		this.summary.setText(summary);
	}

	
}
