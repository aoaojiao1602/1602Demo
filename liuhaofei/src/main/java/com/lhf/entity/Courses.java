package com.lhf.entity;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="courses")
public class Courses {
	@Id
	@GeneratedValue
	@Column(columnDefinition="int unsigned NOT NULL comment '备注:课程编号'")
	private int courseId;
	@Column(columnDefinition="varchar(50) comment '备注:课程类别'")
	private String courseCategory;
	@Column(columnDefinition="varchar(50) comment '备注:课程名称'")
	private String courseName;
	@Column(columnDefinition="varchar(100) comment '备注:课程说明'")
	private String courseRemark;
	@Column(columnDefinition="varchar(50) comment '备注:课程创建者'")
	private String courseCreator;
	@Column(columnDefinition="varchar(10) comment '备注:是否发布'")
	private String courseState;
	@Column(columnDefinition="timestamp comment'备注:创建时间'")
	private Date courseCreateTime;
	@Column(columnDefinition="timestamp comment'备注:编辑时间'")
	private Date courseEditorTime;
	public Courses() {
		super();
	}
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
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
	public Date getCourseCreateTime() {
		return courseCreateTime;
	}
	public void setCourseCreateTime(Date courseCreateTime) {
		this.courseCreateTime = courseCreateTime;
	}
	public Date getCourseEditorTime() {
		return courseEditorTime;
	}
	public void setCourseEditorTime(Date courseEditorTime) {
		this.courseEditorTime = courseEditorTime;
	}
	@Override
	public String toString() {
		return "Courses [courseId=" + courseId + ", courseCategory=" + courseCategory + ", courseName=" + courseName
				+ ", courseRemark=" + courseRemark + ", courseCreator=" + courseCreator + ", courseState=" + courseState
				+ ", courseCreateTime=" + courseCreateTime + ", courseEditorTime=" + courseEditorTime + "]";
	}
	
	
	
	

}
