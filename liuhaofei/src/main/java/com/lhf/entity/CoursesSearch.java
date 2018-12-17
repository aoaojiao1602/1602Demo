package com.lhf.entity;



import com.fasterxml.jackson.annotation.JsonFormat;

public class CoursesSearch {
	private String courseCategory;
	private String courseName;
	private String courseRemark;
	private String courseCreator;
	private String courseState;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private String startCreateTime;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private String endCreateTime;
	public CoursesSearch() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CoursesSearch(String courseCategory, String courseName, String courseRemark, String courseCreator,
			String courseState, String startCreateTime, String endCreateTime) {
		super();
		this.courseCategory = courseCategory;
		this.courseName = courseName;
		this.courseRemark = courseRemark;
		this.courseCreator = courseCreator;
		this.courseState = courseState;
		this.startCreateTime = startCreateTime;
		this.endCreateTime = endCreateTime;
	}
	public String getCourseCategory() {
		return courseCategory;
	}
	public void setCourseCategory(String courseCategory) {
		this.courseCategory = courseCategory;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getCourseRemark() {
		return courseRemark;
	}
	public void setCourseRemark(String courseRemark) {
		this.courseRemark = courseRemark;
	}
	public String getCourseCreator() {
		return courseCreator;
	}
	public void setCourseCreator(String courseCreator) {
		this.courseCreator = courseCreator;
	}
	public String getCourseState() {
		return courseState;
	}
	public void setCourseState(String courseState) {
		this.courseState = courseState;
	}
	public String getStartCreateTime() {
		return startCreateTime;
	}
	public void setStartCreateTime(String startCreateTime) {
		this.startCreateTime = startCreateTime;
	}
	public String getEndCreateTime() {
		return endCreateTime;
	}
	public void setEndCreateTime(String endCreateTime) {
		this.endCreateTime = endCreateTime;
	}
	@Override
	public String toString() {
		return "CoursesSearch [courseCategory=" + courseCategory + ", courseName=" + courseName + ", courseRemark="
				+ courseRemark + ", courseCreator=" + courseCreator + ", courseState=" + courseState
				+ ", startCreateTime=" + startCreateTime + ", endCreateTime=" + endCreateTime + "]";
	}
	

}
