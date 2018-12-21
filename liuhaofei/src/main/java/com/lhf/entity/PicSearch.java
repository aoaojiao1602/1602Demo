package com.lhf.entity;

public class PicSearch {
	private String picCourse;
	private String picUrl;
	public PicSearch(String picCourse, String picUrl) {
		super();
		this.picCourse = picCourse;
		this.picUrl = picUrl;
	}
	public PicSearch() {
		super();
	}
	public String getPicCourse() {
		return picCourse;
	}
	public void setPicCourse(String picCourse) {
		this.picCourse = picCourse;
	}
	public String getPicUrl() {
		return picUrl;
	}
	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}
	@Override
	public String toString() {
		return "PicSearch [picCourse=" + picCourse + ", picUrl=" + picUrl + "]";
	}

	
}
