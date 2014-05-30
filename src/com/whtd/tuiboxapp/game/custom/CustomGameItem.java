package com.whtd.tuiboxapp.game.custom;

import com.whtd.tuiboxapp.R;
import com.whtd.tuiboxapp.tools.imgview.SmartImageView;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.TextView;

public class CustomGameItem extends LinearLayout {

	private SmartImageView icon;
	private TextView name;
	private RatingBar star;
	private TextView download_count;
	private TextView apk_size;
	private ProgressBar download_progress;
	private TextView download_txt;
	private TextView summary;	
	
	public CustomGameItem(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}

	public CustomGameItem(Context context) {
		super(context);
		View view = LayoutInflater.from(context).inflate(R.layout.game_item_view_custom, this, true);
		icon = (SmartImageView) view.findViewById(R.id.custom_item_img_icon);
		name = (TextView) view.findViewById(R.id.custom_item_txt_name);
		star = (RatingBar) view.findViewById(R.id.custom_item_rat_star);
		download_count = (TextView) view.findViewById(R.id.custom_item_download_count);
		apk_size = (TextView) view.findViewById(R.id.custom_item_apk_size);
		download_progress = (ProgressBar) view.findViewById(R.id.custom_item_progress_download);
		download_txt = (TextView) view.findViewById(R.id.custom_item_download_txt);
		summary = (TextView) view.findViewById(R.id.custom_item_summary);
		name.setText("12313");
		
	}

	public void setIcon(SmartImageView icon) {
		this.icon = icon;
	}

	public void setName(String name) {
		this.name.setText(name);
	}

	public void setStar(RatingBar star) {
		this.star = star;
	}

	public void setDownload_count(TextView download_count) {
		this.download_count = download_count;
	}

	public void setApk_size(TextView apk_size) {
		this.apk_size = apk_size;
	}

	public void setDownload_progress(ProgressBar download_progress) {
		this.download_progress = download_progress;
	}

	public void setDownload_txt(TextView download_txt) {
		this.download_txt = download_txt;
	}

	public void setSummary(TextView summary) {
		this.summary = summary;
	}


	
	

}
