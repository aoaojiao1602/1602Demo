package com.lhf.entity;

public class HoursSearch {

	private int hourId;
	private String hourCourse;
	private int hourParentId;
	private String hourName;
	private String hour_xxx;
	
	
	public HoursSearch() {
		super();
	}


	public HoursSearch(int hourId, String hourCourse, int hourParentId, String hourName, String hour_xxx) {
		super();
		this.hourId = hourId;
		this.hourCourse = hourCourse;
		this.hourParentId = hourParentId;
		this.hourName = hourName;
		this.hour_xxx = hour_xxx;
	}


	public int getHourId() {
		return hourId;
	}


	public void setHourId(int hourId) {
		this.hourId = hourId;
	}


	public String getHourCourse() {
		return hourCourse;
	}


	public void setHourCourse(String hourCourse) {
		this.hourCourse = hourCourse;
	}


	public int getHourParentId() {
		return hourParentId;
	}


	public void setHourParentId(int hourParentId) {
		this.hourParentId = hourParentId;
	}


	public String getHourName() {
		return hourName;
	}


	public void setHourName(String hourName) {
		this.hourName = hourName;
	}


	public String getHour_xxx() {
		return hour_xxx;
	}


	public void setHour_xxx(String hour_xxx) {
		this.hour_xxx = hour_xxx;
	}


	@Override
	public String toString() {
		return "HoursSearch [hourId=" + hourId + ", hourCourse=" + hourCourse + ", hourParentId=" + hourParentId
				+ ", hourName=" + hourName + ", hour_xxx=" + hour_xxx + "]";
	}
	
	
}
