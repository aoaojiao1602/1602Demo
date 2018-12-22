package com.lhf.entity;

public class CoursewareSearch {

	private String cwHour;
	private String cwCategory;
	private String cwName;
	private String cwUrl;
	
	
	
	public CoursewareSearch() {
		super();
	}



	public CoursewareSearch(String cwHour, String cwCategory, String cwName, String cwUrl) {
		super();
		this.cwHour = cwHour;
		this.cwCategory = cwCategory;
		this.cwName = cwName;
		this.cwUrl = cwUrl;
	}



	public String getCwHour() {
		return cwHour;
	}
	public void setCwHour(String cwHour) {
		this.cwHour = cwHour;
	}
	public String getCwCategory() {
		return cwCategory;
	}
	public void setCwCategory(String cwCategory) {
		this.cwCategory = cwCategory;
	}
	public String getCwName() {
		return cwName;
	}
	public void setCwName(String cwName) {
		this.cwName = cwName;
	}
	public String getCwUrl() {
		return cwUrl;
	}
	public void setCwUrl(String cwUrl) {
		this.cwUrl = cwUrl;
	}



	@Override
	public String toString() {
		return "CoursewareSearch [cwHour=" + cwHour + ", cwCategory=" + cwCategory + ", cwName=" + cwName + ", cwUrl="
				+ cwUrl + "]";
	}
	
	
	
	

	
	
	



}
