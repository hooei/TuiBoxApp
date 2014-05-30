package com.whtd.softplatform.client.project.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * 游戏属性
 * @author Ben
 *
 */
public class ProjectBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5350489633342549587L;
	/**
	 *  
	 */
	// 游戏编号
	public String id ="1";
	// 名字
	public String name ="1";
	// 类型
	public int type = 0;
	// 图标
	public String icon = "1";
	// 简介
	public String about = "1";
	// 说明
	public String description = "1";
	// 排名
	public int rank = 0;
	// 评价星级
	public float lv = 0;
	//最近使用时间
	public String leastuser = "1";
	// 软件版本号
	public String version = "1.0";
	// 软件更新时间
	public String updateTime = "1";
	// 来源的公司名称
	public String editor = "1";
	//是否内侧
	public int beta = 0;
	

	// 做展示的图片
	public List<String> pictures = new ArrayList<String>();
	
	
	// 下载量
	public int downloads = 0;
	// 安装包下载地址
	public String apkUrl = "1";
	// 安装包大小
	public float apkSize = 0;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public float getLV() {
		return lv;
	}
	public void setLV(float LV) {
		this.lv = LV;
	}
	public String getLeastuser() {
		return leastuser;
	}
	public void setLeastuser(String leastuser) {
		this.leastuser = leastuser;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	public String getEditor() {
		return editor;
	}
	public void setEditor(String editor) {
		this.editor = editor;
	}
	public int getBeta() {
		return beta;
	}
	public void setBeta(int beta) {
		this.beta = beta;
	}
	public List<String> getPictures() {
		return pictures;
	}
	public void setPictures(List<String> pictures) {
		this.pictures = pictures;
	}
	public int getDownloads() {
		return downloads;
	}
	public void setDownloads(int downloads) {
		this.downloads = downloads;
	}
	public String getApkUrl() {
		return apkUrl;
	}
	public void setApkUrl(String apkUrl) {
		this.apkUrl = apkUrl;
	}
	public float getApkSize() {
		return apkSize;
	}
	public void setApkSize(float apkSize) {
		this.apkSize = apkSize;
	}
}

